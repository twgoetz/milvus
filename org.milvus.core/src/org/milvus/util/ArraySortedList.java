package org.milvus.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang3.ArrayUtils;

public class ArraySortedList<T extends Comparable<T>> implements SortedList<T> {

  // TODO: add some error handling
  private T[] array = null;

  @Override
  public T get(int i) {
    return this.array[i];
  }

  @Override
  public T contains(T element) {
    int pos = find(element);
    if (pos >= 0) {
      return this.array[pos];
    }
    return null;
  }

  @Override
  public void insert(T element) {
    int pos = find(element);
    if (pos < 0) {
      pos = -pos - 1;
    }
    this.array = ArrayUtils.add(this.array, pos, element);
  }

  @Override
  public int find(T element) {
    if (this.array == null) {
      return -1;
    }
    return Arrays.binarySearch(this.array, element);
  }

  @Override
  public void remove(int i) {
    this.array = ArrayUtils.remove(this.array, i);
  }

  @Override
  public void addAll(Collection<T> collection) {
    for (T element : collection) {
      insert(element);
    }
  }
  
  public static void main(String[] args) {
    SortedList<String> list = new ArraySortedList<String>();
    list.insert("zzz");
    list.insert("mmm");
    list.insert("bbb");
    for (String s : list) {
      System.out.println(s);
    }
    int pos = list.find("mmm");
    list.remove(pos);
    for (String s : list) {
      System.out.println(s);
    }
  }

  @Override
  public Iterator<T> iterator() {
    return Arrays.asList(this.array).iterator();
  }

  @Override
  public int size() {
    if (this.array == null) {
      return 0;
    }
    return this.array.length;
  }

}
