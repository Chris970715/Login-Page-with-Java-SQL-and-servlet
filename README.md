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



RegisterPgae.html	

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

The CSS file used for the HTML above is RegisterDesign.css

PRG556_servlet.java

Both of forms in the two HTML files send data to the two different Java Eclipse files. 
, one of which is PRG556_servlet that connects to MySQL to verify user's ID and password.

In oter words, It has been designed to get data from PRG556_User_page.html and send data to MySQL to verify User's ID and Password. 


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("===============================");
		
		PrintWriter out = response.getWriter();
		
		// Login requirments
		String identity = request.getParameter("ID");
		String password =  request.getParameter("Password");
		
		
		
		Connection conn = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","1234");
			
			HttpSession session = request.getSession();
			
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM PRG556_P WHERE id = ? AND password = ?");
			
			pst.setString(1,identity);
			pst.setString(2, password);
			
			ResultSet mysqlResult = pst.executeQuery();
			
			if(mysqlResult.next()) 
			{
				String fname = mysqlResult.getString(3);
				String lname = mysqlResult.getString(4);
				String email = mysqlResult.getString(5);
				
				
				session.setAttribute("id", identity);
				session.setAttribute("password", password);
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("email", email);
				
				session.setAttribute("isSuccess", true);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("PRG556_JSP.jsp");
				dispatcher.forward(request,response);
			}
			else 
			{
				session.setAttribute("id", null);
				session.setAttribute("password", null);
				System.out.print("Failed to login !");
				session.setAttribute("isSuccess", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("PRG566_User_Page.html");
				dispatcher.include(request,response);
			}
			
		}catch (ClassNotFoundException e) 
		{
			System.out.println("sql connection failed ");
			 e.printStackTrace();
		}
		catch (SQLException e)
		{
			System.out.println("sql connection failed ");
			e.printStackTrace();
		}
		
		finally 
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
Register.java takes registering data from RegisterPgae.html and add it to the table in MySQL.

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				System.out.println("===============================");
				
				PrintWriter out = response.getWriter();
				
				// Login requirments
				String firstname = request.getParameter("fname");
				String lastname =  request.getParameter("lname");
				String email = request.getParameter("email");
				String id = request.getParameter("identity");
				String password = request.getParameter("password_R");
				
				
				
				
				Connection conn = null;
				
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","1234");
					
					
					PreparedStatement pst = conn.prepareStatement("INSERT INTO prg556_p (id,password,FirstName,LastName,email) VALUES(?,?,?,?,?);");
					
					pst.setString(1,id);
					pst.setString(2, password);
					pst.setString(3, firstname);
					pst.setString(4, lastname);
					pst.setString(5, email);
					
					
					int mysqlResult = pst.executeUpdate();
					
					if(mysqlResult > 0) {
						
						System.out.print("successfully registored!");
						RequestDispatcher dispatcher = request.getRequestDispatcher("PRG566_User_Page.html");
						dispatcher.forward(request,response);
					}
					else 
					{
						System.out.print("Failed to login !");
						RequestDispatcher dispatcher = request.getRequestDispatcher("RegistorPage.html");
						dispatcher.include(request,response);
					}
					
				}catch (ClassNotFoundException e) 
				{
					System.out.println("sql connection failed ");
					 e.printStackTrace();
				}
				catch (SQLException e)
				{
					System.out.println("sql connection failed ");
					e.printStackTrace();
				}
				
				finally 
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}


PRG556_JSP.jsp

Finally, once PRG556_servlet.java get input that a user types confiremd by if(mysqlResult.next()), the file sends data to PRG556_JSP.jsp.

Then, PRG556_JSP.jsp file takes data from PRG556_servlet.java and provides users greeting messages with your full name and email that you provided us at resister page.

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
