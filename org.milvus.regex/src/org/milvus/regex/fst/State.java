package org.milvus.regex.fst;

import org.milvus.util.ArraySortedList;
import org.milvus.util.SortedList;

public class State {

  private boolean isFinal;
  private SortedList<Transition> transitions;
  private int index = 0;
  
  public State(boolean isFinal) {
    super();
    this.isFinal = isFinal;
    this.transitions = new ArraySortedList<Transition>();
  }
  
  public boolean isFinal() {
    return this.isFinal;
  }

  public void setFinal(boolean isFinal) {
    this.isFinal = isFinal;
  }

  public void addTransition(Transition trans) {
    this.transitions.insert(trans);
  }
  
  public SortedList<Transition> getTransitions() {
    return this.transitions;
  }

  public int getIndex() {
    return this.index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
  
  @Override
  public int hashCode() {
    return getIndex();
  }
  
  @Override
  public boolean equals(Object o) {
    if (o instanceof State) {
      return ((State) o).getIndex() == getIndex();
    }
    return false;
  }

}

