package org.khmeracademy.rest.pp.entity;

import java.util.List;

public class Restaurant {
	private int id;
	private int sub_id;
	private String name;
	private String desc;
	private String delivery;
	private String home;
	private String street;
	private String type;
	private String district;
	private String commune;
	private List<Telephone> telephone;
	private List<Menu> menus;
	private List<Images> images;
	
	public Restaurant(){
		
	}
	public Restaurant(int id,int sub_id, String name, String desc,String delivery, String home, String street, String type, String district,
			String commune, String tel, String img, String menu) {
		super();
		this.id = id;
		this.sub_id = sub_id;
		this.name = name;
		this.desc = desc;
		this.delivery = delivery;
		this.home = home;
		this.street = street;
		this.type = type;
		this.district = district;
		this.commune = commune;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public List<Telephone> getTel() {
		return telephone;
	}
	public void setTel(List<Telephone> tel) {
		this.telephone = tel;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public List<Images> getImages() {
		return images;
	}
	public void setImages(List<Images> images) {
		this.images = images;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
		
}
