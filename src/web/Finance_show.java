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
  	  String result="系统提示：Excel文件导出成功！";  
  	  // 以下开始输出到EXCEL
  	  try {    
  	   //定义输出流，以便打开保存对话框______________________begin
  	   //HttpServletResponse response=ServletActionContext.getResponse();
  	   OutputStream os = response.getOutputStream();// 取得输出流      
  	   response.reset();// 清空输出流      
  	   response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("GB2312"),"ISO8859-1"));
  	// 设定输出文件头      
  	   response.setContentType("application/msexcel");// 定义输出类型    
  	   //定义输出流，以便打开保存对话框_______________________end

  	   /** **********创建工作簿************ */
  	   WritableWorkbook workbook = Workbook.createWorkbook(os);

  	   /** **********创建工作表************ */

  	   WritableSheet sheet = workbook.createSheet("Sheet1", 0);

  	   /** **********设置纵横打印（默认为纵打）、打印纸***************** */
  	   jxl.SheetSettings sheetset = sheet.getSettings();
  	   sheetset.setProtected(false);


  	   /** ************设置单元格字体************** */
  	   WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
  	   WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD);

  	   /** ************以下设置三种单元格样式，灵活备用************ */
  	   // 用于标题居中
  	   WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
  	   wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
  	   wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
  	   wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
  	   wcf_center.setWrap(false); // 文字是否换行
  	   
  	   // 用于正文居左
  	   WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
  	   wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
  	   wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
  	   wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
  	   wcf_left.setWrap(false); // 文字是否换行   
  	 

  	   /** ***************以下是EXCEL开头大标题，暂时省略********************* */
  	   //sheet.mergeCells(0, 0, colWidth, 0);
  	   //sheet.addCell(new Label(0, 0, "XX报表", wcf_center));
  	   /** ***************以下是EXCEL第一行列标题********************* */
  	   for (int i = 0; i < Title.length; i++) {
  	    sheet.addCell(new Label(i, 0,Title[i],wcf_center));
  	   }   
  	   /** ***************以下是EXCEL正文数据********************* */
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
  	   /** **********将以上缓存中的内容写到EXCEL文件中******** */
  	   workbook.write();
  	   /** *********关闭文件************* */
  	   workbook.close();   

  	  } catch (Exception e) {
  	   result="系统提示：Excel文件导出失败，原因："+ e.toString();
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
			
			String[] Title_fc={"日期","凭证号","摘要","借方","贷方","金额","所属项目","所属合同","资金支付方式","采购形式","项目分类"};
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
					response = exportExcel("财务信息资料.xls",Title_fc, fc_list,response); 
				}
				request.getRequestDispatcher("/WEB-INF/finance.jsp").forward(request, response);
//				System.out.print("finance.jsp");
			}
			else{
				if(flag_excel_1_0==1){
					System.out.print("1231231231231");
					response = exportExcel("财务信息资料.xls",Title_fc, fc_all_list,response); 
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
