package org.khmeracademy.rest.pp.filter;

public class RestaurantFilter {
	private int id;
	private String c_id;
	private String name;
	private String province;
	private String type_id;
	
	public RestaurantFilter(){
		name = "";
		c_id = "";
		type_id = "";
		province ="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	@Override
	public String toString() {
		return "RestaurantFilter [id=" + id + ", c_id=" + c_id + ", name=" + name + ", province=" + province
				+ ", type_id=" + type_id + "]";
	}
	
}
