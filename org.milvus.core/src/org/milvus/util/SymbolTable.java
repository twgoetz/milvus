package org.milvus.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple symbol table class.  Not thread safe!
 */
public class SymbolTable {
  
  private final Map<String, Integer> symbolNumberMap = new HashMap<String, Integer>();
  
  private final List<String> symbolList = new ArrayList<String>();
  
  public int lookup(String symbol) {
    if (!this.symbolNumberMap.containsKey(symbol)) {
      this.symbolNumberMap.put(symbol, this.symbolList.size());
      this.symbolList.add(symbol);
    }
    return this.symbolNumberMap.get(symbol);
  }
  
  public String getSymbol(int i) {
    return this.symbolList.get(i);
  }
  
  public int size() {
    return this.symbolList.size();
  }

}
