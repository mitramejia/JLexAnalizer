package analizador;

import static analizador.Tokens.*;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
Esp=[\ \t\r\n]
WHITE=[ \t\r\n]
IDENTIFICADOR=[A-Za-z_]+[0-9]*
%{
public String Tipo;
%}
%%

"+" {return SUMA;}
"-" {return RESTA;}
"*" {return MULTIPLICACION;}
"/" {return DIVISION;}
    "^" {return POTENCIA;}
{IDENTIFICADOR} {Tipo=yytext(); return IDENTIFICADOR;}
{D}+{Esp}* {Tipo=yytext(); return NUMERO;}
{D}+("*"|"+"|"-"|"/"|"^"){D}+{Esp}* {Tipo=yytext(); return VALIDO;}
{Esp} {Tipo=yytext(); return SEPARADOR;}
.*|,+ {return ERROR;}

