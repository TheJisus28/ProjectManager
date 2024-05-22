/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.user;
import data.BBDD;
import logic.Validators;
import ui.utils.Utilidades;

/**
 *
 * @author JESUS DANIEL
 */
public class RegisterLogic {
    
     public static int registrarUsuario(String cedula, String nombre, String edadText, String sexo, String dependencia, String titulo , String contrasegnia, String confirmacionContrasegnia) {
        String ventanaTitulo = "Error";
        
        // Validaciones (Fail Fast Assertions)
        
        // Hay campos vacios
        if( Validators.hayCamposVacios(nombre, edadText, sexo, dependencia, titulo, cedula, contrasegnia, confirmacionContrasegnia)){
            Utilidades.mostrarVentana("Todos los campos son requeridos", ventanaTitulo);
            return -1;
        }
        
        // Nombre sin numeros
        if (!Validators.esNombreValido(nombre)) {
            Utilidades.mostrarVentana("El nombre no puede contener números", ventanaTitulo);
            return -1;
        }
        
        //  Edad es numero
        if(!Validators.contieneSoloNumeros(edadText)){
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
        if (!Validators.contieneSoloNumeros(cedula)) {
            Utilidades.mostrarVentana("La cedula solo debe tener numeros", ventanaTitulo);
            return -1;
        }

        // Contrasegnia segura
//        if (!Validators.esContrasenaValida(contrasegnia)) {
//            Utilidades.mostrarVentana("La contraseña debe tener al menos 8 caracteres y contener al menos una letra mayúscula, una letra minúscula y un número.", ventanaTitulo);
//            return -1;
//        }

        // Contrasegnias iguales
        if (!contrasegnia.equals(confirmacionContrasegnia)) {
            Utilidades.mostrarVentana("Las contraseñas no coinciden", ventanaTitulo);
            return -1;
        }
      
        // Fin de validaciones, regitramos usuario.
        
        return BBDD.registerUser(cedula,nombre, edad, sexo, dependencia, titulo , contrasegnia);
        
     }
}
