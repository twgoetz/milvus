package org.milvus.regex.fst;

import static org.milvus.regex.fst.Transition.newEpsilonTransition;

import java.util.List;

import org.milvus.regex.syntax.Chars;
import org.milvus.regex.syntax.Disjunction;
import org.milvus.regex.syntax.Optionality;
import org.milvus.regex.syntax.Plus;
import org.milvus.regex.syntax.Regex;
import org.milvus.regex.syntax.Sequence;
import org.milvus.regex.syntax.StarClosure;
import org.milvus.util.SortedList;

public abstract class RegexToNFA {

  // Tompson construction

  public NFA convert(Regex regex) {
    switch (regex.type) {
    case CHARS: {
      NFA nfa = new NFA();
      SortedList<CharRange> ranges = ((Chars) regex).getChars();
      for (CharRange range : ranges) {
        Transition trans = new Transition(range, nfa.getFinalState());
        nfa.getStartState().addTransition(trans);
      }
      return nfa;
    }
    case DISJUNCTION: {
      NFA nfa = new NFA();
      State start = nfa.getStartState();
      State end = nfa.getFinalState();
      List<Regex> operands = ((Disjunction) regex).getList();
      for (Regex operand : operands) {
        NFA sub = convert(operand);
        nfa.addStates(sub.getStates());
        start.addTransition(newEpsilonTransition(sub.getStartState()));
        sub.getFinalState().addTransition(newEpsilonTransition(end));
      }
      return nfa;
    }
    case OPTIONALITY: {
      NFA nfa = new NFA();
      nfa.getStartState().addTransition(newEpsilonTransition(nfa.getFinalState()));
      NFA sub = convert(((Optionality) regex).getOperand());
      nfa.addStates(sub.getStates());
      nfa.getStartState().addTransition(newEpsilonTransition(sub.getStartState()));
      sub.getFinalState().addTransition(newEpsilonTransition(nfa.getFinalState()));
      return nfa;
    }
    case PLUS: {
      NFA nfa = new NFA();
      NFA sub = convert(((Plus) regex).getOperand());
      nfa.addStates(sub.getStates());
      nfa.getStartState().addTransition(newEpsilonTransition(sub.getStartState()));
      sub.getFinalState().addTransition(newEpsilonTransition(nfa.getFinalState()));
      sub.getFinalState().addTransition(newEpsilonTransition(sub.getStartState()));
      return nfa;
    }
    case SEQUENCE: {
      List<Regex> sequence = ((Sequence) regex).getList();
      if (sequence.size() == 0) {
        // Empty sequence; do we allow that?
        return new NFA();
      }
      NFA nfa = convert(sequence.get(0));
      for (int i = 1; i < sequence.size(); i++) {
        NFA sub = convert(sequence.get(i));
        nfa.addStates(sub.getStates());
        State oldFinal = nfa.getFinalState();
        nfa.setFinalState(sub.getFinalState());
        // Copy outgoing transitions of sub start state onto old final state
        for (Transition trans : sub.getStartState().getTransitions()) {
          oldFinal.addTransition(trans);
        }
      }
      return nfa;
    }
    case STAR: {
      NFA nfa = new NFA();
      nfa.getStartState().addTransition(newEpsilonTransition(nfa.getFinalState()));
      NFA sub = convert(((StarClosure) regex).getOperand());
      nfa.addStates(sub.getStates());
      nfa.getStartState().addTransition(newEpsilonTransition(sub.getStartState()));
      sub.getFinalState().addTransition(newEpsilonTransition(nfa.getFinalState()));
      sub.getFinalState().addTransition(newEpsilonTransition(sub.getStartState()));
      return nfa;
    }
    }
    return null;
  }

}
