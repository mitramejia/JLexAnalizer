package analizador;

import static analizador.Tokens.*;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
Esp=[\ \t\r\n]
WHITE=[ \t\r\n]
%{
public String Tipo;
%}
%%

"+" {return SUMA;}
"-" {return RESTA;}
"*" {return MULTIPLICACION;}
"/" {return DIVISION;}
"^" {return POTENCIA;}
{D}+{Esp}* {Tipo=yytext(); return NUMERO;}
{D}+("*"|"+"|"-"|"/"|"^"){D}+{Esp}* {Tipo=yytext(); return VALIDO;}
{Esp} {Tipo=yytext(); return SEPARADOR;}
.*|,+ {return ERROR;}