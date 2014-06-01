package org.milvus.util;


public class TransitiveClosure {

  /**
   * Compute the transitive closure of a binary relation ~. The relation is represented as an
   * adjacency matrix. That is, i ~ j iff matrix[i][j].  The input matrix is updated destructively.
   * Uses Warshall's algorithm.
   * 
   * @param matrix
   *          A square matrix of booleans, representing the input relation.
   * @return Transitive closure of input adjacency matrix.
   */
  public static void compute(boolean[][] matrix) {
    for (int k = 0; k < matrix.length; k++) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
          if (matrix[i][k] && matrix[k][j]) {
            matrix[i][j] = true;
          }
        }
      }
    }
  }
  


  public static void main(String[] args) {
//    String[][] inputRelation = new String[][] {{"a", "b"}, {"a", "c"}, {"b", "d"}, {"c", "d"}, {"d", "a"}};
    String[][] inputRelation = new String[][] {{"a", "b"}, {"c", "d"}};
    SymbolTable st = new SymbolTable();
    for (String[] pair : inputRelation) {
      st.lookup(pair[0]);
      st.lookup(pair[1]);
    }
    final int size = st.size();
    boolean[][] matrix = new boolean[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = false;
      }
    }
    for (String[] pair : inputRelation) {
      int i = st.lookup(pair[0]);
      int j = st.lookup(pair[1]);
      matrix[i][j] = true;
    }
    compute(matrix);
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (matrix[i][j]) {
          System.out.println(st.getSymbol(i) + " ~* " + st.getSymbol(j));
        }
      }
    }
  }

}
