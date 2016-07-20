package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Payment;

public class PaymentDAO {
	public void addPayment(Payment payment){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select payment_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int payment_idseq = 0;
			if(rs.next()){
				payment_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into payment values(?,?,?,?)");
			
			pstmt.setInt(1, payment_idseq);
			pstmt.setInt(2,payment.getPayment_number());
			pstmt.setString(3, payment.getPayment_name());
			pstmt.setInt(4,payment.getEdition_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Payment> getAllPayment(){
		List<Payment> list = new ArrayList<Payment>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from payment");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int payment_id = rs.getInt(1);
				 int payment_number  = rs.getInt(2);
				 String payment_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Payment pm = new Payment( payment_id,  payment_number,  payment_name,
						 edition_id);
				list.add(pm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int payment_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from payment where payment_id = ?");
			pstmt.setInt(1, payment_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Payment getById(int payment_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from payment where payment_id = ?");
			pstmt.setInt(1, payment_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int payment_number  = rs.getInt(2);
				 String payment_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Payment pm = new Payment( payment_id,  payment_number,  payment_name,
						 edition_id);
				return pm;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updatePayment(Payment pm){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update payment set payment_number=?,payment_name=?," +
					"edition_id=? where payment_id =?");
			pstmt.setInt(4, pm.getPayment_id());
			pstmt.setInt(1,pm.getPayment_number());
			pstmt.setString(2,pm.getPayment_name());
			pstmt.setInt(3,pm.getEdition_id());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
//		PaymentDAO pmado = new PaymentDAO();
//		Payment pm = new Payment();
//		pm.setPayment_id(3);
//		pm.setPayment_number(3);
//		pm.setPayment_name("Êµ²¦×Ê½ð");
//		pm.setEdition_id(3);
//		
//		pmado.addPayment(pm);
		
//		List <Payment> list = new PaymentDAO().getAllPayment();
//		for(Payment pm:list){
//			System.out.println(pm.getPayment_id()+","+pm.getPayment_name());
//		}
		
//		Payment pm = new PaymentDAO().getById(1);
//		System.out.println(pm.getPayment_id()+","+pm.getPayment_name());
		
//		new PaymentDAO().updatePayment(pm);
		
		
	}
}
