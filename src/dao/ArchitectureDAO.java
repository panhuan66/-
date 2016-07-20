package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Architecture;

public class ArchitectureDAO {
	public void addArchitecture(Architecture architecture){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select architecture_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int architecture_idseq = 0;
			if(rs.next()){
				architecture_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into architecture values(?,?,?)");
			
			pstmt.setInt(1, architecture_idseq);
			pstmt.setInt(2,architecture.getArchitecture_number());
			pstmt.setString(3, architecture.getArchitecture_name());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Architecture> getAllArchitecture(){
		List<Architecture> list = new ArrayList<Architecture>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from architecture");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int architecture_id=rs.getInt(1);
				 int architecture_number = rs.getInt(2);
				 String architecture_name = rs.getString(3);

				Architecture ah = new Architecture( architecture_id,  architecture_number,
						 architecture_name);
				list.add(ah);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteByIdr(int architecture_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from architecture where architecture_id = ?");
			pstmt.setInt(1, architecture_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Architecture getById(int architecture_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from architecture where architecture_id = ?");
			pstmt.setInt(1, architecture_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int architecture_number = rs.getInt(2);
				 String architecture_name = rs.getString(3);

				Architecture ah = new Architecture( architecture_id,  architecture_number,
						 architecture_name);
				return ah;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateArchitecture(Architecture ah){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update architecture set architecture_number=?,architecture_name=? where architecture_id =?");
			pstmt.setInt(3, ah.getArchitecture_id());
			pstmt.setInt(1,ah.getArchitecture_number());
			pstmt.setString(2,ah.getArchitecture_name());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
//		ArchitectureDAO ahado = new ArchitectureDAO();
//		Architecture ah = new Architecture();
//		ah.setArchitecture_id(5);
//		ah.setArchitecture_number(5);
//		ah.setArchitecture_name("ÏµÍ³Èí¼þ");
	
		//ahado.addArchitecture(ah);
		
//		List <Architecture> list = new ArchitectureDAO().getAllArchitecture();
//		for(Architecture ah:list){
//			System.out.println(ah.getArchitecture_id()+","+ah.getArchitecture_name());
//		}
		
//		Architecture ah = new ArchitectureDAO().getById(1);
//		System.out.println(ah.getArchitecture_id()+","+ah.getArchitecture_name());
		
//		new ArchitectureDAO().updateArchitecture(ah);
		
		
	}
}
