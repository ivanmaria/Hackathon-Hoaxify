<?php

$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$userid = $_POST['user_id'];
$hoaxid = $_POST['hoax_id'];

$result = $mysqli->query("SELECT hoax_activity_id,vote FROM hoax_activity WHERE user_id = '$userid' AND hoax_id = '$hoaxid'");

if(mysqli_affected_rows($mysqli))
{
	$row = $result->fetch_assoc();
	if($row['vote']== 0)
	{
		$conn = new mysqli("localhost", "atharva", "ath", "hoax");
		$result1 = $conn->query("UPDATE hoax_activity SET vote = '1'");

		if ( false===$result1 ) {
  printf("error: %s\n", mysqli_error($conn));
 }
 else {
   echo 'done.';
 }

		$response['status'] = "upvoted";
		echo json_encode($response);

	}
	else if($row['vote']== 1)
	{
		$conn = new mysqli("localhost", "atharva", "ath", "hoax");
		$result1 = $conn->query("UPDATE hoax_activity SET vote = '0'");
		$response['status'] = "upvote canceled";
		echo json_encode($response);

	}
}
else
{
	$response['status'] = "false";
	echo json_encode($response);

}

?>