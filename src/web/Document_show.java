package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Document;
import vo.Document;
import dao.DocumentDAO;
import dao.DocumentDAO;

/**
 * Servlet implementation cldts Document_show
 */
@WebServlet("/Document_show")
public class Document_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Document_show() {
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
//		System.out.print("doPost");
		if(request.getSession().getAttribute("OK")!=null && request.getSession().getAttribute("OK")!=""){
			List <Document> list = new DocumentDAO().getAllDocument();
//			for(Document dt:list){
//				System.out.println(dt.getDocument_id()+","+dt.getDocument_number());
//			}
			request.setAttribute("dt_list", list);
			
			request.getRequestDispatcher("/WEB-INF/document.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("index.jsp");
		}
			
	}
	

}
