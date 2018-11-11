<?php
//ESTABLECEMOS LA CONEXION
    include './conexion.php';
    $conexion = db();
   
    $consulta = "SELECT nombrerest, descrest, dirtelrest, imagerest, evaluacion FROM restaurantes";//QUERy DE CONSULTA

    $result = mysqli_query($conexion, $consulta);//SE EJECUTA COSNULTA

    $json = array(); //CREAMOS EL ARRAY

   
 
    while ( $datos = mysqli_fetch_array($result)){//SE RECORRE ARRAY
        $json[] = $datos;//SE GUARDAN LOS DATOS DE LA BD EN EL ARRAY MULTIDIMENCIONAL
        
       // echo $datos['nombreSubcategoria'];
     
    }
  
    echo json_encode($json);//SE IMPRIME JASON 

    mysqli_close($conexion); //DESCONECTAMOS DE LA BASE DE DATOS 
        