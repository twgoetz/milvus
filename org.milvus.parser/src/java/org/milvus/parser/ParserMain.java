package org.milvus.parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.CommonTree;

public class ParserMain {

	public static void main(String[] args) {
		try {
			ANTLRInputStream is = new ANTLRInputStream(new BufferedInputStream(
					new FileInputStream(new File(args[0]))), "UTF-8");
			ParserLexer lexer = new ParserLexer(is);
			CommonTokenStream ts = new CommonTokenStream(lexer);
			ParserParser parser = new ParserParser(ts);
			ParserParser.gram_return rv = parser.gram();
			CommonTree tree = (CommonTree) rv.getTree();
			printTree(tree, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final void printTree(BaseTree tree, int level) {
		System.out.println(Integer.toString(level) + ": " + tree.getText());
		if (tree.getChildCount() == 0) {
			return;
		}
		@SuppressWarnings("unchecked")
		List<BaseTree> nodes = tree.getChildren();
		for (BaseTree node : nodes) {
			printTree(node, level + 1);
		}
	}

}
