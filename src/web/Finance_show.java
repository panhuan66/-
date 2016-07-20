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

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * Servlet implementation class Finance_show
 */
@WebServlet("/Finance_show")
public class Finance_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Finance_show() {
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
	
	
	public  HttpServletResponse exportExcel(String fileName,String[] Title, List listContent, HttpServletResponse response) {
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
  	  	return response;
  	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.print("doPost");
		if(request.getSession().getAttribute("OK")!=null && request.getSession().getAttribute("OK")!=""){
			List <Finance> fc_list = new FinanceDAO().getAllFinance();
			//List <Finance> fc_list_radio = new FinanceDAO().getAllFinance();
			//request.setAttribute("fc_list_radio", fc_list);
//			for(Finance fc:list){
//				System.out.println(fc.getFinance_id()+","+fc.getFinance_number());
//			}
			
			
			ArrayList<Object> fc_all_list = new ArrayList<Object>();
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
				fc_all_list.add(one);
				
			}
			request.setAttribute("fc_list", fc_all_list);
			
			
			
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
			
			String[] Title_fc={"����","ƾ֤��","ժҪ","�跽","����","���","������Ŀ","������ͬ","�ʽ�֧����ʽ","�ɹ���ʽ","��Ŀ����"};
			String flag = request.getParameter("flag");
			String flagexcel = request.getParameter("flag_excel");
//			for(Object fc:fc_all_list){
//			System.out.println(fc);
//			}
			int flag_excel_1_0;
			if(flagexcel!=null){
				flag_excel_1_0 = Integer.parseInt(flagexcel);
			}
			else{
				flag_excel_1_0= 0;
			}
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
				
				if(flag_excel_1_0==1){
					//System.out.print("adsfadfsasdfas");
					response = exportExcel("������Ϣ����.xls",Title_fc, fc_list,response); 
				}
				request.getRequestDispatcher("/WEB-INF/finance.jsp").forward(request, response);
//				System.out.print("finance.jsp");
			}
			else{
				if(flag_excel_1_0==1){
					System.out.print("1231231231231");
					response = exportExcel("������Ϣ����.xls",Title_fc, fc_all_list,response); 
				}
				request.getRequestDispatcher("/WEB-INF/finance_issue.jsp").forward(request, response);
//				System.out.print("finance_issue.jsp");
			}
		}
		else{
			response.sendRedirect("index.jsp");
		}

	}

}
