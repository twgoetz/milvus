package org.milvus.dictionary;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import opennlp.tools.sentdetect.EndOfSentenceScanner;
import opennlp.tools.sentdetect.SentenceDetectorFactory;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.Span;

import org.apache.commons.io.FileUtils;
import org.milvus.dictionary.graph.StringTree;

/**
 * Reads a dictionary. Dictionaries are assumed to be in UTF-8 format unless otherwise specified.
 * Each entry must be on a separate line, lines consisting entirely of whitespace are ignored.
 */
public class DictionaryReader {

  private static final String DEFAULT_ENCODING = "UTF-8";

  private static final char DEFAULT_WORD_SEPARATOR = ' ';

  private String encoding = DEFAULT_ENCODING;

  private char wordSeparator = DEFAULT_WORD_SEPARATOR;

  private Tokenizer tokenizer = WhitespaceTokenizer.INSTANCE;

  public final List<String> readDictionary(InputStream is) throws IOException {
    List<String> entries = new ArrayList<String>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is, this.encoding));
    String line = null;
    while ((line = reader.readLine()) != null) {
      Span[] tokenSpans = this.tokenizer.tokenizePos(line);
      if (tokenSpans.length == 0) {
        // The line is empty
        continue;
      } else if (tokenSpans.length == 1 && tokenSpans[0].getStart() == 0
          && tokenSpans[0].getEnd() == line.length()) {
        // The line consists of exactly one token with no gratuitous whitespace
        entries.add(line);
      } else {
        StringBuilder sb = new StringBuilder(line.length());
        for (int i = 0; i < tokenSpans.length; i++) {
          if (i > 0) {
            sb.append(this.wordSeparator);
          }
          sb.append(tokenSpans[i].getCoveredText(line));
        }
        entries.add(sb.toString());
      }
    }
    Collections.sort(entries);
    return entries;
  }

  public final List<String> readDictionary(File file) throws IOException {
    InputStream is = null;
    try {
      is = new BufferedInputStream(new FileInputStream(file));
      return readDictionary(is);
    } finally {
      if (is != null) {
        is.close();
      }
    }
  }

  public String getEncoding() {
    return this.encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  public char getWordSeparator() {
    return this.wordSeparator;
  }

  public void setWordSeparator(char wordSeparator) {
    this.wordSeparator = wordSeparator;
  }

  public StringTree<Object> stringList2Tree(List<String> strings) {
    StringTree<Object> tree = new StringTree<Object>(this.wordSeparator);
    for (String s : strings) {
      tree.addString(s);
    }
    return tree;
  }

  public static void main(String[] args) {
    try {
      String dictionaryFileName = args[0];
      String textFileName = args[1];
      File dictionaryFile = new File(dictionaryFileName);
      DictionaryReader dictReader = new DictionaryReader();
      List<String> dictEntries = dictReader.readDictionary(dictionaryFile);
      StringTree<Object> tree = dictReader.stringList2Tree(dictEntries);
      System.out.println(tree);
      String text = FileUtils.readFileToString(new File(textFileName), DEFAULT_ENCODING);
      SentenceDetectorFactory sdf = new SentenceDetectorFactory();
      EndOfSentenceScanner eosScanner = sdf.getEndOfSentenceScanner();
      Tokenizer tok = WhitespaceTokenizer.INSTANCE;
      List<Integer> eosPos = eosScanner.getPositions(text);
      int start = 0;
      for (int eos : eosPos) {
        String sentence = text.substring(start, eos);
        Span[] tokenSpans = tok.tokenizePos(sentence);
        start = eos + 1;
        List<Span> tokenList = new ArrayList<Span>(tokenSpans.length);
        for (Span span : tokenSpans) {
          tokenList.add(span);
        }
        List<Dictionary<Object>.Match> matches = tree.match(tokenList, sentence);
        for (Dictionary<Object>.Match match : matches) {
          System.out.println(sentence.substring(match.getStart(), match.getEnd()));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
