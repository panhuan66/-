package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConn;
import vo.Project;

public class ProjectDAO {
	public void addProject(Project project){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select project_idseq.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			int project_idseq = 0;
			if(rs.next()){
				project_idseq = rs.getInt(1);
			}
			pstmt = GetConn.getConn().prepareStatement("insert into project values(?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, project_idseq);
			pstmt.setString(2,project.getProject_name());
			pstmt.setString(3, project.getDepartment_name());
			pstmt.setString(4,project.getResponsibility_name());
			pstmt.setString(5,project.getBudget());
			pstmt.setDate(6, project.getStart_date());

			pstmt.setString(7, project.getRemark());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Project> getAllProject(){
		List<Project> list = new ArrayList<Project>();
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from project");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int pj_id = rs.getInt(1);
				String pj_name=rs.getString(2);
				String pj_dep_name = rs.getString(3);
				String pj_rsp_name = rs.getString(4);
				String pj_bdg = rs.getString(5);
				Date pj_date = rs.getDate(6);
				String pj_remark = rs.getString(7);
				
				Project pj = new Project(pj_id,pj_name,pj_dep_name,pj_rsp_name,pj_bdg,pj_date,pj_remark);
				list.add(pj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteById(int project_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("delete from project where project_id = ?");
			pstmt.setInt(1, project_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Project getById(int project_id){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement("select * from project where project_id = ?");
			pstmt.setInt(1, project_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int pj_id = rs.getInt(1);
				String pj_name=rs.getString(2);
				String pj_dep_name = rs.getString(3);
				String pj_rsp_name = rs.getString(4);
				String pj_bdg = rs.getString(5);
				Date pj_date = rs.getDate(6);
				String pj_remark = rs.getString(7);
				Project pj = new Project(pj_id,pj_name,pj_dep_name,pj_rsp_name,pj_bdg,pj_date,pj_remark);
				return pj;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProject(Project pj){
		try {
			PreparedStatement pstmt = GetConn.getConn().prepareStatement( 
					"update project set project_name=?,department_name=?," +
					"responsibility_name=?,budget=?,start_date=?,remark=? where project_id =?");
			pstmt.setInt(7, pj.getProject_id());
			pstmt.setString(1,pj.getProject_name());
			pstmt.setString(2,pj.getDepartment_name());
			pstmt.setString(3,pj.getResponsibility_name());
			pstmt.setString(4,pj.getBudget());
			pstmt.setDate(5,pj.getStart_date());
			pstmt.setString(6,pj.getRemark());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Project> queryAny(Project project){
		List<Project> list = new ArrayList<Project>();
		try {
			String sql = "SELECT * FROM project WHERE 1=1";
			if(project.getProject_name()!=null&&project.getProject_name().equals("")==false){
				sql =sql +" AND project_name like '%"+project.getProject_name()+"%'"; 
			}
			if(project.getStart_date()!=null&&project.getStart_date().equals("")==false){
				sql =sql +" AND start_date like '%"+project.getStart_date()+"%'"; 
			}
			if(project.getDepartment_name()!=null&&project.getDepartment_name().equals("")==false){
				sql =sql +" AND department_name like '%"+project.getDepartment_name()+"%'"; 
			}
			if(project.getResponsibility_name()!=null&&project.getResponsibility_name().equals("")==false){
				sql =sql +" AND responsibility_name like '%"+project.getResponsibility_name()+"%'"; 
			}
			System.out.print(sql);
			PreparedStatement pstmt = GetConn.getConn().prepareStatement(sql);
			//pstmt.setString(1, query_id);
			//pstmt.setString(1, query_name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int pj_id = rs.getInt(1);
				String pj_name=rs.getString(2);
				String pj_dep_name = rs.getString(3);
				String pj_rsp_name = rs.getString(4);
				String pj_bdg = rs.getString(5);
				Date pj_date = rs.getDate(6);
				String pj_remark = rs.getString(7);
				Project pj = new Project(pj_id,pj_name,pj_dep_name,pj_rsp_name,pj_bdg,pj_date,pj_remark);
				list.add(pj);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String args[]){
		
		
		
		ProjectDAO pjado = new ProjectDAO();
		Project pj = new Project();
//		pj.setProject_id(6);
		pj.setProject_name("关于yyy的项目");
//		pj.setDepartment_name("部门B");
//		pj.setResponsibility_name("李四");
//		pj.setBudget("1073232.20");
//		pj.setStart_date(new Date(2006-12-21));
//		pj.setRemark("22备注信息22.");
		//pjado.addProject(pj);
		
/*		List <Project> list = new ProjectDAO().getAllProject();
		for(Project pj:list){
			System.out.println(pj.getProject_id()+","+pj.getProject_name());
		}*/
		
/*		Project pj = new ProjectDAO().getById(1);
		System.out.println(pj.getProject_id()+","+pj.getProject_name());*/
		
//		new ProjectDAO().updateProject(pj);
		
		List <Project> list = new ProjectDAO().queryAny(pj);
		for(Project pj_1:list){
			System.out.println(pj_1.getProject_id()+","+pj_1.getProject_name());
		}
		
	}
}
