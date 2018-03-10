<?php
 
//include('config.php');
$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$hoaxid = $_POST['hoax_id'];
$userid = $_POST['user_id'];

$result1 = $mysqli->query("SELECT * FROM hoax WHERE hoax_id = '$hoaxid' ");

$result2 = $mysqli->query("SELECT * FROM comment WHERE hoax_id = '$hoaxid' ");





if(!mysqli_affected_rows($mysqli))
{
	$response['status'] = "false";
	$response['message'] = "ERROR OCCURED";
	echo json_encode($response);
}
else
{

	
	$j=0;//no of comment details
	$k=0;//user
	
	$row1= $result1->fetch_assoc();
	
		 
		
		$response['text'] = $row['message'];
		$result4 = $mysqli->query("SELECT * FROM hoax_activity WHERE user_id = '$userid'");
		if(mysqli_affected_rows($mysqli)== 0)
		{
			$response['vote'] = 0;
			$response['flag'] = 0;
		}
		else
		{
			$row4= $result4->fetch_assoc();
			$response['vote'] = $row4['vote'];
			$response['flag'] = $row4['flag'];
		}

	while($row2= $result2->fetch_assoc())//comments
	{
		$response['comment_'.$j] = $row2['comment'];

		$temp = $row['user_id'];
		$result3 = $mysqli->query("SELECT * FROM user WHERE user_id = '$temp' ");

		$row3= $result3->fetch_assoc();
		$response['name_'.$j] = $row3['name'];
		$response['designation_'.$j] = $row3['designation'];


		$result5 = $mysqli->query("SELECT * FROM comment_activity WHERE user_id = '$userid'");


		if(mysqli_affected_rows($mysqli)== 0)
		{
			$response['vote_'.$j] = 0;
			$response['flag_'.$j] = 0;
		}
		else
		{
			$row5= $result5->fetch_assoc();
			$response['vote_'.$j] = $row5['vote'];
			$response['flag_'.$j] = $row5['flag'];
		}






		$j++;
		
	}
	
	 
	

	$response['status'] = "true";
	
	echo json_encode($response);
	}


}




?>