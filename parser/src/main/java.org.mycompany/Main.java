import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.mycompany.*;

public class Main {
  public static void main(String[] args) throws IOException {

    // This works in lexer/parser, but not lexer/parser{2} (presto grammar). Cookie for who
    // figures out why.
    String inputString = "SELECT col1, col2 FROM tbl;";

    // create a CharStream that reads from standard input
    ANTLRInputStream input = new ANTLRInputStream(inputString);

        // create a lexer that feeds off of input CharStream
    SqlGrammarLexer lexer = new SqlGrammarLexer(input);
    SqlBaseLexer lexer2 = new SqlBaseLexer(input);

    // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
    CommonTokenStream tokens2 = new CommonTokenStream(lexer2);

    // create a parser that feeds off the tokens buffer
    SqlGrammarParser parser = new SqlGrammarParser(tokens);
    SqlBaseParser parser2 = new SqlBaseParser(tokens);

    // Play around in the .g4 files to understand how myGrammar is generated!
    ParseTree tree = parser.myGrammar();
    ParseTree tree2 = parser2.singleStatement();

        System.out.println(tree.toStringTree(parser)); // print LISP-style tree

  }
}