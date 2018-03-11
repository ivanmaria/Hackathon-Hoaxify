<?php
 
//include('config.php');
$mysqli = new mysqli("localhost", "atharva", "ath", "hoax");

$hoaxid = $_POST['hoax_id'];
$userid = $_POST['user_id'];

$result1 = $mysqli->query("SELECT * FROM hoax WHERE hoax_id = '$hoaxid' ");

if(mysqli_affected_rows($mysqli)==0)
{
	$response['status'] = "false";
	$response['message'] = "ERROR OCCURED";
	echo json_encode($response);
}
else
{
$result2 = $mysqli->query("SELECT * FROM comment WHERE hoax_id = '$hoaxid' ");
	
	$j=0;//no of comment details
	$k=0;//user
		
		

	$row1= $result1->fetch_assoc();
	
	$result8 = $mysqli->query("SELECT COUNT(*) AS count FROM hoax_activity WHERE hoax_id = '$hoaxid' AND vote=1");
		$result9 = $mysqli->query("SELECT COUNT(*) AS count FROM hoax_activity WHERE hoax_id = '$hoaxid' AND vote=2");
		$row8= $result8->fetch_assoc();
		$row9= $result9->fetch_assoc();
		$num3 = $row8['count'];
		$num4 = $row9['count'];
		$response['num_vote'] = $num3-$num4;
		 
		
		$response['text'] = $row1['message'];
		$result4 = $mysqli->query("SELECT * FROM hoax_activity WHERE hoax_id = '$hoaxid' AND user_id = '$userid'");
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
	$response['commentid_'.$j] = $row2['comment_id'];
		$comid = $row2['comment_id'];
		$temp = $row2['user_id'];
		$result3 = $mysqli->query("SELECT * FROM user WHERE user_id = '$temp' ");

		$row3= $result3->fetch_assoc();
		$response['name_'.$j] = $row3['name'];
		$response['designation_'.$j] = $row3['designation'];

		$result6 = $mysqli->query("SELECT COUNT(*) AS count FROM comment_activity WHERE comment_id = '$comid' AND vote=1");
		$result7 = $mysqli->query("SELECT COUNT(*) AS count FROM comment_activity WHERE comment_id = '$comid' AND vote=2");
		$row6= $result6->fetch_assoc();
		$row7= $result7->fetch_assoc();
		$num1 = $row6['count'];
		$num2 = $row7['count'];
		$response['num_vote_'.$j] = $num1-$num2;
		
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
	
	 
	
	$response['num_comment']=$j;
	$response['status'] = "true";
	
	echo json_encode($response);
	}






?>