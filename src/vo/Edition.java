package vo;

import java.sql.Date;

public class Edition {
	private int edition_id;
	private Date edition_year; 
	private String valid;
	private int edition_type;
	
	
	public Edition() {
		super();
	}


	public Edition(int edition_id, Date edition_year, String valid,
			int edition_type) {
		super();
		this.edition_id = edition_id;
		this.edition_year = edition_year;
		this.valid = valid;
		this.edition_type = edition_type;
	}


	public int getEdition_id() {
		return edition_id;
	}


	public void setEdition_id(int edition_id) {
		this.edition_id = edition_id;
	}


	public Date getEdition_year() {
		return edition_year;
	}


	public void setEdition_year(Date edition_year) {
		this.edition_year = edition_year;
	}


	public String getValid() {
		return valid;
	}


	public void setValid(String valid) {
		this.valid = valid;
	}


	public int getEdition_type() {
		return edition_type;
	}


	public void setEdition_type(int edition_type) {
		this.edition_type = edition_type;
	}
	
	
	
}
