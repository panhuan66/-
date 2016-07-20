package vo;

public class Payment {
	private int payment_id;
	private int payment_number;
	private String payment_name;
	private int edition_id;
	
	public Payment() {
		super();
	}

	public Payment(int payment_id, int payment_number, String payment_name,
			int edition_id) {
		super();
		this.payment_id = payment_id;
		this.payment_number = payment_number;
		this.payment_name = payment_name;
		this.edition_id = edition_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getPayment_number() {
		return payment_number;
	}

	public void setPayment_number(int payment_number) {
		this.payment_number = payment_number;
	}

	public String getPayment_name() {
		return payment_name;
	}

	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}

	public int getEdition_id() {
		return edition_id;
	}

	public void setEdition_id(int edition_id) {
		this.edition_id = edition_id;
	}
	
	
	
}
