package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Asset;
import vo.Contract;
import vo.Project;
import dao.AssetDAO;
import dao.ContractDAO;
import dao.ProjectDAO;

/**
 * Servlet implementation class Delete_all
 */
@WebServlet("/Delete_all")
public class Delete_all extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_all() {
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
		if(request.getSession().getAttribute("OK")!=null && request.getSession().getAttribute("OK")!=""){
//			List <Project> list = new ProjectDAO().getAllProject();
//			for(Project pj:list){
//				System.out.println(pj.getProject_id()+","+pj.getProject_name());
//			}
			//request.setAttribute("pj_list", list);
			String flag = request.getParameter("del_i");
			int fg_i;
			if(flag!=null){
				fg_i = Integer.parseInt(flag);
			}
			else{
				fg_i= 0;
			}
			System.out.println(flag);
//			System.out.print(fg == 0 );
			if(fg_i == 1){
				String  pj_id = request.getParameter("pj_id");
				//for(String x:pj_id){
				System.out.print(pj_id+"qq");
				//}
				//System.out.print(pj_id[0]+"qq");
				if(pj_id!=null&&pj_id.equals("")==false)
				{
					int id = Integer.parseInt( pj_id);
					new ProjectDAO().deleteById(id);
					List <Project> list = new ProjectDAO().getAllProject();
					request.setAttribute("pj_list", list);
				}else{
					List <Project> list = new ProjectDAO().getAllProject();
					request.setAttribute("pj_list", list);
				}
				request.getRequestDispatcher("/WEB-INF/project.jsp").forward(request, response);
//				System.out.print("project.jsp");
			}
			else if(fg_i==2){
				//System.out.print("qq");
				String  ctt_id = request.getParameter("ctt_id");
				if(ctt_id!=null&&ctt_id.equals("")==false)
				{
					int id = Integer.parseInt( ctt_id);
					new ContractDAO().deleteById(id);
					List <Contract> list = new ContractDAO().getAllContract();
					request.setAttribute("ctt_list", list);
				}else{
					List <Contract> list = new ContractDAO().getAllContract();
					request.setAttribute("ctt_list", list);
				}
				request.getRequestDispatcher("/WEB-INF/contract.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}else if(fg_i==3){
				//System.out.print("qq");
//				String  ctt_id = request.getParameter("fc");
//				if(ctt_id!=null&&ctt_id.equals("")==false)
//				{
//					int id = Integer.parseInt( ctt_id);
//					new ContractDAO().deleteById(id);
//					List <Contract> list = new ContractDAO().getAllContract();
//					request.setAttribute("ctt_list", list);
//				}else{
//					List <Contract> list = new ContractDAO().getAllContract();
//					request.setAttribute("ctt_list", list);
//				}
				request.getRequestDispatcher("/WEB-INF/contract.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}else if(fg_i==4){
				System.out.print("qq");
				String  as_id = request.getParameter("as_id");
				if(as_id!=null&&as_id.equals("")==false)
				{
					int id = Integer.parseInt(as_id);
					new AssetDAO().deleteById(id);
					List <Asset> list = new AssetDAO().getAllAsset();
					request.setAttribute("as_list", list);
				}else{
					List <Asset> list = new AssetDAO().getAllAsset();
					request.setAttribute("as_list", list);
				}
				request.getRequestDispatcher("/WEB-INF/asset.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
			
		}
		else{
			response.sendRedirect("index.jsp");
		}
	}

}
