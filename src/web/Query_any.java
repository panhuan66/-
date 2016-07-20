package web;


import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
//import org.apache.struts2.ServletActionContext;
import java.lang.reflect.Field;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Accountant_subject;
import vo.Architecture;
import vo.Asset;
import vo.Contract;
import vo.Finance;
import vo.Payment;
import vo.Procurement_category;
import vo.Procurement_form;
import vo.Procurement_type;
import vo.Project;
import dao.Accountant_subjectDAO;
import dao.ArchitectureDAO;
import dao.AssetDAO;
import dao.ContractDAO;
import dao.FinanceDAO;
import dao.PaymentDAO;
import dao.Procurement_categoryDAO;
import dao.Procurement_formDAO;
import dao.Procurement_typeDAO;
import dao.ProjectDAO;

/**
 * Servlet implementation class Query_any
 */
@WebServlet("/Query_any")
public class Query_any extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query_any() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public  void exportExcel(String fileName,String[] Title, List listContent, HttpServletResponse response) {
    	  String result="ϵͳ��ʾ��Excel�ļ������ɹ���";  
    	  // ���¿�ʼ�����EXCEL
    	  try {    
    	   //������������Ա�򿪱���Ի���______________________begin
    	   //HttpServletResponse response=ServletActionContext.getResponse();
    	   OutputStream os = response.getOutputStream();// ȡ�������      
    	   response.reset();// ��������      
    	   response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("GB2312"),"ISO8859-1"));
    	// �趨����ļ�ͷ      
    	   response.setContentType("application/msexcel");// �����������    
    	   //������������Ա�򿪱���Ի���_______________________end

    	   /** **********����������************ */
    	   WritableWorkbook workbook = Workbook.createWorkbook(os);

    	   /** **********����������************ */

    	   WritableSheet sheet = workbook.createSheet("Sheet1", 0);

    	   /** **********�����ݺ��ӡ��Ĭ��Ϊ�ݴ򣩡���ӡֽ***************** */
    	   jxl.SheetSettings sheetset = sheet.getSettings();
    	   sheetset.setProtected(false);


    	   /** ************���õ�Ԫ������************** */
    	   WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
    	   WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD);

    	   /** ************�����������ֵ�Ԫ����ʽ������************ */
    	   // ���ڱ������
    	   WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
    	   wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // ����
    	   wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // ���ִ�ֱ����
    	   wcf_center.setAlignment(Alignment.CENTRE); // ����ˮƽ����
    	   wcf_center.setWrap(false); // �����Ƿ���
    	   
    	   // �������ľ���
    	   WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
    	   wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // ����
    	   wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // ���ִ�ֱ����
    	   wcf_left.setAlignment(Alignment.LEFT); // ����ˮƽ����
    	   wcf_left.setWrap(false); // �����Ƿ���   
    	 

    	   /** ***************������EXCEL��ͷ����⣬��ʱʡ��********************* */
    	   //sheet.mergeCells(0, 0, colWidth, 0);
    	   //sheet.addCell(new Label(0, 0, "XX����", wcf_center));
    	   /** ***************������EXCEL��һ���б���********************* */
    	   for (int i = 0; i < Title.length; i++) {
    	    sheet.addCell(new Label(i, 0,Title[i],wcf_center));
    	   }   
    	   /** ***************������EXCEL��������********************* */
    	   Field[] fields=null;
    	   int i=1;
    	   for(Object obj:listContent){
    		   fields=obj.getClass().getDeclaredFields();
    		   int j=0;
    		   for(Field v:fields){
    			   v.setAccessible(true);
    			   Object va=v.get(obj);
    			   if(va==null){
    				   va="";
    			   }
    			   sheet.addCell(new Label(j, i,va.toString(),wcf_left));
    			   j++;
    		   }
    		   i++;
    	   }
    	   /** **********�����ϻ����е�����д��EXCEL�ļ���******** */
    	   workbook.write();
    	   /** *********�ر��ļ�************* */
    	   workbook.close();   

    	  } catch (Exception e) {
    	   result="ϵͳ��ʾ��Excel�ļ�����ʧ�ܣ�ԭ��"+ e.toString();
    	   System.out.println(result); 
    	   e.printStackTrace();
    	  }
    	
    	 }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		/**
		 * ����excel
		 * @return
		 */
		///public String excelPage(){
