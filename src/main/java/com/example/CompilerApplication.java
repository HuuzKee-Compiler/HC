package com.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class CompilerApplication {
    public static void main(String[] args) throws Exception {

        //String inputText = "{1,2,3,4}";
        String inputFile = "test.me";
        if (args != null && args.length > 0) {
            inputFile = args[0];
        }

        // create a CharStream that reads from standard input
        //ANTLRInputStream input = new ANTLRInputStream(inputText);

        // create a lexer that feeds off of input CharStream
        //ArrayInitLexer lexer = new ArrayInitLexer(input);
        HuuzkeeLexer lexer = new HuuzkeeLexer( new ANTLRFileStream(args[0]) );

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        HuuzkeeParser parser = new HuuzkeeParser(tokens);

        ParseTree tree = parser.init(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}
