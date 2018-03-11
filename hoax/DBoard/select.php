<?php  
 require('config.php'); 
 session_start();

 $output = '';
 
 if(isset($_POST["query"])){
  $sear = $_POST["query"];
  
  $sql = "SELECT * FROM hoax WHERE message LIKE '%$sear%'";
 }
 
else{
 $sql = "SELECT * FROM hoax ";  
}

 $result = mysqli_query($mysqli, $sql);

 $rows = mysqli_num_rows($result);

 echo "Total number of Entries : $rows";

  $output .= '  
      <div class="table-responsive">  
           <table class="table table-bordered">  
                <tr>  
                     <th width="10%">User Id</th>  
                     <th width="40%">Message</th>   
                     <th width="10%">Category Id</th>  
                     <th width="10%">Delete</th>
                </tr>';  


 if($rows > 0)  
 {  
      while($row = mysqli_fetch_array($result))  
      {  
            
           $output .= '  
                <tr>  
                       
                     <td class="user_id" data-id1="'.$row["hoax_id"].'" contenteditable>'.$row["user_id"].'</td>  
                     <td class="message" data-id2="'.$row["hoax_id"].'" contenteditable>'.$row["message"].'</td>
                     <td class="category_id" data-id8="'.$row["hoax_id"].'" contenteditable>'.$row["category_id"].'</td>  
                     <td><button type="button" name="delete_btn" data-id9="'.$row["hoax_id"].'" class="btn btn-xs btn-danger btn_delete">x</button></td>  
                </tr>  
           ';  
      }  
        
 }  
 else  
 {  
      $output .= '';
				  
 }  
 $output .= '</table>  
      </div>';  
 echo $output;  
 ?>

