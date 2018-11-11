package com.example.eduardo.exa_eva2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.loopj.android.http.*;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class AgregarActivity extends AppCompatActivity {
    //DECLARACION DE WIDGETS
    EditText nombreRestA, descRestA, dirTelRestA;
    Button btnAgregar;
    ImageButton imageRestA;

    //DECLARACION DE VARIABLES
    String nombreRest, descripcionRest, dirTelRest, imagen;
    int idImage, imageResource;
     String uri;

    //DECLARACION DE INTENTOS
    Intent inImageRest;
    Intent inRecuperar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        //VINCULACION DE WIDGETS
        nombreRestA = findViewById(R.id.editTextNombreRestA);
        descRestA = findViewById(R.id.editTextDesRestA);
        dirTelRestA = findViewById(R.id.editTextDirTelA);
        btnAgregar = findViewById(R.id.buttonGuardarRestA);
        imageRestA = findViewById(R.id.imageButtonRestA);

        //RECUPERO INTENTO
        inRecuperar = getIntent();
        idImage = inRecuperar.getIntExtra("resultado", 21);
        imagen =  Integer.toString(idImage);

        //OBTENER IMAGEN

        //CONTRUYO URI
         uri = "@drawable/imagen"+imagen;
        //BUSCO LA IMAGEN EN LA CARPETA DRAWABLE Y OBTENGO EL IDENTIFICADOR DE LA IMAGEN PARA PASARSELO A LA LISTA
        imageResource = getResources().getIdentifier(uri, null, getPackageName());
        //INSERTO LA NUEVA IMAGEN
        imageRestA.setImageResource(imageResource);

        //OBTENER DATOS
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombreRest = nombreRestA.getText().toString();
                descripcionRest = descRestA.getText().toString();
                dirTelRest = dirTelRestA.getText().toString();
                agregarRest(nombreRest, descripcionRest, dirTelRest, uri);
            }
        });

        imageRestA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"di click", Toast.LENGTH_SHORT).show();
                inImageRest = new Intent(AgregarActivity.this, ImagesRestActivity.class);
                startActivityForResult(inImageRest, 10);
                finish();
            }
        });


    }


    public void agregarRest(String nombreRest, String descripcionRest, String dirTelRest, String image){



        if (nombreRest.isEmpty() || descripcionRest.isEmpty() || dirTelRest.isEmpty() || image.isEmpty()){
            Toast.makeText(getApplicationContext(),"Llena antes los datos"  , Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(getApplicationContext(),"PROCESANDO INFORMACION", Toast.LENGTH_SHORT).show();
            //INSTANCIO LA CLASE Y DECLARO LA URL DE DONDE SE VA A OBTENER EL JSON
            AsyncHttpClient cliente = new AsyncHttpClient();
            String url = "http://192.168.0.5/Examen/insertar.php";
            //PARA ENVIAR DATOS AL WEBSERVICE DE QUE SE VA A CONSULTAR
            RequestParams parametros = new RequestParams();
            parametros.put("nombreRest", nombreRest);
            parametros.put("desRest", descripcionRest);
            parametros.put("dirTelRes", dirTelRest);
            parametros.put("image", image);
            parametros.put("evaluacion", "3");

            cliente.post(url, parametros, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    if(statusCode == 200) {
                         Toast.makeText(getApplicationContext(),"SE INSERTO CON EXITO", Toast.LENGTH_SHORT).show();
                         finish();
                    }else {

                        Toast.makeText(getApplicationContext(),"ERROR INTENTE DE NUEVO", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Toast.makeText(getApplicationContext(),"NO EXISTE CONEXION", Toast.LENGTH_SHORT).show();
                }
            });



        }
    }

}
