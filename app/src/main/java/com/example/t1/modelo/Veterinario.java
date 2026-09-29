package com.example.t1.modelo;

public class Veterinario extends Usuario {

    public Veterinario(String nombres, String apellidos, String correo, String telefono, String clave) {
        super(nombres, apellidos, correo, telefono, "Veterinario", "Activo", clave);
    }
}
