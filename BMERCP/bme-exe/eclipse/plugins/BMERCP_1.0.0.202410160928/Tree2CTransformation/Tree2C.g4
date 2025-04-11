grammar Tree2C;

@header {
package Tree2CTransformation;
}

/*
 * Lexer rules
 */

// Relational and assignment operators
EQEQ: '"=="';
EQ: '"="';
NOTEQ: '"!="';
PLUSPLUS: '"++"';
GTEQ: '">="' | '"&gt;="';
LTEQ: '"<="' | '"&lt;="';
STAR: '"*"';

// Keywords for control structures
IF: 'keyword="if"';
ELSE: 'keyword="else"';
SWITCH_CASE: 'keyword="case"';
SWITCH_DEFAULT: 'keyword="default"';

// Data types and special symbols
VOID: '"void"';
EXTERN: '"extern"';
UINT8_T: '"uint8_t"';
UINT32_T: '"uint32_t"';
OSTHREADID: '"osThreadId"';
INT: '"int"';
CHAR: '"char"';
TICKTYPE_T: '"TickType_t"';
OSEVENT: '"osEvent"';
FLOAT: '"float"';
LONGINT: '"longint"';

// Function calls and comments
FUNCTION_CALL: 'functioncall';
COMMENT: 'comment';

// Control structure tokens
STATEMENT: 'statement';
COMPONENT: 'component';
PARAMETER: 'parameter';
SWITCH_CASE_TAG: 'switchcase';

// XML-like tags and attributes for the DSML structure
DECLARATION_OPEN: '<declaration>';
DECLARATION_CLOSE: '</declaration>';
ISGLOBAL: 'isGlobal';
DATATYPE:  'dataType';
NAME:  'name';
SIZE: 'size';
INITIAL_VALUE: 'initialValue';

// Literals
ID: '""' | '"' [a-zA-Z_.][a-zA-Z_0-9.]* '"' ;
NUMBER: [0-9]+;
STRING: '"' ~["]* '"';  // match any string enclosed in double quotes

// Special symbols used for XML and C-like syntax
LT: '<' | '&lt;';
GT: '>' | '&gt;';
SLASH: '/';
LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
SEMICOLON: ';';

// End tag to skip specific system end line
END_TAG: '</dSML:System>' -> skip;

// Tokens for C-like function prints
PRINTF: 'printf';
DISPLAY: '$display';

/*
 * Skip whitespace and comments
 */
WS: [ \t\r\n]+ -> skip;

/*
 * Parser rules
 */

system: (declaration component*) | (component* declaration) EOF;

declaration: DECLARATION_OPEN (attribute | functionprototype)* DECLARATION_CLOSE ;

attribute: 
    '<attribute' 
	    ISGLOBAL '=' (EXTERN)? 
	    DATATYPE '=' dataTypes  
	    NAME '=' ID
	    (SIZE '=' (STRING | '""'))? 
	    (INITIAL_VALUE '=' (STRING | '""'))? 
	 '/>';
    
functionprototype: '<functionprototype' 
						'returnType=' dataTypes 
						'functionName=' ID '>'
						parameter*
					'</functionprototype>';	   

component:
    '<component' NAME '=' ID 'type' '=' dataTypes '>' 
     	parameter* (comment | statement | declaration)* '</component>';

parameter:
    '<parameter' 
	    (NAME '=' (ID | VOID |'""'))? 
	    (DATATYPE '=' dataTypes)?
	    ('qualifier' '=' (ID | '""'))? 
	    ('pointer' '=' (STAR | '""'))?
    '/>';

statement:
    '<statement>' (ifstatement | assignment | functioncall | comment | declaration | print | switch) '</statement>';

ifstatement: (('<if' IF) | ('<if' ELSE))
 		         ('variable=' ID
          		 'operator=' operator?
          		 'value=' (ID| STRING | '""'))?
          	 	'>' 
          	 	(statement|ifstatement | assignment | functioncall | comment | declaration| print | switch)* 
          	 '</if>';

switch:
    '<switch'
          'keyword="switch"'
          'value=' ID '>'
          switch_case+
     '</switch>';    

switch_case:
	'<switchcase'
            (SWITCH_CASE | SWITCH_DEFAULT)
            ('value=' (STRING | ID))? '>'
            (statement|ifstatement | assignment | functioncall | comment | declaration| print | switch)*
     '</switchcase>'; 

assignment:
    '<assignment' 
        'leftAttribute=' leftAttribute?
        'operator=' operatorOrEmpty?
        'AssignedSide=' assignedSide?
    '/>';

leftAttribute: ID | STRING;
operatorOrEmpty: operator | '""';
assignedSide: ID | STRING | operator | '""';

functioncall:
    '<functioncall' 
	    'functionName=' ID 
	    ('parameterString=' (ID | STRING | '""'))?
    '/>';

comment:
    '<comment' 
    'commentText=' STRING 
    '/>';

print: PRINTF | DISPLAY;   
    
dataTypes: UINT8_T | UINT32_T | OSTHREADID | VOID | INT | CHAR | TICKTYPE_T | OSEVENT | FLOAT | LONGINT;

operator: EQEQ | LT | GT | EQ | NOTEQ | GTEQ | LTEQ | PLUSPLUS | '""';
