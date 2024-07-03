/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.user;
import data.BBDD;
import logic.Validators;
import ui.utils.UiUtilidades;

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
            UiUtilidades.mostrarVentana("Todos los campos son requeridos", ventanaTitulo);
            return -1;
        }
        
        // Nombre sin numeros
        if (!Validators.esNombreValido(nombre)) {
            UiUtilidades.mostrarVentana("El nombre no puede contener números", ventanaTitulo);
            return -1;
        }
        
        //  Edad es numero
        if(!Validators.contieneSoloNumeros(edadText)){
            UiUtilidades.mostrarVentana("La edad solo debe tener numeros", ventanaTitulo);
            return -1;
        }
        
        // Convertimos edad a numero
        int edad = Integer.parseInt(edadText);
       
        // Edad no negativa
        if (edad < 0) { 
          UiUtilidades.mostrarVentana("La edad no puede ser negativa.", ventanaTitulo);
            return -1;
        }
        
        // Sexo seleccionado
        if (sexo == null || sexo.equalsIgnoreCase("false")) {
            UiUtilidades.mostrarVentana("Debes seleccionar una opción para el sexo", ventanaTitulo);
            return -1;
        }
        
        // Cedula es numero
        if (!Validators.contieneSoloNumeros(cedula)) {
            UiUtilidades.mostrarVentana("La cedula solo debe tener numeros", ventanaTitulo);
            return -1;
        }

        // Contrasegnia segura
//        if (!Validators.esContrasenaValida(contrasegnia)) {
//            UiUtilidades.mostrarVentana("La contraseña debe tener al menos 8 caracteres y contener al menos una letra mayúscula, una letra minúscula y un número.", ventanaTitulo);
//            return -1;
//        }

        // Contrasegnias iguales
        if (!contrasegnia.equals(confirmacionContrasegnia)) {
            UiUtilidades.mostrarVentana("Las contraseñas no coinciden", ventanaTitulo);
            return -1;
        }
        
        // Verificar que ya esta cedula no esté en uso
        
      
        // Fin de validaciones, regitramos usuario.
        
        if (BBDD.registerUser(cedula,nombre, edad, sexo, dependencia, titulo , contrasegnia) == -1){
            UiUtilidades.mostrarVentana("Ya existe un usuario registrado con esta cedula", ventanaTitulo);
            return -1;
        } 
        
        return 1;
     }
}
