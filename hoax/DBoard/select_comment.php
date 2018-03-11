<?php  
 require('config.php'); 
 session_start();

 $output = '';



 $output .= '  
      <div class="table-responsive">  
           <table class="table table-bordered">  
                <tr>  
                     <th width="10%">Hoax Id</th>  
                     <th width="10%">User Id</th>  
                     <th width="40%">Comment</th>   
                     <th width="10%">Delete</th>
                </tr>';  
 
 if(isset($_POST["query"])){
  $sear = $_POST["query"];
  
  $sql = "SELECT * FROM comment WHERE comment LIKE '%$sear%'";
 }
 
else{
 $sql = "SELECT * FROM comment";  
}

 $result = mysqli_query($mysqli, $sql);

 $rows = mysqli_num_rows($result);
 if($rows > 0)  
 {  
      while($row = mysqli_fetch_array($result))  
      {  
            
           $output .= '  
                <tr>  
                       

                     <td class="category_id" data-id8="'.$row["comment_id"].'" contenteditable>'.$row["hoax_id"].'</td>  
                     <td class="user_id" data-id1="'.$row["comment_id"].'" contenteditable>'.$row["user_id"].'</td>  
                     <td class="message" data-id2="'.$row["comment_id"].'" contenteditable>'.$row["comment"].'</td> 
                     <td><button type="button" name="delete_btn" data-id9="'.$row["comment_id"].'" class="btn btn-xs btn-danger btn_delete">x</button></td>  
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

