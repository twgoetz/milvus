package org.milvus.dictionary.graph;

import java.util.Arrays;

public class Node {
  
  private static final char[] emptyCharArray = {};
  
  private static final Node[] emptyNodeArray = {};
  
  private char[] charTransition = emptyCharArray;
  
  private Node[] nodeTransition = emptyNodeArray;
  
  private boolean isFinal;
  
  public Node(boolean isFinal) {
    super();
    this.isFinal = isFinal;
  }
  
  public Node() {
    this(false);
  }
  
  public Node transition(char c) {
    int pos = Arrays.binarySearch(this.charTransition, c);
    if (pos >= 0) {
      return this.nodeTransition[pos];
    }
    return null;
  }
  
  public Node addTransition(char c) {
    Node returnValue = transition(c);
    if (returnValue == null) {
      int pos = addCharTransition(c);
      returnValue = new Node();
      addNodeTransition(pos, returnValue);
    }
    return returnValue;
  }

  // Add a new character transition, returning the point where the character was inserted
  private int addCharTransition(char c) {
    char[] oldChars = this.charTransition;
    if (oldChars.length == 0) {
      this.charTransition = new char[] { c };
      return 0;
    }
    this.charTransition = new char[this.charTransition.length + 1];
    char lastChar = oldChars[oldChars.length - 1];
    if (c > lastChar) {
      // This is the expected case if entries come in in sorted order
      System.arraycopy(oldChars, 0, this.charTransition, 0, oldChars.length);
      this.charTransition[oldChars.length] = c;
      return oldChars.length;
    }
    // If we're inserting in the middle, everything is a little more complicated (and less efficient)
    int pos = Arrays.binarySearch(oldChars, c);
    assert pos < 0;
    pos = -pos - 1; // This is the insertion point computed by Arrays.binarySearch()
    System.arraycopy(oldChars, 0, this.charTransition, 0, pos);
    this.charTransition[pos] = c;
    System.arraycopy(oldChars, pos, this.charTransition, pos + 1, oldChars.length);
    return pos;
  }

  // Add a new node transition in the place where we previously added a character
  private void addNodeTransition(int pos, Node node) {
    assert pos >= 0 && pos <= this.nodeTransition.length;
    Node[] oldNodes = this.nodeTransition;
    this.nodeTransition = new Node[oldNodes.length + 1];
    if (pos == oldNodes.length) {
      System.arraycopy(oldNodes, 0, this.nodeTransition, 0, pos);
    } else {
      System.arraycopy(oldNodes, 0, this.nodeTransition, 0, pos);
      System.arraycopy(oldNodes, pos, this.nodeTransition, pos + 1, oldNodes.length);
    }
    this.nodeTransition[pos] = node;
  }

  /**
   * A node is final iff it is an accepting state of the automaton.
   */
  public boolean isFinal() {
    return this.isFinal;
  }

  public void setFinal(boolean isFinal) {
    this.isFinal = isFinal;
  }
  
  public void addFinal(boolean makeFinal) {
    this.isFinal |= makeFinal;
  }
  
  public char[] getDefinedTransitions() {
    return this.charTransition;
  }
  
  /**
   * A node is terminal iff it has no outgoing transitions.  All terminal nodes are final, but not
   * the other way around.
   */
  public boolean isTerminalNode() {
    return this.charTransition.length == 0;
  }

}
