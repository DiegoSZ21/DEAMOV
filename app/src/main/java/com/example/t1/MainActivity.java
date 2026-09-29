package com.example.t1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.modelo.Datos;
import com.example.t1.modelo.Usuario;
import com.example.t1.vista.MenuAdministrador;

public class MainActivity extends AppCompatActivity {

    private EditText etCorreo;
    private EditText etClave;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Cargar datos iniciales
        Datos.cargarDatosIniciales();

        // Conectar componentes del XML
        etCorreo = findViewById(R.id.etLoginCorreo);
        etClave = findViewById(R.id.etLoginClave);
        btnLogin = findViewById(R.id.btnIniciarSesion);

        // Botón iniciar sesión
        btnLogin.setOnClickListener(v -> validarAcceso());
    }

    private void validarAcceso() {

        String correo =
                etCorreo.getText().toString().trim();

        String clave =
                etClave.getText().toString().trim();

        if (correo.isEmpty() || clave.isEmpty()) {

            Toast.makeText(
                    this,
                    "Complete el correo y la contraseña",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        Usuario usuarioEncontrado = null;

        // Buscar usuario
        for (Usuario usuario : Datos.usuarios) {

            if (usuario.getCorreo().equalsIgnoreCase(correo)
                    && usuario.getClave().equals(clave)) {

                usuarioEncontrado = usuario;
                break;
            }
        }

        // Si encontró usuario
        if (usuarioEncontrado != null) {

            String rol = usuarioEncontrado.getRol();

            if (rol.equalsIgnoreCase("ADMINISTRADOR")) {

                Intent intent = new Intent(
                        MainActivity.this,
                        MenuAdministrador.class
                );

                intent.putExtra(
                        "NOMBRE",
                        usuarioEncontrado.getNombreCompleto()
                );

                startActivity(intent);

                finish();

            } else {

                Toast.makeText(
                        this,
                        "El acceso para propietarios todavía está en desarrollo",
                        Toast.LENGTH_SHORT
                ).show();
            }

        } else {

            Toast.makeText(
                    this,
                    "Correo o contraseña incorrectos",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}