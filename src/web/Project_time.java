package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Project_time
 */
@WebServlet("/Project_time")
public class Project_time extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Project_time() {
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
		//System.out.print("doPost");
		if(request.getSession().getAttribute("OK")!=null && request.getSession().getAttribute("OK")!=""){
//			List <Project> list = new ProjectDAO().getAllProject();
//			for(Project pj:list){
//				System.out.println(pj.getProject_id()+","+pj.getProject_name());
//			}
//			request.setAttribute("pj_list", list);
			String flag = request.getParameter("flag");
			int fg;
			if(flag!=null){
				fg = Integer.parseInt(flag);
			}
			else{
				fg= 0;
			}
//			System.out.print(fg);
//			System.out.print(fg == 0 );
			if(fg == 0){
				request.getRequestDispatcher("/WEB-INF/project_time.jsp").forward(request, response);
//				System.out.print("project.jsp");
			}
			else{
				request.getRequestDispatcher("/WEB-INF/project_time.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
		}
		else{
			response.sendRedirect("index.jsp");
		}
	}

}
