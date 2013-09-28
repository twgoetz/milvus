package org.milvus.regex.syntax;

import static org.milvus.regex.syntax.RegexType.CHARS;

import org.milvus.regex.fst.CharRange;
import org.milvus.util.ArraySortedList;
import org.milvus.util.SortedList;

public class Chars extends Regex {
  
  private SortedList<CharRange> list = new ArraySortedList<CharRange>();
  
  public Chars(CharRange... chars) {
    super(CHARS);
    for (CharRange range : chars) {
      this.list.insert(range);
    }
  }
  
  public void add(CharRange range) {
    this.list.insert(range);
  }
  
  public SortedList<CharRange> getChars() {
    return this.list;
  }

}
