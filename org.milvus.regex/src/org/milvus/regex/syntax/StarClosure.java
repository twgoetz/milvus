package org.milvus.regex.syntax;

import static org.milvus.regex.syntax.RegexType.STAR;

public class StarClosure extends UnaryOperator {
  
  public StarClosure(Regex regex) {
    super(STAR, regex);
  }

}
