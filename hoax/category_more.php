<?php

//include('config.php');
$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");
$response = array(); //to be encoded 

$category = $_POST['category'];
$time = $_POST['time'];

$result=$mysqli->query("SELECT hoax_id, message ,date_time FROM hoax WHERE category_id = (SELECT category_id FROM category WHERE type = '$category') AND date_time >= '$time' ORDER BY date_time LIMIT 5"); //query to be inserted


 if(!mysqli_affected_rows($mysqli))
 {
 	$response['status'] = "false";
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
 		
 	
 		$date_time = $row['new_date'];


 	}
 	$response['date_time'] = "$date_time";
 	$response['no_hoax'] = "$i";
 	$response['status'] = "true";
 	

 	echo json_encode($response);	

 }


$result->close();
$mysqli->close();

?>