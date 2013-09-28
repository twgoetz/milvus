package org.milvus.regex.syntax;

import static org.milvus.regex.syntax.RegexType.OPTIONALITY;

public class Optionality extends UnaryOperator {
  
  public Optionality(Regex regex) {
    super(OPTIONALITY, regex);
  }

}
