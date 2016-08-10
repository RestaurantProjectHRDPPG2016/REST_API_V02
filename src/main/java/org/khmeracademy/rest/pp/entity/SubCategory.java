package org.khmeracademy.rest.pp.entity;

public class SubCategory {
	private int id;
	private int s_id;
	private String name;
	private String img;
	public SubCategory(){
		
	}
	public SubCategory(int id, int s_id, String name, String img) {
		super();
		this.id = id;
		this.s_id = s_id;
		this.name = name;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
