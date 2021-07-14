package signup.login;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import database.connection.DBConnection;
import database.connection.ImageSaveAndDelete;
import database.connection.Message;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
@MultipartConfig
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetails() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user_name=request.getParameter("user_name");
		String user_email=request.getParameter("user_email");
		String user_password=request.getParameter("user_password");
		Part part=request.getPart("profile_image");
		System.out.println(user_password);
		String profile_image=part.getSubmittedFileName();
		System.out.println(profile_image);
		//get the user fro session......................................-----------------------------------------
		 HttpSession s=request.getSession();
		 User user=(User)s.getAttribute("currentUser");
		 user.setUserName(user_name);
		 user.setUserEmail(user_email);
		 user.setUserPassword(user_password);
		 user.setProfileImage(profile_image);
		 user.getDateTime();
		 //------Data Updata in database---------------------------------------------------------------------------
		 //go to dao class----
		 UserDao dao=new UserDao(DBConnection.getConnection());
		 if(dao.updateUser(user)) {
			 //get path--------------------------------------------------------------------------------------------
			  String path=request.getRealPath("/")+"image"+File.separator+user.getProfileImage();
			  ImageSaveAndDelete.deleteFile(path);  
			  System.out.println(path);
				 if(ImageSaveAndDelete.saveFile(part.getInputStream(), path)) {
					System.out.println("updeted");
					
				 }else {
					System.out.println("notUpdated");
				 }
			 } 
		 else {
			 Message m=new Message("Some thing went wrong","error","alert-danger");
			 s.setAttribute("msg", m);
		 }
		 Message m=new Message("Your details are successfully updated","success","alert-success");
		 s.setAttribute("msg", m);
		 response.sendRedirect("user-details/profile.jsp");
			}

}
