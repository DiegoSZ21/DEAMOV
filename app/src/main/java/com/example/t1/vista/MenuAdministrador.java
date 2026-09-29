package com.example.t1.vista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.R;

public class MenuAdministrador extends AppCompatActivity {

    private Button btnPropietarios;
    private Button btnMascotas;
    private Button btnSalud;
    private Button btnPublicaciones;
    private Button btnAlertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_administrador);

        btnPropietarios = findViewById(R.id.btnPropietarios);
        btnMascotas = findViewById(R.id.btnMascotas);
        btnSalud = findViewById(R.id.btnSalud);
        btnPublicaciones = findViewById(R.id.btnPublicaciones);
        btnAlertas = findViewById(R.id.btnAlertas);

        btnPropietarios.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MenuAdministrador.this,
                    Propietarios.class
            );

            startActivity(intent);
        });

        btnMascotas.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuAdministrador.this,
                    Mascotas.class
            );

            startActivity(intent);
        });

        btnSalud.setOnClickListener(v -> {
            // Lo implementaremos después
        });

        btnPublicaciones.setOnClickListener(v -> {
            // Lo implementaremos después
        });

        btnAlertas.setOnClickListener(v -> {
            // Lo implementaremos después
        });
    }
}