package vo;

import java.sql.Date;

public class Contract {
	private int contract_id;
	private int contract_number;
	private String contract_name;
	private String a_name;
	private String b_name;
	private String c_name;
	private Date sign_date;
	private int contract_price;
	private String contract_content;
	private String remark;
	private int architecture_id;
	private int project_id;
	
	
	public Contract() {
		super();
	}

	public Contract(int contract_id, int contract_number, String contract_name,
			String a_name, String b_name, String c_name, Date sign_date,
			int contract_price, String contract_content, String remark,
			int architecture_id, int project_id) {
		super();
		this.contract_id = contract_id;
		this.contract_number = contract_number;
		this.contract_name = contract_name;
		this.a_name = a_name;
		this.b_name = b_name;
		this.c_name = c_name;
		this.sign_date = sign_date;
		this.contract_price = contract_price;
		this.contract_content = contract_content;
		this.remark = remark;
		this.architecture_id = architecture_id;
		this.project_id = project_id;
	}
	
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public int getContract_number() {
		return contract_number;
	}
	public void setContract_number(int contract_number) {
		this.contract_number = contract_number;
	}
	public String getContract_name() {
		return contract_name;
	}
	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Date getSign_date() {
		return sign_date;
	}
	public void setSign_date(Date sign_date) {
		this.sign_date = sign_date;
	}
	public int getContract_price() {
		return contract_price;
	}
	public void setContract_price(int contract_price) {
		this.contract_price = contract_price;
	}
	public String getContract_content() {
		return contract_content;
	}
	public void setContract_content(String contract_content) {
		this.contract_content = contract_content;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getArchitecture_id() {
		return architecture_id;
	}
	public void setArchitecture_id(int architecture_id) {
		this.architecture_id = architecture_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
	
}
