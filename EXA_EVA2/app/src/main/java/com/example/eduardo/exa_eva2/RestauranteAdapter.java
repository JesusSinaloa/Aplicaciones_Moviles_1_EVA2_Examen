package com.example.eduardo.exa_eva2;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestauranteAdapter extends ArrayAdapter{

    String puntaje;
    Context contexto;//CONTEXTO DE LA APLICACION
    int iLayout;
    List<Restaurante> ListRestaurantes;//LISTA DE OBJETOS DE LA CLASE PRODUCTO

    public RestauranteAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        contexto = context;
        iLayout = resource;
        ListRestaurantes = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View vFila = convertView;
        //DECLARACION DE WIDGETS
        TextView nombreRest, descRest, dirTelRest;
        ImageView imagenRest, star1, star2, star3;


        if (vFila == null){//SI NO EXISTE LA FILA HAY QUE CREARLA
            //ESTE OBJETO NOS PERMITE CREAR LA LISTA
            LayoutInflater liVista = LayoutInflater.from(contexto);
            vFila = liVista.inflate(iLayout, parent, false);

        }

        //VINCULAR WIDGETS
        nombreRest= vFila.findViewById(R.id.textViewNombreRestL);
        descRest = vFila.findViewById(R.id.textViewDescRestL);
        dirTelRest = vFila.findViewById(R.id.textViewDirTelRestL);
        imagenRest = vFila.findViewById(R.id.imageViewRestL);
        star1 = vFila.findViewById(R.id.imageViewSatar1);
        star2 = vFila.findViewById(R.id.imageViewStar2);
        star3 = vFila.findViewById(R.id.imageViewStar3);

        //LLENAR DATOS
        nombreRest.setText(ListRestaurantes.get(position).getNombreRest());
        descRest.setText(ListRestaurantes.get(position).getDescRest());
        dirTelRest.setText(ListRestaurantes.get(position).getDirTelRest());
        imagenRest.setImageResource(ListRestaurantes.get(position).getImagenRest());

         puntaje = ListRestaurantes.get(position).getEvaluacion();


        if(puntaje.compareTo("1") == 0){
            star1.setColorFilter(Color.RED);
            star2.setColorFilter(Color.WHITE);
            star3.setColorFilter(Color.WHITE);
        }else {
            if (puntaje.compareTo("2") == 0) {
                star1.setColorFilter(Color.RED);
                star2.setColorFilter(Color.RED);
                star3.setColorFilter(Color.WHITE);
            }else{
                if(puntaje.compareTo("3") == 0){
                    star1.setColorFilter(Color.RED);
                    star2.setColorFilter(Color.RED);
                    star3.setColorFilter(Color.RED);
                }

            }
        }





        return vFila;

    }
}
