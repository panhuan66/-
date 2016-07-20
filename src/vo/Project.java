package vo;

import java.sql.Date;

public class Project {
	private int project_id;
	private String project_name;
	private String department_name;
	private String responsibility_name;
	private String budget;
	private Date start_date;
	private String remark;
	
	
	public Project() {
		super();
	}


	public Project(int project_id, String project_name, String department_name,
			String responsibility_name, String budget, Date start_date,
			String remark) {
		super();
		this.project_id = project_id;
		this.project_name = project_name;
		this.department_name = department_name;
		this.responsibility_name = responsibility_name;
		this.budget = budget;
		this.start_date = start_date;
		this.remark = remark;
	}
	
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getResponsibility_name() {
		return responsibility_name;
	}
	public void setResponsibility_name(String responsibility_name) {
		this.responsibility_name = responsibility_name;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
