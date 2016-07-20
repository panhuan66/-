package vo;

public class Architecture {
	private int architecture_id;
	private int architecture_number;
	private String architecture_name;
	
	
	
	
	public Architecture() {
		super();
	}
	public Architecture(int architecture_id, int architecture_number,
			String architecture_name) {
		super();
		this.architecture_id = architecture_id;
		this.architecture_number = architecture_number;
		this.architecture_name = architecture_name;
	}
	public int getArchitecture_id() {
		return architecture_id;
	}
	public void setArchitecture_id(int architecture_id) {
		this.architecture_id = architecture_id;
	}
	public int getArchitecture_number() {
		return architecture_number;
	}
	public void setArchitecture_number(int architecture_number) {
		this.architecture_number = architecture_number;
	}
	public String getArchitecture_name() {
		return architecture_name;
	}
	public void setArchitecture_name(String architecture_name) {
		this.architecture_name = architecture_name;
	}
	
	
	
}
