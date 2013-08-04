package org.milvus.dictionary;

import java.util.List;

import opennlp.tools.util.Span;

public abstract class Dictionary<Lemma> {
  
  protected char separatorChar;
  
  public Dictionary(char separator) {
    super();
    this.separatorChar = separator;
  }
  
  public class Match {
    
    private int start;
    private int end;
    private Lemma lemma;
    
    public Match(int start, int end, Lemma lemma) {
      super();
      this.start = start;
      this.end = end;
      this.lemma = lemma;
    }
    
    public int getStart() {
      return this.start;
    }
    public void setStart(int start) {
      this.start = start;
    }
    public int getEnd() {
      return this.end;
    }
    public void setEnd(int end) {
      this.end = end;
    }
    public Lemma getLemma() {
      return this.lemma;
    }
    public void setLemma(Lemma lemma) {
      this.lemma = lemma;
    }
  }
  
  public abstract List<Match> match(List<Span> tokens, CharSequence chars);

}
