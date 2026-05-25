package analizadorLexico;
import diccionario.palabrasReservadas;
import static analizadorLexico.Tokens.*;
%%
%class Lexer
%public
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
    private Tokens identificarToken(String lexema){
        try{
            diccionario.palabrasReservadas.valueOf(lexema.toUpperCase());
            return Tokens.RESERVADA;
        } catch(IllegalArgumentException e) {
            return Tokens.IDENTIFICADOR; // Si lanza error, es un identificador normal
        }
    }
%}
%%
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

{L}({L}|{D})* {
    lexeme = yytext();
    return identificarToken(yytext()); 
}

{D}+ { 
    lexeme = yytext();
    return Tokens.NUMERO; 
}

\"[^\"]*\" {
    lexeme = yytext();
    return Tokens.TEXTO; 
}

"{" { lexeme = yytext(); return Tokens.LLAVE_A; }
"}" { lexeme = yytext(); return Tokens.LLAVE_C; }
":" { lexeme = yytext(); return Tokens.DOS_PUNTOS; }
"(" { lexeme = yytext(); return Tokens.PARENTESIS_A; }
")" { lexeme = yytext(); return Tokens.PARENTESIS_C; }
"," { lexeme = yytext(); return Tokens.COMA; }
";" { lexeme = yytext(); return Tokens.PUNTO_COMA; }
. { 
    lexeme = yytext(); 
    return Tokens.ERROR; 
}