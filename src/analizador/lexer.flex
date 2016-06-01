package analizador;

import static analizador.Tokens.*;
%%
%class AnalizadorJFlex
%type Tokens
D=[0-9]
Esp=[\ \t\r\n]
WHITE=[ \t\r\n]
i=[iI]
n=[nN]
t=[tT]
e=[eE]
g=[gG]
e=[eE]
r=[rR]
c=[cC]
h=[hH]
a=[aA]
l=[lL]

IDENTIFICADOR=[A-Za-z_]+[0-9]*
MATRICULA=\b([0-9]{2}("-")[0-9]{4})\b
PRIMERA_ULTIMA_MINUSCULA=(([a]+[a-z]+[a])|([b]+[a-z]+[b]))
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
\((829|809|849)\)"-"{D}{3}"-"{D}{4} {Tipo=yytext(); return TELEFONO;}
({i}{n}{t}{e}{g}{e}{r}|{c}{h}{a}{r}|{r}{e}{a}{l}) {Tipo=yytext(); return PALABRAS_RESERVADAS;}
{PRIMERA_ULTIMA_MINUSCULA} {Tipo=yytext(); return PRIMERA_ULTIMA_MINUSCULA;}
{D}+{Esp}* {Tipo=yytext(); return NUMERO;}
[0-9]{2}"-"[0-9]{4} {Tipo=yytext(); return MATRICULA;}
{D}+("*"|"+"|"-"|"/"|"^"){D}+{Esp}* {Tipo=yytext(); return VALIDO;}
{Esp} {Tipo=yytext(); return SEPARADOR;}
.*|,+ {return ERROR;}

