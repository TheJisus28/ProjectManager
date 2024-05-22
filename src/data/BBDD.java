package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.*;

public class BBDD {
    // Listas para almacenar las entidades del sistema
    private static List<User> usersList = new ArrayList<>(); // Lista para almacenar usuarios
    private static List<Proyecto> proyectosList = new ArrayList<>(); // Lista para almacenar proyectos
    private static List<Actividad> actividadesList = new ArrayList<>(); // Lista para almacenar actividades
    private static List<Tarea> tareasList = new ArrayList<>(); // Lista para almacenar tareas

    
    // ----------------------------------- "GETTERS AND SETTERS" -----------------------------------------

    /**
     * Registrar un nuevo usuario en el sistema.
     * 
     * @param nombre      Nombre del usuario
     * @param edad        Edad del usuario
     * @param sexo        Sexo del usuario
     * @param dependencia Dependencia del usuario
     * @param titulo      Título del usuario
     * @param cedula      Cédula del usuario
     * @param contrasegnia Contraseña del usuario
     * @return -1 si el usuario ya existe, 1 si se registra exitosamente
     */
    public static int registerUser(String nombre, int edad, String sexo, String dependencia, String titulo, String cedula, String contrasegnia) {
        System.out.println("Datos recibidos en la bbdd: " + nombre + " : " + cedula);
        if (obtenerUsuarioPorCedula(cedula) != null) {
//            return -1; // Si la cédula ya existe, retornar -1 indicando error
        }

        User newUser = new User(cedula, edad, sexo, dependencia, titulo, contrasegnia); // Crear un nuevo usuario
        usersList.add(newUser); // Almacenar usuario en la lista
        System.out.println("usuario" + newUser.getNombre() + " almacenado");
        return 1; // Retornar 1 indicando éxito
    }

    /**
     * Obtener un usuario por su cédula.
     * 
     * @param cedula Cédula del usuario
     * @return El usuario correspondiente a la cédula, o null si no se encuentra
     */
    public static User obtenerUsuarioPorCedula(String cedula) {
        System.out.println("En la bbdd");
        for (User user : usersList) {
            System.out.println(user.getCedula());
            if (user.getCedula().equals(cedula)) {
                System.out.print("Encontrado");
                return user;
            }
        }
        System.out.print("no Encontrado");
        return null; // Retornar null si el usuario no se encuentra
    }

    /**
     * Registrar un nuevo proyecto en el sistema.
     * 
     * @param idProyecto  ID del proyecto
     * @param nombre      Nombre del proyecto
     * @param duracion    Duración del proyecto
     * @param descripcion Descripción del proyecto
     * @param encargado   Persona encargada del proyecto
     * @param fechaInicio Fecha de inicio del proyecto
     * @param fechaFinal  Fecha de finalización del proyecto
     * @param presupuesto Presupuesto del proyecto
     * @return -1 si el proyecto ya existe, 1 si se registra exitosamente
     */
    public static int registrarProyecto(String idProyecto, String nombre, int duracion, String descripcion, String encargado, Date fechaInicio, Date fechaFinal, int presupuesto) {
        if (obtenerProyectoPorId(idProyecto) != null) {
            return -1; // Si el proyecto ya existe, retornar -1 indicando error
        }

        Proyecto newProyecto = new Proyecto(idProyecto, nombre, duracion, descripcion, encargado, fechaInicio, fechaFinal, presupuesto); // Crear un nuevo proyecto con el nombre
        proyectosList.add(newProyecto); // Almacenar proyecto en la lista
        return 1; // Retornar 1 indicando éxito
    }

