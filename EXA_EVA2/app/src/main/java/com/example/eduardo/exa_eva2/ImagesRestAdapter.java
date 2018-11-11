package com.example.eduardo.exa_eva2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImagesRestAdapter extends ArrayAdapter {
    Context contexto;
    int iLayout;
    ImageRest[] aImageRest;

    public ImagesRestAdapter(@NonNull Context context, int resource, @NonNull ImageRest[] objects) {
        super(context, resource, objects);
        contexto = context;
        iLayout = resource;
        aImageRest = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ImageView imgVwRest;


        View vFila = convertView;
        if(vFila == null) {//SI ES NULO NO ESXITE LA FILA HAY QUE CREARLA
            //PARA CREAR LA LISTA USAMOS LAYOUTINFLATER
            LayoutInflater liVista = LayoutInflater.from(contexto);
            vFila = liVista.inflate(iLayout, parent, false);
        }

        //VINCULAR LOS WIDGETS
        imgVwRest = vFila.findViewById(R.id.imageViewRestLR);

        //LENAR DATOS
        ImageRest actual = aImageRest[position];
        imgVwRest.setImageResource(actual.imageRest);




        return vFila;


    }
}
