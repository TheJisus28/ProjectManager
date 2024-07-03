package data;

import models.Proyecto;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.*;

public class BBDD implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Listas para almacenar las entidades del sistema
    private static List<User> usersList = new ArrayList<>(); // Lista para almacenar usuarios
    private static List<Proyecto> proyectosList = new ArrayList<>(); // Lista para almacenar proyectos
    private static List<Actividad> actividadesList = new ArrayList<>(); // Lista para almacenar actividades
    private static List<Tarea> tareasList = new ArrayList<>(); // Lista para almacenar tareas

    private static final String DATA_FILE = "BBDD_data.ser"; // Archivo para guardar los datos

    // Método para guardar los datos en un archivo
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(usersList);
            oos.writeObject(proyectosList);
            oos.writeObject(actividadesList);
            oos.writeObject(tareasList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar los datos desde un archivo
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            usersList = (List<User>) ois.readObject();
            proyectosList = (List<Proyecto>) ois.readObject();
            actividadesList = (List<Actividad>) ois.readObject();
            tareasList = (List<Tarea>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found, starting with empty lists.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Llamar al método loadData al iniciar la aplicación para cargar los datos
    static {
        loadData();
    }

    // ----------------------------------- "GETTERS AND SETTERS" -----------------------------------------

    public static int registerUser(String cedula, String nombre, int edad, String sexo, String dependencia, String titulo, String contrasegnia) {
        if (obtenerUsuarioPorCedula(cedula) != null) {
            return -1;
        }

        User newUser = new User(cedula, nombre, edad, sexo, dependencia, titulo, contrasegnia);
        System.out.println("usuario:" + newUser.getNombre() + " con cedula: " + newUser.getCedula() + " y edad: " + newUser.getEdad() + " almacenado");
        usersList.add(newUser);
        saveData(); // Guardar datos después de registrar un nuevo usuario
        return 1;
    }

    public static User obtenerUsuarioPorCedula(String cedula) {
        for (User user : usersList) {
            System.out.println(user.getCedula());
            if (user.getCedula().equals(cedula)) {
                return user;
            }
        }
        return null;
    }

    public static int registrarProyecto(String idProyecto, String nombre, int duracion, String descripcion, String encargado, Date fechaInicio, int presupuesto) {
        if (obtenerProyectoPorId(idProyecto) != null) {
            return -1;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.MONTH, duracion);
        Date fechaFinal = calendar.getTime();

        Proyecto newProyecto = new Proyecto(idProyecto, nombre, duracion, descripcion, encargado, fechaInicio, fechaFinal, presupuesto);
        proyectosList.add(newProyecto);
        saveData(); // Guardar datos después de registrar un nuevo proyecto
        return 1;
    }

    public static Proyecto obtenerProyectoPorId(String idProyecto) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                return proyecto;
            }
        }
        return null;
    }

    public static int registrarActividad(String idActividad, String descripcion, Date fechaInicial, Date fechaFinal, String idProyecto) {
        if (obtenerActividadPorId(idActividad) != null) {
            return -1;
        }

        Actividad newActividad = new Actividad(idActividad, descripcion, fechaInicial, fechaFinal, idProyecto);
        actividadesList.add(newActividad);
        saveData(); // Guardar datos después de registrar una nueva actividad
        return 1;
    }

    public static Actividad obtenerActividadPorId(String idActividad) {
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                return actividad;
            }
        }
        return null;
    }

    public static int registrarTarea(String idTarea, String nombre, String descripcion, int costo, Date fechaInicial, Date fechaFinal) {
        if (obtenerTareaPorId(idTarea) != null) {
            return -1;
        }

        Tarea newTarea = new Tarea(idTarea, nombre, descripcion, costo, fechaInicial, fechaFinal);
        tareasList.add(newTarea);
        saveData(); // Guardar datos después de registrar una nueva tarea
        return 1;
    }

    public static Tarea obtenerTareaPorId(String idTarea) {
        for (Tarea tarea : tareasList) {
            if (tarea.getIdTarea().equals(idTarea)) {
                return tarea;
            }
        }
        return null;
    }

    public static void modificarDatosUsuario(String cedulaUsuario, String nombre, int edad, String sexo, String dependencia, String titulo, String contrasegnia) {
        for (User user : usersList) {
            if (user.getCedula().equals(cedulaUsuario)) {
                user.setNombre(nombre);
                user.setEdad(edad);
                user.setSexo(sexo);
                user.setDependencia(dependencia);
                user.setTitulo(titulo);
                user.setContrasegnia(contrasegnia);
                saveData(); // Guardar datos después de modificar un usuario
                return;
            }
        }
    }

    public static void modificarTarea(String idTarea, String nombre, String descripcion, int costo, Date fechaInicial, Date fechaFinal, boolean estado) {
        for (Tarea tarea : tareasList) {
            if (tarea.getIdTarea().equals(idTarea)) {
                tarea.setNombre(nombre);
                tarea.setDescripcion(descripcion);
                tarea.setCosto(costo);
                tarea.setFechaInicial(fechaInicial);
                tarea.setFechaFinal(fechaFinal);
                tarea.setEstado(estado);
                saveData(); // Guardar datos después de modificar una tarea
                return;
            }
        }
    }

    public static void modificarActividad(String idActividad, String descripcion, Date fechaInicial, Date fechaFinal, boolean estado) {
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                actividad.setDescripcion(descripcion);
                actividad.setFechaInicial(fechaInicial);
                actividad.setFechaFinal(fechaFinal);
                actividad.setEstado(estado);
                saveData(); // Guardar datos después de modificar una actividad
                return;
            }
        }
    }

    public static void modificarProyecto(String idProyecto, String nombre, int duracion, String descripcion, String encargado, Date fechaInicio, Date fechaFinal, int presupuesto) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                proyecto.setNombre(nombre);
                proyecto.setDuracion(duracion);
                proyecto.setDescripcion(descripcion);
                proyecto.setEncargado(encargado);
                proyecto.setFechaInicio(fechaInicio);
                proyecto.setFechaFinal(fechaFinal);
                proyecto.setPresupuesto(presupuesto);
                saveData(); // Guardar datos después de modificar un proyecto
                return;
            }
        }
    }

    public static void agregarPersonaAProyecto(String cedulaPersona, String idProyecto) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                if (!proyecto.getPersonal().contains(cedulaPersona)) {
                    proyecto.getPersonal().add(cedulaPersona);
                }
                saveData(); // Guardar datos después de agregar una persona a un proyecto
                return;
            }
        }
    }

    public static void agregarActividadAProyecto(String idProyecto, String idActividad) {
        for (Proyecto proyecto : proyectosList) {
            if (proyecto.getIdProyecto().equals(idProyecto)) {
                if (!proyecto.getActividades().contains(idActividad)) {
                    proyecto.getActividades().add(idActividad);
                }
                saveData(); // Guardar datos después de agregar una actividad a un proyecto
                return;
            }
        }
    }

    public static void agregarTareaAActividad(String idActividad, String idTarea) {
        for (Actividad actividad : actividadesList) {
            if (actividad.getIdActividad().equals(idActividad)) {
                if (!actividad.getTareas().contains(idTarea)) {
                    actividad.getTareas().add(idTarea);
                }
                saveData(); // Guardar datos después de agregar una tarea a una actividad
                return;
            }
        }
    }

    public static List<User> getUsersList() {
        return usersList;
    }

    public static List<Proyecto> getProyectosList() {
        return proyectosList;
    }

    public static List<Actividad> getActividadesList() {
        return actividadesList;
    }

    public static List<Tarea> getTareasList() {
        return tareasList;
    }

    public static void setUsersList(List<User> usersList) {
        BBDD.usersList = usersList;
        saveData(); // Guardar datos después de establecer la lista de usuarios
    }

    public static void setProyectosList(List<Proyecto> proyectosList) {
        BBDD.proyectosList = proyectosList;
        saveData(); // Guardar datos después de establecer la lista de proyectos
    }

    public static void setActividadesList(List<Actividad> actividadesList) {
        BBDD.actividadesList = actividadesList;
        saveData(); // Guardar datos después de establecer la lista de actividades
    }

    public static void setTareasList(List<Tarea> tareasList) {
        BBDD.tareasList = tareasList;
        saveData(); // Guardar datos después de establecer la lista de tareas
    }
       


    // Agregar un proyecto a un usuario
    public static void agregarProyectoAUsuario(String cedula, String proyectoId) {
        // Buscar el usuario por su cédula
        for (User user : getUsersList()) {
            if (user.getCedula().equals(cedula)) {
                // Verificar si el proyecto ya está asociado al usuario
                if (!user.getProyectos().contains(proyectoId)) {
                    // Obtener el objeto Proyecto correspondiente al proyectoId
                    Proyecto proyecto = obtenerProyectoPorId(proyectoId);
                    if (proyecto != null) {
                        // Agregar el proyecto al usuario
                        user.getProyectos().add(proyectoId);
                        // Agregar el proyecto a la lista general de proyectos si no está presente
                        if (!getProyectosList().contains(proyecto)) {
                            getProyectosList().add(proyecto);
                        }
                        // Guardar los cambios en el archivo de datos
                        saveData();
                    }
                }
                return;
            }
        }
    }

    // Método para obtener proyectos de una persona
    public static List<Proyecto> obtenerProyectosDePersona(String cedula) {
        List<Proyecto> proyectosDePersona = new ArrayList<>();
        for (User user : usersList) {
            if (user.getCedula().equals(cedula)) {
                for (String proyectoId : user.getProyectos()) {
                    Proyecto proyecto = obtenerProyectoPorId(proyectoId);
                    if (proyecto != null) {
                        proyectosDePersona.add(proyecto);
                    }
                }
                break; // Terminamos el ciclo una vez encontrado el usuario
            }
        }
        return proyectosDePersona;
    }

    // Obtener usuarios en un proyecto
    public static List<User> obtenerUsuariosEnProyecto(String proyecto) {
     List<User> usuariosEnProyecto = new ArrayList<>();
     for (User user : getUsersList()) {
         if (user.getProyectos().contains(proyecto)) {
             usuariosEnProyecto.add(user);
         }
     }
     return usuariosEnProyecto;
    }
   
    // ---- 

    
    // Método para obtener la cantidad de personas que trabajan en un proyecto
    public static int cantidadPersonasTrabajanProyecto(String idProyecto) {
        Proyecto proyecto = obtenerProyectoPorId(idProyecto);
        if (proyecto != null) {
            return proyecto.getPersonal().size();
        }
        return 0; // Si el proyecto no existe o no tiene personal asignado
    }

    // Método para obtener la persona responsable de un proyecto
    public static User personaResponsableProyecto(String idProyecto) {
        Proyecto proyecto = obtenerProyectoPorId(idProyecto);
        if (proyecto != null) {
            String cedulaResponsable = proyecto.getEncargado();
            return obtenerUsuarioPorCedula(cedulaResponsable);
        }
        return null; // Si el proyecto no existe o no tiene responsable asignado
    }
}

