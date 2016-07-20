package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Procurement_category;

public class Procurement_categoryDAO {
	public void addProcurement_category(Procurement_category procurement_category){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select procurement_category_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int procurement_category_idseq = 0;
			if(rs.next()){
				procurement_category_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into procurement_category values(?,?,?,?)");
			
			pstmt.setInt(1, procurement_category_idseq);
			pstmt.setInt(2,procurement_category.getProcurement_category_number());
			pstmt.setString(3, procurement_category.getProcurement_category_name());
			pstmt.setInt(4,procurement_category.getEdition_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Procurement_category> getAllProcurement_category(){
		List<Procurement_category> list = new ArrayList<Procurement_category>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from procurement_category");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int procurement_category_id = rs.getInt(1);
				 int procurement_category_number  = rs.getInt(2);
				 String procurement_category_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Procurement_category pc = new Procurement_category( procurement_category_id,  procurement_category_number,  procurement_category_name,
						 edition_id);
				list.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int procurement_category_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from procurement_category where procurement_category_id = ?");
			pstmt.setInt(1, procurement_category_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Procurement_category getById(int procurement_category_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from procurement_category where procurement_category_id = ?");
			pstmt.setInt(1, procurement_category_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int procurement_category_number  = rs.getInt(2);
				 String procurement_category_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Procurement_category pc = new Procurement_category( procurement_category_id,  procurement_category_number,  procurement_category_name,
						 edition_id);
				return pc;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProcurement_category(Procurement_category pc){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update procurement_category set procurement_category_number=?,procurement_category_name=?," +
					"edition_id=? where procurement_category_id =?");
			pstmt.setInt(4, pc.getProcurement_category_id());
			pstmt.setInt(1,pc.getProcurement_category_number());
			pstmt.setString(2,pc.getProcurement_category_name());
			pstmt.setInt(3,pc.getEdition_id());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
//		Procurement_categoryDAO pcado = new Procurement_categoryDAO();
//		Procurement_category pc = new Procurement_category();
//		pc.setProcurement_category_id(3);
//		pc.setProcurement_category_number(3);
//		pc.setProcurement_category_name("·þÎñ");
//		pc.setEdition_id(3);
//		
//		pcado.addProcurement_category(pc);
		
//		List <Procurement_category> list = new Procurement_categoryDAO().getAllProcurement_category();
//		for(Procurement_category pc:list){
//			System.out.println(pc.getProcurement_category_id()+","+pc.getProcurement_category_name());
//		}
		
//		Procurement_category pc = new Procurement_categoryDAO().getById(1);
//		System.out.println(pc.getProcurement_category_id()+","+pc.getProcurement_category_name());
		
//		new Procurement_categoryDAO().updateProcurement_category(pc);
		
		
	}
}
