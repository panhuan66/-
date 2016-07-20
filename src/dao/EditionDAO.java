package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Edition;

public class EditionDAO {
	public void addEdition(Edition edition){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select edition_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int edition_idseq = 0;
			if(rs.next()){
				edition_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into edition values(?,?,?,?)");
			
			pstmt.setInt(1, edition_idseq);
			pstmt.setDate(2,edition.getEdition_year());
			pstmt.setString(3, edition.getValid());
			pstmt.setInt(4,edition.getEdition_type());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Edition> getAllEdition(){
		List<Edition> list = new ArrayList<Edition>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from edition");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int edition_id = rs.getInt(1);
				 Date edition_year  = rs.getDate(2);
				 String valid = rs.getString(3);
				 int edition_type  = rs.getInt(4);
				
				Edition ed = new Edition( edition_id,  edition_year,  valid,
						edition_type);
				list.add(ed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int edition_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from edition where edition_id = ?");
			pstmt.setInt(1, edition_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Edition getById(int edition_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from edition where edition_id = ?");
			pstmt.setInt(1, edition_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 Date edition_year  = rs.getDate(2);
				 String valid = rs.getString(3);
				 int edition_type  = rs.getInt(4);
				
				Edition ed = new Edition( edition_id,  edition_year,  valid,
						edition_type);
				return ed;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateEdition(Edition ed){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update edition set edition_year=?,valid=?," +
					"edition_type=? where edition_id =?");
			pstmt.setInt(4, ed.getEdition_id());
			pstmt.setDate(1,ed.getEdition_year());
			pstmt.setString(2,ed.getValid());
			pstmt.setInt(3,ed.getEdition_type());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		EditionDAO edado = new EditionDAO();
		Edition ed = new Edition();
		ed.setEdition_id(4);
		ed.setEdition_year(new Date(12));
		ed.setValid("1");
		ed.setEdition_type(4);
//		
//		edado.addEdition(ed);
		
//		List <Edition> list = new EditionDAO().getAllEdition();
//		for(Edition ed:list){
//			System.out.println(ed.getEdition_id()+","+ed.getEdition_year());
//		}
//		
//		Edition ed = new EditionDAO().getById(1);
//		System.out.println(ed.getEdition_id()+","+ed.getEdition_year());
		
		new EditionDAO().updateEdition(ed);
		
		
	}
}
