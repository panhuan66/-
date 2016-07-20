package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Contract;
import vo.Project;

public class ContractDAO {
	public void addContract(Contract contract){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select contract_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int contract_idseq = 0;
			if(rs.next()){
				contract_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into contract values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, contract_idseq);
			pstmt.setInt(2,contract.getContract_number());
			pstmt.setString(3, contract.getContract_name());
			pstmt.setString(4,contract.getA_name());
			pstmt.setString(5,contract.getB_name());
			pstmt.setString(6, contract.getC_name());

			pstmt.setDate(7, contract.getSign_date());
			pstmt.setInt(8, contract.getContract_price());
			pstmt.setString(9,contract.getContract_content());
			pstmt.setString(10,contract.getRemark());
			pstmt.setInt(11, contract.getArchitecture_id());
			pstmt.setInt(12,contract.getProject_id());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Contract> getAllContract(){
		List<Contract> list = new ArrayList<Contract>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from contract");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int contract_id = rs.getInt(1);
				 int contract_number = rs.getInt(2);
				 String contract_name = rs.getString(3);
				 String a_name = rs.getString(4);
				 String b_name = rs.getString(5);
				 String c_name = rs.getString(6);
				 Date sign_date =rs.getDate(7);
				 int contract_price=rs.getInt(8);
				 String contract_content = rs.getString(9);
				 String remark = rs.getString(10);
				 int architecture_id = rs.getInt(11);
				 int project_id = rs.getInt(12);
				
				Contract ctt = new Contract(contract_id, contract_number,contract_name,
						a_name,b_name,c_name, sign_date,
						 contract_price,contract_content, remark,
						 architecture_id,  project_id);
				list.add(ctt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int contract_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from contract where contract_id = ?");
			pstmt.setInt(1, contract_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Contract getById(int contract_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from contract where contract_id = ?");
			pstmt.setInt(1, contract_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 int contract_number = rs.getInt(2);
				 String contract_name = rs.getString(3);
				 String a_name = rs.getString(4);
				 String b_name = rs.getString(5);
				 String c_name = rs.getString(6);
				 Date sign_date =rs.getDate(7);
				 int contract_price=rs.getInt(8);
				 String contract_content = rs.getString(9);
				 String remark = rs.getString(10);
				 int architecture_id = rs.getInt(11);
				 int project_id = rs.getInt(12);
				
				Contract ctt = new Contract(contract_id, contract_number,contract_name,
						a_name,b_name,c_name, sign_date,
						 contract_price,contract_content, remark,
						 architecture_id,  project_id);
				return ctt;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateContract(Contract contract){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update contract set contract_number=?,contract_name=?,a_name=?," +
					"b_name=?,c_name=?,sign_date=?,contract_price=?,contract_content=?," +
					"remark=?,architecture_id=?,project_id=? where contract_id =?");
			pstmt.setInt(12, contract.getContract_id());
			pstmt.setInt(1,contract.getContract_number());
			pstmt.setString(2, contract.getContract_name());
			pstmt.setString(3,contract.getA_name());
			pstmt.setString(4,contract.getB_name());
			pstmt.setString(5, contract.getC_name());

			pstmt.setDate(6, contract.getSign_date());
			pstmt.setInt(7, contract.getContract_price());
			pstmt.setString(8,contract.getContract_content());
			pstmt.setString(9,contract.getRemark());
			pstmt.setInt(10, contract.getArchitecture_id());
			pstmt.setInt(11,contract.getProject_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Contract> queryAny(Contract contract){
		List<Contract> list = new ArrayList<Contract>();
		try {
			String sql = "SELECT * FROM contract WHERE 1=1";
			if(contract.getContract_name()!=null&&contract.getContract_name().equals("")==false){
				sql =sql +" AND contract_name like '%"+contract.getContract_name()+"%'"; 
			}
			//if(contract.getContract_price()!=null&&contract.getContract_price().equals("")==false){
				//sql =sql +" AND contract_price ='"+contract.getContract_price()+"'"; 
			//}
			if(contract.getA_name()!=null&&contract.getA_name().equals("")==false){
				sql =sql +" AND a_name ='"+contract.getA_name()+"'"; 
			}
			//if(contract.getContract_number()!=null&&contract.getContract_number().equals("")==false){
				//sql =sql +" AND contract_number ='"+contract.getContract_number()+"'"; 
			//}
			if(contract.getB_name()!=null&&contract.getB_name().equals("")==false){
				sql =sql +" AND b_name ='"+contract.getB_name()+"'"; 
			}
			if(contract.getSign_date()!=null&&contract.getSign_date().equals("")==false){
				sql =sql +" AND sign_date ='"+contract.getSign_date()+"'"; 
			}
			if(contract.getC_name()!=null&&contract.getC_name().equals("")==false){
				sql =sql +" AND c_name ='"+contract.getC_name()+"'"; 
			}
			if(contract.getContract_content()!=null&&contract.getContract_content().equals("")==false){
				sql =sql +" AND contract_content like '%"+contract.getContract_content()+"%'"; 
			}
			
//			System.out.print(sql);
			PreparedStatement pstmt = GetConn.getConn().prepareStatement(sql);
			//pstmt.setString(1, query_id);
			//pstmt.setString(1, query_name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int contract_id = rs.getInt(1);
				 int contract_number = rs.getInt(2);
				 String contract_name = rs.getString(3);
				 String a_name = rs.getString(4);
				 String b_name = rs.getString(5);
				 String c_name = rs.getString(6);
				 Date sign_date =rs.getDate(7);
				 int contract_price=rs.getInt(8);
				 String contract_content = rs.getString(9);
				 String remark = rs.getString(10);
				 int architecture_id = rs.getInt(11);
				 int project_id = rs.getInt(12);
				
				Contract ctt = new Contract(contract_id, contract_number,contract_name,
						a_name,b_name,c_name, sign_date,
						 contract_price,contract_content, remark,
						 architecture_id,  project_id);
				list.add(ctt);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String args[]){
		ContractDAO cttado = new ContractDAO();
		Contract ctt = new Contract();
//		ctt.setContract_id(5);
//		ctt.setContract_number(2);
		ctt.setContract_name("关于yyy的合同");
//		ctt.setA_name("李四");
//		ctt.setB_name("张三");
//		ctt.setC_name("赵六");
//		ctt.setSign_date(new Date(2006-10-20));
//		ctt.setContract_price(132233523);
//		ctt.setContract_content("项目内容");
//		ctt.setRemark("	2备注信息.22.");
//		ctt.setArchitecture_id(2);
//		ctt.setProject_id(2);
//		cttado.addContract(ctt);
//		List <Contract> list = new ContractDAO().getAllContract();
//		for(Contract ctt:list){
//			System.out.println(ctt.getContract_id()+","+ctt.getContract_name());
//		}
		
//		Contract pj = new ContractDAO().getById(1);
//		System.out.println(pj.getContract_id()+","+pj.getContract_name());
		
//		new ContractDAO().updateContract(ctt);
		
		List <Contract> list = new ContractDAO().queryAny(ctt);
		System.out.println("tt");
		for(Contract ctt_1:list){
			System.out.println(ctt_1.getContract_id()+",qqq"+ctt_1.getContract_name());
		}
		
	}
}
