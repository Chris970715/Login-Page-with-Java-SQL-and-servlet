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
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class PRG556_servlet
 */
@WebServlet("/PRG556_servlet")
public class PRG556_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Preparedstatment = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PRG556_servlet() {
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

}
