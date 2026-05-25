/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sharian;

import analizadorLexico.Tokens;

/**
 *
 * @author CARLO
 */
public class TokenData {
    public Tokens tipo;
    public String lexema;

    public TokenData(Tokens tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
    }
}
