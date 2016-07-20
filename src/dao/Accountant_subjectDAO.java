package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Accountant_subject;

public class Accountant_subjectDAO {
	
	public void addAccountant_subject(Accountant_subject accountant_subject){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select accountant_subject_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int accountant_subject_idseq = 0;
			if(rs.next()){
				accountant_subject_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into accountant_subject values(?,?,?)");
			
			pstmt.setInt(1, accountant_subject_idseq);
			pstmt.setInt(2,accountant_subject.getAccountant_subject_number());
			pstmt.setString(3, accountant_subject.getAccountant_subject_name());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Accountant_subject> getAllAccountant_subject(){
		List<Accountant_subject> list = new ArrayList<Accountant_subject>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from accountant_subject");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int accountant_subject_id=rs.getInt(1);
				 int accountant_subject_number = rs.getInt(2);
				 String accountant_subject_name = rs.getString(3);

				Accountant_subject abj = new Accountant_subject( accountant_subject_id,  accountant_subject_number,
						 accountant_subject_name);
				list.add(abj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int accountant_subject_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from accountant_subject where accountant_subject_id = ?");
			pstmt.setInt(1, accountant_subject_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Accountant_subject getById(int accountant_subject_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from accountant_subject where accountant_subject_id = ?");
			pstmt.setInt(1, accountant_subject_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int accountant_subject_number = rs.getInt(2);
				 String accountant_subject_name = rs.getString(3);

				Accountant_subject abj = new Accountant_subject( accountant_subject_id,  accountant_subject_number,
						 accountant_subject_name);
				return abj;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateAccountant_subject(Accountant_subject abj){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update accountant_subject set accountant_subject_number=?,accountant_subject_name=? where accountant_subject_id =?");
			pstmt.setInt(3, abj.getAccountant_subject_id());
			pstmt.setInt(1,abj.getAccountant_subject_number());
			pstmt.setString(2,abj.getAccountant_subject_name());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
//		Accountant_subjectDAO abjado = new Accountant_subjectDAO();
//		Accountant_subject abj = new Accountant_subject();
//		abj.setAccountant_subject_id(2);
//		abj.setAccountant_subject_number(103);
//		abj.setAccountant_subject_name("建筑安装投资");
	
//		abjado.addAccountant_subject(abj);
		
//		List <Accountant_subject> list = new Accountant_subjectDAO().getAllAccountant_subject();
//		for(Accountant_subject abj:list){
//			System.out.println(abj.getAccountant_subject_id()+","+abj.getAccountant_subject_name());
//		}
		
//		Accountant_subject abj = new Accountant_subjectDAO().getById(1);
//		System.out.println(abj.getAccountant_subject_id()+","+abj.getAccountant_subject_name());
		
//		new Accountant_subjectDAO().updateAccountant_subject(abj);
		
		
	}
}
