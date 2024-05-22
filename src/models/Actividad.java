package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actividad {
    private String idActividad;
    private String descripcion;
    private Date fechaInicial;
    private Date fechaFinal;
    private String idProyecto;
    private boolean estado;
    private List<String> tareas; // Lista de IDs de tareas

    // Constructor
    public Actividad(String idActividad, String descripcion, Date fechaInicial, Date fechaFinal, String idProyecto) {
        this.idActividad = idActividad;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idProyecto = idProyecto;
        this.estado = false; // Inicialmente en desarrollo
        this.tareas = new ArrayList<>(); // Inicializar la lista de tareas
    }

    // Getters y Setters
    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<String> getTareas() {
        return tareas;
    }
}
