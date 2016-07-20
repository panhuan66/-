package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Asset;
import vo.Project;

public class AssetDAO {
	public void addAsset(Asset asset){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select asset_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int asset_idseq = 0;
			if(rs.next()){
				asset_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into asset values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, asset_idseq);
			pstmt.setInt(2,asset.getAsset_number());
			pstmt.setString(3, asset.getAsset_name());
			pstmt.setString(4,asset.getAsset_spect());
			pstmt.setString(5,asset.getAsset_type());
			pstmt.setInt(6,asset.getAsset_price());
			pstmt.setInt(7,asset.getAsset_count());
			pstmt.setInt(8,asset.getMoney());
			pstmt.setDate(9, asset.getBuy_date());

			pstmt.setString(10, asset.getBuyer());
			pstmt.setString(11,asset.getDepartment_name());
			pstmt.setString(12,asset.getRemark());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Asset> getAllAsset(){
		List<Asset> list = new ArrayList<Asset>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from asset");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int asset_id = rs.getInt(1);
				 int asset_number = rs.getInt(2);
				 String asset_name = rs.getString(3);
				 String asset_spect = rs.getString(4);
				 String asset_type = rs.getString(5);
				 int asset_price = rs.getInt(6);
				 int asset_count = rs.getInt(7);
				 int money = rs.getInt(8);
				 Date buy_date= rs.getDate(9);
				 String buyer= rs.getString(10);
				 String department_name= rs.getString(11);
				 String remark= rs.getString(12);
				
				
				Asset as = new Asset( asset_id,  asset_number,  asset_name,
						 asset_spect,  asset_type,  asset_price,
						 asset_count,  money,  buy_date,  buyer,
						 department_name,  remark);
				list.add(as);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int asset_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from asset where asset_id = ?");
			pstmt.setInt(1, asset_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Asset getById(int asset_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from asset where asset_id = ?");
			pstmt.setInt(1, asset_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 
				 int asset_number = rs.getInt(2);
				 String asset_name = rs.getString(3);
				 String asset_spect = rs.getString(4);
				 String asset_type = rs.getString(5);
				 int asset_price = rs.getInt(6);
				 int asset_count = rs.getInt(7);
				 int money = rs.getInt(8);
				 Date buy_date= rs.getDate(9);
				 String buyer= rs.getString(10);
				 String department_name= rs.getString(11);
				 String remark= rs.getString(12);
				
				
				Asset as = new Asset( asset_id,  asset_number,  asset_name,
						 asset_spect,  asset_type,  asset_price,
						 asset_count,  money,  buy_date,  buyer,
						 department_name,  remark);
				return as;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateAsset(Asset as){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update asset set asset_number=?,asset_name=?,asset_spect=?," +
					"asset_type=?,asset_price=?,asset_count=?,money=?," +
					"buy_date=?,buyer=?,department_name=?,remark=? where asset_id =?");
			pstmt.setInt(12, as.getAsset_id());
			pstmt.setInt(1, as.getAsset_number());
			pstmt.setString(2,as.getAsset_name());
			pstmt.setString(3,as.getAsset_spect());
			pstmt.setString(4,as.getAsset_type());
			pstmt.setInt(5, as.getAsset_price());
			pstmt.setInt(6, as.getAsset_count());
			pstmt.setInt(7, as.getMoney());
			
			pstmt.setDate(8,as.getBuy_date());
			pstmt.setString(9,as.getBuyer());
			pstmt.setString(10,as.getDepartment_name());
			pstmt.setString(11,as.getRemark());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Asset> queryAny(Asset asset){
		List<Asset> list = new ArrayList<Asset>();
		try {
			String sql = "SELECT * FROM asset WHERE 1=1";
			if(asset.getAsset_name()!=null&&asset.getAsset_name().equals("")==false){
				sql =sql +" AND asset_name like '%"+asset.getAsset_name()+"%'"; 
			}
			if(asset.getAsset_spect()!=null&&asset.getAsset_spect().equals("")==false){
				sql =sql +" AND asset_spect like '%"+asset.getAsset_spect()+"%'"; 
			}
			if(asset.getAsset_type()!=null&&asset.getAsset_type().equals("")==false){
				sql =sql +" AND asset_type like '%"+asset.getAsset_type()+"%'"; 
			}
			//if(asset.getAsset_count()!=null&&asset.getAsset_count().equals("")==false){
				//sql =sql +" AND asset_count ='"+asset.getAsset_count()+"'"; 
			//}
			//if(asset.getAsset_price()!=null&&asset.getAsset_price().equals("")==false){
				//sql =sql +" AND asset_price ='"+asset.getAsset_price()+"'"; 
			//}
			//if(asset.getMoney()!=null&&asset.getMoney().equals("")==false){
				//sql =sql +" AND money ='"+asset.getMoney()+"'"; 
			//}
			if(asset.getBuy_date()!=null&&asset.getBuy_date().equals("")==false){
				sql =sql +" AND buy_date ='"+asset.getBuy_date()+"'"; 
			}
			if(asset.getBuyer()!=null&&asset.getBuyer().equals("")==false){
				sql =sql +" AND buyer like '%"+asset.getBuyer()+"%'"; 
			}
			if(asset.getDepartment_name()!=null&&asset.getDepartment_name().equals("")==false){
				sql =sql +" AND department_name like '%"+asset.getDepartment_name()+"%'"; 
			}
			//if(asset.getAsset_number()!=null&&asset.getAsset_number().equals("")==false){
				//sql =sql +" AND asset_number ='"+asset.getAsset_number()+"'"; 
			//}
			
//			System.out.print(sql);
			PreparedStatement pstmt = GetConn.getConn().prepareStatement(sql);
			//pstmt.setString(1, query_id);
			//pstmt.setString(1, query_name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 int asset_id = rs.getInt(1);
				 int asset_number = rs.getInt(2);
				 String asset_name = rs.getString(3);
				 String asset_spect = rs.getString(4);
				 String asset_type = rs.getString(5);
				 int asset_price = rs.getInt(6);
				 int asset_count = rs.getInt(7);
				 int money = rs.getInt(8);
				 Date buy_date= rs.getDate(9);
				 String buyer= rs.getString(10);
				 String department_name= rs.getString(11);
				 String remark= rs.getString(12);
				
				
				Asset as = new Asset( asset_id,  asset_number,  asset_name,
						 asset_spect,  asset_type,  asset_price,
						 asset_count,  money,  buy_date,  buyer,
						 department_name,  remark);
				list.add(as);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String args[]){
		AssetDAO asado = new AssetDAO();
		Asset as = new Asset();
//		as.setAsset_id(2);
//		as.setAsset_number(2);
		as.setAsset_name("资产名称B");
		as.setAsset_spect("规格b");
//		as.setAsset_type("型号y");
//		as.setAsset_price(7);
//		as.setAsset_count(1350);
//		as.setMoney(7495);
//		as.setBuy_date(new Date(2006-12-21));
//		as.setBuyer("李四");
//		as.setDepartment_name("BBB部门");
//		as.setAsset_type("备注信息..");
		//asado.addAsset(as);
		
//		List <Asset> list = new AssetDAO().getAllAsset();
//		for(Asset as:list){
//			System.out.println(as.getAsset_id()+","+as.getAsset_name());
//		}
		
//		Asset as = new AssetDAO().getById(1);
//		System.out.println(as.getAsset_id()+","+as.getAsset_name());
		
//		new AssetDAO().updateAsset(as);
		
		List <Asset> list = new AssetDAO().queryAny(as);
		for(Asset as_1:list){
			System.out.println(as_1.getAsset_id()+","+as_1.getAsset_name());
		}
		
		
	}
}
