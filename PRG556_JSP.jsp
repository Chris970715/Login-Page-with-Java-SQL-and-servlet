<%@ page import="PRG556_Project.PRG556_servlet" %>
<%@ page import="PRG556_Project.tables" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="HomePage_Design.css">
<title>Home Page</title>
</head>
<body>
	<% String fname = (String)session.getAttribute("fname"); 
	   String lname = (String)session.getAttribute("lname");
	   String email = (String)session.getAttribute("email");
	%>
	
	<div class = "banner">
	
		<div class="bar">
			<img src="C:\Users\Gyubum Kim\eclipse-workspace\PRG556_Project\Project_PRG556\src\main\webapp\logo-websites-31321.png" class = "logo">
			<ul>
				<li><a href = "#">Home</a></li>
				<li><a href = "#">Dogs</a></li>
				<li><a href = "#">Cats</a></li>
				<li><a href = "#">Fish</a></li>
				<li><a href = "#">Birds &amp; Small Animals</a></li>
				<li><a href = "#">About Us</a></li>
				<li><a href = "#">Contact Us</a></li>
			</ul>
		</div>
		
		<div class = "con">
			<h1>Welcome, <%out.print(fname); %> <%out.print(lname); %> !</h1>
			<p>Please let us send you updates to your email address, <% out.print(email); %></p>
		</div>
		
	</div>

</body>

</html>