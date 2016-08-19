package org.khmeracademy.rest.pp.entity;

public class Slide {
	private int s_id;
	private String name;
	private String description;
	private String status;
	private String url;
	
	public Slide(){
		
	}

	public Slide(int s_id, String name, String description, String status, String url) {
		super();
		this.s_id = s_id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.url = url;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
