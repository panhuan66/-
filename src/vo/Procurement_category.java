package vo;

public class Procurement_category {
	private int procurement_category_id;
	private int procurement_category_number;
	private String procurement_category_name;
	private int edition_id;
	
	
	public Procurement_category() {
		super();
	}


	public Procurement_category(int procurement_category_id,
			int procurement_category_number, String procurement_category_name,
			int edition_id) {
		super();
		this.procurement_category_id = procurement_category_id;
		this.procurement_category_number = procurement_category_number;
		this.procurement_category_name = procurement_category_name;
		this.edition_id = edition_id;
	}


	public int getProcurement_category_id() {
		return procurement_category_id;
	}


	public void setProcurement_category_id(int procurement_category_id) {
		this.procurement_category_id = procurement_category_id;
	}


	public int getProcurement_category_number() {
		return procurement_category_number;
	}


	public void setProcurement_category_number(int procurement_category_number) {
		this.procurement_category_number = procurement_category_number;
	}


	public String getProcurement_category_name() {
		return procurement_category_name;
	}


	public void setProcurement_category_name(String procurement_category_name) {
		this.procurement_category_name = procurement_category_name;
	}


	public int getEdition_id() {
		return edition_id;
	}


	public void setEdition_id(int edition_id) {
		this.edition_id = edition_id;
	}
	
	
}
