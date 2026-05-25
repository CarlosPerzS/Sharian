/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorSintactico;

import analizadorLexico.Tokens;
import java.util.List;
import sharian.TokenData;

/**
 *
 * @author CARLO
 */
public class Parser {
    private List<TokenData> tokens;
    private int posicion = 0;

    public Parser(List<TokenData> tokens) {
        this.tokens = tokens;
    }
    
    public String analizarSintaxis(){
        try{
            while(posicion < tokens.size()){
                parsear();
            }
            return "COMPILADO CORRECTAMENTE";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    private void parsear() throws Exception{
        TokenData actual = tokens.get(posicion);
        if (actual.tipo == Tokens.RESERVADA){
            switch (actual.lexema.toUpperCase()){
                case "CREAR":
                    validarComandoSimple();
                    break;
                case "CONECTAR":
                    validarComandoSimple();
                    break;
                case "DESCONECTAR":
                    validarDesconectar();
                    break;
                case "BORRAR":
                    validarComandoDatos();//FALTA
                    break;
                case "AGREGAR":
                    validarComandoDatos();//FALTA
                    break;
                case "VER":
                    validarComandoSimple();
                    break;
                case "BUSCAR":
                    validarComandoDatos();//FALTA
                    break;
                case "CAMBIA":
                    validarComandoDatos(); //FALTA
                    break;
                case "CONTAR":
                    validarComandoSimple();
                    break;
                case "VACIO":
                    validarComandoSimple();
                    break;
            } //switch
        } //if tipo
        else{
            throw new Exception("Se esperaba un comando en: " + actual.lexema);
        } //else tipo
    }
    
    private void validarComandoSimple() throws Exception{ //comando identificador ;
        String comando = tokens.get(posicion).lexema;
        posicion++;
        if(posicion >= tokens.size() || tokens.get(posicion).tipo != Tokens.IDENTIFICADOR){
            String error;
            if(posicion >= tokens.size()){
                error = "ERROR: Se esperaba el identificador de "+ comando + " al final del archivo";
            }
            else{
                error = "ERROR: Se esperaba el identificador de "+ comando + " en vez de: '" + tokens.get(posicion).lexema +"'";
            }
            throw new Exception (error);
        }
        posicion++;
        if(posicion >= tokens.size() || tokens.get(posicion).tipo != Tokens.PUNTO_COMA){
            String error;
            if(posicion >= tokens.size()){
                error = "ERROR: Se esperaba ; al final del archivo";
            }
            else{
                error = "ERROR: Se esperaba ; de "+ comando + " en vez de: '" + tokens.get(posicion).lexema +"'";
            }
            throw new Exception (error);
        }
        posicion++;
    }
    
    private void validarComandoDatos() throws Exception{ //comando identificador {dato} ;
        throw new Exception ("ERROR: TODAVIA NO TERMINAMOS ESTAS VERIFICACIONES");
    }
    
    private void validarDesconectar() throws Exception{ //comando;
        String comando = tokens.get(posicion).lexema;
        posicion++;
        if(posicion >= tokens.size() || tokens.get(posicion).tipo != Tokens.PUNTO_COMA){
            String error;
            if(posicion >= tokens.size()){
                error = "ERROR: Se esperaba ; al final del archivo";
            }
            else{
                error = "ERROR: Se esperaba ; de "+ comando + " en vez de: '" + tokens.get(posicion).lexema +"'";
            }
            throw new Exception (error);
        }
        posicion++;
    }
}
