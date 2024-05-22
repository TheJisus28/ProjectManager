// User.java
package models;

import java.util.ArrayList;

public class User {
    String cedula;
    String nombre;
    int edad;
    String sexo;
    String dependencia;
    String titulo;
    String contrasegnia;
    ArrayList<String> proyectos;

    public User(String cedula, String nombre , int edad, String sexo, String dependencia, String titulo, String contrasegnia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dependencia = dependencia;
        this.titulo = titulo;
        this.contrasegnia = contrasegnia;
        this.proyectos = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContrasegnia() {
        return contrasegnia;
    }

    public void setContrasegnia(String contrasegnia) {
        this.contrasegnia = contrasegnia;
    }

    public ArrayList<String> getProyectos() {
        return proyectos;
    }    
    
}
