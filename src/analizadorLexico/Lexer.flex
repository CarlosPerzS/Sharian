package analizadorLexico;
import diccionario.palabrasReservadas;
import static analizadorLexico.Tokens.*;
%%
%class Lexer
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
"(" { return Tokens.PARENTESIS_A; }
")" { return Tokens.PARENTESIS_C; }
"," { return Tokens.COMA; }
";" { return Tokens.PUNTO_COMA; }
. { 
    lexeme = yytext(); // Capturamos el símbolo extraño
    return Tokens.ERROR; 
}
"(" { return Parentesis_A; }
")" { return Parentesis_C; }
"," { return Coma; }
";" { return Punto_Coma; }
. { return ERROR; }