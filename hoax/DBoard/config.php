<?php

$server = "localhost";
$user = "atharva";
$pass = "ath";
$dbname = "HOAX";

$mysqli = new mysqli($server,$user,$pass,$dbname);

if ($mysqli->connect_error)
{
    $response['status'] = "false";
    $response['message'] = "DATABASE PROBLEM";
    echo json_encode($response);
    die("Connection failed: " . $mysqli->connect_error);
} 


?>