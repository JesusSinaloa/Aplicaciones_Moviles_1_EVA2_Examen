<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//ESTABLECEMOS LA CONEXION
    include './conexion.php';
    $conexion = db();
    $opinion = $_REQUEST["evaluacion"];//SE OBTIENE EL DATO ENVIADO DESDE ANDROID   
    $nombreRest = $_REQUEST["nomRest"];
   
   
    
    $update = "UPDATE restaurantes SET evaluacion='$opinion' WHERE nombrerest='$nombreRest'";//QUERy DE CONSULTA
  
    if($result = mysqli_query($conexion, $update)){//SE EJECUTA COSNULTA

         echo json_encode("OK");//SE IMPRIME JASON 

    }
 


    mysqli_close($conexion); //DESCONECTAMOS DE LA BASE DE DATOS