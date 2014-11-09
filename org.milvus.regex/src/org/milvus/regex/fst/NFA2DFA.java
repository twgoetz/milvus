package org.milvus.regex.fst;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.milvus.util.TransitiveClosure;

public abstract class NFA2DFA {
  
  public static void eliminateEpsilonTransitions(NFA nfa) {
    fixStateIndex(nfa);
    List<State> states = nfa.getStates();
    boolean[][] epsilonTransitionMatrix = emptyAdjacencyMatrix(states.size());
    for (State q0 : states) {
      List<Transition> transitions = q0.getTransitions();
      for (int i = 0; i < transitions.size(); i++) {
        Transition delta = transitions.get(i);
        if (delta.getRange() == CharRange.getEpsilon()) {
          State q1 = delta.getTarget();
          epsilonTransitionMatrix[q0.getIndex()][q1.getIndex()] = true;
        }
      }
      removeEpsilonTransitions(transitions);
    }
    TransitiveClosure.compute(epsilonTransitionMatrix);
    for (int i = 0; i < states.size(); i++) {
      for (int j = 0; j < states.size(); j++) {
        // skip transitions into the state itself
        if (i != j && epsilonTransitionMatrix[i][j]) {
          List<Transition> transitions = states.get(j).getTransitions();
          State q0 = states.get(i);
          for (Transition delta : transitions) {
            q0.addTransition(delta);
          }
        }
      }
    }
  }
  
  public static void eliminateUnreachableNodes(NFA nfa) {
    // Build the transitive closure of the reachability relation, then eliminate all nodes not
    // reachable from the start state.  It is sufficient to remove the nodes themselves, as the only
    // possible incoming transitions are from non-reachable nodes that will be removed themselves.
    fixStateIndex(nfa);
    List<State> states = nfa.getStates();
    boolean[][] reachable = emptyAdjacencyMatrix(states.size());
    for (State state : states) {
      List<Transition> transitions = state.getTransitions();
      for (Transition delta : transitions) {
        State target = delta.getTarget();
        reachable[state.getIndex()][target.getIndex()] = true;
      }
    }
    TransitiveClosure.compute(reachable);
    State startState = nfa.getStartState();
    int startIndex = startState.getIndex();
    for (State state : states) {
      if (state != startState && !reachable[startIndex][state.getIndex()]) {
        nfa.remove(state);
      }
    }
  }
  
  private static final void removeEpsilonTransitions(List<Transition> transitions) {
    int i = 0;
    while (i < transitions.size()) {
      if (transitions.get(i).getRange() == CharRange.getEpsilon()) {
        transitions.remove(i);
      } else {
        ++i;
      }
    }
  }
  
  public static NFA determinize(NFA nfa) {
    fixStateIndex(nfa);
    StateSet stateSet = new StateSet(nfa.getStates().size());
    Queue<State> stateQ = new ArrayDeque<State>();
    State start = nfa.getStartState();
    State newStart = new State(false);
    NFA dfa = new NFA(newStart, null);
    Set<State> startSet = new HashSet<State>();
    startSet.add(newStart);
    stateSet.addState(newStart, startSet);
    stateQ.add(newStart);
    while (!stateQ.isEmpty()) {
      State s0 = stateQ.remove();
      
    }
    return dfa; 
  }
  
  private static final boolean[][] emptyAdjacencyMatrix(int size) {
    boolean[][] matrix = new boolean[size][];
    for (int i = 0; i < size; i++) {
      boolean[] row = new boolean[size];
      for (int j = 0; j < size; j++) {
        row[j] = false;
      }
      matrix[i] = row;
    }
    return matrix;
  }
  
  // Since the NFA may have been built up from previous NFAs, the states' index may be all over the
  // place.  This method fixes the state index so it can be used in the NFA to DFA transformations.
  private static final void fixStateIndex(NFA nfa) {
    List<State> states = nfa.getStates();
    final int max = states.size();
    for (int i = 0; i < max; i++) {
      states.get(i).setIndex(i);
    }
  }

}
