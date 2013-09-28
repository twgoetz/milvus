package org.milvus.regex.syntax;

import static org.milvus.regex.syntax.RegexType.PLUS;

public class Plus extends UnaryOperator {
  
  public Plus(Regex regex) {
    super(PLUS, regex);
  }

}
