package com.example.t1.vista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);

        String rol = getIntent().getStringExtra("ROL");
        String nombre = getIntent().getStringExtra("NOMBRE");

        Toast.makeText(this, "Bienvenido " + nombre + " (" + rol + ")", Toast.LENGTH_SHORT).show();

        Button btnPropietarios = findViewById(R.id.btnPropietarios);
        Button btnMascotas = findViewById(R.id.btnMascotas);
        Button btnSalud = findViewById(R.id.btnSalud);
        Button btnPublicaciones = findViewById(R.id.btnPublicaciones);
        Button btnAlertas = findViewById(R.id.btnAlertas);

        btnPropietarios.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, Propietarios.class);
            startActivity(intent);
        });

        btnMascotas.setOnClickListener(v -> Toast.makeText(this, "Mascotas en desarrollo", Toast.LENGTH_SHORT).show());
        btnSalud.setOnClickListener(v -> Toast.makeText(this, "Salud en desarrollo", Toast.LENGTH_SHORT).show());
        btnPublicaciones.setOnClickListener(v -> Toast.makeText(this, "Publicaciones en desarrollo", Toast.LENGTH_SHORT).show());
        btnAlertas.setOnClickListener(v -> Toast.makeText(this, "Alertas en desarrollo", Toast.LENGTH_SHORT).show());
    }
}
