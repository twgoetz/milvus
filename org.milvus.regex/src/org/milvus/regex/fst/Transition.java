package org.milvus.regex.fst;

public class Transition implements Comparable<Transition> {

  private final CharRange range;

  private State targetState;

  public Transition(CharRange range, State state) {
    super();
    this.range = range;
    this.targetState = state;
  }
  
  public static final Transition newEpsilonTransition(State state) {
    return new Transition(CharRange.getEpsilon(), state);
  }

  public State getTarget() {
    return this.targetState;
  }

  public CharRange getRange() {
    return this.range;
  }

  public void setTarget(State target) {
    this.targetState = target;
  }

  @Override
  public int compareTo(Transition trans) {
    int comp = this.range.compareTo(trans.range);
    if (comp == 0) {
      this.targetState.compareTo(trans.targetState);
    }
    return comp;
  }
  
}
