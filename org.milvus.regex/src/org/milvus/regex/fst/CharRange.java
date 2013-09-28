package org.milvus.regex.fst;

import static org.milvus.regex.fst.CharRange.Type.CHAR;
import static org.milvus.regex.fst.CharRange.Type.EPSILON;
import static org.milvus.regex.fst.CharRange.Type.RANGE;

public class CharRange implements Comparable<CharRange> {
  
  public static enum Type {
    CHAR, RANGE, EPSILON
  }
  
  private static final CharRange epsilon = new CharRange((char) 0, (char) 0, EPSILON);
  
  public final char from;
  public final char to;
  
  public final Type type;
  
  public CharRange(char from, char to, Type type) {
    super();
    this.from = from;
    this.to = to;
    this.type = type;
  }
  
  public static final CharRange getEpsilon() {
    return epsilon;
  }
  
  public static final CharRange getSingleChar(char c) {
    return new CharRange(c, c, CHAR);
  }
  
  public static final CharRange getRange(char from, char to) {
    return new CharRange(from, to, RANGE);
  }

  public boolean identicalTo(CharRange r) {
    return (this.from == r.from) && (this.to == r.to);
  }
  
  /**
   * Equality here means overlap of at least one character.  
   */
  @Override
  public int compareTo(CharRange range) {
    if (this.to < range.from) {
      return -1;
    }
    if (this.from > range.to) {
      return 1;
    }
    return 0;
  }
  
  
  
}
