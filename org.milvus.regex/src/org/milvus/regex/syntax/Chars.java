package org.milvus.regex.syntax;

import static org.milvus.regex.syntax.RegexType.CHARS;

import java.util.List;

import org.milvus.regex.fst.CharRange;
import org.milvus.util.SortedArrayList;

public class Chars extends Regex {
  
  private List<CharRange> list = new SortedArrayList<CharRange>();
  
  public Chars(CharRange... chars) {
    super(CHARS);
    for (CharRange range : chars) {
      this.list.add(range);
    }
  }
  
  public void add(CharRange range) {
    this.list.add(range);
  }
  
  public List<CharRange> getChars() {
    return this.list;
  }

}
