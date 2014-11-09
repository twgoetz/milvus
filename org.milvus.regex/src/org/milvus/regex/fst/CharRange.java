package org.milvus.regex.fst;

import static org.milvus.regex.fst.CharRange.Type.CHAR;
import static org.milvus.regex.fst.CharRange.Type.EPSILON;
import static org.milvus.regex.fst.CharRange.Type.RANGE;

import java.util.ArrayList;
import java.util.List;

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


  // Implement standard range comparison
  @Override
  public int compareTo(CharRange range) {
    if (this.from < range.from) {
      return -1;
    } else if (this.from > range.from) {
      return 1;
    } else {
      if (this.to > range.to) {
        return -1;
      } else if (this.to < range.to) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  //

  public static final List<CharRange> makeNonOverlapping(CharRange r1, CharRange r2) {
    List<CharRange> list = new ArrayList<CharRange>();
    switch (r1.type) {
    case CHAR: {

      break;
    }
    case RANGE: {

      break;
    }
    case EPSILON: {
      // this case can not occur as we are only applying this after epsilon removal
      break;
    }
    }
    return list;
  }

}
