package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Document;

public class DocumentDAO {
	public void addDocument(Document document){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select document_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int document_idseq = 0;
			if(rs.next()){
				document_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into document values(?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, document_idseq);
			pstmt.setInt(2,document.getDocument_number());
			pstmt.setString(3, document.getDocument_file());
			pstmt.setDate(4,document.getUpload_date());
			pstmt.setString(5,document.getResponsibility_name());
			pstmt.setString(6, document.getRemark());

			pstmt.setInt(7, document.getProject_id());
			pstmt.setInt(8, document.getContract_id());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Document> getAllDocument(){
		List<Document> list = new ArrayList<Document>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from document");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int document_id = rs.getInt(1);
				 int document_number = rs.getInt(2);
				 String document_file = rs.getString(3);
				 Date upload_date = rs.getDate(4);
				 String responsibility_name = rs.getString(5);
				 String remark = rs.getString(6);
				 int project_id = rs.getInt(7);
				 int contract_id = rs.getInt(8);
				
				Document dt = new Document( document_id,  document_number,  document_file,
						 upload_date,  responsibility_name,  remark,
						 project_id,  contract_id);
				list.add(dt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int document_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from document where document_id = ?");
			pstmt.setInt(1, document_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Document getById(int document_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from document where document_id = ?");
			pstmt.setInt(1, document_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int document_number = rs.getInt(2);
				 String document_file = rs.getString(3);
				 Date upload_date = rs.getDate(4);
				 String responsibility_name = rs.getString(5);
				 String remark = rs.getString(6);
				 int project_id = rs.getInt(7);
				 int contract_id = rs.getInt(8);
				
				Document dt = new Document( document_id,  document_number,  document_file,
						 upload_date,  responsibility_name,  remark,
						 project_id,  contract_id);
				return dt;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateDocument(Document dt){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update document set document_number=?,document_file=?," +
					"upload_date=?,responsibility_name=?,remark=?,project_id=?,contract_id=? where document_id =?");
			pstmt.setInt(8, dt.getDocument_id());
			pstmt.setInt(1,dt.getDocument_number());
			pstmt.setString(2,dt.getDocument_file());
			pstmt.setDate(3,dt.getUpload_date());
			pstmt.setString(4,dt.getResponsibility_name());
			pstmt.setString(5,dt.getRemark());
			pstmt.setInt(6,dt.getProject_id());
			pstmt.setInt(7,dt.getContract_id());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		DocumentDAO dtado = new DocumentDAO();
		Document dt = new Document();
		dt.setDocument_id(3);
		dt.setDocument_number(1);
		dt.setDocument_file("需求报告");
		dt.setUpload_date(new Date(2006-12-21));
		dt.setResponsibility_name("李四");
		dt.setRemark("备注信息备注信息备注信息备注信息备注信息");
		dt.setProject_id(2);
		dt.setContract_id(2);
//		dtado.addDocument(dt);
		
//		List <Document> list = new DocumentDAO().getAllDocument();
//		for(Document dt:list){
//			System.out.println(dt.getDocument_id()+","+dt.getResponsibility_name());
//		}
		
//		Document dt = new DocumentDAO().getById(1);
//		System.out.println(dt.getDocument_id()+","+dt.getResponsibility_name());
		
		new DocumentDAO().updateDocument(dt);
		
		
	}
}
