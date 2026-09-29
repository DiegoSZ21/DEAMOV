package com.example.t1.vista;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.R;
import com.example.t1.modelo.Datos;
import com.example.t1.modelo.Mascota;

public class Mascotas extends AppCompatActivity {

    private LinearLayout contenedor;

    private Button btnNuevaMascota;
    private Button btnVolverMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mascotas);

        // Conectar componentes del XML
        contenedor =
                findViewById(R.id.llContenedorMascotas);

        btnNuevaMascota =
                findViewById(R.id.btnNuevaMascota);

        btnVolverMascotas =
                findViewById(R.id.btnVolverMascotas);


        // Ir al formulario de registro
        btnNuevaMascota.setOnClickListener(v -> {

            Toast.makeText(this, "Abriendo RegistrarMascota...", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Mascotas.this, RegistrarMascota.class);
            startActivity(intent);
        });


        // Volver al menú administrador
        btnVolverMascotas.setOnClickListener(v -> {

            finish();

        });
    }


    @Override
    protected void onResume() {

        super.onResume();

        listarMascotas();
    }


    private void listarMascotas() {

        // Limpiar la lista antes de volver a cargarla
        contenedor.removeAllViews();

        LayoutInflater inflater =
                LayoutInflater.from(this);


        // Recorrer las mascotas registradas
        for (Mascota mascota : Datos.mascotas) {

            // Crear una tarjeta para la mascota
            View item = inflater.inflate(
                    R.layout.item_mascota,
                    contenedor,
                    false
            );


            // =========================================
            // CONECTAR COMPONENTES DEL ITEM
            // =========================================

            TextView tvNombre =
                    item.findViewById(
                            R.id.tvNombreMascota
                    );


            TextView tvInformacion =
                    item.findViewById(
                            R.id.tvInformacionMascota
                    );


            TextView tvPropietario =
                    item.findViewById(
                            R.id.tvPropietarioMascota
                    );


            ImageView ivFoto =
                    item.findViewById(
                            R.id.ivFotoItemMascota
                    );


            // =========================================
            // MOSTRAR NOMBRE
            // =========================================

            tvNombre.setText(
                    mascota.getNombre()
            );


            // =========================================
            // MOSTRAR INFORMACIÓN
            // =========================================

            tvInformacion.setText(
                    mascota.getEspecie()
                            + " | "
                            + mascota.getRaza()
                            + " | "
                            + mascota.getSexo()
            );


            // =========================================
            // MOSTRAR PROPIETARIO
            // =========================================

            if (mascota.getPropietario() != null) {

                tvPropietario.setText(
                        "Propietario: "
                                + mascota.getPropietario()
                                .getNombreCompleto()
                );

            } else {

                tvPropietario.setText(
                        "Propietario: No asignado"
                );
            }


            // =========================================
            // MOSTRAR FOTO
            // =========================================

            if (mascota.getFoto() != null
                    && !mascota.getFoto().isEmpty()) {

                try {

                    Uri uri =
                            Uri.parse(
                                    mascota.getFoto()
                            );

                    ivFoto.setImageURI(uri);

                } catch (Exception e) {

                    // Si ocurre un error con la imagen
                    ivFoto.setImageResource(
                            R.drawable.ic_launcher_foreground
                    );
                }

            } else {

                // Imagen predeterminada
                ivFoto.setImageResource(
                        R.drawable.ic_launcher_foreground
                );
            }


            // =========================================
            // AGREGAR ITEM A LA LISTA
            // =========================================

            contenedor.addView(item);
        }
    }
}