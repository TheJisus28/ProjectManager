/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.HashMap;
import models.User;
import utils.Utilidades;

/**
 *
 * @author JESUS DANIEL
 */
public class BBDD {
    private static HashMap<String, User> usersMap = new HashMap<>(); // HashMap para almacenar usuarios por cédula

    // registrar usuario
    public static int registerUser(String nombre, int edad, String sexo, String dependencia, String titulo, String cedula, String contrasegnia) {
        
        // Validamos que el usuario a registrar no se encuentre en la BBDD
        if (usersMap.containsKey(cedula)) {
            // Si la cédula ya existe en el HashMap, retornar -1 indicando error
            Utilidades.mostrarVentana("Ya existe un usuario registrado con esta cédula", "Error");
            return -1;
        }

        User newUser = new User(); // Crear un nuevo usuario
        newUser.setCedula(cedula); // Asignar cédula
        newUser.setNombre(nombre); // Asignar nombre
        newUser.setEdad(edad); // Asignar edad
        newUser.setSexo(sexo); // Asignar sexo
        newUser.setDependencia(dependencia); // Asignar dependencia
        newUser.setTitulo(titulo); // Asignar título
        newUser.setContrasegnia(contrasegnia); // Asignar contraseña

        usersMap.put(cedula, newUser); // Almacenar usuario en el HashMap
        return 1; // Retornar 1 indicando éxito
    }
    
    // obtener usuario
    public static User obtenerUsuarioPorCedula(String cedula) {
        return usersMap.get(cedula);
    }

}
