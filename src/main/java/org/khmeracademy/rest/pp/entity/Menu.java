package org.khmeracademy.rest.pp.entity;
public class Menu {
	private int id;
	private int r_id;
	private String name;
	private String url;
	public Menu(){
		
	}
	public Menu(int id, int r_id, String name, String url) {
		super();
		this.id = id;
		this.r_id = r_id;
		this.name = name;
		this.url = url;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
