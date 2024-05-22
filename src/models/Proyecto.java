// Proyecto.java
package models;

import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
    String idProyecto;
    int duracion;
    String descripcion;
    String encargado;
    Date fechaInicio;
    Date fechaFinal;
    int presupuesto;
    ArrayList<String> actividades;
    ArrayList<String> personal;

    public Proyecto(String idProyecto, int duracion, String descripcion, String encargado, Date fechaInicio, Date fechaFinal, int presupuesto) {
        this.idProyecto = idProyecto;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.encargado = encargado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.presupuesto = presupuesto;
        this.actividades = new ArrayList<>();
        this.personal = new ArrayList<>();
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ArrayList<String> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<String> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<String> getPersonal() {
        return personal;
    }
        
}
