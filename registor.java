package PRG556_Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registor
 */
@WebServlet("/registor")
public class registor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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

}
