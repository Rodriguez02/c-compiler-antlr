grammar reglas;

@header {
package app;
}

//////////////////////////////////////////////////////////////////////////////
/////////////////////////////  Regex /////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

fragment LETRA : [A-Za-z];
fragment DIGITO : [0-9];

// LLaves, corchetes, parentesis
PA   : '(' ;
PC   : ')' ;
CA   : '[' ;
CC   : ']' ;
LA   : '{' ;
LC   : '}' ;

// Punto y coma, coma
PYC  : ';' ;
COMA : ',' ;

// assignment
EQ   : '=' ;

// comparison (mayor, menor, mayor-igual, menor-igual, igual, distinto)
MAY  : '>' ;
MAYEQ: '>=';
MEN  : '<' ;
MENEQ: '<=';
EQL  : '==';
DST  : '!=';

// operaciones matematicas
SUM  : '+' ;
RES  : '-' ;
MUL  : '*' ;
DIV  : '/' ;
MOD  : '%' ;

// operaciones logicas
OR   : '||' ;
AND  : '&&' ;
NOT  : '!'  ;

// Bucles for y while
FOR  : 'for';
WHILE: 'while';

// Sentencia if else
IF   : 'if' ;
ELSE : 'else' ;

// Tipo de datos
INT     : 'int' ;
CHAR    : 'char' ;
DOUBLE  : 'double' ;
VOID    : 'void' ;

// Retornar
RETURN : 'return';

// Variables
ID : (LETRA | '_') (LETRA | DIGITO | '_')*;

// Numeros
INTEGER : DIGITO+;
DECIMAL : INTEGER'.'INTEGER;

// Caracetes
CHARACTER: '\''(LETRA|OTRO|DIGITO)'\'';

// Otros
WS : [ \n\t] -> skip ;
OTRO : . ;

//////////////////////////////////////////////////////////////////////////////
//////////////////////  Reglas sintácticas ///////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

prog: instructions EOF; 

instructions : instruction instructions 
              |
              ;

block : LA instructions LC 
       ;

instruction : declaration PYC
            | assignment PYC
            | cyclefor
            | cyclewhile
            | condif
            | prototype PYC
            | function
            | callfunction PYC
            | retorno PYC
            | block
            ;

retorno : RETURN opal;

declaration : datatype ID
            | datatype ID asign
            ;

asign : EQ operation
      ;

datatype : INT
         | CHAR
         | DOUBLE
         | VOID
         ;

assignment  : ID asign
            ;

// Bucles
cyclefor : FOR PA assignment PYC operation PYC ID asign PC instruction
         ;

cyclewhile : WHILE PA operation PC instruction
           ;

// Sentencia if else
condif : IF PA operation PC instruction
       | IF PA operation PC block ELSE block
       ;

// funciones
prototype : datatype ID PA parameters PC
          ;

function : datatype ID PA parameters PC block
        ;

parameters : param
           ;

param : declaration param
      | COMA declaration param
      |
      ;

callfunction : ID PA arguments PC
               ;

arguments : operation arg
          ;

arg  : COMA operation arg
     |
     ;

// operaciones aritmeticas-logicas
operation : opal ;

opal : disjunction 
     |
     ;

disjunction : conjunction disy
           ;

disy : OR conjunction disy
     |
     ;

conjunction : comparison conj
           ;

conj : AND comparison conj
     |
     ;

comparison : expression comp
              ;

comp : opcomp expression comp
     |
     ;

opcomp : EQL
       | DST
       | MAY
       | MAYEQ
       | MEN
       | MENEQ
       ;

// Expresiones
expression : term exp;

exp : SUM term exp
    | RES term exp
    |
    ;

// Terminos
term : factor ter ;

ter : MUL factor ter
    | DIV factor ter
    | MOD factor ter
    |
    ;

// Factores
factor : f PA opal PC
       | f callfunction
       | f INTEGER
       | f DECIMAL
       | f CHARACTER
       | f ID
       ;

f : SUM
  | RES
  | NOT
  |
  ;