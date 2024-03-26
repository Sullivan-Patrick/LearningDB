grammar SqlGrammar;

myGrammar
  : (statement | ';')+ EOF
  ;

statement
    : selectfromtable
    ;

selectfromtable
    : SELECT expressionList FROM tableIdentifier (WHERE booleanExpression)?
    ;

columnNames
    : LEFT_PARENTHESIS identifier  (COMMA identifier)* RIGHT_PARENTHESIS
    ;

values
    :  LEFT_PARENTHESIS constants RIGHT_PARENTHESIS
    ;
constants
    :constant (COMMA constant)*;

expressionList
    : expression (COMMA expression)*
    ;

booleanExpression
    : identifier compare expression
    | left=booleanExpression operator=AND right=booleanExpression
    | left=booleanExpression operator=OR right=booleanExpression
    ;

compare:
    EQUALS | GT | GE| LT| LE | NE;

expression
    : ASTERISK
    | identifier
    | constant
    ;

identifier
    : IDENTIFIER DOT IDENTIFIER
    | IDENTIFIER
    ;

constant
    : NULL
    | identifier
    | (MINUS | PLUS)? INTEGER_VALUE
    | (MINUS | PLUS)? DECIMAL_VALUE
    | QUOTED_STRING+
    ;

tableIdentifier
    : name=identifier
    ;

SELECT: 'SELECT' | 'select';
FROM: 'FROM' | 'from';
ROWS : 'ROWS' | 'rows';
WHERE : 'WHERE' | 'where';
NULL : 'NULL' | 'null';


DOT: '.';
COMMA: ',';
ASTERISK: '*';
LEFT_PARENTHESIS: '(';
RIGHT_PARENTHESIS: ')';
EQUALS: '=';
NOT : '!';
MINUS : '-';
PLUS: '+';
GT: '>';
GE: '>=';
LT: '<';
LE: '<=';
NE: '!=';


AND: 'AND' | 'and' | '&&';
OR: 'OR' | 'or' | '||';


QUOTED_STRING
    : '\'' ( ~('\''|'\\') | ('\\' .) )* '\''
    | '"' ( ~('"'|'\\') | ('\\' .) )* '"'
    ;

INTEGER_VALUE
    : DIGIT+
    ;

DECIMAL_VALUE
    : DECIMAL_DIGITS
    ;

IDENTIFIER
    : (LETTER | DIGIT)+
    ;

fragment DECIMAL_DIGITS
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [a-zA-Z]
    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;
