package post.like.comment;

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
import signup.login.User;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
@MultipartConfig
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		int catId=Integer.parseInt(request.getParameter("catSelect"));
		String userTitle=request.getParameter("postTitle");
		String pCode=request.getParameter("textCode");
		Part part=request.getPart("postImage");
		String userImage=part.getSubmittedFileName();
		//geting session...
		HttpSession s=request.getSession();
		User user=(User) s.getAttribute("currentUser");
		   user.getId();
		//...........................................
				 out.println(userImage);
				 out.println(userTitle);
				 out.println(pCode);
				// System.out.println(user.getId());
				//.......................................
		 Post post=new Post(userTitle,catId,pCode,userImage,user.getId());
		 System.out.println(post);
		 PostDao postd=new PostDao(DBConnection.getConnection());
		if(postd.savePostData(post)) {
			  String path=request.getRealPath("/")+"post-pics"+File.separator+part.getSubmittedFileName();
			  System.out.println(path);
			  ImageSaveAndDelete.saveFile(part.getInputStream(), path);
			  Message m=new Message("Post Successful Upload","success","alert-success");
			  s.setAttribute("msg", m);
			  response.sendRedirect("user-details/profile.jsp");
		}else {
			Message m=new Message("Something Wend wrong","error","alert-danger");
			  s.setAttribute("msg", m);
			  response.sendRedirect("user-details/profile.jsp");
		} 
	}

}
