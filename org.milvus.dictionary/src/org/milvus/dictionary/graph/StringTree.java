package org.milvus.dictionary.graph;

import java.util.ArrayList;
import java.util.List;

import opennlp.tools.util.Span;

import org.milvus.dictionary.Dictionary;

public class StringTree<Lemma> extends Dictionary<Lemma> {

  private Node root = new Node();

  public StringTree(char separator) {
    super(separator);
  }

  public void addString(String s) {
    Node node = this.root;
    for (int i = 0; i < s.length(); i++) {
      node = node.addTransition(s.charAt(i));
    }
    node.setFinal(true);
  }


  public String asString() {
    StringBuilder sb = new StringBuilder();
    print(this.root, 0, sb);
    return sb.toString();
  }

  private static boolean print(Node node, int offset, StringBuilder sb) {
    if (node.isFinal()) {
      sb.append('\n');
    }
    for (int i = 0; i < node.getDefinedTransitions().length; i++) {
      char c = node.getDefinedTransitions()[i];
      if (i > 0 || node.isFinal()) {
        for (int j = 0; j < offset; j++) {
          sb.append(' ');
        }
      }
      sb.append(c);
      print(node.transition(c), offset + 1, sb);
    }
    return node.isFinal();
  }

  private MatchState matches(Span tokenSpan, CharSequence chars, Node node) {
    final int end = tokenSpan.getEnd();
    boolean isMatch = true;
    boolean moreMatchesPossible = false;
    for (int i = tokenSpan.getStart(); i < end; i++) {
      char c = chars.charAt(i);
      node = node.transition(c);
      if (node == null) {
        break;
      }
    }
    isMatch = ((node != null) && node.isFinal());
    // Check if there are potentially more matches.  For this to be possible, the state we arrived
    // at must obviously not be null.
    if (node != null) {
      Node next = node.transition(this.separatorChar);
      // If we can continue with the word separator character, there is a possible match with the
      // next token (independent of whether we matched with this one or not).
      moreMatchesPossible = (next != null);
      if (moreMatchesPossible) {
        node = next;
      } 
    }
    return new MatchState(isMatch, moreMatchesPossible, node);
  }

  @Override
  public List<Match> match(List<Span> tokens, CharSequence chars) {
    List<Match> matches = new ArrayList<Match>();
    final int max = tokens.size();
    int start = 0;
    for (int i = 0; i < max; i++) {
      Span span = tokens.get(i);
      start = span.getStart();
      MatchState state = matches(span, chars, this.root);
      if (state.isMatch()) {
        matches.add(new Match(start, span.getEnd(), null));
      }
      int j = i + 1;
      while (state.isMoreMatchesPossible() && j < tokens.size()) {
        span = tokens.get(j);
        state = matches(span, chars, state.getNextNode());
        if (state.isMatch()) {
          matches.add(new Match(start, span.getEnd(), null));
        }
        ++j;
      }
    }
    return matches;
  }
  
  

}
