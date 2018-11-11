package com.example.eduardo.exa_eva2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    //DECLARACION DE WIDGETS
    Button btnCapturar, btnMostrar, btnSalir;
    //DECLARACION DE INTENTOS
    Intent inCapturar, inMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //VINCULACION DE WIDGETS
        btnCapturar = findViewById(R.id.buttonCapturar);
        btnMostrar = findViewById(R.id.buttonMostrar);
        btnSalir = findViewById(R.id.buttonSalir);

        //EVENTO PARA AGREGAR RESTAURANTE
        btnCapturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inCapturar = new Intent(Principal.this, AgregarActivity.class);
                startActivity(inCapturar);
            }
        });

        //EVENTO PARA MOSTRAR LISTA DEE RESTAURANTES
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inMostrar = new Intent(Principal.this, MostrarActivity.class);
                startActivity(inMostrar);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }


}
