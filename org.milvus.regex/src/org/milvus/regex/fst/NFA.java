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
    setFinalState(end);
  }
  
  /**
   * Creates a new NFA with a distinct start and end state, and no transitions.
   */
  public NFA() {
    this(new State(false), new State(true));
  }
  
  public void addState(State state) {
    this.states.add(state);
  }
  
  public List<State> getStates() {
    return this.states;
  }
  
  public void addStates(List<State> stateList) {
    this.states.addAll(stateList);
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
  
}
