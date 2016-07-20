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
import dao.AssetDAO;
import dao.ContractDAO;

/**
 * Servlet implementation class Asset_show
 */
@WebServlet("/Asset_show")
public class Asset_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Asset_show() {
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
			List <Asset> list = new AssetDAO().getAllAsset();
//			for(Asset as:list){
//				System.out.println(as.getAsset_id()+","+as.getAsset_number());
//			}
			request.setAttribute("as_list", list);
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
				request.getRequestDispatcher("/WEB-INF/asset.jsp").forward(request, response);
//				System.out.print("project.jsp");
			}
			else{
				request.getRequestDispatcher("/WEB-INF/asset_issue.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
			//request.getRequestDispatcher("/WEB-INF/asset.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("index.jsp");
		}
			
	}

}
