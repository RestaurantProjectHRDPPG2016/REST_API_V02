package org.khmeracademy.rest.pp.entity;

public class Restaurant {
	private int id;
	private String name;
	private String desc;
	private String delivery;
	private String home;
	private String street;
	private String type;
	private String district;
	private String commune;
	private String tel;
	private String img;
	private String menu;
	public Restaurant(){
		
	}
	public Restaurant(int id, String name, String desc,String delivery, String home, String street, String type, String district,
			String commune, String tel, String img, String menu) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.delivery = delivery;
		this.home = home;
		this.street = street;
		this.type = type;
		this.district = district;
		this.commune = commune;
		this.tel = tel;
		this.img = img;
		this.menu = menu;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
}
