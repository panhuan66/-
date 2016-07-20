package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vo.Accountant_subject;
import vo.Asset;
import vo.Contract;
import vo.Finance;
import vo.Payment;
import vo.Procurement_category;
import vo.Procurement_form;
import vo.Procurement_type;
import vo.Project;
import dao.Accountant_subjectDAO;
import dao.AssetDAO;
import dao.ContractDAO;
import dao.FinanceDAO;
import dao.PaymentDAO;
import dao.Procurement_categoryDAO;
import dao.Procurement_formDAO;
import dao.Procurement_typeDAO;
import dao.ProjectDAO;
/**
 * Servlet implementation class UploadHandleServlet
 */
@WebServlet("/UploadHandleServlet")
public class UploadHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadHandleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("OK")!=null && request.getSession().getAttribute("OK")!=""){
			List <Project> pj_list = new ProjectDAO().getAllProject();
			request.setAttribute("pj_list", pj_list);
			
			List <Contract> ctt_list = new ContractDAO().getAllContract();
			request.setAttribute("ctt_list", ctt_list);
			
			List <Asset> as_list = new AssetDAO().getAllAsset();
			request.setAttribute("as_list", as_list);
			
			List <Finance> fc_list = new FinanceDAO().getAllFinance();
			List <Accountant_subject> abj_list = new Accountant_subjectDAO().getAllAccountant_subject();
			request.setAttribute("abj_list", abj_list);
			
//			List <Project> pj_list = new ProjectDAO().getAllProject();
//			request.setAttribute("pj_list", pj_list);
//			
//			List <Contract> ctt_list = new ContractDAO().getAllContract();
//			request.setAttribute("ctt_list", ctt_list);
			
			List <Payment> pay_list = new PaymentDAO().getAllPayment();
			request.setAttribute("pay_list", pay_list);
			
			List <Procurement_type> pt_list = new Procurement_typeDAO().getAllProcurement_type();
			request.setAttribute("pt_list", pt_list);
			
			List <Procurement_form> pf_list = new Procurement_formDAO().getAllProcurement_form();
			request.setAttribute("pf_list", pf_list);
			
			List <Procurement_category> pc_list = new Procurement_categoryDAO().getAllProcurement_category();
			request.setAttribute("pc_list", pc_list);
			
			
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
			
			
			
			 int fg = 0;

				//�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		        System.out.println(savePath);
		        File file = new File(savePath);
		        //�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
		        if (!file.exists() && !file.isDirectory()) {
		            System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
		            //����Ŀ¼
		            file.mkdir();
		        }
		        //��Ϣ��ʾ
		        String message = "";
		        System.out.print("��������0");
		        try{
		            //ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
		            //1������һ��DiskFileItemFactory����
		            DiskFileItemFactory factory = new DiskFileItemFactory();
		            //2������һ���ļ��ϴ�������
		            ServletFileUpload upload = new ServletFileUpload(factory);
		             //����ϴ��ļ�������������
		            upload.setHeaderEncoding("UTF-8"); 
		            //3���ж��ύ�����������Ƿ����ϴ���������
		            if(!ServletFileUpload.isMultipartContent(request)){
		                //���մ�ͳ��ʽ��ȡ����
		                return;
		            }
		            System.out.print("��������1");
		            //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
		            List<FileItem> list = upload.parseRequest(request);
		            System.out.print("��������2");
		            for(FileItem item : list){
		                //���fileitem�з�װ������ͨ�����������
		                if(item.isFormField()){
		                    String name = item.getFieldName();
		                    //�����ͨ����������ݵ�������������
		                    String value = item.getString("UTF-8");
		                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
		                    System.out.println(name + "=" + value);
		                    //flag = value;
		                    
		                   
		        			if(value!=null){
		        				fg = Integer.parseInt(value);
		        			}
		        			else{
		        				fg= 0;
		        			}
		        			
		        			
		                }else{//���fileitem�з�װ�����ϴ��ļ�
		                    //�õ��ϴ����ļ����ƣ�
		                	fg=0;
		                    String filename = item.getName();
		                    //System.out.println(filename);
		                    if(filename==null || filename.trim().equals("")){
		                        continue;
		                    }
		                    //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
		                    //�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
		                    filename = filename.substring(filename.lastIndexOf("\\")+1);
		                    //��ȡitem�е��ϴ��ļ���������
		                    InputStream in = item.getInputStream();
		                    //����һ���ļ������
		                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
		                    //����һ��������
		                    byte buffer[] = new byte[1024];
		                    //�ж��������е������Ƿ��Ѿ�����ı�ʶ
		                    int len = 0;
		                    //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
		                    while((len=in.read(buffer))>0){
		                        //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
		                        out.write(buffer, 0, len);
		                    }
		                    //�ر�������
		                    in.close();
		                    //�ر������
		                    out.close();
		                    //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
		                    item.delete();
		                    message = "�ļ��ϴ��ɹ���";
		                }
		            }
		        }catch (Exception e) {
		            message= "�ļ��ϴ�ʧ�ܣ�";
		            e.printStackTrace();
		            fg=0;
		            
		        }
		        request.setAttribute("message",message);

			System.out.println(fg);

			if(fg == 1){
				request.getRequestDispatcher("/WEB-INF/project_issue.jsp").forward(request, response);
				//System.out.println("11project_issue.jsp");
			}
			else if(fg==2){
				request.getRequestDispatcher("/WEB-INF/contract_issue.jsp").forward(request, response);
				//System.out.println("22other.jsp");
			}
			else if(fg==3){
				request.getRequestDispatcher("/WEB-INF/finance_issue.jsp").forward(request, response);
				//System.out.println("33other.jsp");
			}
			else if(fg==4){
				request.getRequestDispatcher("/WEB-INF/asset_issue.jsp").forward(request, response);
				//System.out.println("44other.jsp");
			}
			else if(fg==5){
				request.getRequestDispatcher("/WEB-INF/group_issue.jsp").forward(request, response);
				//System.out.println("55other.jsp");
			}
		}
		else{
			response.sendRedirect("66index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);
	}

}
