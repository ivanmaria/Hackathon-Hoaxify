<?php

$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$userid = $_POST['user_id'];
$hoaxid = $_POST['hoax_id'];

$result = $mysqli->query("SELECT hoax_activity_id,vote FROM hoax_activity WHERE user_id = '$userid' AND hoax_id = '$hoaxid'");

if(mysqli_affected_rows($mysqli)== 0)
{	
	$conn1 = new mysqli("localhost", "atharva", "ath", "hoax");
	$result = $conn1->query("INSERT INTO hoax_activity(user_id,hoax_id,vote,flag) VALUES('$userid','$hoaxid','0','0')");
	
 }





$result1 = $mysqli->query("SELECT hoax_activity_id, vote FROM hoax_activity WHERE user_id = '$userid' AND hoax_id = '$hoaxid'");

if(mysqli_affected_rows($mysqli)==1)
{
	$row = $result1->fetch_assoc();

	if($row['vote']== 0 || $row['vote']== 2)
	{
		$conn = new mysqli("localhost", "atharva", "ath", "hoax");
		$result2 = $conn->query("UPDATE hoax_activity SET vote = '1' WHERE user_id = '$userid' AND hoax_id = '$hoaxid'");


		$response['message'] = "upvoted";
		$response['status'] = "true";
		echo json_encode($response);

	}

	else if($row['vote']== 1) 
	{
		$conn = new mysqli("localhost", "atharva", "ath", "hoax");
		$result2 = $conn->query("UPDATE hoax_activity SET vote = '0' WHERE user_id = '$userid' AND hoax_id = '$hoaxid'");
		$response['message'] = "vote removed";
		$response['status'] = "true";
		echo json_encode($response);

	}
}
else
{
	$response['status'] = "false";
	echo json_encode($response);

}

$result->close();
$mysqli->close();
$conn1->close();
$result1->close();
$conn->close();
$result2->close();
$row->close();
?>