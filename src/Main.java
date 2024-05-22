
import logic.user.RegisterLogic;
import ui.users.UserLoginUI;

/**
 *
 * @author JESUS DANIEL
 */

public class Main {
    static String usuarioActual;
    
    public static void main(String[] args) {
        // Creamos un nuevo usuario con los datos deseados para Jesus Carracal
        String nombreJesus = "Jesus Carrascal";
        String edadJesus = "25";
        String sexoJesus = "Masculino";
        String dependenciaJesus = "Departamento";
        String tituloJesus = "Título";
        String cedulaJesus = "123";
        String contrasenaJesus = "123";

        // Registramos el usuario Jesus Carrascal
        RegisterLogic.registrarUsuario(cedulaJesus,nombreJesus, edadJesus, sexoJesus, dependenciaJesus, tituloJesus, contrasenaJesus, contrasenaJesus);

        
         // Creamos un nuevo usuario con los datos deseados para Maria
        String nombreMaria = "Maria Rodriguez";
        String edadMaria = "30"; // Asumiendo una edad para el ejemplo
        String sexoMaria = "Femenino";
        String dependenciaMaria = "Departamento";
        String tituloMaria = "Título";
        String cedulaMaria = "321";
        String contrasenaMaria = "321";

        // Registramos el usuario Maria pasando los datos directamente al constructor
        RegisterLogic.registrarUsuario(cedulaMaria,nombreMaria,edadMaria,sexoMaria,dependenciaMaria,tituloMaria,contrasenaMaria,contrasenaMaria);
         
         
        
           
        new UserLoginUI().setVisible(true);

    }
}
