package vo;

import java.sql.Date;

public class Asset {
	private int asset_id;
	private int asset_number;
	private String asset_name;
	private String asset_spect;
	private String asset_type;
	private int asset_price;
	private int asset_count;
	private int money;
	private Date buy_date;
	private String buyer;
	private String department_name;
	private String remark;
	
	
	
	
	
	public Asset() {
		super();
	}


	public Asset(int asset_id, int asset_number, String asset_name,
			String asset_spect, String asset_type, int asset_price,
			int asset_count, int money, Date buy_date, String buyer,
			String department_name, String remark) {
		super();
		this.asset_id = asset_id;
		this.asset_number = asset_number;
		this.asset_name = asset_name;
		this.asset_spect = asset_spect;
		this.asset_type = asset_type;
		this.asset_price = asset_price;
		this.asset_count = asset_count;
		this.money = money;
		this.buy_date = buy_date;
		this.buyer = buyer;
		this.department_name = department_name;
		this.remark = remark;
	}
	
	
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public int getAsset_number() {
		return asset_number;
	}
	public void setAsset_number(int asset_number) {
		this.asset_number = asset_number;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getAsset_spect() {
		return asset_spect;
	}
	public void setAsset_spect(String asset_spect) {
		this.asset_spect = asset_spect;
	}
	public String getAsset_type() {
		return asset_type;
	}
	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}
	public int getAsset_price() {
		return asset_price;
	}
	public void setAsset_price(int asset_price) {
		this.asset_price = asset_price;
	}
	public int getAsset_count() {
		return asset_count;
	}
	public void setAsset_count(int asset_count) {
		this.asset_count = asset_count;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
