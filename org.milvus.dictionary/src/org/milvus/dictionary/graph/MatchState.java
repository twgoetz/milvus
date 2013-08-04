package org.milvus.dictionary.graph;

public class MatchState {
  
  private final boolean isMatch;
  
  private final boolean moreMatchesPossible;
  
  private final Node nextNode;
  
  public MatchState(boolean isMatch, boolean moreMatchesPossible, Node nextNode) {
    super();
    this.isMatch = isMatch;
    this.moreMatchesPossible = moreMatchesPossible;
    this.nextNode = nextNode;
  }

  public boolean isMatch() {
    return this.isMatch;
  }

  public boolean isMoreMatchesPossible() {
    return this.moreMatchesPossible;
  }


  public Node getNextNode() {
    return this.nextNode;
  }

}
