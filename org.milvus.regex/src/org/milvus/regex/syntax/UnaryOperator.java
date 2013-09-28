package org.milvus.regex.syntax;

public abstract class UnaryOperator extends Regex {
  
  private final Regex operand;
  
  public Regex getOperand() {
    return this.operand;
  }

  public UnaryOperator(RegexType type, Regex regex) {
    super(type);
    this.operand = regex;
  }

}
