// $ANTLR 3.4 Parser.g 2012-11-28 21:27:52

package org.milvus.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ParserLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ParserLexer() {} 
    public ParserLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ParserLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Parser.g"; }

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:6:7: ( ';' )
            // Parser.g:6:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "RULE_KW"
    public final void mRULE_KW() throws RecognitionException {
        try {
            int _type = RULE_KW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:17:9: ( 'rule' )
            // Parser.g:17:11: 'rule'
            {
            match("rule"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RULE_KW"

    // $ANTLR start "VAR_KW"
    public final void mVAR_KW() throws RecognitionException {
        try {
            int _type = VAR_KW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:18:8: ( 'var' )
            // Parser.g:18:10: 'var'
            {
            match("var"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VAR_KW"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:19:8: ( '{' )
            // Parser.g:19:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:20:8: ( '}' )
            // Parser.g:20:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "SLCOMMENTCHAR"
    public final void mSLCOMMENTCHAR() throws RecognitionException {
        try {
            // Parser.g:21:24: ( '#' )
            // Parser.g:21:26: '#'
            {
            match('#'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SLCOMMENTCHAR"

    // $ANTLR start "LOWER"
    public final void mLOWER() throws RecognitionException {
        try {
            // Parser.g:23:15: ( 'a' .. 'z' )
            // Parser.g:
            {
            if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOWER"

    // $ANTLR start "UPPER"
    public final void mUPPER() throws RecognitionException {
        try {
            // Parser.g:24:15: ( 'A' .. 'Z' )
            // Parser.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UPPER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // Parser.g:25:15: ( '0' .. '9' )
            // Parser.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Parser.g:26:16: ( LOWER | UPPER )
            // Parser.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "IDENT_CHAR"
    public final void mIDENT_CHAR() throws RecognitionException {
        try {
            // Parser.g:27:20: ( LETTER | DIGIT | '_' )
            // Parser.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT_CHAR"

    // $ANTLR start "SLCOMMENT"
    public final void mSLCOMMENT() throws RecognitionException {
        try {
            int _type = SLCOMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:29:11: ( SLCOMMENTCHAR (~ ( '\\n' ) )* '\\n' )
            // Parser.g:29:13: SLCOMMENTCHAR (~ ( '\\n' ) )* '\\n'
            {
            mSLCOMMENTCHAR(); 


            // Parser.g:29:27: (~ ( '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Parser.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match('\n'); 

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SLCOMMENT"

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:30:6: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // Parser.g:30:8: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // Parser.g:30:8: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Parser.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPACE"

    // $ANTLR start "QUOTED_STRING"
    public final void mQUOTED_STRING() throws RecognitionException {
        try {
            int _type = QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:31:14: ( '\"' (~ ( '\\\\' | '\"' ) | '\\\\n' | '\\\\t' | '\\\\\"' | '\\\\\\\\' )* '\"' )
            // Parser.g:31:16: '\"' (~ ( '\\\\' | '\"' ) | '\\\\n' | '\\\\t' | '\\\\\"' | '\\\\\\\\' )* '\"'
            {
            match('\"'); 

            // Parser.g:31:20: (~ ( '\\\\' | '\"' ) | '\\\\n' | '\\\\t' | '\\\\\"' | '\\\\\\\\' )*
            loop3:
            do {
                int alt3=6;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }
                else if ( (LA3_0=='\\') ) {
                    switch ( input.LA(2) ) {
                    case 'n':
                        {
                        alt3=2;
                        }
                        break;
                    case 't':
                        {
                        alt3=3;
                        }
                        break;
                    case '\"':
                        {
                        alt3=4;
                        }
                        break;
                    case '\\':
                        {
                        alt3=5;
                        }
                        break;

                    }

                }


                switch (alt3) {
            	case 1 :
            	    // Parser.g:31:22: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // Parser.g:31:40: '\\\\n'
            	    {
            	    match("\\n"); 



            	    }
            	    break;
            	case 3 :
            	    // Parser.g:31:48: '\\\\t'
            	    {
            	    match("\\t"); 



            	    }
            	    break;
            	case 4 :
            	    // Parser.g:31:56: '\\\\\"'
            	    {
            	    match("\\\""); 



            	    }
            	    break;
            	case 5 :
            	    // Parser.g:31:64: '\\\\\\\\'
            	    {
            	    match("\\\\"); 



            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_STRING"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Parser.g:33:11: ( LETTER ( IDENT_CHAR )* )
            // Parser.g:33:13: LETTER ( IDENT_CHAR )*
            {
            mLETTER(); 


            // Parser.g:33:20: ( IDENT_CHAR )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Parser.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    public void mTokens() throws RecognitionException {
        // Parser.g:1:8: ( T__18 | RULE_KW | VAR_KW | LBRACE | RBRACE | SLCOMMENT | SPACE | QUOTED_STRING | IDENTIFIER )
        int alt5=9;
        switch ( input.LA(1) ) {
        case ';':
            {
            alt5=1;
            }
            break;
        case 'r':
            {
            int LA5_2 = input.LA(2);

            if ( (LA5_2=='u') ) {
                int LA5_10 = input.LA(3);

                if ( (LA5_10=='l') ) {
                    int LA5_12 = input.LA(4);

                    if ( (LA5_12=='e') ) {
                        int LA5_14 = input.LA(5);

                        if ( ((LA5_14 >= '0' && LA5_14 <= '9')||(LA5_14 >= 'A' && LA5_14 <= 'Z')||LA5_14=='_'||(LA5_14 >= 'a' && LA5_14 <= 'z')) ) {
                            alt5=9;
                        }
                        else {
                            alt5=2;
                        }
                    }
                    else {
                        alt5=9;
                    }
                }
                else {
                    alt5=9;
                }
            }
            else {
                alt5=9;
            }
            }
            break;
        case 'v':
            {
            int LA5_3 = input.LA(2);

            if ( (LA5_3=='a') ) {
                int LA5_11 = input.LA(3);

                if ( (LA5_11=='r') ) {
                    int LA5_13 = input.LA(4);

                    if ( ((LA5_13 >= '0' && LA5_13 <= '9')||(LA5_13 >= 'A' && LA5_13 <= 'Z')||LA5_13=='_'||(LA5_13 >= 'a' && LA5_13 <= 'z')) ) {
                        alt5=9;
                    }
                    else {
                        alt5=3;
                    }
                }
                else {
                    alt5=9;
                }
            }
            else {
                alt5=9;
            }
            }
            break;
        case '{':
            {
            alt5=4;
            }
            break;
        case '}':
            {
            alt5=5;
            }
            break;
        case '#':
            {
            alt5=6;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt5=7;
            }
            break;
        case '\"':
            {
            alt5=8;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 's':
        case 't':
        case 'u':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=9;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // Parser.g:1:10: T__18
                {
                mT__18(); 


                }
                break;
            case 2 :
                // Parser.g:1:16: RULE_KW
                {
                mRULE_KW(); 


                }
                break;
            case 3 :
                // Parser.g:1:24: VAR_KW
                {
                mVAR_KW(); 


                }
                break;
            case 4 :
                // Parser.g:1:31: LBRACE
                {
                mLBRACE(); 


                }
                break;
            case 5 :
                // Parser.g:1:38: RBRACE
                {
                mRBRACE(); 


                }
                break;
            case 6 :
                // Parser.g:1:45: SLCOMMENT
                {
                mSLCOMMENT(); 


                }
                break;
            case 7 :
                // Parser.g:1:55: SPACE
                {
                mSPACE(); 


                }
                break;
            case 8 :
                // Parser.g:1:61: QUOTED_STRING
                {
                mQUOTED_STRING(); 


                }
                break;
            case 9 :
                // Parser.g:1:75: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;

        }

    }


 

}