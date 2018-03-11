<?php

$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$response = array();
$userid = $_POST['user_id'];
//$categoryid = $_POST['category_id'];
$message = $_POST['text'];
//$datetime = $_POST['date_time'];









$result = $mysqli->query("INSERT INTO hoax(user_id,category_id,message) VALUES ('$userid','1','$message')");

if(mysqli_affected_rows($mysqli))
{
	$conn = new mysqli("localhost", "atharva", "ath", "hoax");
	$result2 = $conn->query("SELECT MAX(hoax_id) as max FROM hoax");


	$row2 = $result2->fetch_assoc();
	$response['hoax_id'] = $row2['max'];
	$response['status'] = "true";
	echo json_encode($response);
}
else
{
	$response['status'] = "false";
	echo json_encode($response);

}

?>