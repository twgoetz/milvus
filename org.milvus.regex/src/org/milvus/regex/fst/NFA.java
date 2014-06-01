package org.milvus.regex.fst;

import java.util.ArrayList;
import java.util.List;

public class NFA {

  private State startState;

  private State finalState;

  private final List<State> states;

  public NFA(State start, State end) {
    super();
    this.states = new ArrayList<State>();
    this.startState = start;
    this.states.add(start);
    if (end != null) {
      this.states.add(end);
      setFinalState(end);
    }
  }

  /**
   * Creates a new NFA with a distinct start and end state, and no transitions.
   */
  public NFA() {
    this(new State(false), new State(true));
  }

  public void addState(State state) {
    state.setIndex(this.states.size());
    this.states.add(state);
  }

  public List<State> getStates() {
    return this.states;
  }

  public void addStates(List<State> stateList) {
    for (State state : stateList) {
      addState(state);
    }
  }

  public State getStartState() {
    return this.startState;
  }

  public void setFinalState(State state) {
    addState(state);
    this.finalState = state;
  }

  public State getFinalState() {
    return this.finalState;
  }

  public void remove(State state) {
    // Sanity check
    if (state == this.startState) {
      throw new IllegalArgumentException("Can't remove start state.");
    }
    if (state == this.finalState) {
      throw new IllegalArgumentException("Can't remove only final state.");
    }
    this.states.remove(state);
  }

}
