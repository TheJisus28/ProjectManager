package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.*;

public class BBDD {
    private static List<User> usersList = new ArrayList<>(); // ArrayList para almacenar usuarios
    private static List<Proyecto> proyectosList = new ArrayList<>(); // ArrayList para almacenar proyectos
    private static List<Actividad> actividadesList = new ArrayList<>(); // ArrayList para almacenar actividades
    private static List<Tarea> tareasList = new ArrayList<>(); // ArrayList para almacenar tareas

    
    
    // ----------------------------------- "GETTERS AND SETTERS" -----------------------------------------
    
    // Registrar usuario
    public static int registerUser(String nombre, int edad, String sexo, String dependencia, String titulo, String cedula, String contrasegnia) {
        // Validamos que el usuario a registrar no se encuentre en la BBDD
        if (obtenerUsuarioPorCedula(cedula) != null) {
            // Si la cédula ya existe en la lista, retornar -1 indicando error
            return -1;
        }

        User newUser = new User(cedula, edad, sexo, dependencia, titulo, contrasegnia); // Crear un nuevo usuario
        usersList.add(newUser); // Almacenar usuario en el ArrayList
        return 1; // Retornar 1 indicando éxito
    }

    // Obtener usuario por cédula
    public static User obtenerUsuarioPorCedula(String cedula) {
        for (User user : usersList) {
            if (user.getCedula().equals(cedula)) {
                return user;
            }
        }
        return null; // Retornar null si el usuario no se encuentra
    }

    // Registrar proyecto
    public static int registrarProyecto(String idProyecto, int duracion, String descripcion, String encargado, Date fechaInicio, Date fechaFinal, int presupuesto) {
        // Validamos que el proyecto a registrar no se encuentre en la BBDD
        if (obtenerProyectoPorId(idProyecto) != null) {
            // Si el proyecto ya existe en la lista, retornar -1 indicando error
            return -1;
        }

        Proyecto newProyecto = new Proyecto(idProyecto, duracion, descripcion, encargado, fechaInicio, fechaFinal, presupuesto); // Crear un nuevo proyecto
        proyectosList.add(newProyecto); // Almacenar proyecto en el ArrayList
        return 1; // Retornar 1 indicando éxito
    }

