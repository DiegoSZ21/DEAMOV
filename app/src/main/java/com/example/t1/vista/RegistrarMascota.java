package com.example.t1.vista;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.R;
import com.example.t1.modelo.Datos;
import com.example.t1.modelo.Mascota;
import com.example.t1.modelo.Usuario;

import java.util.ArrayList;
import java.util.Calendar;

public class RegistrarMascota extends AppCompatActivity {

    private EditText etNombreMascota;
    private EditText etRazaMascota;
    private EditText etFechaNacimiento;

    private Spinner spEspecie;
    private Spinner spSexo;
    private Spinner spPropietario;

    private ImageButton ivFotoMascota;

    private Button btnRegistrarMascota;
    private Button btnVolverRegistrarMascota;

    private Uri fotoSeleccionada;

    private ArrayList<Usuario> propietariosActivos =
            new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registrar_mascota);

        // Conectar componentes del XML con Java

        etNombreMascota =
                findViewById(R.id.etNombreMascota);

        etRazaMascota =
                findViewById(R.id.etRazaMascota);

        etFechaNacimiento =
                findViewById(R.id.etFechaNacimiento);

        spEspecie =
                findViewById(R.id.spEspecie);

        spSexo =
                findViewById(R.id.spSexo);

        spPropietario =
                findViewById(R.id.spPropietario);

        ivFotoMascota =
                findViewById(R.id.ivFotoMascota);

        btnRegistrarMascota =
                findViewById(R.id.btnRegistrarMascota);

        btnVolverRegistrarMascota =
                findViewById(R.id.btnVolverRegistrarMascota);


        // Configurar los Spinner
        configurarSpinners();

        // Configurar selección de fecha
        configurarFecha();


        // Al tocar la imagen se abre la galería
        ivFotoMascota.setOnClickListener(v -> {
            seleccionarFoto();
        });


        // Registrar mascota
        btnRegistrarMascota.setOnClickListener(v -> {
            registrarMascota();
        });


        // Volver
        btnVolverRegistrarMascota.setOnClickListener(v -> {
            finish();
        });
    }


    // =========================================================
    // CONFIGURAR SPINNERS
    // =========================================================

    private void configurarSpinners() {

        // Especies
        String[] especies = {
                "Perro",
                "Gato",
                "Otro"
        };

        ArrayAdapter<String> adapterEspecie =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        especies
                );

        adapterEspecie.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spEspecie.setAdapter(adapterEspecie);


        // Sexo
        String[] sexos = {
                "Macho",
                "Hembra"
        };

        ArrayAdapter<String> adapterSexo =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        sexos
                );

        adapterSexo.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spSexo.setAdapter(adapterSexo);


        // =====================================================
        // PROPIETARIOS ACTIVOS
        // =====================================================

        propietariosActivos.clear();

        for (Usuario usuario : Datos.usuarios) {

            if (usuario.getRol().equalsIgnoreCase("PROPIETARIO")
                    && !usuario.getEstadoCuenta()
                    .equalsIgnoreCase("INACTIVA")) {

                propietariosActivos.add(usuario);
            }
        }


        ArrayList<String> nombresPropietarios =
                new ArrayList<>();

        for (Usuario usuario : propietariosActivos) {

            nombresPropietarios.add(
                    usuario.getNombreCompleto()
            );
        }


        ArrayAdapter<String> adapterPropietarios =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        nombresPropietarios
                );

        adapterPropietarios.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spPropietario.setAdapter(adapterPropietarios);
    }


    // =========================================================
    // FECHA DE NACIMIENTO
    // =========================================================

    private void configurarFecha() {

        // Evitar que el usuario escriba manualmente
        etFechaNacimiento.setFocusable(false);

        etFechaNacimiento.setOnClickListener(v -> {

            Calendar calendario =
                    Calendar.getInstance();

            int año =
                    calendario.get(Calendar.YEAR);

            int mes =
                    calendario.get(Calendar.MONTH);

            int dia =
                    calendario.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog dialogo =
                    new DatePickerDialog(
                            this,
                            (view, year, month, dayOfMonth) -> {

                                String fecha =
                                        dayOfMonth + "/" +
                                                (month + 1) + "/" +
                                                year;

                                etFechaNacimiento.setText(fecha);
                            },
                            año,
                            mes,
                            dia
                    );

            dialogo.show();
        });
    }


    // =========================================================
    // SELECCIONAR FOTO
    // =========================================================

    private void seleccionarFoto() {

        Intent intent =
                new Intent(Intent.ACTION_PICK);

        intent.setType("image/*");

        startActivityForResult(
                intent,
                100
        );
    }


    // =========================================================
    // RESULTADO DE LA GALERÍA
    // =========================================================

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data
        );


        if (requestCode == 100
                && resultCode == RESULT_OK
                && data != null) {

            fotoSeleccionada =
                    data.getData();


            ivFotoMascota.setImageURI(
                    fotoSeleccionada
            );
        }
    }


    // =========================================================
    // REGISTRAR MASCOTA
    // =========================================================

    private void registrarMascota() {

        String nombre =
                etNombreMascota
                        .getText()
                        .toString()
                        .trim();

        String raza =
                etRazaMascota
                        .getText()
                        .toString()
                        .trim();

        String fechaNacimiento =
                etFechaNacimiento
                        .getText()
                        .toString()
                        .trim();


        // Validar nombre
        if (nombre.isEmpty()) {

            etNombreMascota.setError(
                    "Ingrese el nombre de la mascota"
            );

            etNombreMascota.requestFocus();

            return;
        }


        // Validar raza
        if (raza.isEmpty()) {

            etRazaMascota.setError(
                    "Ingrese la raza"
            );

            etRazaMascota.requestFocus();

            return;
        }


        // Validar fecha
        if (fechaNacimiento.isEmpty()) {

            etFechaNacimiento.setError(
                    "Seleccione la fecha de nacimiento"
            );

            etFechaNacimiento.requestFocus();

            return;
        }


        // Validar propietarios
        if (propietariosActivos.isEmpty()) {

            Toast.makeText(
                    this,
                    "No existen propietarios activos",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        // Obtener propietario seleccionado
        Usuario propietario =
                propietariosActivos.get(
                        spPropietario
                                .getSelectedItemPosition()
                );


        // Obtener especie
        String especie =
                spEspecie
                        .getSelectedItem()
                        .toString();


        // Obtener sexo
        String sexo =
                spSexo
                        .getSelectedItem()
                        .toString();


        // Guardar ruta de la foto
        String foto = "";

        if (fotoSeleccionada != null) {

            foto =
                    fotoSeleccionada.toString();
        }


        // Crear mascota
        Mascota mascota =
                new Mascota(
                        nombre,
                        especie,
                        raza,
                        fechaNacimiento,
                        sexo,
                        foto,
                        propietario
                );


        // Guardar temporalmente
        Datos.mascotas.add(mascota);


        // Mensaje
        Toast.makeText(
                this,
                "Mascota registrada correctamente",
                Toast.LENGTH_SHORT
        ).show();


        // Regresar
        finish();
    }
}