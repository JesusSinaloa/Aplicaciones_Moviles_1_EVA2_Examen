package com.example.eduardo.exa_eva2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ImagesRestActivity extends AppCompatActivity {
    //DECLARACION DE INTENTOS
    Intent inRespuesta;
    //DECLARACION DE WIDGETS
    ListView lstImageRest;
    //DECLARACION DE VARIABLES
    ImageRest [] imagenesRest ={
            new ImageRest(R.drawable.imagen0),
            new ImageRest(R.drawable.imagen1),
            new ImageRest(R.drawable.imagen2),
            new ImageRest(R.drawable.imagen3),
            new ImageRest(R.drawable.imagen4),
            new ImageRest(R.drawable.imagen5),
            new ImageRest(R.drawable.imagen6),
            new ImageRest(R.drawable.imagen7),
            new ImageRest(R.drawable.imagen8),
            new ImageRest(R.drawable.imagen9),
            new ImageRest(R.drawable.imagen10),
            new ImageRest(R.drawable.imagen11),
            new ImageRest(R.drawable.imagen12),
            new ImageRest(R.drawable.imagen13),
            new ImageRest(R.drawable.imagen14),
            new ImageRest(R.drawable.imagen15),
            new ImageRest(R.drawable.imagen16),
            new ImageRest(R.drawable.imagen17),
            new ImageRest(R.drawable.imagen18),
            new ImageRest(R.drawable.imagen19),
            new ImageRest(R.drawable.imagen20),
    };

    int idImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_rest);
        lstImageRest = findViewById(R.id.lstViewImgRestIR);


        ImagesRestAdapter miAdaptador = new ImagesRestAdapter(ImagesRestActivity.this,R.layout.layput_image_rest,imagenesRest);//LE MANDAMOS AL CONTRUCTOR DE LA CLASE EL CONTEXTO; LA LISTA Y ILAYOUT
        lstImageRest.setAdapter(miAdaptador);


        lstImageRest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              idImagen = (int) lstImageRest.getItemIdAtPosition(position);

                Toast.makeText(getApplicationContext(),"idImagen:" +idImagen, Toast.LENGTH_SHORT).show();



               inRespuesta = new Intent(ImagesRestActivity.this, AgregarActivity.class);
                inRespuesta.putExtra("resultado", idImagen);
                startActivity(inRespuesta);
                finish();
            }
        });

    }
}
