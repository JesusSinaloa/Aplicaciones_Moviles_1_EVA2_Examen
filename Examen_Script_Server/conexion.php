<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function db (){
$conect = mysqli_connect("localhost", 'root', "", "examen");
        //validar si la conexion tuvo exito
        if (mysqli_connect_errno()){
            echo "Error en conexion de BD: " . mysqli_connect_error();
        }
        return $conect;
}
  


