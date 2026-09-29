package com.example.t1.vista;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.R;
import com.example.t1.modelo.Datos;
import com.example.t1.modelo.Usuario;

public class RegistrarPropietario extends AppCompatActivity {

    private EditText etNombres;
    private EditText etApellidos;
    private EditText etCorreo;
    private EditText etTelefono;

    private Button btnRegistrarPropietario;
    private Button btnVolverRegistrarPropietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registrar_propietario);

        // Conectar componentes del XML con Java
        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);

        btnRegistrarPropietario =
                findViewById(R.id.btnRegistrarPropietario);

        btnVolverRegistrarPropietario =
                findViewById(R.id.btnVolverRegistrarPropietario);

        // Botón registrar
        btnRegistrarPropietario.setOnClickListener(v -> {
            registrarPropietario();
        });

        // Botón volver
        btnVolverRegistrarPropietario.setOnClickListener(v -> {
            finish();
        });
    }

    private void registrarPropietario() {

        String nombres = etNombres.getText().toString().trim();
        String apellidos = etApellidos.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();

        // Validar campos
        if (nombres.isEmpty()) {
            etNombres.setError("Ingrese los nombres");
            etNombres.requestFocus();
            return;
        }

        if (apellidos.isEmpty()) {
            etApellidos.setError("Ingrese los apellidos");
            etApellidos.requestFocus();
            return;
        }

        if (correo.isEmpty()) {
            etCorreo.setError("Ingrese el correo");
            etCorreo.requestFocus();
            return;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("Ingrese el teléfono");
            etTelefono.requestFocus();
            return;
        }

        // Crear propietario
        Usuario usuario = new Usuario(
                nombres,
                apellidos,
                correo,
                telefono,
                "PROPIETARIO",
                "PENDIENTE"
        );

        // Guardar temporalmente
        Datos.usuarios.add(usuario);

        // Mensaje de confirmación
        Toast.makeText(
                this,
                "Propietario registrado correctamente",
                Toast.LENGTH_SHORT
        ).show();

        // Regresar a la lista de propietarios
        finish();
    }
}