package org.milvus.regex.syntax;

import java.util.ArrayList;
import java.util.List;

public abstract class Aggregation extends Regex {

  List<Regex> list = new ArrayList<Regex>();
  
  public Aggregation(RegexType type) {
    super(type);
  }
  
  public List<Regex> getList() {
    return this.list;
  }
  
  public void add(Regex regex) {
    this.list.add(regex);
  }
  
}
