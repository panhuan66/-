package vo;

public class Procurement_form {
	private int procurement_form_id;
	private int procurement_form_number;
	private String procurement_form_name;
	private int edition_id;
	
	public Procurement_form() {
		super();
	}
	
	public Procurement_form(int procurement_form_id, int procurement_form_number,
			String procurement_form_name, int edition_id) {
		super();
		this.procurement_form_id = procurement_form_id;
		this.procurement_form_number = procurement_form_number;
		this.procurement_form_name = procurement_form_name;
		this.edition_id = edition_id;
	}
	
	public int getProcurement_form_id() {
		return procurement_form_id;
	}
	public void setProcurement_form_id(int procurement_form_id) {
		this.procurement_form_id = procurement_form_id;
	}
	public int getProcurement_form_number() {
		return procurement_form_number;
	}
	public void setProcurement_form_number(int procurement_form_number) {
		this.procurement_form_number = procurement_form_number;
	}
	public String getProcurement_form_name() {
		return procurement_form_name;
	}
	public void setProcurement_form_name(String procurement_form_name) {
		this.procurement_form_name = procurement_form_name;
	}
	public int getEdition_id() {
		return edition_id;
	}
	public void setEdition_id(int edition_id) {
		this.edition_id = edition_id;
	}
	
	
}
