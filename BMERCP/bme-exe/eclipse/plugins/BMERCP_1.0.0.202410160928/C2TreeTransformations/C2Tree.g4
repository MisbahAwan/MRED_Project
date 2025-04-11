grammar C2Tree;

@header {
package C2TreeTransformations;
}

// Lexer rules
EXTERN			: 'extern';
ELSE            : 'else';
CASE            : 'case';
DEFAULT         : 'default';
SWITCH          : 'switch';
BREAK           : 'break';
FOR				: 'for';
WHILE			: 'while';
PRINTF          : 'printf'; 
ID              : [a-zA-Z_.][a-zA-Z0-9_.]* ;
INT             : [0-9]+ ;
HEX_INT         : '0x' [0-9a-fA-F]+ ;
WS              : [ \t\r\n]+ -> skip ;
SINGLE_LINE_COMMENT : '//' ~[\r\n]*;
MULTI_LINE_COMMENT  : '/*' .*? '*/';
STRING          : '"' ('\\"' | ~["])* '"' ;
CHAR            : '\'' . '\'' ;
SEMICOLON       : ';' ;
COLON           : ':' ;
COMMA           : ',' ;
DOT             : '.' ;
LPAREN          : '(' ;
RPAREN          : ')' ;
LBRACE          : '{' ;
RBRACE          : '}' ;
LBRACK          : '[' ;
RBRACK          : ']' ;
EQUAL           : '=' ;
PLUS            : '+' ;
MINUS           : '-' ;
STAR            : '*' ;
SLASH           : '/' ;
PERCENT         : '%' ;
LT              : '<' ;
GT              : '>' ;
LE              : '<=' ;
GE              : '>=' ;
EQEQ            : '==' ;
NOTEQ           : '!=' ;
QUOTE           : '\'' ;
DOLLAR          : '$' ;



file: ( moduleDecl  ) EOF ;

moduleDecl: moduleItem* ;
moduleItem: declaration | functionDecl | statement;

functionDecl: returnType ID LPAREN (parameterList)? RPAREN SEMICOLON? (LBRACE  statement* RBRACE)?;
returnType: 'int' | 'uint8_t' | 'uint32_t' | 'osThreadId' | 'char' | 'TickType_t' | 'osEvent' | 'float'  | 'void' | ID ;
parameterList: parameter qualifier? STAR? ID? (COMMA? parameter)* ;
parameter: ID | 'void' |dataType;
qualifier : 'const' ;


declaration: EXTERN? dataType ID (LBRACK INT RBRACK)? (EQUAL primary)? SEMICOLON ;
dataType: 'int' | 'uint8_t' | 'uint32_t' | 'osThreadId' | 'char' | 'TickType_t' | 'osEvent' | 'float' | ID ;

statement: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | printStatement | comment) SEMICOLON? ;
statementTwo: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | printStatement | comment) SEMICOLON? ;

assignment: indexedID ((EQUAL expression) | PLUSPLUS | MINUSMINUS) ;
indexedID: ID (LBRACK expression RBRACK)* ;
PLUSPLUS: ('++');
MINUSMINUS: ('--');

functionCall: ID LPAREN (argumentList)? RPAREN ;
argumentList: argument (COMMA argument)* ;
argument: expression | transformedArgument ;
transformedArgument: dataCastArgument | functionCallArgument ;
dataCastArgument: LPAREN dataType STAR? RPAREN ID ;
functionCallArgument: ID LPAREN ID RPAREN ;
functionCallID: ID ;

ifStatement: 'if' LPAREN expression RPAREN LBRACE statement+ RBRACE (ELSE LBRACE statementTwo+ RBRACE)? ;
loopStatement: forLoop | whileLoop ;

forLoop: FOR LPAREN dataType assignment SEMICOLON expression SEMICOLON assignment RPAREN LBRACE statement+ RBRACE;

whileLoop: WHILE LPAREN expression RPAREN LBRACE statement+ RBRACE;        

// Switch statement
switchStatement: SWITCH LPAREN expression RPAREN LBRACE caseBlock+ (defaultBlock)? RBRACE;
caseBlock: CASE expression COLON LBRACE statement* BREAK SEMICOLON? RBRACE;
defaultBlock: DEFAULT COLON (statement*)? BREAK SEMICOLON?;              

expression: '&'? primary (LPAREN argumentList? RPAREN)? (operator primary)* ;
primary: ID | HEX_INT | INT | STRING | CHAR  | castFunctionCall | dataType |LPAREN expression RPAREN ;
operator: PLUS | MINUS | STAR | SLASH | PERCENT | LT | GT | LE | GE | EQEQ | NOTEQ ;

castFunctionCall: LPAREN dataType RPAREN ID LPAREN RPAREN ;

printStatement: PRINTF LPAREN STRING? argument? (COMMA argumentList)? RPAREN;

comment: SINGLE_LINE_COMMENT | MULTI_LINE_COMMENT ;
