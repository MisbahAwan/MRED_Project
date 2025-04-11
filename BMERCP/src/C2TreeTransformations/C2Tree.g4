grammar C2Tree;

@header {
package C2TreeTransformations;
}

// Lexer rules
IF				: 'if';
EXTERN			: 'extern';
ELSE            : 'else';
CASE            : 'case';
DEFAULT         : 'default';
SWITCH          : 'switch';
BREAK           : 'break';
FOR				: 'for';
WHILE			: 'while';
PRINTF          : 'printf'; 
INCLUDE         : '#include';
DEFINE          : '#define';
TYPEDEF         : 'typedef';
ENUM            : 'enum';
VOLATILE		: 'volatile';
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
DOUBLE_QUOTE    : '"' ;
DOLLAR          : '$' ;
AND				:'&&';
OR				: '||';



file: (preprocessorDirective | includeDirective | comment | moduleDecl )* EOF ;

preprocessorDirective: DEFINE ID EQUAL? INT SEMICOLON?;

includeDirective : INCLUDE (systemInclude | localInclude) ;
systemInclude   : LT ID GT ;
localInclude    : DOUBLE_QUOTE ID DOUBLE_QUOTE ;

moduleDecl: moduleItem ;
moduleItem: declaration | functionDecl | statement | enumDecl ;

enumDecl: TYPEDEF ENUM LBRACE enumList RBRACE ID SEMICOLON ;
enumList: ID (COMMA ID)* ;

functionDecl: returnType ID LPAREN (parameterList)? RPAREN SEMICOLON? (LBRACE  statement* RBRACE)?;
returnType: 'int' | 'uint8_t' | 'uint32_t' | 'osThreadId' | 'char' | 'TickType_t' | 'osEvent' | 'float'  | 'void' | ID ;
parameterList: (COMMA? dataType qualifier? STAR? ID?)*;
qualifier : 'const' ;


declaration: EXTERN? qualifier? dataType ID (LBRACK INT RBRACK)? (EQUAL primary)? SEMICOLON ;
dataType: 'int' | 'uint8_t' | 'uint32_t' | 'osThreadId' | 'char' | 'TickType_t' | 'osEvent' | 'float' | ID | 'void' ;

statement: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | printStatement | comment| returnStatement) SEMICOLON? ;
statementTwo: (assignment | declaration | functionCall | ifStatement | loopStatement | switchStatement | printStatement | comment| returnStatement) SEMICOLON? ;

returnStatement: 'return' expression? SEMICOLON ;

assignment: indexedID ((EQUAL expression) | assignmentType) (ID | INT)? SEMICOLON? ;
assignmentType: PLUSPPLUS | MINUSMINUS | MINUSEQUAL | PLUSEQUAL | EQUALMINUS | EQUALPLUS ;
indexedID: ID (LBRACK expression RBRACK)* ;

functionCall: ID LPAREN (argumentList)? RPAREN ;
argumentList: argument (COMMA argument)* ;
argument: expression | transformedArgument ;
transformedArgument: dataCastArgument | functionCallArgument ;
dataCastArgument: LPAREN dataType STAR? RPAREN ID ;
functionCallArgument: ID LPAREN ID RPAREN ;
functionCallID: ID ;

ifStatement: IF LPAREN expression RPAREN ((LBRACE statement+ RBRACE) | statement) comment? (ELSE (ifStatement| (LBRACE statementTwo+ RBRACE) | statementTwo))? ;
loopStatement: forLoop | whileLoop ;

forLoop: FOR LPAREN VOLATILE? dataType assignment SEMICOLON expression SEMICOLON assignment? RPAREN (SEMICOLON? | (LBRACE? statement* RBRACE?)?) ;

whileLoop: WHILE LPAREN expression RPAREN LBRACE? statement+ RBRACE?;        

// Switch statement
switchStatement: SWITCH LPAREN expression RPAREN LBRACE? caseBlock+ (defaultBlock)? RBRACE?;
caseBlock: CASE expression COLON LBRACE? statement* BREAK SEMICOLON? RBRACE?;
defaultBlock: DEFAULT COLON (statement*)? BREAK SEMICOLON?;              

expression: '&'? primary (LPAREN argumentList? RPAREN)? (operator primary)* ;
primary: ID | HEX_INT | INT | STRING | CHAR  | castFunctionCall | dataType |LPAREN expression RPAREN ;
operator: PLUS | MINUS | STAR | SLASH | PERCENT | LT | GT | LE | GE | EQEQ | NOTEQ |AND | OR;

castFunctionCall: LPAREN dataType RPAREN ID LPAREN RPAREN ;

printStatement: PRINTF LPAREN STRING? COMMA? argument? (COMMA argumentList)? RPAREN;

comment: SINGLE_LINE_COMMENT | MULTI_LINE_COMMENT ;