//			//ExportExcel excel=new ExportExcel();
//			String str="";
//			try {
//				str = new String(request.getParameter("wineOrg.orgName").getBytes("iso8859-1"),"UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//wineOrg.setOrgName(str);
			//List<Object> li=service.exportExcel(wineOrg);
			
			//List <Project> li = new ProjectDAO().getAllProject();
			//String[] Title={"�޸�������	","�޸�ʱ��"};
			//exportExcel("�ͻ�������Ϣ.xls",Title, li,response); 
			
			//return SUCCESS;
		//}
			
			doPost(request,response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("OK")!=null && request.getSession().getAttribute("OK")!=""){
			String[] Title_pj={"��Ŀ���","��Ŀ����","��Ŀ�е�����","������","��ĿԤ��","��ʼ����","��ע"};
			String[] Title_ctt={"���","���","��ͬ����","�׷�","�ҷ�","����","ǩ������","��ͬ�ۿ�","������Ŀ","��ע"};
			String[] Title_fc={"����","ƾ֤��","ժҪ","�跽","����","���","������Ŀ","������ͬ","�ʽ�֧����ʽ","�ɹ���ʽ","��Ŀ����"};
			String[] Title_as={"���","�ʲ�����","���","�ͺ�","����","����","���","��������","������","ʹ�ò���","��ע"};
			//String[] Title_as={"���","�ʲ�����","���","�ͺ�","����","����","���","��������","������","ʹ�ò���","��ע"};
			
			
			
			String flag_1_0 = request.getParameter("flag_1_0");
			String flagexcel = request.getParameter("flag_excel");
			String flag = request.getParameter("flag_i");
			System.out.println(flag_1_0+","+flagexcel+","+flag);
			int flag_excel_1_0;
			if(flagexcel!=null){
				flag_excel_1_0 = Integer.parseInt(flagexcel);
			}
			else{
				flag_excel_1_0= 0;
			}
			int fg_1_0;
			if(flag_1_0!=null){
				fg_1_0 = Integer.parseInt(flag_1_0);
			}
			else{
				fg_1_0= 0;
			}
			
			int fg;
			if(flag!=null){
				fg = Integer.parseInt(flag);
			}
			else{
				fg= 0;
			}
			System.out.print(fg);
//			System.out.print(fg == 0 );
			if(fg == 0){
				List <Project> list = new ProjectDAO().getAllProject();
				request.setAttribute("pj_list", list);
				if(fg_1_0==0)
				{
					if(flag_excel_1_0==1){
						exportExcel("��Ŀ��Ϣ����.xls",Title_pj, list,response); 
					}
					System.out.print("project.jsp");
					request.getRequestDispatcher("/WEB-INF/project.jsp").forward(request, response);
					
				}else{
					System.out.print("project_issue.jsp");
					request.getRequestDispatcher("/WEB-INF/project_issue.jsp").forward(request, response);
					
				}
				
			}
			else if(fg==1){
				Project pj_cx = new Project();
				pj_cx.setProject_name(request.getParameter("pj_name_cx"));
				String time_pj = request.getParameter("pj_date_cx");
				System.out.println(time_pj);
				if(time_pj!=null&&time_pj.equals("")==false)
				{
					java.util.Date date_pj;
					try {
						date_pj = new SimpleDateFormat("dd/MM/yyyy").parse(time_pj.substring(0,10));
						java.sql.Date  sqlDate_pj  =  new java.sql.Date(date_pj.getTime());
						System.out.println(date_pj);
						pj_cx.setStart_date(sqlDate_pj);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}     
				}

				pj_cx.setDepartment_name(request.getParameter("pj_dept_cx"));
				pj_cx.setResponsibility_name(request.getParameter("pj_rspb_cx"));
				System.out.println(request.getParameter("pj_name_cx")+"jj,jj"+request.getParameter("pj_dept_cx"));
				List <Project> list_cx = new ProjectDAO().queryAny(pj_cx);
//				for(Project pj:list_cx){
//					System.out.println(pj.getProject_id()+","+pj.getProject_name());
//				}
				request.setAttribute("pj_list", list_cx);
				if(fg_1_0==0)
				{
					if(flag_excel_1_0==1){
						exportExcel("��Ŀ��Ϣ����.xls",Title_pj, list_cx,response); 
					}
					System.out.print("project.jsp");
					request.getRequestDispatcher("/WEB-INF/project.jsp").forward(request, response);

					
				}else{
					if(flag_excel_1_0==1){
						exportExcel("��Ŀ��Ϣ����.xls",Title_pj, list_cx,response); 
					}
					System.out.print("project_issue.jsp");
					request.getRequestDispatcher("/WEB-INF/project_issue.jsp").forward(request, response);
					
				}
				//request.getRequestDispatcher("/WEB-INF/project_issue.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
			else if(fg==2){
				List <Project> pj_list = new ProjectDAO().getAllProject();
				request.setAttribute("pj_list", pj_list);
				
				List <Architecture> ah_list = new ArchitectureDAO().getAllArchitecture();
				request.setAttribute("ah_list", ah_list);
				
				Contract ctt_cx = new Contract();
				ctt_cx.setContract_name(request.getParameter("ctt_name_cx"));
//				ctt_cx.setContract_price(Integer.parseInt(request.getParameter("ctt_price_cx")));
				ctt_cx.setA_name(request.getParameter("ctt_aname_cx"));
				ctt_cx.setB_name(request.getParameter("ctt_bname_cx"));
				ctt_cx.setC_name(request.getParameter("ctt_cname_cx"));
//				ctt_cx.setContract_number(Integer.parseInt(request.getParameter("ctt_num_cx")));
//				ctt_cx.setSign_date(request.getParameter("ctt_date_cx"));
				ctt_cx.setContract_content(request.getParameter("ctt_cont_cx"));
				
//				System.out.println(request.getParameter("pj_name_cx")+"jj,jj"+request.getParameter("pj_dept_cx"));
				List <Contract> list_cx = new ContractDAO().queryAny(ctt_cx);
//				for(Project pj:list_cx){
//					System.out.println(pj.getProject_id()+","+pj.getProject_name());
//				}
				request.setAttribute("ctt_list", list_cx);
				
				if(fg_1_0==0)
				{
					if(flag_excel_1_0==1){
						exportExcel("��ͬ��Ϣ����.xls",Title_ctt, list_cx,response); 
					}
					System.out.print("contract.jsp");
					request.getRequestDispatcher("/WEB-INF/contract.jsp").forward(request, response);
					
				}else{
					if(flag_excel_1_0==1){
						exportExcel("��ͬ��Ϣ����.xls",Title_ctt, list_cx,response); 
					}
					System.out.print("contract_issue.jsp");
					request.getRequestDispatcher("/WEB-INF/contract_issue.jsp").forward(request, response);
					
				}
				//request.getRequestDispatcher("/WEB-INF/contract_issue.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
			else if(fg==3){
				//System.out.print("finance");
				Finance fc_cx = new Finance();
//				fc_cx.setFinance_date(request.getParameter("fc_date_cx"));
//				fc_cx.setFinance_number(Integer.parseInt(request.getParameter("fc_num_cx")));

				fc_cx.setFinance_abstract(request.getParameter("fc_abst_cx"));
//				fc_cx.setMoney(Integer.parseInt(request.getParameter("fc_money_cx")));
				
				String oneortwo =request.getParameter("fc_oneortwo_cx");
				
				String fc_pj_cx = request.getParameter("fc_pj_cx");
				String fc_ctt_cx = request.getParameter("fc_ctt_cx");
				String fc_pay_cx = request.getParameter("fc_pay_cx");
				String fc_type_cx = request.getParameter("fc_type_cx");
				String fc_from_cx = request.getParameter("fc_form_cx");
				String fc_cate_cx = request.getParameter("fc_cate_cx");
	
				
//				System.out.println(request.getParameter("fc_pj_cx")+"jj,jj"+request.getParameter("fc_ctt_cx")
//						+"jj,jj"+request.getParameter("fc_pay_cx")
//						+"jj,jj"+request.getParameter("fc_type_cx")
//						+"jj,jj"+request.getParameter("fc_form_cx")
//						+"jj,jj"+request.getParameter("fc_cate_cx")
//						+"jj,jj"+request.getParameter("fc_abst_cx"));
				List <Finance> fc_list = new FinanceDAO().queryAny(fc_cx);
				for(Finance fc:fc_list){
					System.out.println(fc.getFinance_abstract()+","+fc.getLoan_subject_id());
				}
//				request.setAttribute("fc_list", list_cx);

				List <Accountant_subject> abj_list = new Accountant_subjectDAO().getAllAccountant_subject();
				request.setAttribute("abj_list", abj_list);
				
				List <Project> pj_list = new ProjectDAO().getAllProject();
				request.setAttribute("pj_list", pj_list);
				
				List <Contract> ctt_list = new ContractDAO().getAllContract();
				request.setAttribute("ctt_list", ctt_list);
				
				List <Payment> pay_list = new PaymentDAO().getAllPayment();
				request.setAttribute("pay_list", pay_list);
				
				List <Procurement_type> pt_list = new Procurement_typeDAO().getAllProcurement_type();
				request.setAttribute("pt_list", pt_list);
				
				List <Procurement_form> pf_list = new Procurement_formDAO().getAllProcurement_form();
				request.setAttribute("pf_list", pf_list);
				
				List <Procurement_category> pc_list = new Procurement_categoryDAO().getAllProcurement_category();
				request.setAttribute("pc_list", pc_list);
				
				ArrayList fc_all_list = new ArrayList();
				int flag_all_or_cx=0;
				for(Finance fc:fc_list){
					Accountant_subject fc_bs = new Accountant_subjectDAO().getById(fc.getBorrow_subject_id());
					Accountant_subject fc_ls = new Accountant_subjectDAO().getById(fc.getLoan_subject_id());
					Contract fc_ctt = new ContractDAO().getById(fc.getContract_id());
					
					Project fc_pj = new ProjectDAO().getById(fc_ctt.getProject_id());
					Payment fc_pay = new PaymentDAO().getById(fc.getPayment_id());
					Procurement_type fc_pt = new Procurement_typeDAO().getById(fc.getProcurement_type_id());
					Procurement_form fc_pf = new Procurement_formDAO().getById(fc.getProcurement_from_id());
					Procurement_category fc_ct = new Procurement_categoryDAO().getById(fc.getProcurement_category_id());
				
					if(fc_pj_cx.indexOf(fc_pj.getProject_name())==-1&&fc_pj_cx.equals("")==false){
						continue;
					}
					if(fc_ctt_cx.indexOf(fc_ctt.getContract_name())==-1&&fc_ctt_cx.equals("")==false){
						continue;
					}
					if(fc_pay_cx.indexOf(fc_pay.getPayment_name())==-1&&fc_pay_cx.equals("")==false){
						continue;
					}
					if(fc_type_cx.indexOf(fc_pt.getProcurement_type_name())==-1&&fc_type_cx.equals("")==false){
						continue;
					}
					if(fc_from_cx.indexOf(fc_pf.getProcurement_form_name())==-1&&fc_from_cx.equals("")==false){
						continue;
					}
					if(fc_cate_cx.indexOf(fc_ct.getProcurement_category_name())==-1&&fc_cate_cx.equals("")==false){
						continue;
					}
				
					Object[] one={
							fc.getFinance_date(),
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
							fc_ct.getProcurement_category_name()
							
					};
					flag_all_or_cx=1;
					fc_all_list.add(one);
					//System.out.print("zz");
					
				}
					//System.out.print("ww");
				//request.setAttribute("fc_list", list_cx);
				request.setAttribute("fc_list", fc_all_list);
				if(fg_1_0==0)
				{
					if(flag_excel_1_0==1){
						exportExcel("������Ϣ����.xls",Title_fc, fc_all_list,response); 
					}
					System.out.print("project.jsp");
					request.getRequestDispatcher("/WEB-INF/finance.jsp").forward(request, response);
					
				}else{
					if(flag_excel_1_0==1){
						exportExcel("������Ϣ����.xls",Title_fc, fc_all_list,response); 
					}
					System.out.print("project_issue.jsp");
					request.getRequestDispatcher("/WEB-INF/finance_issue.jsp").forward(request, response);
					
				}
				//request.getRequestDispatcher("/WEB-INF/finance_issue.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
			else if(fg==4){
//				System.out.print("asset");
				Asset as_cx = new Asset();
				as_cx.setAsset_name(request.getParameter("as_name_cx"));
				as_cx.setAsset_spect(request.getParameter("as_spect_cx"));

				as_cx.setAsset_type(request.getParameter("as_type_cx"));
//				as_cx.setAsset_count(Integer.parseInt(request.getParameter("as_count_cx")));
//				as_cx.setAsset_price(Integer.parseInt(request.getParameter("as_price_cx")));
//				as_cx.setMoney(Integer.parseInt(request.getParameter("as_money_cx")));
//				as_cx.setBuy_date(request.getParameter("as_date_cx"));
				
				as_cx.setBuyer(request.getParameter("as_buyer_cx"));
				as_cx.setDepartment_name(request.getParameter("as_dept_cx"));
//				ctt_cx.setAsset_number(Integer.parseInt(request.getParameter("as_num_cx")));

				
				System.out.println(request.getParameter("as_type_cx")+"jj,jj"+request.getParameter("pj_dept_cx"));
				List <Asset> list_cx = new AssetDAO().queryAny(as_cx);
//				for(Project pj:list_cx){
//					System.out.println(pj.getProject_id()+","+pj.getProject_name());
//				}
				request.setAttribute("as_list", list_cx);
				if(fg_1_0==0)
				{
					if(flag_excel_1_0==1){
						exportExcel("�ʲ���Ϣ����.xls",Title_ctt, list_cx,response); 
					}
					System.out.print("contract.jsp");
					request.getRequestDispatcher("/WEB-INF/asset.jsp").forward(request, response);
					
				}else{
					if(flag_excel_1_0==1){
						exportExcel("�ʲ���Ϣ����.xls",Title_ctt, list_cx,response); 
					}
					System.out.print("contract_issue.jsp");
					request.getRequestDispatcher("/WEB-INF/asset_issue.jsp").forward(request, response);
					
				}
				//request.getRequestDispatcher("/WEB-INF/asset_issue.jsp").forward(request, response);
//				System.out.print("project_issue.jsp");
			}
		}
		else{
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
