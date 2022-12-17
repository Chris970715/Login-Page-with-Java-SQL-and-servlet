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
import PRG556_Project.prg_tables;
/**
 * Servlet implementation class tables
 */
@WebServlet("/tables")
public class tables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tables() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String identity = request.getParameter("identity");
		String password =  request.getParameter("password");
		
		
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
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("PRG556_JSP.jsp");
			
			
			
			prg_tables tables = new prg_tables();
			
			
			while(mysqlResult.next()) 
			{
				String _lastName = mysqlResult.getString("lastName");
				String _firstName = mysqlResult.getString("FirstName");
				String _email = mysqlResult.getString("email");
				String _id = mysqlResult.getString("id");
				String _password = mysqlResult.getString("password");
				
				tables.setFirstname(_firstName);
				tables.setLastname(_lastName);
				tables.setEmail(_email);
				tables.setId(_id);
				tables.setPassword(password);
				
				tables.addNew(tables);
				
				
			}
				request.setAttribute("list", tables);
				dispatcher.forward(request,response);
			
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
