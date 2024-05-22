/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JESUS DANIEL
 */
public class Validators {
    
    // Método para verificar si hay campos vacíos en una lista de cadenas
    public static boolean hayCamposVacios(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return true; // Se encontró un campo vacío
            }
        }
        return false; // No se encontraron campos vacíos
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
    
    
        /**
     * Verifica si una cadena representa una fecha válida en formato "dd/mm/aaaa".
     * @param fechaStr La cadena de fecha a verificar.
     * @return true si la cadena representa una fecha válida, false de lo contrario.
     */
    public static boolean esFechaValida(String fechaStr) {
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        try {
            formatoFecha.parse(fechaStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
