<?php
  require('config.php');
  session_start();
  if(!isset($_SESSION['username'])){
    include('login.php');
  }
  else
  {
?> 


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Hoax Detection</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <style>
          
.page-footer{
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 120px;

}
    </style>
  </head>
  <body>
    
    <!--navbar-->
    <nav class="navbar navbar-toggleable-md navbar-light text-white fixed-top bg-info">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand text-white" href="index.php"><strog>HOAX</strog></a>
    <div class="collapse navbar-collapse justify-content-end text-white bg-info" id="navbarNav">
      <ul class="navbar-nav ">
        <li class="nav-item active">
          <a class="nav-link text-white text-uppercase" href="index.php">Home <span class="sr-only">(current)</span></a>
        </li>       
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle text-white text-uppercase" href="dash.php" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          DashBoard
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <div class="dropdown-divider"></div>
          <a class="dropdown-item bg-secondary" href="hoaxview.php">HoaxView</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item bg-secondary" href="commentview.php">CommentView</a>
        </div>
      </li>
        
      <?php

        if(isset($_SESSION['username'])){
        echo "<li class='nav-item'>
          <li class='nav-item dropdown'>
        <a class='nav-link dropdown-toggle text-white' href='dash.php' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>
          Hi ADMIN
        </a>
        <div class='dropdown-menu' aria-labelledby='navbarDropdown'>
          
          <a class='dropdown-item bg-secondary' href='logout.php'>Logout</a>
        </div>
      </li>
        </li>";
        }
        else{
        echo "<li class='nav-item'>
          <a class='nav-link text-white text-uppercase' href='login.php'>login</a>
        </li>";
        }
      
      ?>

      </ul>
    </div>
    </nav>

    <div class="container" style="padding-top: 60px">
<section>
  <div class="container text-center">
    
    <h1>COMMENTS TABLE</h1>
    <br>
    <form class="form-inline">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="search_text" id="search_text" />
    </form><br>
   
    <div class="table-responsive">
    
      <span id="result"></span>
      <div id="live_data"></div><br><br><br>
    </div>

    </div>
</section>
</div>


      <!--Footer-->
      <footer class="page-footer bg-info">
          <div class="footer-copyright text-center">
              <div class="container-fluid">
                    <h5 class="text-uppercase">Hoax detection Android application</h5>
                    <p><strong>contact us:mumbaihackathonhoax@gmail.com</strong></p>
                  © 2018 Copyright: Android App and website <a href="index.php"> HOME </a>
                  <p>Project is made by Ivan, Shyam, Atharva and Amey for #Mumbai hackthon</p>
              </div>
          </div>
    </footer>
      <!--/.Footer-->

    <!-- jQuery first, then tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
  </body>
</html>


<script>  
$(document).ready(function(){  

    load_data();

 function load_data(query)
 {
  $.ajax({
   url:"select_comment.php",
   method:"POST",
   data:{query:query},
   success:function(data)
   {
    $('#live_data').html(data);
   }
  });
 }
 $('#search_text').keyup(function(){
  var search = $(this).val();
  if(search != '')
  {
   load_data(search);
  }
  else
  {
   load_data();
  }
 });
   
    
  $(document).on('click', '.btn_delete', function(){  
        var id=$(this).data("id9");  
        if(confirm("Are you sure you want to delete this?"))  
        {  
            $.ajax({  
                url:"delete_comment.php",  
                method:"POST",  
                data:{id:id},  
                dataType:"text",  
                success:function(data){  
                    alert(data);
                    location.reload();  
                }  
            });  
        }  
    });  
});  
</script>

<?php } ?>