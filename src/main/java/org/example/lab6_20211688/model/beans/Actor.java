package org.example.lab6_20211688.model.beans;

public class Actor {
    private int idActor;
    private String nombre;
    private String apellido;
    private int anhoNacimiento;
    private int ganadorPremioOscar;

    public int getAnhoNacimiento() {
        return anhoNacimiento;
    }

    public void setAnhoNacimiento(int anhoNacimiento) {
        this.anhoNacimiento = anhoNacimiento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGanadorPremioOscar() {
        return ganadorPremioOscar;
    }

    public void setGanadorPremioOscar(int ganadorPremioOscar) {
        this.ganadorPremioOscar = ganadorPremioOscar;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
