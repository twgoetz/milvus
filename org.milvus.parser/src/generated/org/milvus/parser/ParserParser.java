// $ANTLR 3.4 Parser.g 2012-11-28 21:27:52

package org.milvus.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ParserParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENTIFIER", "IDENT_CHAR", "LBRACE", "LETTER", "LOWER", "QUOTED_STRING", "RBRACE", "RULE_KW", "SLCOMMENT", "SLCOMMENTCHAR", "SPACE", "UPPER", "VAR_KW", "';'"
    };

    public static final int EOF=-1;
    public static final int T__18=18;
    public static final int DIGIT=4;
    public static final int IDENTIFIER=5;
    public static final int IDENT_CHAR=6;
    public static final int LBRACE=7;
    public static final int LETTER=8;
    public static final int LOWER=9;
    public static final int QUOTED_STRING=10;
    public static final int RBRACE=11;
    public static final int RULE_KW=12;
    public static final int SLCOMMENT=13;
    public static final int SLCOMMENTCHAR=14;
    public static final int SPACE=15;
    public static final int UPPER=16;
    public static final int VAR_KW=17;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public ParserParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ParserParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return ParserParser.tokenNames; }
    public String getGrammarFileName() { return "Parser.g"; }


    public static class gram_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "gram"
    // Parser.g:35:1: gram : ( rule )* ;
    public final ParserParser.gram_return gram() throws RecognitionException {
        ParserParser.gram_return retval = new ParserParser.gram_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ParserParser.rule_return rule1 =null;



        try {
            // Parser.g:35:6: ( ( rule )* )
            // Parser.g:35:8: ( rule )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // Parser.g:35:8: ( rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_KW) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Parser.g:35:8: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_gram230);
            	    rule1=rule();

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "gram"


    public static class rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rule"
    // Parser.g:37:1: rule : RULE_KW ( IDENTIFIER )? LBRACE ( statement )* RBRACE -> ^( RULE_KW IDENTIFIER ( statement )* ) ;
    public final ParserParser.rule_return rule() throws RecognitionException {
        ParserParser.rule_return retval = new ParserParser.rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token RULE_KW2=null;
        Token IDENTIFIER3=null;
        Token LBRACE4=null;
        Token RBRACE6=null;
        ParserParser.statement_return statement5 =null;


        CommonTree RULE_KW2_tree=null;
        CommonTree IDENTIFIER3_tree=null;
        CommonTree LBRACE4_tree=null;
        CommonTree RBRACE6_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_RULE_KW=new RewriteRuleTokenStream(adaptor,"token RULE_KW");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // Parser.g:37:5: ( RULE_KW ( IDENTIFIER )? LBRACE ( statement )* RBRACE -> ^( RULE_KW IDENTIFIER ( statement )* ) )
            // Parser.g:37:7: RULE_KW ( IDENTIFIER )? LBRACE ( statement )* RBRACE
            {
            RULE_KW2=(Token)match(input,RULE_KW,FOLLOW_RULE_KW_in_rule238);  
            stream_RULE_KW.add(RULE_KW2);


            // Parser.g:37:15: ( IDENTIFIER )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENTIFIER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Parser.g:37:15: IDENTIFIER
                    {
                    IDENTIFIER3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule240);  
                    stream_IDENTIFIER.add(IDENTIFIER3);


                    }
                    break;

            }


            LBRACE4=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_rule243);  
            stream_LBRACE.add(LBRACE4);


            // Parser.g:37:34: ( statement )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==VAR_KW) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Parser.g:37:34: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_rule245);
            	    statement5=statement();

            	    state._fsp--;

            	    stream_statement.add(statement5.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            RBRACE6=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_rule248);  
            stream_RBRACE.add(RBRACE6);


            // AST REWRITE
            // elements: IDENTIFIER, statement, RULE_KW
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 37:52: -> ^( RULE_KW IDENTIFIER ( statement )* )
            {
                // Parser.g:37:55: ^( RULE_KW IDENTIFIER ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_RULE_KW.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_IDENTIFIER.nextNode()
                );

                // Parser.g:37:76: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rule"


    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // Parser.g:39:1: statement : statement0 ';' !;
    public final ParserParser.statement_return statement() throws RecognitionException {
        ParserParser.statement_return retval = new ParserParser.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal8=null;
        ParserParser.statement0_return statement07 =null;


        CommonTree char_literal8_tree=null;

        try {
            // Parser.g:39:10: ( statement0 ';' !)
            // Parser.g:39:12: statement0 ';' !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_statement0_in_statement266);
            statement07=statement0();

            state._fsp--;

            adaptor.addChild(root_0, statement07.getTree());

            char_literal8=(Token)match(input,18,FOLLOW_18_in_statement268); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class statement0_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement0"
    // Parser.g:41:1: statement0 : var_decl ;
    public final ParserParser.statement0_return statement0() throws RecognitionException {
        ParserParser.statement0_return retval = new ParserParser.statement0_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ParserParser.var_decl_return var_decl9 =null;



        try {
            // Parser.g:41:11: ( var_decl )
            // Parser.g:41:13: var_decl
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_var_decl_in_statement0276);
            var_decl9=var_decl();

            state._fsp--;

            adaptor.addChild(root_0, var_decl9.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement0"


    public static class var_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_decl"
    // Parser.g:43:1: var_decl : VAR_KW IDENTIFIER IDENTIFIER -> ^( VAR_KW IDENTIFIER IDENTIFIER ) ;
    public final ParserParser.var_decl_return var_decl() throws RecognitionException {
        ParserParser.var_decl_return retval = new ParserParser.var_decl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token VAR_KW10=null;
        Token IDENTIFIER11=null;
        Token IDENTIFIER12=null;

        CommonTree VAR_KW10_tree=null;
        CommonTree IDENTIFIER11_tree=null;
        CommonTree IDENTIFIER12_tree=null;
        RewriteRuleTokenStream stream_VAR_KW=new RewriteRuleTokenStream(adaptor,"token VAR_KW");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // Parser.g:43:9: ( VAR_KW IDENTIFIER IDENTIFIER -> ^( VAR_KW IDENTIFIER IDENTIFIER ) )
            // Parser.g:43:11: VAR_KW IDENTIFIER IDENTIFIER
            {
            VAR_KW10=(Token)match(input,VAR_KW,FOLLOW_VAR_KW_in_var_decl283);  
            stream_VAR_KW.add(VAR_KW10);


            IDENTIFIER11=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_var_decl285);  
            stream_IDENTIFIER.add(IDENTIFIER11);


            IDENTIFIER12=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_var_decl287);  
            stream_IDENTIFIER.add(IDENTIFIER12);


            // AST REWRITE
            // elements: VAR_KW, IDENTIFIER, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 43:40: -> ^( VAR_KW IDENTIFIER IDENTIFIER )
            {
                // Parser.g:43:43: ^( VAR_KW IDENTIFIER IDENTIFIER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_VAR_KW.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_IDENTIFIER.nextNode()
                );

                adaptor.addChild(root_1, 
                stream_IDENTIFIER.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_decl"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_gram230 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_RULE_KW_in_rule238 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule240 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LBRACE_in_rule243 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_statement_in_rule245 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_RBRACE_in_rule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement0_in_statement266 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_decl_in_statement0276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_KW_in_var_decl283 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_var_decl285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_var_decl287 = new BitSet(new long[]{0x0000000000000002L});

}