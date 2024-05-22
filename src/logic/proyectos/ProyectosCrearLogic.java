package logic.proyectos;

import logic.LogicUtilidades;
import data.BBDD;
import logic.Validators;
import ui.utils.UiUtilidades;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProyectosCrearLogic {
    
    public static int crearProyecto(String idProyecto, String nombre, String duracionText, String descripcion, String encargado, String fechaInicioText, String presupuestoText) {
        String ventanaTitulo = "Error";
        
        // Validaciones (Fail Fast Assertions)
        
        // Campos vacíos
        if (Validators.hayCamposVacios(idProyecto, nombre, duracionText, descripcion, encargado, fechaInicioText, presupuestoText)) {
            UiUtilidades.mostrarVentana("Todos los campos son requeridos", ventanaTitulo);
            return -1;
        }
        
        // Duración es número
        if (!Validators.contieneSoloNumeros(duracionText)) {
            UiUtilidades.mostrarVentana("La duración debe ser un número entero", ventanaTitulo);
            return -1;
        }
        
        int duracion = Integer.parseInt(duracionText);
        
        // Fecha de inicio válida
        if (!esFechaValida(fechaInicioText)) {
            UiUtilidades.mostrarVentana("La fecha de inicio no es válida", ventanaTitulo);
            return -1;
        }
        
        // Presupuesto es número
        if (!Validators.contieneSoloNumeros(presupuestoText)) {
            UiUtilidades.mostrarVentana("El presupuesto debe ser un número entero", ventanaTitulo);
            return -1;
        }
        
        int presupuesto = Integer.parseInt(presupuestoText);
        
        // Convertir la cadena de fecha de inicio en objeto Date
        Date fechaInicio = LogicUtilidades.convertirStringADate(fechaInicioText);

        // Validar si ocurrió algún error en la conversión
        if (fechaInicio == null) {
            UiUtilidades.mostrarVentana("Error al convertir la fecha de inicio", ventanaTitulo);
            return -1;
        }
        
        // Fin de validaciones

    // Guardar el proyecto en la base de datos
    int resultado = BBDD.registrarProyecto(idProyecto, nombre, duracion, descripcion, encargado, fechaInicio, presupuesto);

    // Asociar el proyecto con el usuario y viceversa
    if (resultado == 1) {
        // Asociar el proyecto con el usuario
        BBDD.agregarPersonaAProyecto(encargado, idProyecto);
        // Asociar el usuario con el proyecto
        BBDD.agregarProyectoAUsuario(encargado, idProyecto);
    }

    return resultado;
    }
    
    // Método para validar si una cadena de texto representa una fecha válida en el formato dd/MM/yyyy
    private static boolean esFechaValida(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
