package signup.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.DBConnection;

/**
 * Servlet implementation class CheckUsername
 */
@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsername() {
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
		//doGet(request, response);
		String user_email=request.getParameter("userEmail");
		PrintWriter out=response.getWriter();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		response.setContentType("text/html");
		 
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select count(Id) cnt from  cc_employee where user_email=trim(lower(?))");
			ps.setString(1, user_email);
			rs = ps.executeQuery();
			rs.next();
			if(rs.getInt("cnt") == 0) {
				out.println("{\"status\":\"success\",\"message\":\"This username is available.\"}");
			} else {
				out.println("{\"status\":\"failure\",\"message\":\"This username already exists.\"}");
			}
			
		}
		catch (Exception e) {
			out.println("{\"status\":\"error\",\"message\":\""+e.toString()+"\"}");
		}
	}

}
