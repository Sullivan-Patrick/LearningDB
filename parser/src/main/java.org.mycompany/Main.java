package main.java.org.mycompany;

import java.io.IOException;
import java.util.function.Predicate;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.mycompany.*;
import org.mycompany.SqlGrammarParser.BooleanExpressionContext;
import org.mycompany.SqlGrammarParser.ColumnNamesContext;
import org.mycompany.SqlGrammarParser.CompareContext;
import org.mycompany.SqlGrammarParser.ConstantContext;
import org.mycompany.SqlGrammarParser.ConstantsContext;
import org.mycompany.SqlGrammarParser.ExpressionContext;
import org.mycompany.SqlGrammarParser.ExpressionListContext;
import org.mycompany.SqlGrammarParser.IdentifierContext;
import org.mycompany.SqlGrammarParser.MyGrammarContext;
import org.mycompany.SqlGrammarParser.SelectfromtableContext;
import org.mycompany.SqlGrammarParser.StatementContext;
import org.mycompany.SqlGrammarParser.TableIdentifierContext;
import org.mycompany.SqlGrammarParser.ValuesContext;

public class Main {

  static class MyListener implements SqlGrammarListener {

    @Override
    public void enterMyGrammar(MyGrammarContext ctx) {

    }

    @Override
    public void exitMyGrammar(MyGrammarContext ctx) {

    }

    @Override
    public void enterStatement(StatementContext ctx) {

    }

    @Override
    public void exitStatement(StatementContext ctx) {

    }

    @Override
    public void enterSelectfromtable(SelectfromtableContext ctx) {

    }

    @Override
    public void exitSelectfromtable(SelectfromtableContext ctx) {

    }

    @Override
    public void enterColumnNames(ColumnNamesContext ctx) {

    }

    @Override
    public void exitColumnNames(ColumnNamesContext ctx) {

    }

    @Override
    public void enterValues(ValuesContext ctx) {

    }

    @Override
    public void exitValues(ValuesContext ctx) {

    }

    @Override
    public void enterConstants(ConstantsContext ctx) {

    }

    @Override
    public void exitConstants(ConstantsContext ctx) {

    }

    @Override
    public void enterExpressionList(ExpressionListContext ctx) {
    }

    @Override
    public void exitExpressionList(ExpressionListContext ctx) {

    }

    @Override
    public void enterBooleanExpression(BooleanExpressionContext ctx) {

    }

    @Override
    public void exitBooleanExpression(BooleanExpressionContext ctx) {

    }

    @Override
    public void enterCompare(CompareContext ctx) {

    }

    @Override
    public void exitCompare(CompareContext ctx) {

    }

    @Override
    public void enterExpression(ExpressionContext ctx) {
    }

    @Override
    public void exitExpression(ExpressionContext ctx) {

    }

    @Override
    public void enterIdentifier(IdentifierContext ctx) {
      int size = ctx.IDENTIFIER().size();
      if (size == 2) {
        // Qualified with table name
      } else if (size == 1) {
        // Unqualified
      } else {
        throw new RuntimeException("Uh oh");
      }

      for (ParseTree identifierNode : ctx.children) {
        System.out.println("identifier: " + identifierNode.getText());
      }
    }

    @Override
    public void exitIdentifier(IdentifierContext ctx) {

    }

    @Override
    public void enterConstant(ConstantContext ctx) {
      for (ParseTree identifierNode : ctx.children) {
        System.out.println("constant: " + identifierNode.getText());
      }
    }

    @Override
    public void exitConstant(ConstantContext ctx) {

    }

    @Override
    public void enterTableIdentifier(TableIdentifierContext ctx) {
      //todo
    }

    @Override
    public void exitTableIdentifier(TableIdentifierContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
  }

  public static void main(String[] args) throws IOException {

    // This works in lexer/parser, but not lexer/parser{2} (presto grammar). Cookie for who
    // figures out why.
    String inputString = "SELECT col1, col2, tbl2.col3, 'foo' FROM tbl;";

    // create a CharStream that reads from standard input
    ANTLRInputStream input = new ANTLRInputStream(inputString);

    // create a lexer that feeds off of input CharStream
    SqlGrammarLexer lexer = new SqlGrammarLexer(input);

    // create a buffer of tokens pulled from the lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // create a parser that feeds off the tokens buffer
    SqlGrammarParser parser = new SqlGrammarParser(tokens);

    // Play around in the .g4 files to understand how myGrammar is generated!
    ParseTree tree = parser.myGrammar();

    ParseTreeWalker walker = new ParseTreeWalker();
    SqlGrammarListener listener = new MyListener();
    walker.walk(listener, tree);

    System.out.println(tree.toStringTree(parser)); // print LISP-style tree

  }
}