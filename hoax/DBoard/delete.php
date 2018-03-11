<?php
require('config.php');
if(isset($_POST["id"]))
{
 $query = "DELETE FROM hoax WHERE hoax_id = '".$_POST["id"]."'";
 if(mysqli_query($mysqli, $query))
 {
  echo 'Data Deleted';
 }
 $query = "DELETE FROM hoax_activity WHERE hoax_id = '".$_POST["id"]."'";
 if(mysqli_query($mysqli, $query))
 {
  echo 'Data Deleted';
 }
}
?>