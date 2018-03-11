<?php

$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$response = array();

$userid = $_POST['user_id'];
$hoaxid = $_POST['hoax_id'];
$comment = $_POST['comment'];
//$datetime = $_POST['date_time'];









$result = $mysqli->query("INSERT INTO comment(user_id,hoax_id,comment) VALUES ('$userid','$hoaxid','$comment')");
if ( false===$result ) {
  printf("error: %s\n", mysqli_error($mysqli));
 }

if(mysqli_affected_rows($mysqli))
{
	$conn = new mysqli("localhost", "atharva", "ath", "hoax");
	$result2 = $conn->query("SELECT MAX(comment_id) as max FROM comment");


	$row2 = $result2->fetch_assoc();
	$response['comment_id'] = $row2['max'];
	$response['status'] = "true";
	echo json_encode($response);
}
else
{
	$response['status'] = "false";
	echo json_encode($response);

}

?>