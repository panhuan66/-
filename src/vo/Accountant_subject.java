package vo;

public class Accountant_subject {
	private int accountant_subject_id;
	private int accountant_subject_number;
	private String accountant_subject_name;
	
	public Accountant_subject() {
		super();
	}
	
	public Accountant_subject(int accountant_subject_id,
			int accountant_subject_number, String accountant_subject_name) {
		super();
		this.accountant_subject_id = accountant_subject_id;
		this.accountant_subject_number = accountant_subject_number;
		this.accountant_subject_name = accountant_subject_name;
	}
	
	public int getAccountant_subject_id() {
		return accountant_subject_id;
	}
	public void setAccountant_subject_id(int accountant_subject_id) {
		this.accountant_subject_id = accountant_subject_id;
	}
	public int getAccountant_subject_number() {
		return accountant_subject_number;
	}
	public void setAccountant_subject_number(int accountant_subject_number) {
		this.accountant_subject_number = accountant_subject_number;
	}
	public String getAccountant_subject_name() {
		return accountant_subject_name;
	}
	public void setAccountant_subject_name(String accountant_subject_name) {
		this.accountant_subject_name = accountant_subject_name;
	}
	
	
}
