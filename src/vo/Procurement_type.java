package vo;

public class Procurement_type {
	private int procurement_type_id;
	private int procurement_type_number;
	private String procurement_type_name;
	private int edition_id;
	
	
	public Procurement_type() {
		super();
	}


	public Procurement_type(int procurement_type_id,
			int procurement_type_number, String procurement_type_name,
			int edition_id) {
		super();
		this.procurement_type_id = procurement_type_id;
		this.procurement_type_number = procurement_type_number;
		this.procurement_type_name = procurement_type_name;
		this.edition_id = edition_id;
	}


	public int getProcurement_type_id() {
		return procurement_type_id;
	}


	public void setProcurement_type_id(int procurement_type_id) {
		this.procurement_type_id = procurement_type_id;
	}


	public int getProcurement_type_number() {
		return procurement_type_number;
	}


	public void setProcurement_type_number(int procurement_type_number) {
		this.procurement_type_number = procurement_type_number;
	}


	public String getProcurement_type_name() {
		return procurement_type_name;
	}


	public void setProcurement_type_name(String procurement_type_name) {
		this.procurement_type_name = procurement_type_name;
	}


	public int getEdition_id() {
		return edition_id;
	}


	public void setEdition_id(int edition_id) {
		this.edition_id = edition_id;
	}
	
	
}
