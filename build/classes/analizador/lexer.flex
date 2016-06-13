package analizador;

import static analizador.Tokens.*;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
Op=[\*\/\-\^\+]
Prt=[\)\(\[\]\{\}]

%{
public String Tipo;
%}
%%

[0-9] {return DIGITO;}
"+" {return SUMA;}
"-" {return RESTA;}
"*" {return MULTIPLICACION;}
"/" {return DIVISION;}
"(" {return PAREN_LFT;}
")" {return PAREN_RGT;}
"^" {return POTENCIA;}

([\-\+]?{Prt}*({D}+|{D}*\.{D}+)+{Prt}*+{Op}*{Prt}*)*({D}+|{D}*\.{D}+)+{Prt}* {Tipo=yytext(); return VALIDO;}
.*|,+ {return ERROR;}