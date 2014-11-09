package org.milvus.regex.fst;

import java.util.List;

import org.milvus.util.SortedArrayList;

public class State implements Comparable<State> {

  private boolean isFinal;
  private List<Transition> transitions;
  // An internal index that is used for matrix computations such as transitive closure
  private int index = 0;
  
  public State(boolean isFinal) {
    super();
    this.isFinal = isFinal;
    this.transitions = new SortedArrayList<Transition>();
  }
  
  public boolean isFinal() {
    return this.isFinal;
  }

  public void setFinal(boolean isFinal) {
    this.isFinal = isFinal;
  }

  public void addTransition(Transition trans) {
    this.transitions.add(trans);
  }
  
  public List<Transition> getTransitions() {
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
      return compareTo((State) o) == 0;
    }
    return false;
  }

  @Override
  public int compareTo(State o) {
    if (this.index < o.index) {
      return -1;
    }
    if (this.index > o.index) {
      return 1;
    }
    return 0;
  }

}

