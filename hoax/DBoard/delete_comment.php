<?php
require('config.php');
session_start();
if(isset($_POST["id"]))
{
 $query = "DELETE FROM comment WHERE comment_id = '".$_POST["id"]."'";
 if(mysqli_query($mysqli, $query))
 {
  echo 'Data Deleted';
 }
 $query = "DELETE FROM comment_activity WHERE hoax_id = '".$_POST["id"]."'";
 if(mysqli_query($mysqli, $query))
 {
  echo 'Data Deleted';
 }
}
?>