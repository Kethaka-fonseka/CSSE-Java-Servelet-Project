
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="fonts/icons/style.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/header.css">

<style>

</style>



</head>





<body class="brain">

         
       <div class="site-navbar bg-white py-2">
    
          <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
          <form action="#" method="post">
            <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
          </form>  
        </div>
      </div>
    
          <div class="container">
            <div class="d-flex align-items-center justify-content-between">
              <div class="logo">
                <div class="site-logo">
                  <a href="landPageCusView.jsp" class="js-logo-clone"> <img src="images/Auction.png" id="mainLogo" style="width: 450px;height: 100px;"> </a>
                </div>
              </div>
              <div class="main-nav d-none d-lg-block">
                <nav class="site-navigation text-right text-md-center" role="navigation">
                  <ul class="site-menu js-clone-nav d-none d-lg-block">
                    
                    <li class="has-children">
                      <a href="landPageCusView.jsp">Inventory transactions</a>
                      <ul class="dropdown">

                          <li class="has-children">
                            <a href="#">Requisition Form</a>
                            <ul class="dropdown">
                              <li><a href="#">Add Requisition</a></li>
                              <li><a href="#">Check Requisition</a></li>
                            </ul>
                          </li>

                          <li class="has-children">
                            <a href="#">Purchase Order</a>
                            <ul class="dropdown">
                              <li><a href="#">Create Purchase Order</a></li>
                              <li><a href="#">Purchase Order History</a></li>
                              <li><a href="#">Approvl purchase Order</a></li>
                            </ul>
                          </li>

                          <li class="has-children">
                            <a href="#">Goods Recived Note</a>

                          </li>
                    </ul>
                    </li>

                    
                    <li><a href="topsellers.jsp">Suppies</a></li>
                    <li><a href="about.jsp">Approvals</a></li>
                    <li><a href="contact.jsp">Profile</a></li>
                   
                  </ul>
                  </ul>
                </nav>
              </div>
              <div class="icons">
            <a href="#" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
           
         
          



 


<button onclick= "openNav()" class="btnmen"><i class="fas fa-user-tie" style ="color:white;"></i></button> 


<div id="mySidenav1" class="sidenav">

  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  
 <div class="rocket">
 
 

 
       <img id="side-img2"  src="images/user.png">
  

    }
    if(img != null){


      <img id="side-img1"  src="Display.jsp?username=Uname">
      

  <div class="overlay">
  <a href="javascript:openForm()" class="icon" title="Upload profile picture">
    <i class="fa fa-camera"></i> 
  </a>
  </div>
  </div>
  <h1 id="side-head1">Uname</h1>
  <span style =" display:block;margin-left:100px; font-size:10px;" >Online<i class="far fa-dot-circle" style ="color:green;"></i></span>
  <a href="javascript:openSettingForm()">Account Settings</a>
  <a href="addItem.jsp">Post Auctions</a>
  <a href="landPage.jsp">View Auctions</a>
  <a href="logout.jsp">Log out</a>
</div>






<div id="mySidenav2" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
 <div class="rocket">
 

 
       <img id="side-img3"  src="images/user.png">
  

      <img id="side-img4"  src="Display.jsp?username=Uname">
      

  <div class="overlay">
  <a href="javascript:openForm()" class="icon" title="Upload profile picture">
    <i class="fa fa-camera"></i> 
  </a>
  </div>
  </div>
  
  <h1 id="side-head2">Uname</h1>
   <span style =" display:block;margin-left:100px; font-size:10px;" >Online<i class="far fa-dot-circle" style ="color:green;"></i></span>
  <a href="javascript:openSettingForm()" >Account Settings</a>
  <a href="deleteCategory.jsp">Manage Categories</a>
  <a href="user.jsp">Manage Users</a>
    <a href="notifications.jsp">Notifications</a>
  <a href="logout.jsp">Log out</a>
  
</div>





<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <div class="rocket">
  
  

 
       <img id="side-img5"  src="images/user.png">
  

      <img id="side-img6"  src="Display.jsp?username=Uname">

 
  <div class="overlay">
  <a href="javascript:openForm()" class="icon" title="Upload profile picture">
    <i class="fa fa-camera"></i> 
  </a>
  </div>
  </div>
  <h1 id="side-head">Uname </h1>
<span style =" display:block;margin-left:100px; font-size:10px;" >Online<i class="far fa-dot-circle" style ="color:green;"></i></span>
  <a href="javascript:openSettingForm()">Account Settings</a>
  <a href="paymentList.jsp">Bid History</a>
  <a href="viewawarded.jsp">Awarded Bids</a>
  <a href="logout.jsp">Log out</a>
</div>


      
          </div>
            </div>
          </div>
        </div>
        
<!-- Profile Picture updating form -->
<div class="image-form-container" id="ImageForm">
<a href="javascript:void(0)" class="image-form-close" onclick="closeForm()">&times;</a>
  <form method ="POST" action="UploadDP" enctype="multipart/form-data" class="form-container">


    <label ><b style ="display:block; margin-left:420px; font-Family:blooming sans elegent; font-size:30px;">Upload your image Here</b></label><br>
    <input class="file-input" type="file" placeholder="Profile.pic" id="image" accept="image/*" name="image" onchange="preview_image(event)" required>
    <label for="image">Choose a file</label>
    <br>
    <img id="output_image"/>
    
    <div >
        <input type="hidden" value="<%=(String)session.getAttribute("username") %>" name="username"/>
        </div>

    <button type="submit" class="image-form-upload">Upload</button>
  </form>
</div>        

 
<script>
//navigation handler
function openNav() {
  document.getElementById("mySidenav").style.width = "240px";
  document.getElementById("brain").style.marginLeft = "240px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("brain").style.marginLeft= "0";
}
</script>

<script>
//Form opener
function openForm() {
  document.getElementById("ImageForm").style.display = "block";
}

function closeForm() {
  document.getElementById("ImageForm").style.display = "none";
}
</script>


<script>
//Settings opener
function openSettingForm() {
  document.getElementById("SettingForm").style.display = "block";
}

function closeSettingForm() {
  document.getElementById("SettingForm").style.display = "none";
}
</script>

<script type='text/javascript'>
function preview_image(event) 
{
 var reader = new FileReader();
 reader.onload = function()
 {
  var output = document.getElementById('output_image');
  output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}
</script>
</body>
</html>
