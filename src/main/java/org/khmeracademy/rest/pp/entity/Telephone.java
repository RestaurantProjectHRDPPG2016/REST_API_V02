package org.khmeracademy.rest.pp.entity;

public class Telephone {
	private int id;
	private int r_id;
	private String tel;
	private Telephone(){
		
	}
	public Telephone(int id, int r_id, String tel) {
		super();
		this.id = id;
		this.r_id = r_id;
		this.tel = tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
