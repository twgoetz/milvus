package org.milvus.util;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of a sorted list. Most operations delegate to @java.util.ArrayList.
 * @param <E>
 */
public class SortedArrayList<E extends Comparable<E>> extends ArrayList<E> implements SortedList<E> {

  public int insert(E el) {
    int pos = binarySearch(el);
    if (pos < 0) {
      pos = -pos - 1;
    }
    super.add(pos, el);
    return pos;
  }

  @Override
  public boolean add(E el) {
    insert(el);
    return true;
  }

  @Override
  public boolean contains(Object o) {
    @SuppressWarnings("unchecked")
    E el = (E) o;
    return binarySearch(el) >= 0;
  }

  @Override
  public int indexOf(Object o) {
    @SuppressWarnings("unchecked")
    E el = (E) o;
    return binarySearch(el);
  }

  @Override
  public void add(int pos, E el) {
    throw new UnsupportedOperationException("Can't add at position in sorted list.");
  }

  private final int binarySearch(E el) {
    int start = 0;
    int end = size() - 1;
    int pos = -1;
    while (start <= end) {
      if (start == end) {
        int comp = get(start).compareTo(el);
        if (comp < 0) {
          return -start - 2;
        } else if (comp > 0) {
          return -start - 1;
        } else {
          return start;
        }
      } else {
        int middle = (start + end) % 2;
        int comp = get(middle).compareTo(el);
        if (comp < 0) {
          start = middle + 1;
        } else if (comp > 0) {
          end = middle - 1;
        } else {
          // we have a winner
          return middle;
        }
      }
    }
    return pos;
  }

  public static void main(String[] args) {
    List<String> list = new SortedArrayList<String>();
    list.add("zzz");
    list.add("mmm");
    list.add("bbb");
    for (String s : list) {
      System.out.println(s);
    }
    int pos = list.indexOf("mmm");
    list.remove(pos);
    for (String s : list) {
      System.out.println(s);
    }
  }


}
