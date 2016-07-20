package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.User;

public class UserDAO {
	//验证用户名和密码，正确返回true,否则返回false
	public boolean getCheck(String name,String ps){
		try {
			
			Connection conn = GetConn.getConn();
			
			//3.发送sql语句的载体
			PreparedStatement pstmt = conn.prepareStatement("select * from users where email=? and password =?");
			//设置？的值
			pstmt.setString(1,name);
			pstmt.setString(2,ps);
			//执行  select的方法,把数据放在到ResultSet中
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}else{
				System.out.print("1");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.print("123");
			return false;
		}
		//return false;
	}
	public boolean addUser(User user){
		try {
			String useremail = user.getEmail();
			System.out.print("123"+useremail);
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from users where email = ?");
			pstmt.setString(1, user.getEmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return false;
			}
			
			pstmt = GetConn.getConn().prepareStatement("insert into users values(?,?)");
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPs());
			pstmt.executeUpdate();
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getEmail(String email) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from users where email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
//	public List<User> getAllUser(){
//		List<User> list = new ArrayList<User>();
//		try {
//			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from users");
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				int uid = rs.getInt(1);
//				String name = rs.getString(2);
//				String ps = rs.getString(3);
//				String address = rs.getString(4);
//				String email = rs.getString(5);
//				
//				User user = new User(uid,name,ps,address,email);
//				list.add(user);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
//	public void deleteUser(int userid){
//		try {
//			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from users where userid = ?");
//			pstmt.setInt(1, userid);
//			pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	public User getById(int userid){
//		PreparedStatement pstmt;
//		try {
//			pstmt = GetConn.getConn().prepareStatement("select * from users where userid=?");
//			//设置？的值
//			pstmt.setInt(1,userid);
//			//执行  select的方法,把数据放在到ResultSet中
//			
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()){
//				int uid = rs.getInt(1);
//				String name = rs.getString(2);
//				String ps = rs.getString(3);
//				String address = rs.getString(4);
//				String email = rs.getString(5);
//				User user = new User(uid,name,ps,address,email);
//				return user;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public void updateUser(User user){
//		PreparedStatement pstmt;
//		try {
//			pstmt = GetConn.getConn().prepareStatement("update users set name=?,ps=?,address=?,email=? where userid = ?");
//			//设置？的值
//			
//			pstmt.setString(1, user.getName());
//			pstmt.setString(2, user.getPs());
//			pstmt.setString(3, user.getAddress());
//			pstmt.setString(4, user.getEmail());
//			pstmt.setInt(5,user.getUserid());
//			pstmt.executeUpdate();
//			//执行  select的方法,把数据放在到ResultSet中
//			//ResultSet rs = pstmt.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	public static void main(String args[]){
		//boolean b = new UserDAO().getCheck("user","123");
		//System.out.print(b);
		User user = new User();
		user.setEmail("2124404@qq.com");
		user.setPs("123");
//		new UserDAO().updateUser(user);
//		new UserDAO().addUser(user);
		System.out.println(new UserDAO().getEmail(user.getEmail())+"end");
		/*List<User> list = new UserDAO().getAllUser();
		for(User user:list){
			System.out.println(user.getUserid()+","+user.getName());
		}*/
		
		//new UserDAO().deleteUser(41);
		//User user = new UserDAO().getById(3);
		//System.out.println(user.getUserid()+","+user.getName());
		
	}

}
