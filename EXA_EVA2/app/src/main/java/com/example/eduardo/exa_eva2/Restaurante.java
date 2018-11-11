package com.example.eduardo.exa_eva2;

import java.io.Serializable;

public class Restaurante implements Serializable {

        //DECLARACION DE ATRIBUTOS
        private String nombreRest, descRest, dirTelRest, evaluacion;
        private int imagenRest;



        //DECLARACION DE CONTRUCTOR CON LOS VALORES QUE VA A RECIBIR

        public Restaurante (String nombreRest, String descRest, String dirTelRest, String evaluacion, int imagenRest){
            //LOS ATRIBUTOS DE ELA CLASE SON IGUAL A LO QUE RECIBIO
            this.nombreRest = nombreRest;
            this.descRest = descRest;
            this.dirTelRest = dirTelRest;
            this.evaluacion = evaluacion;
            this.imagenRest = imagenRest;


        }

    public String getNombreRest() {
        return nombreRest;
    }

    public void setNombreRest(String nombreRest) {
        this.nombreRest = nombreRest;
    }

    public String getDescRest() {
        return descRest;
    }

    public void setDescRest(String descRest) {
        this.descRest = descRest;
    }

    public String getDirTelRest() {
        return dirTelRest;
    }

    public void setDirTelRest(String dirTelRest) {
        this.dirTelRest = dirTelRest;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public int getImagenRest() {
        return imagenRest;
    }

    public void setImagenRest(int imagenRest) {
        this.imagenRest = imagenRest;
    }
}
