package com.example.mimascotaseguraprueba.vista;

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

public class MainActivity extends AppCompatActivity {

    EditText edtCorreo, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtCorreo = findViewById(R.id.edtCorreo);
        edtPassword = findViewById(R.id.edtPassword);
    }

    public void btnIngresar(View view) {

        String correo = edtCorreo.getText().toString();
        String password = edtPassword.getText().toString();
        if (correo.isEmpty()) {
            edtCorreo.setError("Ingrese su correo");
        } else if (password.isEmpty()) {
            edtPassword.setError("Ingrese su contraseña");
        } else {
            boolean encontrado = false;
            for (Usuario u : listas.usuarios) {
                if (u.getCorreo().equals(correo) && u.getPassword().equals(password)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                Toast.makeText(this, "Inicio de sesión correcto",
                        Toast.LENGTH_SHORT).show();
                Intent x = new Intent(this, frmMenu.class);
                startActivity(x);
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void btnRegistrarme(View view) {

        Intent x = new Intent(this, frmRegistrarUsuario.class);
        startActivity(x);
    }
}
