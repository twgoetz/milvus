package org.milvus.regex.syntax;

public abstract class Regex {
  
  public final RegexType type;
  
  public Regex(RegexType type) {
    this.type = type;
  }

}
