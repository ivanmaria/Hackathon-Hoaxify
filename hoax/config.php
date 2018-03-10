<?php

$server = "localhost";
$user = "atharva";
$pass = "ath";
$dbname = "hoax";

$mysqli = new mysqli($server,$user,$pass,$dbname);

if ($mysqli->connect_error)
{
    $response['status'] = "false";
    $response['message'] = "DATABASE PROBLEM";
    echo json_encode($response);
    die("Connection failed: " . $conn->connect_error);
} 
echo "db working";

?>