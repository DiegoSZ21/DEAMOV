package com.example.t1.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.R;
import com.example.t1.modelo.Datos;
import com.example.t1.modelo.Usuario;

public class Propietarios extends AppCompatActivity {

    private LinearLayout contenedor;

    private Button btnNuevoPropietario;
    private Button btnVolverPropietarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_propietarios);

        // Conectar componentes del XML
        contenedor = findViewById(R.id.llContenedorPropietarios);

        btnNuevoPropietario =
                findViewById(R.id.btnNuevoPropietario);

        btnVolverPropietarios =
                findViewById(R.id.btnVolverPropietarios);

        // Abrir formulario de registro
        btnNuevoPropietario.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Propietarios.this,
                    RegistrarPropietario.class
            );

            startActivity(intent);
        });

        // Volver al menú administrador
        btnVolverPropietarios.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        listar();
    }

    private void listar() {

        contenedor.removeAllViews();

        LayoutInflater inflater =
                LayoutInflater.from(this);

        for (int i = 0; i < Datos.usuarios.size(); i++) {

            Usuario usuario = Datos.usuarios.get(i);

            // No mostrar cuentas desactivadas
            if (usuario.getEstadoCuenta().equalsIgnoreCase("INACTIVA")) {
                continue;
            }

            final int pos = i;

            View item = inflater.inflate(
                    R.layout.item_generico,
                    contenedor,
                    false
            );

            TextView t1 =
                    item.findViewById(R.id.tvItemTitulo);

            TextView t2 =
                    item.findViewById(R.id.tvItemSubtitulo1);

            TextView t3 =
                    item.findViewById(R.id.tvItemSubtitulo2);

            Button btnEliminar =
                    item.findViewById(R.id.btnItemEliminar);

            Button btnEditar =
                    item.findViewById(R.id.btnItemEditar);

            btnEditar.setVisibility(View.GONE);

            t1.setText(usuario.getNombreCompleto());

            t2.setText(
                    "Tel: " + usuario.getTelefono()
            );

            t3.setText(
                    "Correo: " + usuario.getCorreo()
            );

            // Ya no eliminamos: desactivamos
            btnEliminar.setText("DESACTIVAR");

            btnEliminar.setOnClickListener(view -> {

                usuario.setEstadoCuenta("INACTIVA");

                Toast.makeText(
                        this,
                        "Cuenta desactivada",
                        Toast.LENGTH_SHORT
                ).show();

                listar();
            });

            contenedor.addView(item);
        }
    }
}