<?php
  require('config.php');
  session_start();
?>



<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Hoax Detection</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  <body id="specify" data-spy="scroll" data-target=".navbar" data-offset="50">
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
<div class="container">

<h1 style="padding-top: 30px"></h1>
    <section>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators ">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" height="500px" src="img/img1.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" height="500px" src="img/image4.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" height ="500px" src="img/image3.jpg" alt="Third slide">
    </div>
    <h1 style="padding: 8px"></h1>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</section>

<!-- features -->

<section>
  
  <div class="jumbotron jumbotron-fluid">
    <h1 class="display-4">Features</h1><br><br>


<div class="card-deck">
  <div class="card">
  <center>
  <img src="img/logo.png" class="rounded-circle" alt="" width="150" height="150">
</center>
    <div class="card-body">
      <h5 class="card-title">See the hoax</h5>
      <p class="card-text text-center">User can see the hoax that has been uplaoded by the other user along with the comments on it.</p>
    </div>
  </div>
  <div class="card">
    <center>
      <img class="rounded-circle" src="img/image1.jpg" alt="" width="150" height="150">
   </center>
    <div class="card-body">
      <h5 class="card-title">uplaod new hoax</h5>
      <p class="card-text">Can upload the hoax if they want to check whether it is true/false.</p>
    </div>
  </div>

  <div class="card">
     <center>
       <img src="img/hoax.jpg" class="rounded-circle" alt="" width="150" height="150">
    </center>
    <div class="card-body">
      <h5 class="card-title">comment on the hoax</h5>
      <p class="card-text">User has the privilage to comment on the different hoaxes present on the App.</p>
    </div>
  </div>
  <div class="card">
     <center>
     <img src="img/image2.png" class="rounded-circle" alt="" width="150" height="150">
      </center>
    <div class="card-body">
      <h5 class="card-title">Activity</h5>
      <p class="card-text">User can do upvote, downvote, set flag and Give the status of the comment.</p>
    </div>
  </div>
  
</div>

</section>

<section>

    <div class="jumbotron text-center">
  <div class="container">
    <h1 class="display-4">About Hoaxify Android App</h1>
    <p class="lead">It is very easy to find the truth and spread the rumors. This is also called as hoax. Hoaxes have been around even before the birth of internet where propagators have used mouth to mouth, post card and printed letter as channel. With the advancement of technology it has become even simpler to do so.</p>
    <p class="lead">This is an attempts to list some of the most popular hoaxes. You can find out the truth about most popular social media hoax messages, Have a feature to putforth your views.</p>
  </div>
</div>

    <!-- <div class="jumbotron jumbotron-fluid  text-white">
    <div class="container">
    <h1 class="display-4">About Hoaxify Android App</h1>
    <p class="lead">It is very easy to find the truth and spread the rumors. This is also called as hoax. Hoaxes have been around even before the birth of internet where propagators have used mouth to mouth, post card and printed letter as channel. With the advancement of technology it has become even simpler to do so.</p>
    <p class="lead">This is an attempts to list some of the most popular hoaxes. You can find out the truth about most popular social media hoax messages, Have a feature to putforth your views.</p>
  </div>

    
  </div> -->
</section>

</div><br><br><br>

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
  </body>
</html>