    // Obtener proyecto por id
    public static Proyecto obtenerProyectoPorId(String idProyecto) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                return proyecto;
            }
        }
        return null; // Retornar null si el proyecto no se encuentra
    }

    // Registrar actividad
    public static int registrarActividad(String idActividad, String descripcion, Date fechaInicial, Date fechaFinal, String idProyecto) {
        // Validamos que la actividad a registrar no se encuentre en la BBDD
        if (obtenerActividadPorId(idActividad) != null) {
            // Si la actividad ya existe en la lista, retornar -1 indicando error
            return -1;
        }

        Actividad newActividad = new Actividad(idActividad, descripcion, fechaInicial, fechaFinal, idProyecto); // Crear una nueva actividad
        actividadesList.add(newActividad); // Almacenar actividad en el ArrayList
        return 1; // Retornar 1 indicando éxito
    }

    // Obtener actividad por id
    public static Actividad obtenerActividadPorId(String idActividad) {
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                return actividad;
            }
        }
        return null; // Retornar null si la actividad no se encuentra
    }

    // Registrar tarea
    public static int registrarTarea(String idTarea, String nombre, String descripcion, int costo, Date fechaInicial, Date fechaFinal) {
        // Validamos que la tarea a registrar no se encuentre en la BBDD
        if (obtenerTareaPorId(idTarea) != null) {
            // Si la tarea ya existe en la lista, retornar -1 indicando error
            return -1;
        }

        Tarea newTarea = new Tarea(idTarea, nombre, descripcion, costo, fechaInicial, fechaFinal); // Crear una nueva tarea
        tareasList.add(newTarea); // Almacenar tarea en el ArrayList
        return 1; // Retornar 1 indicando éxito
    }

    // Obtener tarea por id
    public static Tarea obtenerTareaPorId(String idTarea) {
        for (Tarea tarea : tareasList) {
            if (tarea.getIdTarea().equals(idTarea)) {
                return tarea;
            }
        }
        return null; // Retornar null si la tarea no se encuentra
    }

    
    
    // --------------------------- MODIFICAR DATOS -----------------------------
    
    // Modificar datos de un usuario
    public static void modificarDatosUsuario(String cedulaUsuario, String nombre, int edad, String sexo, String dependencia, String titulo, String contrasegnia) {
        // Buscar el usuario por su cédula
        for (User user : usersList) {
            if (user.getCedula().equals(cedulaUsuario)) {
                // Modificar los datos del usuario
                user.setNombre(nombre);
                user.setEdad(edad);
                user.setSexo(sexo);
                user.setDependencia(dependencia);
                user.setTitulo(titulo);
                user.setContrasegnia(contrasegnia);
                return; // Salir del método una vez modificados los datos del usuario
            }
        }
    }
    
    // Modificar datos de una tarea
    public static void modificarTarea(String idTarea, String nombre, String descripcion, int costo, Date fechaInicial, Date fechaFinal) {
        // Buscar la tarea por su ID
        for (Tarea tarea : tareasList) {
            if (tarea.getIdTarea().equals(idTarea)) {
                // Modificar los datos de la tarea
                tarea.setNombre(nombre);
                tarea.setDescripcion(descripcion);
                tarea.setCosto(costo);
                tarea.setFechaInicial(fechaInicial);
                tarea.setFechaFinal(fechaFinal);
                return; // Salir del método una vez modificados los datos de la tarea
            }
        }
    }

    // Modificar datos de una actividad
    public static void modificarActividad(String idActividad, String descripcion, Date fechaInicial, Date fechaFinal) {
        // Buscar la actividad por su ID
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                // Modificar los datos de la actividad
                actividad.setDescripcion(descripcion);
                actividad.setFechaInicial(fechaInicial);
                actividad.setFechaFinal(fechaFinal);
                return; // Salir del método una vez modificados los datos de la actividad
            }
        }
    }

    // Modificar datos de un proyecto
    public static void modificarProyecto(String idProyecto, int duracion, String descripcion, String encargado, Date fechaInicio, Date fechaFinal, int presupuesto) {
        // Buscar el proyecto por su ID
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                // Modificar los datos del proyecto
                proyecto.setDuracion(duracion);
                proyecto.setDescripcion(descripcion);
                proyecto.setEncargado(encargado);
                proyecto.setFechaInicio(fechaInicio);
                proyecto.setFechaFinal(fechaFinal);
                proyecto.setPresupuesto(presupuesto);
                return; // Salir del método una vez modificados los datos del proyecto
            }
        }
    }


    
    // ----------------------------------- FUNCIONALIDADES -------------------------------------------
    
    
    // Agregar persona a un proyecto
    public static void agregarPersonaAProyecto(String cedulaPersona, String idProyecto) {
        // Buscar el proyecto por su ID
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                // Verificar si la persona ya está en el proyecto
                if (!proyecto.getPersonal().contains(cedulaPersona)) {
                    // Si no está, agregarla
                    proyecto.getPersonal().add(cedulaPersona);
                }
                return; // Salir del método una vez agregada la persona al proyecto
            }
        }
    }
    
    // Agregar proyecto a un usuario
    public static void agregarProyectoAUsuario(String cedulaUsuario, String idProyecto) {
        // Buscar el usuario por su cédula
        for (User user : usersList) {
            if (user.getCedula().equals(cedulaUsuario)) {
                // Verificar si el proyecto ya está asociado al usuario
                if (!user.getProyectos().contains(idProyecto)) {
                    // Si no está, agregarlo
                    user.getProyectos().add(idProyecto);
                }
                return; // Salir del método una vez agregado el proyecto al usuario
            }
        }
    }

    // Agregar actividad a un proyecto
    public static void agregarActividadAProyecto(String idProyecto, String idActividad) {
        // Buscar el proyecto por su ID
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                // Verificar si la actividad ya está en el proyecto
                if (!proyecto.getActividades().contains(idActividad)) {
                    // Si no está, agregarla
                    proyecto.getActividades().add(idActividad);
                }
                return; // Salir del método una vez agregada la actividad al proyecto
            }
        }
    }

    // Agregar tarea a una actividad
    public static void agregarTareaAActividad(String idActividad, String idTarea) {
        // Buscar la actividad por su ID
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                // Verificar si la tarea ya está en la actividad
                if (!actividad.getTareas().contains(idTarea)) {
                    // Si no está, agregarla
                    actividad.getTareas().add(idTarea);
                }
                return; // Salir del método una vez agregada la tarea a la actividad
            }
        }
    }

    
    
    // ----------------------------------- PREGUNTAS ----------------------------------- ---------------------
    
    // -------- PREGUNTA 1 -------- 
    
    // Consultar de un proyecto que actividades se han cumplido
    public static ArrayList<String> consultarActividadesCumplidas(String idProyecto) {
        ArrayList<String> actividadesCumplidas = new ArrayList<>();
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdProyecto().equals(idProyecto) && actividad.isEstado()) {
                actividadesCumplidas.add(actividad.getIdActividad());
            }
        }
        return actividadesCumplidas;
    }
    
    // Consultar de un proyecto que actividades se no han cumplido 
    public static ArrayList<String> consultarActividadesNoCumplidas(String idProyecto) {
        ArrayList<String> actividadesNoCumplidas = new ArrayList<>();
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdProyecto().equals(idProyecto) && !actividad.isEstado()) {
                actividadesNoCumplidas.add(actividad.getIdActividad());
            }
        }
        return actividadesNoCumplidas;
    }

    // Consultar todas las tareas de una actividad
    public static ArrayList<Tarea> obtenerTareasDeActividad(String idActividad) {
        ArrayList<Tarea> tareasDeActividad = new ArrayList<>();
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                for (String idTarea : actividad.getTareas()) {
                    Tarea tarea = obtenerTareaPorId(idTarea);
                    if (tarea != null) {
                        tareasDeActividad.add(tarea);
                    }
                }
                break;
            }
        }
        return tareasDeActividad;
    }
    
    // Obtenermos la cantidad de tareas y la cantidad de tareas completadas y faltantes por actividad
    // [cantidadDeTareas,tareasCompletadas,tareasFaltantes]
    public static int[] consultarEstadisticasTareasDeActividad(String idActividad) {
        int[] estadisticas = new int[3]; // 0: total tareas, 1: tareas cumplidas, 2: tareas no cumplidas
        int totalTareas = 0;
        int tareasCumplidas = 0;
        int tareasNoCumplidas = 0;

        Actividad actividad = obtenerActividadPorId(idActividad);
        if (actividad != null) {
            for (String idTarea : actividad.getTareas()) {
                Tarea tarea = obtenerTareaPorId(idTarea);
                if (tarea != null) {
                    totalTareas++;
                    if (tarea.isEstado()) {
                        tareasCumplidas++;
                    } else {
                        tareasNoCumplidas++;
                    }
                }
            }
        }

        estadisticas[0] = totalTareas;
        estadisticas[1] = tareasCumplidas;
        estadisticas[2] = tareasNoCumplidas;

        return estadisticas;
    }
    
    // -------- PREGUNTA 2 --------
    
    // Consultar todas las tareas del proyecto
    public static ArrayList<String> consultarTodasTareas(String idProyecto) {
        ArrayList<String> todasTareas = new ArrayList<>();
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdProyecto().equals(idProyecto)) {
                todasTareas.addAll(actividad.getTareas());
            }
        }
        return todasTareas;
    }
    
    
    // ------- PREGUTA 3 ---------
    
    // Consultar cuantas personas trabajan en el proyecto
    public static int cantidadPersonasTrabajanProyecto(String idProyecto) {
        int cantidad = 0;
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                cantidad = proyecto.getPersonal().size();
                break;
            }
        }
        return cantidad;
    }
    
    // Consultar personas que participan en el proyecto
    public static ArrayList<String> obtenerPersonasProyecto(String idProyecto) {
        ArrayList<String> personasProyecto = new ArrayList<>();
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                personasProyecto.addAll(proyecto.getPersonal());
                break;
            }
        }
        return personasProyecto;
    }

    
    // -------- PREGUNTA 4 ---------
    
    // Consultar la persona responsable del proyecto
    public static String personaResponsableProyecto(String idProyecto) {
        String responsable = "";
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                responsable = proyecto.getEncargado();
                break;
            }
        }
        return responsable;
    }
}
