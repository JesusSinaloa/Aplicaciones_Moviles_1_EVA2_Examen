package com.example.eduardo.exa_eva2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MostrarActivity extends AppCompatActivity {
    //DECLARACION DE GIDGETS
    ListView lstRestaurantes;
    //DECLARACION DE INTENTOS
    Intent inEvaluacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        //VINCULACION DE GIDGETS
        lstRestaurantes = findViewById(R.id.lstViewRest);

        obtenerDatos();


        //EVENTO PARA PASAR AL DETALLE DEL RESTAURANTE Y EVALUARLO
        lstRestaurantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                inEvaluacion = new Intent(MostrarActivity.this, EvaluacionActivity.class);


                inEvaluacion.putExtra("restaurante", (Serializable) lstRestaurantes.getItemAtPosition(position));
                startActivity(inEvaluacion);
                finish();

            }
        });
    }

    //OBTINE DATOS DEL SERVIDOR
    public void obtenerDatos(){
        Toast.makeText(getApplicationContext(),"PROCESANDO INFORMACION", Toast.LENGTH_SHORT).show();
        //INSTANCIO LA CLASE Y DECLARO LA URL DE DONDE SE VA A OBTENER EL JSON
        AsyncHttpClient cliente = new AsyncHttpClient();
        String url = "http://192.168.0.5/Examen/consulta.php";


        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200) {
                    cargarLista(obtnerDatosJSON(new String (responseBody)));
                    Toast.makeText(getApplicationContext(),"SE PROCESO INFORMACION CON EXITO", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"NO SE PUDO OBTNER INFORMACION, VERIFIQUE CONEXION", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(),"NO EXISTE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });


    }

    //METODO QUE DEVUELVE UNA LISTA CON LOS RESULTADOS

    public ArrayList<Restaurante> obtnerDatosJSON(String response){
        ArrayList<Restaurante> listRestaurantes = new ArrayList<>();//DECLARAMOS LA LISTA
        try{
            JSONArray jsonArray = new JSONArray(response);//GUARDAMOS EN UN OBJETO JASON EL ARRAY QUE OBTENEOS DE RESPONSE
            //String texto;
            for( int i=0; i<jsonArray.length(); i++){//RECOOREMOS EL ARRAY DE TODOS LOS OBJETOS
                //AGREGAR A LA VARIABLE EL OBJETO
              /* texto = jsonArray.getJSONObject(i).getString("nombreproducto") +" "+
                       jsonArray.getJSONObject(i).getString("precio") +" "+
                       jsonArray.getJSONObject(i).getString("imagen") +" "+
                       jsonArray.getJSONObject(i).getString("Marca") +" ";*/
                //list.add(texto);//AÑADE A LA LISTA
                //OBTENGO EL NOMBRE DE LA IMAGEN EN LA BASE DE DATOS
               /* String image;

                image = jsonArray.getJSONObject(i).getString("imagerest");
                Toast.makeText(getApplicationContext(),image, Toast.LENGTH_SHORT).show();
                //CONTRUYO LA RUTA PARA BUSCAR LA IMAGEN DENTRO DE LA CARPETA DRAWABLE*/
                String uri = jsonArray.getJSONObject(i).getString("imagerest");
                //BUSCO LA IMAGEN EN LA CARPETA DRAWABLE Y OBTENGO EL IDENTIFICADOR DE LA IMAGEN PARA PASARSELO A LA LISTA
                int imageResource;
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                //Drawable Dimagen = ContextCompat.getDrawable(getApplicationContext(), imageResource);
                //AGREGAR A LA LISTA
                listRestaurantes.add(new Restaurante(jsonArray.getJSONObject(i).getString("nombrerest"),jsonArray.getJSONObject(i).getString("descrest"), jsonArray.getJSONObject(i).getString("dirtelrest"), jsonArray.getJSONObject(i).getString("evaluacion"), imageResource));//AGREGAMOS EL RESULTADO A LA LISTA

            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return listRestaurantes;
    }

    //METODO PARA CREAR ADAPTADOR  DE LA LISTA
    public void cargarLista(ArrayList<Restaurante> datos){
        //CREO ADAPTADOR
        RestauranteAdapter miAdaptadorRestaurantes = new RestauranteAdapter(MostrarActivity.this,R.layout.layout_restaurante,datos);//LE MANDAMOS AL CONTRUCTOR DE LA CLASE EL CONTEXTO; LA LISTA Y ILAYOUT
        lstRestaurantes.setAdapter(miAdaptadorRestaurantes);



            /*for (Categoria p : datos) {//RECORREMOS LA LISTA

                Toast.makeText(getApplicationContext(), "imagen:" + p.getIconCategoria(), Toast.LENGTH_SHORT).show();
            }*/

    }
}
