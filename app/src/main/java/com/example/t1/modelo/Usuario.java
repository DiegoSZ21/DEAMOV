package com.example.t1.modelo;

public class Usuario {

    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rol;
    private String estadoCuenta;
    private String clave;

    public Usuario(String nombres,
                   String apellidos,
                   String correo,
                   String telefono,
                   String rol,
                   String estadoCuenta,
                   String clave) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
        this.estadoCuenta = estadoCuenta;
        this.clave = clave;
    }

    public Usuario(String nombres,
                   String apellidos,
                   String correo,
                   String telefono,
                   String rol,
                   String estadoCuenta) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
        this.estadoCuenta = estadoCuenta;
        this.clave = "";
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (" + correo + ")";
    }
}