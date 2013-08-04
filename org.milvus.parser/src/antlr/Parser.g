grammar Parser;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

@header{
package org.milvus.parser;
}

@lexer::header{
package org.milvus.parser;
}

// Keywords
RULE_KW : 'rule';
VAR_KW : 'var';
LBRACE : '{';
RBRACE : '}';
fragment SLCOMMENTCHAR : '#';

fragment LOWER: 'a'..'z';
fragment UPPER: 'A'..'Z';
fragment DIGIT: '0'..'9';
fragment LETTER: LOWER | UPPER;
fragment IDENT_CHAR: LETTER | DIGIT | '_';

SLCOMMENT : SLCOMMENTCHAR ~('\n')* '\n' { skip(); };
SPACE: (' ' | '\t' | '\r' | '\n')+ { skip(); };
QUOTED_STRING: '"' ( ~( '\\' | '"' ) | '\\n' | '\\t' | '\\"' | '\\\\')* '"';

IDENTIFIER: LETTER IDENT_CHAR*;

gram : rule*;

rule: RULE_KW IDENTIFIER? LBRACE statement* RBRACE -> ^(RULE_KW IDENTIFIER statement*);

statement: statement0 ';'!;

statement0: var_decl;

var_decl: VAR_KW IDENTIFIER IDENTIFIER -> ^(VAR_KW IDENTIFIER IDENTIFIER);
