<?php

$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$message = $_POST['text'];

$result = $mysqli->query("SELECT hoax_id FROM hoax WHERE message LIKE '%$message%'");

if(mysqli_affected_rows($mysqli))
{
	$row = $result->fetch_assoc();
	$response['hoax_id'] = $row['hoax_id'];
	$response['status'] = "true";
	$response['message'] = "Hoax Found";
	echo json_encode($response);
}
else
{
	$response['status'] = "false";
	$response['message'] = "Hoax not found. Creating..";
	echo json_encode($response);

}

?>