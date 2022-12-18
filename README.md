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


