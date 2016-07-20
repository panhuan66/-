package vo;

import java.sql.Date;

public class Document {
	private int document_id;
	private int document_number;
	private String document_file;
	private Date upload_date;
	private String responsibility_name;
	private String remark;
	private int project_id;
	private int contract_id;
	
	
	
	public Document() {
		super();
	}

	public Document(int document_id, int document_number, String document_file,
			Date upload_date, String responsibility_name, String remark,
			int project_id, int contract_id) {
		super();
		this.document_id = document_id;
		this.document_number = document_number;
		this.document_file = document_file;
		this.upload_date = upload_date;
		this.responsibility_name = responsibility_name;
		this.remark = remark;
		this.project_id = project_id;
		this.contract_id = contract_id;
	}

	public int getDocument_id() {
		return document_id;
	}

	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}

	public int getDocument_number() {
		return document_number;
	}

	public void setDocument_number(int document_number) {
		this.document_number = document_number;
	}

	public String getDocument_file() {
		return document_file;
	}

	public void setDocument_file(String document_file) {
		this.document_file = document_file;
	}

	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}

	public String getResponsibility_name() {
		return responsibility_name;
	}

	public void setResponsibility_name(String responsibility_name) {
		this.responsibility_name = responsibility_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int getContract_id() {
		return contract_id;
	}

	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	
	
	
}
