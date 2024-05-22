package logic.user;

import data.BBDD;
import models.User;
import ui.utils.Utilidades;

public class LoginLogic {

    public static int validateLogin(String cedula, String contrasegnia) {
        User user = BBDD.obtenerUsuarioPorCedula(cedula); // Obtener el usuario por su cédula

        if (user != null && user.getContrasegnia().equals(contrasegnia)) {
            return 1; // Usuario encontrado y contraseña correcta
        } else {
            Utilidades.mostrarVentana("Credenciales invalidos", "Error");
            return 0; // Usuario no encontrado o contraseña incorrecta
        }
    }
}