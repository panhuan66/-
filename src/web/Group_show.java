package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Accountant_subject;
import vo.Contract;
import vo.Finance;
import vo.Payment;
import vo.Procurement_category;
import vo.Procurement_form;
import vo.Procurement_type;
import vo.Project;
import dao.Accountant_subjectDAO;
import dao.ContractDAO;
import dao.FinanceDAO;
import dao.PaymentDAO;
import dao.Procurement_categoryDAO;
import dao.Procurement_formDAO;
import dao.Procurement_typeDAO;
import dao.ProjectDAO;

/**
 * Servlet implementation class Group_show
 */
@WebServlet("/Group_show")
public class Group_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Group_show() {
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
//			List <Project> pj_list = new ProjectDAO().getAllProject();
//			List <Contract> ctt_list = new ContractDAO().getAllContract();
//			
			List <Finance> fc_list = new FinanceDAO().getAllFinance();
			
			ArrayList fc_all_list = new ArrayList();
			
			for(Finance fc:fc_list){
				Accountant_subject fc_bs = new Accountant_subjectDAO().getById(fc.getBorrow_subject_id());
				Accountant_subject fc_ls = new Accountant_subjectDAO().getById(fc.getLoan_subject_id());
				Contract fc_ctt = new ContractDAO().getById(fc.getContract_id());
				
				Project fc_pj = new ProjectDAO().getById(fc_ctt.getProject_id());
				Payment fc_pay = new PaymentDAO().getById(fc.getPayment_id());
				Procurement_type fc_pt = new Procurement_typeDAO().getById(fc.getProcurement_type_id());
				Procurement_form fc_pf = new Procurement_formDAO().getById(fc.getProcurement_from_id());
				Procurement_category fc_ct = new Procurement_categoryDAO().getById(fc.getProcurement_category_id());

				Object[] one={
						fc_pj.getProject_id(),
						fc_pj.getProject_name(),
						fc_pj.getDepartment_name(),
						fc_pj.getResponsibility_name(),
						fc_pj.getBudget(),
						fc_pj.getStart_date(),
						
						fc_ctt.getContract_number(),
						fc_ctt.getContract_name(),
						fc_ctt.getA_name(),
						fc_ctt.getB_name(),
						fc_ctt.getC_name(),
						fc_ctt.getSign_date(),
						fc_ctt.getContract_price(),
						fc_pj.getProject_name(),
						
						fc.getFinance_date(),
						fc.getFinance_number(),
						fc.getFinance_abstract(),
						fc_bs.getAccountant_subject_name(),
						fc_ls.getAccountant_subject_name(),
						fc.getMoney(),
						fc_pj.getProject_name(),
						fc_ctt.getContract_name(),
						fc_pay.getPayment_name(),
						fc_pf.getProcurement_form_name(),
						fc_ct.getProcurement_category_name()
						
						/*fc.getFinance_date(),
						fc.getFinance_number(),
						fc.getFinance_abstract(),
						fc_bs.getAccountant_subject_name(),
						fc_ls.getAccountant_subject_name(),
						fc.getMoney(),
						fc_pj.getProject_name(),
						fc_ctt.getContract_name(),
						fc_pay.getPayment_name(),
						fc_pt.getProcurement_type_name(),
						//fc_pf.getProcurement_form_name(),
						fc_ct.getProcurement_category_name()*/
						
				};
				fc_all_list.add(one);
				
			}
//			for(Project pj:list){
//				System.out.println(pj.getProject_id()+","+pj.getProject_name());
//			}
			//request.setAttribute("pj_list", pj_list);
			//request.setAttribute("ctt_list", ctt_list);
			//request.setAttribute("fc_list", fc_list);
			
			String flag = request.getParameter("flag");
			String table_head[]={"项目编号","项目名称","项目承担部门","责任人","项目预算","开始日期","合同编号","合同名称","甲方",
					"乙方","丙方","签订日期","合同价款","所属项目","日期","凭证号","摘要","借方","贷方","金额","所属项目","所属合同","资金支付方式","采购形式","项目分类"};
			String table_all[] =request.getParameterValues("group");
//			for(int i=0;i<table_head.length;i++){
//				System.out.println(table_head[i]);
//			}
//			System.out.print("11qq"+table_all);
			
			ArrayList group_all_list = new ArrayList();
			if(table_all!=null&&table_all.equals("")==false)
			{
					for(String pj:table_all){
						//System.out.println(pj);
						for(int i=0;i<table_head.length;i++){
							//System.out.println(table_head[i]);
							if(table_head[i].equals(pj))
							{
								Object [] one =new Object [] {};
								ArrayList list = new ArrayList();
								//one[0]=new String(table_head[i]);
								list.add(table_head[i]);
								for(int j=0;j<fc_all_list.size();j++){
									Object [] temp =(Object[]) fc_all_list.get(j);
									//System.out.print("qq"+temp[i]);
									list.add(temp[i]);
									//one[j+1] = temp[i];
									//for(int k=0;k)

								}
//								Object[] one={
//										table_head[i],
///*//										temp[i]
//*/								};
//								one.
//									Object[] one={
//											table_head[i],
//									
//									};
								group_all_list.add(list);
							}
						}
					}
				
			} 
			request.setAttribute("group_all_list", group_all_list);
//			String[][] excel_str = new String[group_all_list.size()][];
//			for (int i = 0; i < rs.size(); i++) {
//				   LeakInfo user = rs.get(i);
//				   String[] q = { user.getUsername(), user.getResult()};//获取对象成员保存至一维数组
//				   for (int j = 0; j < excel_str.length; j++) {
//				    excel_str[i] = q;
//				   }
//				  }
				  //return excel_str;
//			for(int i=0;i<group_all_list.size();i++){
//				//Object [] temp =(Object[]) group_all_list.get(i);
//				for(int j=0;j<temp.length;j++){
//					System.out.println(temp[j]);
//				}
//			}
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
				request.getRequestDispatcher("/WEB-INF/group_issue.jsp").forward(request, response);
//				System.out.print("project.jsp");
			}
			else{
				request.getRequestDispatcher("/WEB-INF/group_issue.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
		}
		else{
			response.sendRedirect("index.jsp");
		}
	}

}
