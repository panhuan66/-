package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Procurement_form;

public class Procurement_formDAO {
	public void addProcurement_form(Procurement_form procurement_form){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select procurement_form_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int procurement_form_idseq = 0;
			if(rs.next()){
				procurement_form_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into procurement_form values(?,?,?,?)");
			
			pstmt.setInt(1, procurement_form_idseq);
			pstmt.setInt(2,procurement_form.getProcurement_form_number());
			pstmt.setString(3, procurement_form.getProcurement_form_name());
			pstmt.setInt(4,procurement_form.getEdition_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Procurement_form> getAllProcurement_form(){
		List<Procurement_form> list = new ArrayList<Procurement_form>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from procurement_form");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int procurement_form_id = rs.getInt(1);
				 int procurement_form_number  = rs.getInt(2);
				 String procurement_form_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Procurement_form pf = new Procurement_form( procurement_form_id,  procurement_form_number,  procurement_form_name,
						 edition_id);
				list.add(pf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int procurement_form_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from procurement_category where procurement_form_id = ?");
			pstmt.setInt(1, procurement_form_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Procurement_form getById(int procurement_form_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from procurement_form where procurement_form_id = ?");
			pstmt.setInt(1, procurement_form_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int procurement_form_number  = rs.getInt(2);
				 String procurement_form_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Procurement_form pf = new Procurement_form( procurement_form_id,  procurement_form_number,  procurement_form_name,
						 edition_id);
				return pf;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProcurement_form(Procurement_form pf){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update procurement_form set procurement_form_number=?,procurement_form_name=?," +
					"edition_id=? where procurement_form_id =?");
			pstmt.setInt(4, pf.getProcurement_form_id());
			pstmt.setInt(1,pf.getProcurement_form_number());
			pstmt.setString(2,pf.getProcurement_form_name());
			pstmt.setInt(3,pf.getEdition_id());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
//		Procurement_formDAO pfado = new Procurement_formDAO();
//		Procurement_form pf = new Procurement_form();
//		pf.setProcurement_form_id(6);
//		pf.setProcurement_form_number(6);
//		pf.setProcurement_form_name("委托组织分散采购");
//		pf.setEdition_id(3);
//		
//		pfado.addProcurement_form(pf);
		
//		List <Procurement_form> list = new Procurement_formDAO().getAllProcurement_form();
//		for(Procurement_form pf:list){
//			System.out.println(pf.getProcurement_form_id()+","+pf.getProcurement_form_name());
//		}
//		
//		Procurement_form pf = new Procurement_formDAO().getById(1);
//		System.out.println(pf.getProcurement_form_id()+","+pf.getProcurement_form_name());
//		
//		new Procurement_formDAO().updateProcurement_form(pf);
		
		
	}
}
