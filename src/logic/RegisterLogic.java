/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import data.BBDD;
import utils.Utilidades;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JESUS DANIEL
 */
public class RegisterLogic {
    
     public static int registrarUsuario(String nombre, String edadText, String sexo, String dependencia, String titulo, String cedula, String contrasegnia, String confirmacionContrasegnia) {
        String ventanaTitulo = "Error";
        
        // Validaciones
        
        // Hay campos vacios
        if( hayCamposVacios(nombre, edadText, sexo, dependencia, titulo, cedula, contrasegnia, confirmacionContrasegnia)){
            Utilidades.mostrarVentana("Todos los campos son requeridos", ventanaTitulo);
            return -1;
        }
        
        // Nombre sin numeros
        if (!esNombreValido(nombre)) {
            Utilidades.mostrarVentana("El nombre no puede contener números", ventanaTitulo);
            return -1;
        }
        
        //  Edad es numero
        if(!contieneSoloNumeros(edadText)){
            Utilidades.mostrarVentana("La edad solo debe tener numeros", ventanaTitulo);
            return -1;
        }
        
        // Convertimos edad a numero
        int edad = Integer.parseInt(edadText);
       
        // Edad no negativa
        if (edad < 0) {
          Utilidades.mostrarVentana("La edad no puede ser negativa.", ventanaTitulo);
            return -1;
        }
        
        // Sexo seleccionado
        if (sexo == null || sexo.equalsIgnoreCase("false")) {
            Utilidades.mostrarVentana("Debes seleccionar una opción para el sexo", ventanaTitulo);
            return -1;
        }
        
        // Cedula es numero
        if (!contieneSoloNumeros(cedula)) {
            Utilidades.mostrarVentana("La cedula solo debe tener numeros", ventanaTitulo);
            return -1;
        }

        // Contrasegnia segura
        if (!esContrasenaValida(contrasegnia)) {
            Utilidades.mostrarVentana("La contraseña debe tener al menos 8 caracteres y contener al menos una letra mayúscula, una letra minúscula y un número.", ventanaTitulo);
            return -1;
        }

        // Contrasegnias iguales
        if (!contrasegnia.equals(confirmacionContrasegnia)) {
            Utilidades.mostrarVentana("Las contraseñas no coinciden", ventanaTitulo);
            return -1;
        }
      
        // Fin de validaciones, regitramos usuario.
        
        return BBDD.registerUser(nombre, edad, sexo, dependencia, titulo, cedula, contrasegnia);
        
     }
   
     
     public static boolean hayCamposVacios(String nombre, String edadText, String sexo, String dependencia, String titulo, String cedula, String contrasegnia, String confirmacionContrasegnia){
    // Si están vacios, Mostrar mensaje de error
        
        return (nombre.isEmpty() || edadText.isEmpty() || sexo == null || titulo.isEmpty() ||
                dependencia.isEmpty() || cedula.isEmpty() || contrasegnia.isEmpty() ||
                confirmacionContrasegnia.isEmpty());
    }
    
     private static boolean esContrasenaValida(String contrasena) {
        // Verificar que la contraseña tenga al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();
    }
    private static boolean esNombreValido(String nombre) {
        // Verificar que el nombre no contenga números
        return !nombre.matches(".*\\d.*");
    }
    
    private static boolean contieneSoloNumeros(String cadena) {
    // Verificar que la cédula solo contenga números
    for (int i = 0; i < cadena.length(); i++) {
        if (!Character.isDigit(cadena.charAt(i))) {
            return false;
        }
    }

    return true;
    }
}
