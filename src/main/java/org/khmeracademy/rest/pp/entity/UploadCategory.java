package org.khmeracademy.rest.pp.entity;

public class UploadCategory {
	private int id;
	private int t_id;
	private String name;
	private String img1;
	private String img2;
	public UploadCategory(int id, int t_id, String name, String img1, String img2) {
		super();
		this.id = id;
		this.t_id = t_id;
		this.name = name;
		this.img1 = img1;
		this.img2 = img2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	@Override
	public String toString() {
		return "UploadCategory [id=" + id + ", t_id=" + t_id + ", name=" + name + ", img1=" + img1 + ", img2=" + img2
				+ "]";
	}
	
}
