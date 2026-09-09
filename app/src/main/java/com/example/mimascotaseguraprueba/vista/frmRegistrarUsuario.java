package com.example.mimascotaseguraprueba.vista;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mimascotaseguraprueba.R;
import com.example.mimascotaseguraprueba.modelo.Usuario;
import com.example.mimascotaseguraprueba.modelo.listas;

public class frmRegistrarUsuario extends AppCompatActivity {

    EditText edtNombre, edtCorreo,edtPassword,edtConfirmarPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frm_registrar_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNombre = findViewById(R.id.edtNombre);
        edtCorreo = findViewById(R.id.edtCorreoRegistro);
        edtPassword = findViewById(R.id.edtPasswordRegistro);
        edtConfirmarPassword = findViewById(R.id.edtConfirmarPassword);
    }

    public void btnRegistrarUsuario(View view) {

        String nombre = edtNombre.getText().toString();
        String correo = edtCorreo.getText().toString();
        String password = edtPassword.getText().toString();
        String confirmar = edtConfirmarPassword.getText().toString();

        if (nombre.isEmpty()) {

            edtNombre.setError("Ingrese su nombre");

        } else if (correo.isEmpty()) {

            edtCorreo.setError("Ingrese su correo");

        } else if (password.isEmpty()) {

            edtPassword.setError("Ingrese su contraseña");

        } else if (confirmar.isEmpty()) {

            edtConfirmarPassword.setError("Confirme su contraseña");

        } else if (!password.equals(confirmar)) {

            edtConfirmarPassword.setError("Las contraseñas no coinciden");

        } else {

            Usuario nuevoUsuario = new Usuario(nombre, correo, password);

            listas.usuarios.add(nuevoUsuario);

            Toast.makeText(this, "Usuario registrado correctamente",
                    Toast.LENGTH_SHORT).show();

            Intent x = new Intent(this, MainActivity.class);
            startActivity(x);
            finish();
        }
    }
}
