package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConn {
	public static Connection getConn(){
		//1.ע������,���������������
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.��ȡ����
 			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String username = "scott";
			String password = "student"; 
			
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/sp";
//			String username = "root";
//			String password = "123456";
			//System.out.print("111111111");
			Connection conn = DriverManager.getConnection(url, username, password);
//			System.out.print("111111111"+conn);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public static void main(String args[]){
		System.out.print("123"+GetConn.getConn());
	}
}
