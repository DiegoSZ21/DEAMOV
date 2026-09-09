package com.example.mimascotaseguraprueba.modelo;

public class Mascota {

    private String codigo;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String dueño;

    public Mascota(String codigo, String nombre, String especie,
                   String raza, int edad, String dueño) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.dueño = dueño;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getDueño() {
        return dueño;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public Mascota(String dueño, int edad, String raza, String especie, String nombre, String codigo) {
        this.dueño = dueño;
        this.edad = edad;
        this.raza = raza;
        this.especie = especie;
        this.nombre = nombre;
        this.codigo = codigo;
    }
}