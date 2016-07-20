package vo;

import java.sql.Date;

public class Finance {
	private int finance_id;
	private int finance_number;
	private Date finance_date;
	private String finance_abstract;
	private int money;
	private int borrow_subject_id;
	private int loan_subject_id;
	private int contract_id;
	private int payment_id;
	private int procurement_type_id;
	private int procurement_from_id;
	private int procurement_category_id;
	
	
	
	
	public Finance() {
		super();
	}
	public Finance(int finance_id, int finance_number, Date finance_date,
			String finance_abstract, int money, int borrow_subject_id,
			int loan_subject_id, int contract_id, int payment_id,
			int procurement_type_id, int procurement_from_id,
			int procurement_category_id) {
		super();
		this.finance_id = finance_id;
		this.finance_number = finance_number;
		this.finance_date = finance_date;
		this.finance_abstract = finance_abstract;
		this.money = money;
		this.borrow_subject_id = borrow_subject_id;
		this.loan_subject_id = loan_subject_id;
		this.contract_id = contract_id;
		this.payment_id = payment_id;
		this.procurement_type_id = procurement_type_id;
		this.procurement_from_id = procurement_from_id;
		this.procurement_category_id = procurement_category_id;
	}
	public int getFinance_id() {
		return finance_id;
	}
	public void setFinance_id(int finance_id) {
		this.finance_id = finance_id;
	}
	public int getFinance_number() {
		return finance_number;
	}
	public void setFinance_number(int finance_number) {
		this.finance_number = finance_number;
	}
	public Date getFinance_date() {
		return finance_date;
	}
	public void setFinance_date(Date finance_date) {
		this.finance_date = finance_date;
	}
	public String getFinance_abstract() {
		return finance_abstract;
	}
	public void setFinance_abstract(String finance_abstract) {
		this.finance_abstract = finance_abstract;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBorrow_subject_id() {
		return borrow_subject_id;
	}
	public void setBorrow_subject_id(int borrow_subject_id) {
		this.borrow_subject_id = borrow_subject_id;
	}
	public int getLoan_subject_id() {
		return loan_subject_id;
	}
	public void setLoan_subject_id(int loan_subject_id) {
		this.loan_subject_id = loan_subject_id;
	}
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getProcurement_type_id() {
		return procurement_type_id;
	}
	public void setProcurement_type_id(int procurement_type_id) {
		this.procurement_type_id = procurement_type_id;
	}
	public int getProcurement_from_id() {
		return procurement_from_id;
	}
	public void setProcurement_from_id(int procurement_from_id) {
		this.procurement_from_id = procurement_from_id;
	}
	public int getProcurement_category_id() {
		return procurement_category_id;
	}
	public void setProcurement_category_id(int procurement_category_id) {
		this.procurement_category_id = procurement_category_id;
	}
	
	
	
}
