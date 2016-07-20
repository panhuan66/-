package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class Email_ajax_check
 */
@WebServlet("/Email_ajax_check")
public class Email_ajax_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Email_ajax_check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("Register_email");
		System.out.print(email);
		UserDAO dao = new UserDAO();
		boolean b = dao.getEmail(email);
		if(b && email!=null && email!="")
		{
		response.reset(); 
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter pw = response.getWriter(); 
		pw.print("ok"); 
		pw.flush(); 
		pw.close(); 
		}
		else if(email==null || email==""){
			response.reset(); 
			response.setContentType("text/html;charset=utf-8"); 
			PrintWriter pw = response.getWriter(); 
			pw.print("none"); 
			pw.flush(); 
			pw.close(); 
		}

		
	}

}
