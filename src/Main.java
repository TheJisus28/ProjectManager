
import data.BBDD;
import logic.user.RegisterLogic;
import models.User;
import ui.users.UserLoginUI;

/**
 *
 * @author JESUS DANIEL
 */

public class Main {
    static String usuarioActual;
    
    public static void main(String[] args) {
        // Creamos un nuevo usuario con los datos deseados para Jesus Carracal
        String nombreJesus = "Jesus Carracal";
        String edadJesus = "25";
        String sexoJesus = "Masculino";
        String dependenciaJesus = "Departamento";
        String tituloJesus = "Título";
        String cedulaJesus = "123";
        String contrasenaJesus = "123";

        // Registramos el usuario Jesus Carracal
        int registrado = RegisterLogic.registrarUsuario(cedulaJesus,nombreJesus, edadJesus, sexoJesus, dependenciaJesus, tituloJesus, contrasenaJesus, contrasenaJesus);
        
        if(registrado ==1){
            System.out.println("valor de registrado: " + registrado);
            User user = BBDD.obtenerUsuarioPorCedula("123"); // Obtener el usuario por su cédula
            System.out.println("mostramos el nombre: " + user.getNombre());
        }
        
        /**
         // Creamos un nuevo usuario con los datos deseados para Maria
        String nombreMaria = "Maria";
        int edadMaria = 30; // Asumiendo una edad para el ejemplo
        String sexoMaria = "Femenino";
        String dependenciaMaria = "Departamento";
        String tituloMaria = "Título";
        String cedulaMaria = "321";
        String contrasenaMaria = "321";

        // Registramos el usuario Maria pasando los datos directamente al constructor
        RegisterLogic.registrarUsuario(nombreMaria, Integer.toString(edadMaria), sexoMaria, dependenciaMaria, tituloMaria, cedulaMaria, contrasenaMaria, contrasenaMaria);
         
         */
        
           
        new UserLoginUI().setVisible(true);

    }
}
