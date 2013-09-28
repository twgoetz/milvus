package org.milvus.util;

import java.util.Collection;

/**
 * TODO: Create type commment.
 */
public interface SortedList<T extends Comparable<T>> extends Iterable<T>{

  T get(int i);
  
  T contains(T element);
  
  void insert(T element);
  
  int find(T element);
  
  void remove(int i);
  
  void addAll(Collection<T> collection);
  
}
