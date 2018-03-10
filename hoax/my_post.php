<?php

//include('congig.php');
$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");


$userid = $_POST['user_id'];

$response = array(); //to be encoded

$result = $mysqli->query("SELECT hoax_id, message FROM HOAX WHERE user_id = '$userid'"); 

if(mysqli_affected_rows($mysqli) == 1)
{
	$response['status'] = "false";
	json_encode($response);
}

else
{
	$i = 0;
	

	while($row = $result->fetch_assoc())
	{	
		
		$response['hoax_id_'.$i] = $row['hoax_id'];
		$response['comment_'.$i] = $row['message'];
		
		$i++;
		
	}
	
	$response['no_posts'] = "$i";
	$response['status'] = "true";
	echo json_encode($response);	

}

$result->close();
$mysqli->close();



?>