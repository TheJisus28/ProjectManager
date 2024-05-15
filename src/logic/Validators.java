/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JESUS DANIEL
 */
public class Validators {
    
    public static boolean hayCamposVacios(String nombre, String edadText, String sexo, String dependencia, String titulo, String cedula, String contrasegnia, String confirmacionContrasegnia){
    // Si están vacios, Mostrar mensaje de error
        return (nombre.isEmpty() || edadText.isEmpty() || sexo == null || titulo.isEmpty() ||
                dependencia.isEmpty() || cedula.isEmpty() || contrasegnia.isEmpty() ||
                confirmacionContrasegnia.isEmpty());
    }
    
     public static boolean esContrasenaValida(String contrasena) {
        // Verificar que la contraseña tenga al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();
    }
     
    public static boolean esNombreValido(String nombre) {
        // Verificar que el nombre no contenga números
        return !nombre.matches(".*\\d.*");
    }
    
    public static boolean contieneSoloNumeros(String cadena) {
    // Verificar que la cédula solo contenga números
    for (int i = 0; i < cadena.length(); i++) {
        if (!Character.isDigit(cadena.charAt(i))) {
            return false;
        }
    }
    return true;
    }
}
