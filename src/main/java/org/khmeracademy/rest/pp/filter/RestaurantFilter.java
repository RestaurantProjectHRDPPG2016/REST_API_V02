package org.khmeracademy.rest.pp.filter;

public class RestaurantFilter {
	private int id;
	private int c_id;
	private int name;
	private int province;
	private int type_id;
	public RestaurantFilter(int id, int c_id, int name, int province, int type_id) {
		super();
		this.id = id;
		this.c_id = c_id;
		this.name = name;
		this.province = province;
		this.type_id = type_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	@Override
	public String toString() {
		return "RestaurantFilter [id=" + id + ", c_id=" + c_id + ", name=" + name + ", province=" + province
				+ ", type_id=" + type_id + "]";
	}
}
