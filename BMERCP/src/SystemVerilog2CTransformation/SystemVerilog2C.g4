grammar SystemVerilog2C;

@header {
package SystemVerilog2CTransformation;
}

// Lexer rules
CONST			: 'const';
TYPEDEF         : 'typedef';
ENUM            : 'enum';
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
HEX_INT         : [1-9][0-9]* '\'' 'h' [0-9a-fA-F]+ ;
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
PLUSPPLUS       : '++' ;
MINUS           : '-' ;
MINUSMINUS      : '--' ;
MINUSEQUAL      : '-=' ;
PLUSEQUAL       : '+=' ;
EQUALMINUS      : '=-' ;
EQUALPLUS       : '=+' ;
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
AND				:'&&';
OR				: '||';

file: (moduleDecl | functionDecl | declaration | statement)* EOF ;

moduleDecl: 'module' ID SEMICOLON moduleItem* 'endmodule' ;
moduleItem: declaration | functionDecl | statement | initialBlock | enumDecl ;

initialBlock: 'initial' BEGIN statement END ;

enumDecl: TYPEDEF ENUM 'logic[1:0]' LBRACE enumList RBRACE ID SEMICOLON ;
enumList: ID (COMMA ID)* ;

functionDecl: 'function' returnType ID LPAREN (parameterList)? RPAREN SEMICOLON statement* 'endfunction' ;
returnType: 'void' | 'int' | 'real' | ID ;
parameterList: parameter* STARR? ID? (COMMA? parameter)* ;
parameter: ID | 'void' | 'const'| primary  ;
STARR: 'logic[31:0]';

declaration: CONST? dataType ID (LBRACK INT COLON INT RBRACK)? (EQUAL primary)? SEMICOLON ;
dataType: 'int' | 'real' | 'logic' | 'byte' | ID ;

statement: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | displayStatement | comment | returnStatement) SEMICOLON? ;
statementTwo: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | displayStatement  | comment | returnStatement) SEMICOLON? ;

returnStatement: 'return' expression? SEMICOLON ;

assignment: indexedID ((EQUAL expression) | assignmentType) (ID | INT)? SEMICOLON? ;
assignmentType: PLUSPPLUS | MINUSMINUS | MINUSEQUAL | PLUSEQUAL | EQUALMINUS | EQUALPLUS ;
indexedID: ID (LBRACK expression RBRACK)* ;

functionCall: ID LPAREN (argumentList)? RPAREN ;
argumentList: argument (COMMA argument)* ;
argument: expression | transformedArgument | primary ;
transformedArgument: dataCastArgument | bitsArgument ;
dataCastArgument: dataType QUOTE ID ;
bitsArgument: DOLLAR 'bits' LPAREN ID RPAREN ;
functionCallID: ID ;

ifStatement: IF LPAREN expression RPAREN ((BEGIN statement+ END) | statement) comment? (ELSE (ifStatement | (BEGIN statementTwo+ END) | statementTwo))? ;
loopStatement: forLoop | whileLoop ;

forLoop: FOR LPAREN dataType assignment SEMICOLON expression SEMICOLON assignment? RPAREN BEGIN? statement* END?;

whileLoop: WHILE LPAREN expression RPAREN BEGIN? statement* END?;        

// Switch statement
switchStatement: CASE LPAREN expression RPAREN caseBlock+ (defaultBlock)? ENDCASE;
caseBlock: expression COLON BEGIN? statement* END? SEMICOLON?;
defaultBlock: DEFAULT COLON BEGIN (statement*)? END  BREAK? SEMICOLON?;

expression: '&'?  primary (LPAREN argumentList? RPAREN)? (operator primary)* ;
primary: ID | HEX_INT | INT | STRING | CHAR | dataType |LPAREN expression RPAREN | castFunctionCall ;
operator: PLUS | MINUS | STAR | SLASH | PERCENT | LT | GT | LE | GE | EQEQ | NOTEQ  |AND | OR;

castFunctionCall: dataType QUOTE ID LPAREN RPAREN ;

displayStatement: DISPLAY LPAREN STRING? COMMA? argument? (COMMA argumentList)? RPAREN;

comment: SINGLE_LINE_COMMENT | MULTI_LINE_COMMENT ;
