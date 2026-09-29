package com.example.t1.modelo;

import java.util.ArrayList;

public class Datos {

    public static ArrayList<Usuario> usuarios =
            new ArrayList<>();

    public static void cargarDatosIniciales() {

        if (!usuarios.isEmpty()) {
            return;
        }

        Usuario administrador = new Usuario(
                "Administrador",
                "Municipal",
                "admin@barranco.gob.pe",
                "999999999",
                "ADMINISTRADOR",
                "ACTIVA",
                "123456"
        );

        usuarios.add(administrador);
    }
    public static ArrayList<Mascota> mascotas =
            new ArrayList<>();
}