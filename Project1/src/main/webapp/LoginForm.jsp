<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/e48d166edc.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="LoginForm.css">
    <title>Login Form</title>
</head>

<body>
  

    <div class="container">

        <div class="img">
            <img src="BG.png" alt="BG">
        </div>
        <div class="login-content">

            <form action="Login">

                <div class="title-container">
                    <h1>Login</h1>
                    <h2>Hello, Friends!</h2>
                    <p>Enter your personal detail and start journey with us.</p>
                </div>


                <div class="login-inner-content">


                    <div class="input-div one">
                        <div class="i">
                            <i class="far fa-user-circle"></i>
                        </div>
                        <div class="div">
                            <h5>User id</h5>
                            <input type="text" class="input" name="userid">
                        </div>
                    </div>

                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-eye" onclick="show()"></i>
                        </div>
                        <div class="div">
                            <h5>Password</h5>
                            <input id="pswrd" type="password" class="input" name="userpass">
                        </div>
                    </div>

                    <a href="ForgetPasswordAndUserId.html">Forgot password / Username</a>

                </div>

                <input type="submit" class="btn" value="Login">

                <h5>Not a member ? <a href="SignUpPage.html">Create Account</a></h5>

            </form>
        </div>
    </div>





    <script src="LoginForm.js"></script>

</body>

</html>