package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String email = request.getParameter("Login_email");
		String ps = request.getParameter("Login_ps");
		//System.out.print(name+","+ps);
		UserDAO dao = new UserDAO();
		boolean b = dao.getCheck(email,ps);
		if(b){
			//响应成功画面
//			System.out.print("成功");
			request.getSession().setAttribute("OK", email);
			response.sendRedirect("/web_kf/Project_show?flag=0");
		}else{
			//响应失败画面
//			System.out.print("失败");
			response.sendRedirect("index.jsp");
		}
		
	}

}
