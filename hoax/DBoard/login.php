<?php
  require('config.php');
  session_start();

  if(isset($_POST['username'])) {
      
        $username = stripcslashes($_POST['username']);
        $username = mysqli_real_escape_string($mysqli,$username); 

        $password = stripcslashes($_POST['password']);
        $password = mysqli_real_escape_string($mysqli,$password);
    
        $query = "SELECT email from user where email='$username' AND password='$password'";
        $result = mysqli_query($mysqli,$query);
        $row = mysqli_fetch_array($result);
      
        $count = mysqli_num_rows($result);
        
        if($count == 1) {
            $_SESSION['username'] = $username;
            echo "<div class = 'form'>Logged in!!</div>";
            header("location:index.php");
        }else {
            echo "<div class='form'>Your Login Name or Password is invalid</div>";
        }
   }
   else{
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
  height: 95px;

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
          <a class="dropdown-item bg-secondary" href="hoaxview.php">HoaxView</a>
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

      <div class="container" style="padding-top: 100px">
          
            <div class="container text-center" style="width:50%;border: 1px solid grey;padding:3%;background-color: skyblue;">
                <h3>Admin page</h3><br>

                <div class="form">
                <form method="POST" name="form">
                <input type="text" name="username" id="username" placeholder="Email" required><br><br>
                <input type="password" name="password" id="password" placeholder="Password" required><br><br>
                <button type="submit" name="submit" class="btn btn-primary" id="login_ad">Login</button>
                </form>
                </div>

            </div>
       </div> 

      <!--Footer-->
      <div class="footer">
      <footer class="page-footer bg-info">
          <div class="footer-copyright text-center">
              <div class="container-fluid">
                    <h5 class="text-uppercase">Hoax detection Android application</h5>
                  © 2018 Copyright: Android App and website <a href="index.php"> HOME </a>
                  <p>Project is made by Ivan, Shyam, Atharva amd Amey for #Mumbai hackthon</p>
              </div>
          </div>
    </footer>
  </div>
      <!--/.Footer-->
    
<?php } ?>  

        



    <!-- jQuery first, then tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
  </body>
</html>
