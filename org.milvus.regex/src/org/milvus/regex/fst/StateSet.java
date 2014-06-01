package org.milvus.regex.fst;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StateSet {

  private final int numStates;

  private final Map<BitSet, State> setToStateMap = new HashMap<BitSet, State>();

  private final Map<State, Set<State>> stateToSetMap = new HashMap<State, Set<State>>();

  public StateSet(int numStates) {
    super();
    this.numStates = numStates;
  }

  public State getState(Set<State> states) {
    return this.setToStateMap.get(getBitSet(states));
  }

  public void addState(State state, Set<State> set) {
    this.stateToSetMap.put(state, set);
    this.setToStateMap.put(getBitSet(set), state);
  }

  private final BitSet getBitSet(Set<State> states) {
    BitSet bs = new BitSet(this.numStates);
    for (State s : states) {
      bs.set(s.getIndex());
    }
    return bs;
  }

  public State getState(State start) {
    Set<State> set = new HashSet<State>();
    set.add(start);
    return getState(set);
  }

}
