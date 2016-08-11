package org.khmeracademy.rest.pp.entity;

public class Images {
	private int id;
	private int r_id;
	private String url;
	
	public Images(){
		
	}
	public Images(int id, int r_id, String url,String projectPath,String serverPath,String message) {
		this.id = id;
		this.r_id = r_id;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
