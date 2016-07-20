package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Procurement_type;

public class Procurement_typeDAO {
	public void addProcurement_type(Procurement_type procurement_type){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select procurement_type_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int procurement_type_idseq = 0;
			if(rs.next()){
				procurement_type_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into procurement_type values(?,?,?,?)");
			
			pstmt.setInt(1, procurement_type_idseq);
			pstmt.setInt(2,procurement_type.getProcurement_type_number());
			pstmt.setString(3, procurement_type.getProcurement_type_name());
			pstmt.setInt(4,procurement_type.getEdition_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Procurement_type> getAllProcurement_type(){
		List<Procurement_type> list = new ArrayList<Procurement_type>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from procurement_type");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int procurement_type_id = rs.getInt(1);
				 int procurement_type_number  = rs.getInt(2);
				 String procurement_type_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Procurement_type pt = new Procurement_type( procurement_type_id,  procurement_type_number,  procurement_type_name,
						 edition_id);
				list.add(pt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int procurement_type_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from procurement_type where procurement_type_id = ?");
			pstmt.setInt(1, procurement_type_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Procurement_type getById(int procurement_type_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from procurement_type where procurement_type_id = ?");
			pstmt.setInt(1, procurement_type_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int procurement_type_number  = rs.getInt(2);
				 String procurement_type_name = rs.getString(3);
				 int edition_id  = rs.getInt(4);
				
				Procurement_type pt = new Procurement_type( procurement_type_id,  procurement_type_number,  procurement_type_name,
						 edition_id);
				return pt;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProcurement_type(Procurement_type pt){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update procurement_type set procurement_type_number=?,procurement_type_name=?," +
					"edition_id=? where procurement_type_id =?");
			pstmt.setInt(4, pt.getProcurement_type_id());
			pstmt.setInt(1,pt.getProcurement_type_number());
			pstmt.setString(2,pt.getProcurement_type_name());
			pstmt.setInt(3,pt.getEdition_id());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
//		Procurement_typeDAO ptado = new Procurement_typeDAO();
//		Procurement_type pt = new Procurement_type();
//		pt.setProcurement_type_id(6);
//		pt.setProcurement_type_number(6);
//		pt.setProcurement_type_name("ÆäËû");
//		pt.setEdition_id(2);
//		
		//ptado.addProcurement_type(pt);
		
//		List <Procurement_type> list = new Procurement_typeDAO().getAllProcurement_type();
//		for(Procurement_type pt:list){
//			System.out.println(pt.getProcurement_type_id()+","+pt.getProcurement_type_name());
//		}
		
//		Procurement_type pt = new Procurement_typeDAO().getById(1);
//		System.out.println(pt.getProcurement_type_id()+","+pt.getProcurement_type_name());
		
//		new Procurement_typeDAO().updateProcurement_type(pt);
		
		
	}
}