    /**
     * Obtener un proyecto por su ID.
     * 
     * @param idProyecto ID del proyecto
     * @return El proyecto correspondiente al ID, o null si no se encuentra
     */
    public static Proyecto obtenerProyectoPorId(String idProyecto) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                return proyecto;
            }
        }
        return null; // Retornar null si el proyecto no se encuentra
    }

    /**
     * Registrar una nueva actividad en el sistema.
     * 
     * @param idActividad ID de la actividad
     * @param descripcion Descripción de la actividad
     * @param fechaInicial Fecha de inicio de la actividad
     * @param fechaFinal  Fecha de finalización de la actividad
     * @param idProyecto  ID del proyecto al que pertenece la actividad
     * @return -1 si la actividad ya existe, 1 si se registra exitosamente
     */
    public static int registrarActividad(String idActividad, String descripcion, Date fechaInicial, Date fechaFinal, String idProyecto) {
        if (obtenerActividadPorId(idActividad) != null) {
            return -1; // Si la actividad ya existe, retornar -1 indicando error
        }

        Actividad newActividad = new Actividad(idActividad, descripcion, fechaInicial, fechaFinal, idProyecto); // Crear una nueva actividad
        actividadesList.add(newActividad); // Almacenar actividad en la lista
        return 1; // Retornar 1 indicando éxito
    }

    /**
     * Obtener una actividad por su ID.
     * 
     * @param idActividad ID de la actividad
     * @return La actividad correspondiente al ID, o null si no se encuentra
     */
    public static Actividad obtenerActividadPorId(String idActividad) {
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                return actividad;
            }
        }
        return null; // Retornar null si la actividad no se encuentra
    }

    /**
     * Registrar una nueva tarea en el sistema.
     * 
     * @param idTarea      ID de la tarea
     * @param nombre       Nombre de la tarea
     * @param descripcion  Descripción de la tarea
     * @param costo        Costo de la tarea
     * @param fechaInicial Fecha de inicio de la tarea
     * @param fechaFinal   Fecha de finalización de la tarea
     * @return -1 si la tarea ya existe, 1 si se registra exitosamente
     */
    public static int registrarTarea(String idTarea, String nombre, String descripcion, int costo, Date fechaInicial, Date fechaFinal) {
        if (obtenerTareaPorId(idTarea) != null) {
            return -1; // Si la tarea ya existe, retornar -1 indicando error
        }

        Tarea newTarea = new Tarea(idTarea, nombre, descripcion, costo, fechaInicial, fechaFinal); // Crear una nueva tarea
        tareasList.add(newTarea); // Almacenar tarea en la lista
        return 1; // Retornar 1 indicando éxito
    }

    /**
     * Obtener una tarea por su ID.
     * 
     * @param idTarea ID de la tarea
     * @return La tarea correspondiente al ID, o null si no se encuentra
     */
    public static Tarea obtenerTareaPorId(String idTarea) {
        for (Tarea tarea : tareasList) {
            if (tarea.getIdTarea().equals(idTarea)) {
                return tarea;
            }
        }
        return null; // Retornar null si la tarea no se encuentra
    }

    // --------------------------- MODIFICAR DATOS -----------------------------

    /**
     * Modificar los datos de un usuario existente.
     * 
     * @param cedulaUsuario Cédula del usuario a modificar
     * @param nombre        Nuevo nombre del usuario
     * @param edad          Nueva edad del usuario
     * @param sexo          Nuevo sexo del usuario
     * @param dependencia   Nueva dependencia del usuario
     * @param titulo        Nuevo título del usuario
     * @param contrasegnia  Nueva contraseña del usuario
     */
    public static void modificarDatosUsuario(String cedulaUsuario, String nombre, int edad, String sexo, String dependencia, String titulo, String contrasegnia) {
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

    /**
    * Modificar los datos de una tarea existente.
    * 
    * @param idTarea      ID de la tarea a modificar
    * @param nombre       Nuevo nombre de la tarea
    * @param descripcion  Nueva descripción de la tarea
    * @param costo        Nuevo costo de la tarea
    * @param fechaInicial Nueva fecha de inicio de la tarea
    * @param fechaFinal   Nueva fecha de finalización de la tarea
    * @param estado       Nuevo estado de la tarea ("terminado" o "en desarrollo")
    */
   public static void modificarTarea(String idTarea, String nombre, String descripcion, int costo, Date fechaInicial, Date fechaFinal, boolean estado) {
       for (Tarea tarea : tareasList) {
           if (tarea.getIdTarea().equals(idTarea)) {
               // Modificar los datos de la tarea
               tarea.setNombre(nombre);
               tarea.setDescripcion(descripcion);
               tarea.setCosto(costo);
               tarea.setFechaInicial(fechaInicial);
               tarea.setFechaFinal(fechaFinal);
               tarea.setEstado(estado);
               return; // Salir del método una vez modificados los datos de la tarea
           }
       }
   }

   /**
    * Modificar los datos de una actividad existente.
    * 
    * @param idActividad  ID de la actividad a modificar
    * @param descripcion  Nueva descripción de la actividad
    * @param fechaInicial Nueva fecha de inicio de la actividad
    * @param fechaFinal   Nueva fecha de finalización de la actividad
    * @param estado       Nuevo estado de la actividad ("terminado" o "en desarrollo")
    */
   public static void modificarActividad(String idActividad, String descripcion, Date fechaInicial, Date fechaFinal, boolean estado) {
       for (Actividad actividad : actividadesList) {
           if (actividad.getIdActividad().equals(idActividad)) {
               // Modificar los datos de la actividad
               actividad.setDescripcion(descripcion);
               actividad.setFechaInicial(fechaInicial);
               actividad.setFechaFinal(fechaFinal);
               actividad.setEstado(estado);
               return; // Salir del método una vez modificados los datos de la actividad
           }
       }
   }
    
   /**
     * Modificar los datos de un proyecto existente.
     * 
     * @param idProyecto  ID del proyecto a modificar
     * @param nombre      Nuevo nombre del proyecto
     * @param duracion    Nueva duración del proyecto
     * @param descripcion Nueva descripción del proyecto
     * @param encargado   Nueva persona encargada del proyecto
     * @param fechaInicio Nueva fecha de inicio del proyecto
     * @param fechaFinal  Nueva fecha de finalización del proyecto
     * @param presupuesto Nuevo presupuesto del proyecto
     */
    public static void modificarProyecto(String idProyecto, String nombre, int duracion, String descripcion, String encargado, Date fechaInicio, Date fechaFinal, int presupuesto) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                // Modificar los datos del proyecto
                proyecto.setNombre(nombre);
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

    /**
     * Agregar una persona a un proyecto.
     * 
     * @param cedulaPersona Cédula de la persona a agregar
     * @param idProyecto    ID del proyecto
     */
    public static void agregarPersonaAProyecto(String cedulaPersona, String idProyecto) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                if (!proyecto.getPersonal().contains(cedulaPersona)) {
                    // Si la persona no está en el proyecto, agregarla
                    proyecto.getPersonal().add(cedulaPersona);
                }
                return; // Salir del método una vez agregada la persona al proyecto
            }
        }
    }

    /**
     * Agregar un proyecto a un usuario.
     * 
     * @param cedulaUsuario Cédula del usuario
     * @param idProyecto    ID del proyecto a agregar
     */
    public static void agregarProyectoAUsuario(String cedulaUsuario, String idProyecto) {
        for (User user : usersList) {
            if (user.getCedula().equals(cedulaUsuario)) {
                if (!user.getProyectos().contains(idProyecto)) {
                    // Si el proyecto no está asociado al usuario, agregarlo
                    user.getProyectos().add(idProyecto);
                }
                return; // Salir del método una vez agregado el proyecto al usuario
            }
        }
    }

    /**
     * Agregar una actividad a un proyecto.
     * 
     * @param idProyecto   ID del proyecto
     * @param idActividad  ID de la actividad a agregar
     */
    public static void agregarActividadAProyecto(String idProyecto, String idActividad) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                if (!proyecto.getActividades().contains(idActividad)) {
                    // Si la actividad no está en el proyecto, agregarla
                    proyecto.getActividades().add(idActividad);
                }
                return; // Salir del método una vez agregada la actividad al proyecto
            }
        }
    }

    /**
     * Agregar una tarea a una actividad.
     * 
     * @param idActividad ID de la actividad
     * @param idTarea     ID de la tarea a agregar
     */
    public static void agregarTareaAActividad(String idActividad, String idTarea) {
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                if (!actividad.getTareas().contains(idTarea)) {
                    // Si la tarea no está en la actividad, agregarla
                    actividad.getTareas().add(idTarea);
                }
                return; // Salir del método una vez agregada la tarea a la actividad
            }
        }
    }

    // ----------------------------------- PREGUNTAS ----------------------------------- ---------------------

    /**
     * Consultar las actividades cumplidas de un proyecto.
     * 
     * @param idProyecto ID del proyecto
     * @return Lista de IDs de actividades cumplidas
     */
    public static ArrayList<String> consultarActividadesCumplidas(String idProyecto) {
        ArrayList<String> actividadesCumplidas = new ArrayList<>();
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdProyecto().equals(idProyecto) && actividad.isEstado()) {
                actividadesCumplidas.add(actividad.getIdActividad());
            }
        }
        return actividadesCumplidas;
    }

    /**
     * Consultar las actividades no cumplidas de un proyecto.
     * 
     * @param idProyecto ID del proyecto
     * @return Lista de IDs de actividades no cumplidas
     */
    public static ArrayList<String> consultarActividadesNoCumplidas(String idProyecto) {
        ArrayList<String> actividadesNoCumplidas = new ArrayList<>();
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdProyecto().equals(idProyecto) && !actividad.isEstado()) {
                actividadesNoCumplidas.add(actividad.getIdActividad());
            }
        }
        return actividadesNoCumplidas;
    }

    /**
     * Obtener todas las tareas de una actividad.
     * 
     * @param idActividad ID de la actividad
     * @return Lista de tareas correspondientes a la actividad
     */
    public static ArrayList<Tarea> obtenerTareasDeActividad(String idActividad) {
        Actividad actividad = obtenerActividadPorId(idActividad);
        ArrayList<Tarea> tareas = new ArrayList<>();
        if (actividad != null) {
            for (String idTarea : actividad.getTareas()) {
                Tarea tarea = obtenerTareaPorId(idTarea);
                if (tarea != null) {
                    tareas.add(tarea);
                }
            }
        }
        return tareas;
    }

    /**
     * Consultar estadísticas de tareas de una actividad.
     * 
     * @param idActividad ID de la actividad
     * @return Array con estadísticas [cantidad de tareas, tareas cumplidas, tareas no cumplidas]
     */
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

    /**
     * Consultar todas las tareas de un proyecto.
     * 
     * @param idProyecto ID del proyecto
     * @return Lista de IDs de todas las tareas del proyecto
     */
    public static ArrayList<String> consultarTodasTareas(String idProyecto) {
        ArrayList<String> todasTareas = new ArrayList<>();
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdProyecto().equals(idProyecto)) {
                todasTareas.addAll(actividad.getTareas());
            }
        }
        return todasTareas;
    }

    /**
     * Consultar la cantidad de personas que trabajan en un proyecto.
     * 
     * @param idProyecto ID del proyecto
     * @return Cantidad de personas trabajando en el proyecto
     */
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

    /**
     * Consultar las personas que participan en un proyecto.
     * 
     * @param idProyecto ID del proyecto
     * @return Lista de cédulas de personas que participan en el proyecto
     */
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

    /**
     * Consultar la persona responsable de un proyecto.
     * 
     * @param idProyecto ID del proyecto
     * @return Cédula de la persona responsable del proyecto
     */
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
