<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//ESTABLECEMOS LA CONEXION
    include './conexion.php';
    $conexion = db();
    $nombreRest = $_REQUEST["nombreRest"];//SE OBTIENE EL DATO ENVIADO DESDE ANDROID   
    $descRest = $_REQUEST["desRest"];
    $dirTelRest = $_REQUEST["dirTelRes"];
    $image = $_REQUEST["image"];
    $evaluacion = $_REQUEST["evaluacion"];
   
    
    $insert = "INSERT INTO restaurantes (nombrerest, descrest, dirtelrest, imagerest, evaluacion) VALUES ('$nombreRest', '$descRest', '$dirTelRest', '$image', '$evaluacion')";//QUERy DE CONSULTA
  
    if($result = mysqli_query($conexion, $insert)){//SE EJECUTA COSNULTA

         echo json_encode("OK");//SE IMPRIME JASON 

    }
 


    mysqli_close($conexion); //DESCONECTAMOS DE LA BASE DE DATOS