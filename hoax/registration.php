<?php


//require('congig.php');

$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$response = array(); //to be encoded 

//taking inputs from json file

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
//protecting mysql injection

$name = test_input($_POST['name']);

$email = test_input($_POST['email']);
$contact = test_input($_POST['contact']);
$designation = test_input($_POST['designation']);


$password = test_input($_POST['password']);



$result = $mysqli->query("INSERT INTO user(designation, email, password, name, contact) VALUES ('$designation', '$email', '$password', '$name', '$contact')");




 if(mysqli_affected_rows($mysqli) == '1')
 {
 	$response['status'] = "true";
	$response['message'] = "REGISTRATION SUCCESSFUL";
 	echo json_encode($response);
 }

 else
 {	
 	$response['status'] = "false";
 	$response['message'] = "REGISTRATION UNSUCCESSFUL";
 	echo json_encode($response);
 }




$query->close();
$mysqli->close();

?>