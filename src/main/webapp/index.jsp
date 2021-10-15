<!--		    Student : Fernando .S .M. J
		        IT No   : IT19053592
		        Batch 06
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Log In | LM Construction</title>
    <!-- Font Icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/7db8364a09.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,300;0,400;0,500;1,300;1,400;1,500&display=swap" rel="stylesheet">


    <!-- Main css -->
    <link rel="stylesheet" href="css/signin.css">
    <link rel="stylesheet" href="css/head.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/forms.css">
</head>
<body class="main">

<section class="sign-in">
    <div class="container">
        <div class="signin-content">
            <div class="signin-image">
                <figure><img  style="margin-top: 50px" src="images/LogoLG-W.png" class="pt-5"
                              alt="sing up image flipper"></figure>
            </div>

            <div class="signin-form">
                <h2 style="color:white" class="form-titles text-center">Log In</h2>
                <form method="POST" class="register-form" action="LoginServlet" id="login-form">
                    <div class="form-group">
                        <label for="user_email"><i class="zmdi zmdi-email material-icons-name "></i></label>
                        <input type="email" name="user_email" id="user_email" placeholder="Email"
                               required="required"/>
                    </div>
                    <div class="form-group">
                        <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                        <input type="password" name="user_pass" id="your_pass" placeholder="Password"
                               required="required"/>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="remember-me" id="remember-me" class="agree-term"/>
                        <label style="color:white" for="remember-me" class="label-agree-term"><span><span></span></span>Remember
                            me</label>
                    </div>


                    <div class="form-group" style="color: red">
                        <%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%>
                            </div>
                            
                            <div class="form-group form-button">
                                <button type="submit" id="signin" class="form-submit" > Log in </button>
                            </div>
                         
                            
                        </form>

                    </div>
                </div>
            </div>
        </section>


</body>
</html>
