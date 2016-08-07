package org.khmeracademy.rest.pp.entity;

public class RestType {
	private int id;
	private String name;
	public RestType(){
		
	}
	public RestType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
