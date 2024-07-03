package models;

import java.io.Serializable;
import java.util.Date;

public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idTarea;
    private String nombre;
    private String descripcion;
    private int costo;
    private Date fechaInicial;
    private Date fechaFinal;
    private boolean estado; 

    // Constructor
    public Tarea(String idTarea, String nombre, String descripcion, int costo, Date fechaInicial, Date fechaFinal) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.estado = false; // Inicialmente en desarrollo
    }

    // Getters y Setters
    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
