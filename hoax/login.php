<?php

require('config.php');
$rsponse = array();
$username = $_POST['username'];
$password = $_POST['password'];

$result = $mysqli->query("SELECT * FROM USER WHERE contact = '$username' OR email = '$username' AND password = '$password'");

if(!mysqli_affected_rows($mysqli))
{
	$response['status'] = "false";
	$response['message'] = "INCORRECT USERNAME OR PASSWORD";

	echo json_encode($response);

}

else
{
	

	$row = $result->fetch_assoc();
 	 
	$response['user_id'] = $row['user_id'];
	$response['designation'] = $row['designation'];
	$response['email'] = $row['email'];
	$response['name'] = $row['name'];
	$response['contact'] = $row['contact'];

	$response['status'] = "true";
	$response['message'] = "LOGIN SUCCESSFUL";

 	echo json_encode($response);
	

}

?>