package com.example.eduardo.exa_eva2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class EvaluacionActivity extends AppCompatActivity {
    //DECLARACION DE WIDGETS
    TextView nombreRest, descRest, dirTelRest;
    ImageView imageRest, star1, star2, star3;
    Spinner evaluacion;
    Button actualizar;

    //DECLARACION DE INTENTOS
    Intent inRecuperar;
    Intent inRegresar;

    //DECLARACION DE VARIABLES
    int image;
    String[] strPuntos;
    String Evaluacion, puntuacion, nombreRestaurante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        //VINCULACION DE WIDGETS
        nombreRest = findViewById(R.id.textViewNombreRestE);
        descRest = findViewById(R.id.textViewDesRestE);
        dirTelRest = findViewById(R.id.textViewDirTelE);
        imageRest = findViewById(R.id.imageViewRestE);
        evaluacion = findViewById(R.id.spinnerEva);
        actualizar = findViewById(R.id.buttonActualizarE);
        star1 = findViewById(R.id.imageViewStar1E);
        star2 = findViewById(R.id.imageViewStar2E);
        star3 = findViewById(R.id.imageViewStar3E);
        //RECUPERAR INTENTO
        inRecuperar = getIntent();
        //OBTENER OBJETO
        Restaurante ObjRest= (Restaurante) inRecuperar.getSerializableExtra("restaurante");
        //LLENAR DATOS
        nombreRest.setText(ObjRest.getNombreRest().toString());
        descRest.setText(ObjRest.getDescRest().toString());
        dirTelRest.setText(ObjRest.getDirTelRest().toString());
        Evaluacion = ObjRest.getEvaluacion().toString();
        nombreRestaurante = ObjRest.getNombreRest().toString();
        if(Evaluacion.compareTo("1") == 0){
            star1.setColorFilter(Color.RED);
            star2.setColorFilter(Color.WHITE);
            star3.setColorFilter(Color.WHITE);
        }
        if(Evaluacion.compareTo("2") == 0){
            star1.setColorFilter(Color.RED);
            star2.setColorFilter(Color.RED);
            star3.setColorFilter(Color.WHITE);
        }
        if(Evaluacion.compareTo("3") == 0){
            star1.setColorFilter(Color.RED);
            star2.setColorFilter(Color.RED);
            star3.setColorFilter(Color.RED);
        }

        image=  ObjRest.getImagenRest();
        imageRest.setImageResource(image);

        strPuntos = new String[] {"Regular", "Buena", "Excelente"};

        ArrayAdapter<String> miAdaptadorSpinner = new ArrayAdapter<String>(EvaluacionActivity.this, android.R.layout.simple_spinner_dropdown_item, strPuntos);
        miAdaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        evaluacion.setAdapter(miAdaptadorSpinner);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opinion = String.valueOf(evaluacion.getSelectedItem());//OBTENGO EL ITEM SELECCIONADO DEL SPINNER
                if(opinion.compareTo("Regular") == 0){
                   puntuacion = "1";
                }
                if(opinion.compareTo("Buena") == 0){
                    puntuacion = "2";
                }
                if(opinion.compareTo("Excelente") == 0){
                    puntuacion = "3";
                }
                Toast.makeText(getApplicationContext(),"ACTUALIZANDO A" + puntuacion, Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(),"PROCESANDO INFORMACION", Toast.LENGTH_LONG).show();
                //INSTANCIO LA CLASE Y DECLARO LA URL DE DONDE SE VA A OBTENER EL JSON
                AsyncHttpClient cliente = new AsyncHttpClient();
                String url = "http://192.168.0.5/Examen/actualizar.php";
                //PARA ENVIAR DATOS AL WEBSERVICE DE QUE SE VA A CONSULTAR
                RequestParams parametros = new RequestParams();
                parametros.put("evaluacion", puntuacion);
                parametros.put("nomRest", nombreRestaurante);


                cliente.post(url, parametros, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if(statusCode == 200) {
                            Toast.makeText(getApplicationContext(),"SE ACTUALIZO CON EXITO", Toast.LENGTH_SHORT).show();
                            inRegresar = new Intent(EvaluacionActivity.this, MostrarActivity.class);
                            startActivity(inRegresar);
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
        });

    }
}
