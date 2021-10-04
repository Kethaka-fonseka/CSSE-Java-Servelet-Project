<!--		    Student : Fernando .S .M. J
		        IT No   : IT19053592
		        Batch 06
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.csse.servlet.LoginServlet" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Log In | LM Construction</title>


<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/7db8364a09.js"></script>

<!-- Main css -->
<link rel="stylesheet" href="css/styles.css">
</head>
<body class="main">

        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/Auction - white.png" alt="sing up image"></figure>
                    </div>

                    <div class="signin-form">
                        <h2  style="color:white"class="form-title text-center">Log In</h2>
                        <form method="POST" class="register-form" action="LoginServlet" id="login-form">
                            <div class="form-group">
                                <label for="user_email"><i class="zmdi zmdi-email material-icons-name "></i></label>
                                <input type="email" name="user_email" id="user_email" placeholder="Email"
                                       required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="user_pass" id="your_pass" placeholder="Password"  required="required"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label style ="color:white" for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            
                               
                            <div class="form-group" style="color: red">
                               <%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%>
                            </div>
                            
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                            </div>
                         
                            
                        </form>

                    </div>
                </div>
            </div>
        </section>


</body>
</html>
