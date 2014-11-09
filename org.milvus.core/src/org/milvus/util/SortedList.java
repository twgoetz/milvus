package org.milvus.util;

import java.util.List;

/**
 * TODO: remove. No longer used.
 */
public interface SortedList<T extends Comparable<T>> extends List<T>{

  int insert(T element);
  
}
