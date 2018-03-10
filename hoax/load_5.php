<?php

//include('config.php');
$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");
$response = array(); //to be encoded 

$result=$mysqli->query("SELECT hoax_id, message ,date_time FROM hoax ORDER BY date_time LIMIT 5"); //query to be inserted


 if(!mysqli_affected_rows($mysqli))
 {
 	$status['status'] = "false";
 	$response['message'] = "ERROR OCCURED";
	echo json_encode($response);
 }
 else
 {
 	$i = 0;
 	$date_time = "";

 	while($row = $result->fetch_assoc())
 	{	
		
 		$response['hoax_id_'+$i] = $row['hoax_id'];
 		$response['message_'+$i] = $row['message'];
		
 		$i++;
 		
 	
 		$date_time = $row['date_time'];


 	}
 	$response['date_time'] = "$date_time";
 	$response['no_hoax'] = "$i";
 	$response['status'] = "true";
 	

 	echo json_encode($response);	

 }


$result->close();
$mysqli->close();

?>