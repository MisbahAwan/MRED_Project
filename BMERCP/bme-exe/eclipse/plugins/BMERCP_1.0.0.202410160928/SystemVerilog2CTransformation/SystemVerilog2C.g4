grammar SystemVerilog2C;

@header {
package SystemVerilog2CTransformation;
}

// Lexer rules
ELSE            : 'else';
CASE            : 'case';
DEFAULT         : 'default';
BREAK           : 'break';
FOR				: 'for';
WHILE			: 'while';
BEGIN			: 'begin';
END				: 'end';
ENDCASE			: 'endcase';
IF				: 'if';
DISPLAY          : '$display'; 
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

file: (moduleDecl | functionDecl | declaration | statement)* EOF ;

moduleDecl: 'module' ID SEMICOLON moduleItem* 'endmodule' ;
moduleItem: declaration | functionDecl | statement | initialBlock ;

initialBlock: 'initial' BEGIN statement END ;

functionDecl: 'function' returnType ID LPAREN (parameterList)? RPAREN SEMICOLON statement* 'endfunction' ;
returnType: 'void' | 'int' | 'real' | ID ;
parameterList: parameter* STAR? ID? (COMMA? parameter)* ;
parameter: ID | 'void' | 'const';

declaration: dataType ID (LBRACK INT COLON INT RBRACK)? (EQUAL primary)? SEMICOLON ;
dataType: 'int' | 'real' | 'logic' | 'byte' | ID ;

statement: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | displayStatement | comment) SEMICOLON? ;
statementTwo: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | displayStatement  | comment) SEMICOLON? ;

assignment: indexedID ((EQUAL expression) | ('++') | ('--')) ;
indexedID: ID (LBRACK expression RBRACK)* ;

functionCall: ID LPAREN (argumentList)? RPAREN ;
argumentList: argument (COMMA argument)* ;
argument: expression | transformedArgument ;
transformedArgument: dataCastArgument | bitsArgument ;
dataCastArgument: dataType QUOTE ID ;
bitsArgument: DOLLAR 'bits' LPAREN ID RPAREN ;
functionCallID: ID ;

ifStatement: IF LPAREN expression RPAREN BEGIN statement+ END (ELSE BEGIN statementTwo+ END)? ;
loopStatement: forLoop | whileLoop ;

forLoop: FOR LPAREN dataType assignment SEMICOLON expression SEMICOLON assignment RPAREN BEGIN? statement+ END?;

whileLoop: WHILE LPAREN expression RPAREN BEGIN? statement+ END?;        

// Switch statement
switchStatement: CASE LPAREN expression RPAREN caseBlock+ (defaultBlock)? ENDCASE;
caseBlock: expression COLON BEGIN? statement* END? SEMICOLON?;
defaultBlock: DEFAULT COLON (statement*)? BREAK? SEMICOLON?;

expression: primary (LPAREN argumentList? RPAREN)? (operator primary)* ;
primary: ID | HEX_INT | INT | STRING | CHAR | dataType |LPAREN expression RPAREN | castFunctionCall ;
operator: PLUS | MINUS | STAR | SLASH | PERCENT | LT | GT | LE | GE | EQEQ | NOTEQ ;

castFunctionCall: dataType QUOTE ID LPAREN RPAREN ;

displayStatement: DISPLAY LPAREN STRING? argument? (COMMA argumentList)? RPAREN;


comment: SINGLE_LINE_COMMENT | MULTI_LINE_COMMENT ;
