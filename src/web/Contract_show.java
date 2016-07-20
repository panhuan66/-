package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Architecture;
import vo.Contract;
import vo.Project;
import dao.ArchitectureDAO;
import dao.ContractDAO;
import dao.ProjectDAO;

/**
 * Servlet implementation class Contract_show
 */
@WebServlet("/Contract_show")
public class Contract_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contract_show() {
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
			List <Contract> list = new ContractDAO().getAllContract();
//			for(Contract ctt:list){
//				System.out.println(ctt.getContract_id()+","+ctt.getContract_name());
//			}
			request.setAttribute("ctt_list", list);
			
			List <Project> pj_list = new ProjectDAO().getAllProject();
			request.setAttribute("pj_list", pj_list);
			
			List <Architecture> ah_list = new ArchitectureDAO().getAllArchitecture();
			request.setAttribute("ah_list", ah_list);
			
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
				request.getRequestDispatcher("/WEB-INF/contract.jsp").forward(request, response);
//				System.out.print("project.jsp");
			}
			else{
				request.getRequestDispatcher("/WEB-INF/contract_issue.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
			//request.getRequestDispatcher("/WEB-INF/contract.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("index.jsp");
		}

	}

}
