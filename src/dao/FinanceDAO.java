package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Finance;
import vo.Project;

public class FinanceDAO {
	public void addFinance(Finance finance){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select finance_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int finance_idseq = 0;
			if(rs.next()){
				finance_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into finance values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, finance_idseq);
			pstmt.setInt(2,finance.getFinance_number());
			pstmt.setDate(3, finance.getFinance_date());
			pstmt.setString(4,finance.getFinance_abstract());
			pstmt.setInt(5,finance.getMoney());
			pstmt.setInt(6, finance.getBorrow_subject_id());

			pstmt.setInt(7, finance.getLoan_subject_id());
			pstmt.setInt(8, finance.getContract_id());
			
			pstmt.setInt(9, finance.getPayment_id());
			pstmt.setInt(10, finance.getProcurement_type_id());
			pstmt.setInt(11, finance.getProcurement_from_id());
			pstmt.setInt(12, finance.getProcurement_category_id());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Finance> getAllFinance(){
		List<Finance> list = new ArrayList<Finance>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from finance");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int finance_id = rs.getInt(1);
				 int finance_number = rs.getInt(2);
				 Date finance_date = rs.getDate(3);
				 String finance_abstract = rs.getString(4);
				 int money = rs.getInt(5);
				 int borrow_subject_id = rs.getInt(6);
				 int loan_subject_id = rs.getInt(7);
				 int contract_id = rs.getInt(8);
				 int payment_id = rs.getInt(9);
				 int procurement_type_id = rs.getInt(10);
				 int procurement_from_id = rs.getInt(11);
				 int procurement_category_id = rs.getInt(12);
				
				Finance fc = new Finance(finance_id, finance_number, finance_date,
						finance_abstract, money, borrow_subject_id,
						loan_subject_id, contract_id, payment_id,
						procurement_type_id, procurement_from_id,
						procurement_category_id);
				list.add(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Finance getById(int finance_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from finance where finance_id = ?");
			pstmt.setInt(1, finance_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
			
				 int finance_number = rs.getInt(2);
				 Date finance_date = rs.getDate(3);
				 String finance_abstract = rs.getString(4);
				 int money = rs.getInt(5);
				 int borrow_subject_id = rs.getInt(6);
				 int loan_subject_id = rs.getInt(7);
				 int contract_id = rs.getInt(8);
				 int payment_id = rs.getInt(9);
				 int procurement_type_id = rs.getInt(10);
				 int procurement_from_id = rs.getInt(11);
				 int procurement_category_id = rs.getInt(12);
				
				Finance fc = new Finance(finance_id, finance_number, finance_date,
						finance_abstract, money, borrow_subject_id,
						loan_subject_id, contract_id, payment_id,
						procurement_type_id, procurement_from_id,
						procurement_category_id);
				return fc;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateFinance(Finance fc){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update finance set finance_number=?,finance_date=?," +
					"abstract=?,money=?,borrow_subject_id=?,loan_subject_id=?," +
					"contract_id=?,payment_id=?,procurement_type_id=?," +
					"procurement_from_id=?,procurement_category_id=? where finance_id =?");
			pstmt.setInt(12, fc.getFinance_id());
			pstmt.setInt(1,fc.getFinance_number());
			pstmt.setDate(2,fc.getFinance_date());
			pstmt.setString(3,fc.getFinance_abstract());
			pstmt.setInt(4,fc.getMoney());
			pstmt.setInt(5,fc.getBorrow_subject_id());
			pstmt.setInt(6,fc.getLoan_subject_id());
			pstmt.setInt(7,fc.getContract_id());
			pstmt.setInt(8,fc.getPayment_id());
			pstmt.setInt(9,fc.getProcurement_type_id());
			pstmt.setInt(10,fc.getProcurement_from_id());
			pstmt.setInt(11,fc.getProcurement_category_id());

			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Finance> queryAny(Finance finance){
		List<Finance> list = new ArrayList<Finance>();
		try {
			String sql = "SELECT * FROM finance WHERE 1=1";
			if(finance.getFinance_date()!=null&&finance.getFinance_date().equals("")==false){
				sql =sql +" AND finance_date ='"+finance.getFinance_date()+"'"; 
			}
			//if(finance.getFinance_number()!=null&&finance.getFinance_number().equals("")==false){
				//sql =sql +" AND finance_number ='"+finance.getFinance_number()+"'"; 
			//}
			
			if(finance.getFinance_abstract()!=null&&finance.getFinance_abstract().equals("")==false){
				sql =sql +" AND abstract like '%"+finance.getFinance_abstract()+"%'"; 
			}
			//if(finance.getMoney()!=null&&finance.getMoney().equals("")==false){
				//sql =sql +" AND money ='"+finance.getMoney()+"'"; 
			//}
			
			
			
			//if(finance.getDepartment_name()!=null&&finance.getDepartment_name().equals("")==false){
				//sql =sql +" AND department_name '%"+finance.getDepartment_name()+"%'"; 
			//}
			
			
			PreparedStatement pstmt = GetConn.getConn().prepareStatement(sql);
			//pstmt.setString(1, query_id);
			//pstmt.setString(1, query_name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int finance_id = rs.getInt(1);
				 int finance_number = rs.getInt(2);
				 Date finance_date = rs.getDate(3);
				 String finance_abstract = rs.getString(4);
				 int money = rs.getInt(5);
				 int borrow_subject_id = rs.getInt(6);
				 int loan_subject_id = rs.getInt(7);
				 int contract_id = rs.getInt(8);
				 int payment_id = rs.getInt(9);
				 int procurement_type_id = rs.getInt(10);
				 int procurement_from_id = rs.getInt(11);
				 int procurement_category_id = rs.getInt(12);
				
				Finance fc = new Finance(finance_id, finance_number, finance_date,
						finance_abstract, money, borrow_subject_id,
						loan_subject_id, contract_id, payment_id,
						procurement_type_id, procurement_from_id,
						procurement_category_id);
				list.add(fc);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String args[]){
		FinanceDAO fcado = new FinanceDAO();
		Finance fc = new Finance();
//		fc.setFinance_id(2);
//		fc.setFinance_number(2);
//		fc.setFinance_date(new Date(2006-12-21));
		fc.setFinance_abstract("ժҪ..");
//		fc.setMoney(32111323);
//		fc.setBorrow_subject_id(2);
//		fc.setLoan_subject_id(2);
//		fc.setContract_id(2);
//		fc.setPayment_id(2);
//		fc.setProcurement_type_id(2);
//		fc.setProcurement_from_id(2);
//		fc.setProcurement_category_id(2);
//		
//		fcado.addFinance(fc);
		
//		List <Finance> list = new FinanceDAO().getAllFinance();
//		for(Finance fc:list){
//			System.out.println(fc.getFinance_id()+","+fc.getFinance_abstract());
//		}
		
//		Finance fc = new FinanceDAO().getById(1);
//		System.out.println(fc.getFinance_id()+","+fc.getFinance_abstract());
		
//		new FinanceDAO().updateFinance(fc);
		
		List <Finance> list = new FinanceDAO().queryAny(fc);
		for(Finance fc_1:list){
			System.out.println(fc_1.getFinance_id()+","+fc_1.getFinance_abstract());
		}
	}
}
