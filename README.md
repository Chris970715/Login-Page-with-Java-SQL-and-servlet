# Login-Page-with-Java-SQL-and-servlet\

This project was designed to provide users Login interface through Java, Servlet, MySQL, CSS, and Html.

PRG556_User_page.html

<form> in a HTML file called "PRG556_User_page.html" was initialized to get data from users and send the data to java.

<form action="PRG556_servlet" method = "POST">
	
			<p>ID :</p>
			<input type = "text" id = "ID" name = "ID">
		
			<br>
		
			<p>Password :</p>
			<input type = "password" id = "Password" name = "Password">	

			<input type = "submit" value = "login" id = button>
		
</form>

The HTML form has been decorated by the following CSS file named "LoginPage.css"

@charset "ISO-8859-1";

* {
	padding: 0;
	margin: 0;
	font-family:sans-serif;
}

body{
	background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(149,199,20,1) 0%, rgba(0,212,255,1) 95%);
}

.user_menu
{
	width:350px;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	position: absolute;
	color: #fff;
}
h1{
	font-size:40px;
	text-align: center;
	text-transform: uppercase;
	margin:240px 40px;
	
}
.user_menu p
{
	font-size: 20px;
	margin:15px 0;
}
.user_menu input
{
	font-size:16px;
	width: 100%;
	padding: 15px 10px;
	border: 0;
	outline: none;
	border-radius: 5px;
}
#button
{
	font-size: 19px;
	font-weight: bold;
	margin:20px 0;
	padding:10px 15px;
	width:50%;
	border-radius: 5px;
	
}
.big_text
{
	color: #FFFAF0;
}

A link located on the bottom of the login form has been designed to provide Register page. 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="RegisterDesign.css">

</head>
<body>
	<h1>Register Form</h1>
	<div class = "register_line">
	
		
		
		<form action="registor" method = "POST">
		
			<p>First Name</p>
			<input type = "text" name = "fname" id = "fname">
		
			<p>Last Name</p>
			<input type = "text" name = "lname" id = "lname">
		
			<p>Email</p>
			<input type = "text" name = "email" id = "email">

			<p>ID</p>
			<input type = "text" name = "identity" id = "identity" >
					
			<p>Password</p>
			<input type = "password" name = "password_R" id = "password_R">
			
			<button type ="submit" value = "submit">Register</button>
		
		</form>
	</div>
</body>
</html>


