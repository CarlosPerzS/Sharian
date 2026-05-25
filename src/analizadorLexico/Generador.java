/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorLexico;

import java.io.File;

public class Generador {
    public static void main(String[] args) {
        // Asegúrate de que esta ruta apunte exactamente a donde está tu archivo .flex
        String ruta = "src/analizadorLexico/Lexer.flex"; 
        generarLexer(ruta);
    }
    
    public static void generarLexer(String ruta) {
        File archivo = new File(ruta);
        try {
            JFlex.Main.generate(archivo);
            System.out.println("¡Lexer generado con éxito! Ya tienes el código nuevo.");
        } catch (Exception e) {
            System.out.println("Error al generar el Lexer: " + e.getMessage());
        }
    }
}