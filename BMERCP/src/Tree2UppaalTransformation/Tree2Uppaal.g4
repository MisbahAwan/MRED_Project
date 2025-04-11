grammar Tree2Uppaal;

@header {
package Tree2UppaalTransformation;
}

/*
 * Lexer rules
 */
 
 /*
 * Skip whitespace and comments
 */
WS: [ \t\r\n]+ -> skip;

PRINT_TAG_OPEN: '<print';
PRINT_TAG_CLOSE: '/>';
PRINT_TEXT: 'printText=';

LT: '<' | '"<"' | '&lt;'| '"&lt;"';
GT: '>' | '">"' | '&gt;'| '"&gt;"';
AND: '&&' | '"&&"' | '&amp;&amp;'| '"&amp;&amp;"';
 
INCLUDE         : '"#include"';
DEFINE          : '"#define"';
TYPEDEF         : 'typedef';
ENUM            : 'enum';
FOR_VOLATILE	: '"for volatile"';
FOR 			: '"for"';
WHILE			: 'while';

// Relational and assignment operators
EQEQ	: '"=="' |'==';
EQ		: '"="'| '=';
NOTEQ	: '"!="' | '!=';
PLUSPLUS: '"++"' | '++';
GTEQ	: '">="' | '"&gt;="';
LTEQ	: '"<="' | '"&lt;="';
STAR	: '"*"' |'*';
PLUS            : '"+"' |'+' ;
MINUS           : '"-"' |'-' ;
MINUSMINUS      : '"--"'|'--' ;
MINUSEQUAL      : '"-="'|'-=' ;
PLUSEQUAL       : '"+="'|'+=' ;
EQUALMINUS      : '"=-"'|'=-' ;
EQUALPLUS       : '"=+"'|'=+' ;


// Keywords for control structures
IF: 'keyword="if"';
ELSE: 'keyword="else"';
ELSEIF: 'keyword="else if"';
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
CONSTINT: '"const int"';

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
VALUE: 'value';
SIZE: 'size';
INITIAL_VALUE: 'initialValue';

// Literals
ID: '""' | '"' [a-zA-Z_.][a-zA-Z_0-9.]* '"' | [a-zA-Z_.][a-zA-Z_0-9.]*;
NUMBER: [0-9]+;
STRING: '"' (~["\\\r\n] | '\\' .)* '"';
// Special symbols used for XML and C-like syntax

SLASH: '/';
LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
SEMICOLON: ';';

// End tag to skip specific system end line
END_TAG: '</dSML:System>' -> skip;

PRINTF: 'printf';
DISPLAY: '$display';

/*
 * Parser rules
 */

system: ( includeDirective | preprocessorDirective | comment | print | declaration | component )*  EOF;
					   
preprocessorDirective: '<preprocessordirective'
                        'keyword=' DEFINE
                        'name="' ID '"'
                        'value="' NUMBER '"'
                       '/>';
                       
includeDirective : '<includedirective' (systemInclude | localInclude) ;

systemInclude: 
				'keyword=' INCLUDE 
				'name="' '&lt;' ID '>"' 
				'/>';
localInclude:  
				'keyword=' INCLUDE 
				'name=' '"'  ID '"'
				'/>';									   	

declaration: DECLARATION_OPEN (attribute| enumDecl | functionprototype | comment)* DECLARATION_CLOSE ;

enumDecl: '<enum' 
			  'enumID="' ID '">' 
			  enumList
		   '</enum>';

enumList: ('<enumlist'
              ('enumItem="' ID '"')
           '/>')*;

attribute: 
    '<attribute' 
        ISGLOBAL '=' (EXTERN | '""')
        DATATYPE '=' dataTypes  
        'name="' ID '"'
        (SIZE '=' STRING)?       // Optional size when present
        (SIZE '=' '""')?         // Ensure empty size is captured as a token
        (INITIAL_VALUE '=' (STRING | ID | NUMBER | '""'))?  // Ensures correct token alignment
    '/>';
    
functionprototype: '<functionprototype' 
						'returnType=' dataTypes 
						'functionName=' ID '>'
						parameter*
					'</functionprototype>';	
component:
    '<component' 'name="' ID '"' 'type=' dataTypes '>' 
     	parameter* (comment | statement | declaration |return|print)* '</component>';

parameter:
    '<parameter' 
	    ('name="' (ID '"' | VOID  | '"'))? 
	    (DATATYPE '=' dataTypes)?
	    ('qualifier' '=' (ID | '""'))? 
	    ('pointer' '=' (STAR | STARR | '""'))?
    '/>';
STARR: 'logic[31:0]';    

statement:
    '<statement>' (ifstatement | assignment | functioncall | comment | declaration | print | switch | return |loop |statement) '</statement>';

ifstatement: (('<if' IF) | ('<if' ELSE)| ('<if' ELSEIF))
 		         ('variable=' ID
          		 'operator=' operator?
          		 'value="' (ID | STRING | NUMBER)? '">')?
          	 	 ('>')?
          	 	(statement|ifstatement | assignment | functioncall | comment | declaration| print | switch | return| loop)* 
          	 '</if>';
return:
    '<statement'
        'name="return"'
        'value="' (ID | NUMBER) '"'  
     '/>' ;

switch:
    '<switch'
          'keyword="switch"'
          'value="' ID '">'
          switch_case+
     '</switch>';    

switch_case:
	'<switchcase'
            (SWITCH_CASE | SWITCH_DEFAULT) '>'?
            (('value="' (STRING | ID | NUMBER) )? '">')?
            (statement | ifstatement | assignment | functioncall | comment | declaration| print | switch | return|loop)*
     '</switchcase>'; 

loop:
	'<loop'
	      'type=' (FOR | FOR_VOLATILE |'"' WHILE '"')
	      'initial="' dataTypes expression '"'
	      'condition="' expression '"'
	      'increment="' expression? '">'
            (statement | ifstatement | assignment | functioncall | comment | declaration| print | switch | return|loop)*
     '</loop>'; 

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

print: PRINT_TAG_OPEN WS* PRINT_TEXT WS* STRING WS* PRINT_TAG_CLOSE;
           
    
dataTypes: UINT8_T | UINT32_T | OSTHREADID | VOID | INT | CHAR | TICKTYPE_T | OSEVENT | FLOAT | LONGINT |ID|'""'|CONSTINT;

expression: ID operator (ID | NUMBER)? SEMICOLON? ;

operator: EQEQ | LT | GT | EQ | '=' | '&lt;' | NOTEQ | GTEQ | LTEQ | PLUSPLUS | PLUS | MINUS | MINUSMINUS | MINUSEQUAL | PLUSEQUAL | EQUALMINUS | EQUALPLUS | AND  | '""';


