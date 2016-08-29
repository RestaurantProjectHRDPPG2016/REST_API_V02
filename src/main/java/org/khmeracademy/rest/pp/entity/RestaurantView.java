package org.khmeracademy.rest.pp.entity;

public class RestaurantView {
	private int id;
	private int r_id;
	private int v_number;
	public RestaurantView(){
		
	}
	public RestaurantView(int id, int r_id, int v_number) {
		super();
		this.id = id;
		this.r_id = r_id;
		this.v_number = v_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getV_number() {
		return v_number;
	}
	public void setV_number(int v_number) {
		this.v_number = v_number;
	}
	
}
