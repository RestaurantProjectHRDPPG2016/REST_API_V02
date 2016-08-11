package org.khmeracademy.rest.pp.entity;

import java.util.List;

public class Product {
	private int id;
	private int r_id;
	private String name;
	private String detail;
	private double price;
	private String date;
	private String video;
	private List<ProImage> proImage;
	private List<ProType> proType;
	public Product(){
		
	}
	public Product(int id, int r_id, String name, String detail, double price, String date, String video,
			List<ProImage> proImage, List<ProType> proType) {
		super();
		this.id = id;
		this.r_id = r_id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.date = date;
		this.video = video;
		this.proImage = proImage;
		this.proType = proType;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public List<ProImage> getProImage() {
		return proImage;
	}
	public void setProImage(List<ProImage> proImage) {
		this.proImage = proImage;
	}
	public List<ProType> getProType() {
		return proType;
	}
	public void setProType(List<ProType> proType) {
		this.proType = proType;
	}
	
}
