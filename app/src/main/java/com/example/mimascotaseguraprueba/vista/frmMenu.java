package com.example.mimascotaseguraprueba.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mimascotaseguraprueba.R;

public class frmMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frm_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btnMascotas(View view) {

        Intent x = new Intent(this, frmMenu.class);
        startActivity(x);
    }
    public void btnSalud(View view) {

        Intent x = new Intent(this, frmMenu.class);
        startActivity(x);
    }
    public void btnRecordatorios(View view) {

        Intent x = new Intent(this, frmMenu.class);
        startActivity(x);
    }
    public void btnComunidad(View view) {

        Intent x = new Intent(this, frmMenu.class);
        startActivity(x);
    }
    public void btnPerfil(View view) {

        Intent x = new Intent(this, frmMenu.class);
        startActivity(x);
    }

    public void btnSalir(View view) {
            finish();

    }
}