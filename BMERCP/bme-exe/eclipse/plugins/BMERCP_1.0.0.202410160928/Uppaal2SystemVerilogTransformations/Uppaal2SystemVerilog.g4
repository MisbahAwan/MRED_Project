grammar Uppaal2SystemVerilog;

@header {
package Uppaal2SystemVerilogTransformations;
}


// Lexer rules (tokens)
ARRAY_SV: ':0';
VOID: 'void';
DATATYPE: 'int' |  'double' | 'char'; // Data types
ID:  [a-zA-Z_.:][a-zA-Z0-9_.:]* ; // Identifiers
LBRACK: '['; // Left bracket
RBRACK: ']'; // Right bracket
LPAREN: '('; // Left parenthesis
RPAREN: ')'; // Right parenthesis
LBRACE: '{'; // Left brace
RBRACE: '}'; // Right brace

OPEN_DECLARATION: '<declaration>';
OPEN_TEMPLATE: '<template>';
OPEN_TEMPLATE_NAME: '<name>';
CLOSE_TEMPLATE_NAME: '</name>';
OPEN_PARAMETER : '<parameter>';
CLOSE_PARAMETER : '</parameter>';
OPEN_LOCATION: '<location';

EQUAL: '='; // Equals sign
STRING: '"' ( ~["] )* '"'; // String literals
INT: [0-9]+; // Integer literals

CLOSE_LOCATION: '</location>';
INIT:	'<init ref="id0"/>';

UPPAAL_COMMENT_WITH_TEXT: '<!--' ~[<>]* '-->'; // UPPAAL comment with user-defined text


SEMICOLON: ';'; // Semicolon
COLON: ':'; // Colon
COMMA: ','; // Comma
DOT: '.'; // Dot
PLUS: '+'; // Plus sign
PLUSPLUS: '++'; // Plus sign
MINUS: '-'; // Minus sign
STAR: '*'; // Multiplication sign
SLASH: '/'; // Division sign
PERCENT: '%'; // Modulus sign
LT: '<'; // Less than
GT: '>'; // Greater than
LE: '<='; // Less than or equal to
GE: '>='; // Greater than or equal to
EQEQ: '=='; // Equality operator
NOTEQ: '!='; // Inequality operator
QUOTE: '\''; // Single quote
DOLLAR: '$'; // Dollar sign
HEX_INT         : '0x' [0-9a-fA-F]+ ;

// UPPAAL specific tags
NTA_OPEN: '<nta>';
NTA_CLOSE: '</nta>';

CLOSE_DECLARATION: '</declaration>';
CLOSE_SOURCE_TARGET: '/>';
CLOSE_TEMPLATE: '</template>';
OPEN_SYSTEM: '<system>';
CLOSE_SYSTEM: '</system>';
OPEN_QUERIES: '<queries>';
CLOSE_QUERIES: '</queries>';

OPEN_TRANSITION: '<transition>';
CLOSE_TRANSITION: '</transition>';
OPEN_LABEL: '<label';
CLOSE_LABEL: '</label>';
OPEN_SOURCE: '<source ref=';

OPEN_TARGET: '<target ref=';
OPEN_QUERY: '<query>';
CLOSE_QUERY: '</query>';
OPEN_FORMULA: '<formula>';
CLOSE_FORMULA: '</formula>';
OPEN_COMMENT: '<comment>';
CLOSE_COMMENT: '</comment>';

WS: [ \t\r\n]+ -> skip; // Skip whitespace (spaces, tabs, newlines)



// Entry point for parsing
file: (ntaSection) EOF;

// NTA section
ntaSection: NTA_OPEN ntaItem+ NTA_CLOSE;
ntaItem: declaration+ | template+ | system | queries;

// Declaration section
declaration: OPEN_DECLARATION declarationItem+ CLOSE_DECLARATION;

// Individual items in declaration
declarationItem: declarationVar | declarationFunc;

declarationVar: DATATYPE ID (LBRACK INT ARRAY_SV? RBRACK)? '='? ID? SEMICOLON; // Variable declaration
declarationFunc: (DATATYPE | VOID) ID LPAREN  parameterList? RPAREN LBRACE RBRACE; // Function declaration
parameterList: parameter (COMMA parameter)* ;
parameter: ID | 'void';


// Template section
template: OPEN_TEMPLATE nameSection templateParameter? (location | INIT |transition | comment)* CLOSE_TEMPLATE;

templateParameter : OPEN_PARAMETER ((DATATYPE | VOID)? qualifier? pointer? ID?) (COMMA (DATATYPE | VOID)? qualifier? pointer? ID? )*? CLOSE_PARAMETER ;

qualifier : 'const' ;
pointer : STAR ; 

// Name section for template name
nameSection: OPEN_TEMPLATE_NAME ID CLOSE_TEMPLATE_NAME;

// System section
system: OPEN_SYSTEM 'system' ID SEMICOLON CLOSE_SYSTEM;

// Queries section
queries: OPEN_QUERIES query* CLOSE_QUERIES;



// Location section
location: OPEN_LOCATION 'id' EQUAL STRING 'x' EQUAL STRING 'y' EQUAL STRING '>' nameSection? CLOSE_LOCATION;
inItLocation: INIT STRING CLOSE_SOURCE_TARGET;

// Transition section
transition: OPEN_TRANSITION source target (label)*? CLOSE_TRANSITION;

// Label section
label: OPEN_LABEL ('kind' EQUAL STRING)? GT expression CLOSE_LABEL;

expression:  ( ID  
			  (ID)? // FOR Switch and case
              (LBRACK INT RBRACK)?  
              (EQEQ|EQUAL| GE|LPAREN ((HEX_INT| (ID MINUS LPAREN ID MINUS ID RPAREN) | ID |INT) COMMA?)*? RPAREN|NOTEQ |PLUSPLUS ) ?
              ((LPAREN? ID (PERCENT|SLASH) INT RPAREN? SLASH? INT? PLUS QUOTE INT QUOTE ) | (QUOTE (ID|EQUAL) QUOTE)|(ID PLUS INT)|ID | INT |ID LPAREN ID? RPAREN)? COMMA? | comment)*? ;
 
// Source and Target
source: OPEN_SOURCE STRING CLOSE_SOURCE_TARGET; // Source definition
target: OPEN_TARGET STRING CLOSE_SOURCE_TARGET; // Target definition

// Query section
query: OPEN_QUERY OPEN_FORMULA CLOSE_FORMULA OPEN_COMMENT CLOSE_COMMENT CLOSE_QUERY;

// Comment rule
comment: UPPAAL_COMMENT_WITH_TEXT;
