package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;

import dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String ps = request.getParameter("Register_ps");
		//String ps2 = request.getParameter("ps2");
		UserDAO dao = new UserDAO();
		boolean b = dao.addUser(new User(email,ps));
		if(b){
			//��Ӧ�ɹ�����
//			System.out.print("ע��ɹ�");
//			request.getSession().setAttribute("OK", email);
			response.sendRedirect("index.jsp");
		}else{
			//��Ӧʧ�ܻ���
//			System.out.print("ע��ʧ��");
			response.sendRedirect("index.jsp");
		}
	}

}
