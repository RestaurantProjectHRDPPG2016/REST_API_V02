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
	private String province;
	private String district;
	private String commune;
	private String latitude;
	private String longitude;
	private String create_date;
	private List<Telephone> telephone;
	private List<Menu> menus;
	private List<Images> images;
	private int views;
	
	public Restaurant(){
		
	}
	

	public Restaurant(int id, int sub_id, String name, String desc, String delivery, String home, String street,
			String type, String province, String district, String commune, String latitude, String longitude,
			String create_date, List<Telephone> telephone, List<Menu> menus, List<Images> images,int views) {
		super();
		this.id = id;
		this.sub_id = sub_id;
		this.name = name;
		this.desc = desc;
		this.delivery = delivery;
		this.home = home;
		this.street = street;
		this.type = type;
		this.province = province;
		this.district = district;
		this.commune = commune;
		this.latitude = latitude;
		this.longitude = longitude;
		this.create_date = create_date;
		this.telephone = telephone;
		this.menus = menus;
		this.images = images;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
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

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
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

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", sub_id=" + sub_id + ", name=" + name + ", desc=" + desc + ", delivery="
				+ delivery + ", home=" + home + ", street=" + street + ", type=" + type + ", province=" + province
				+ ", district=" + district + ", commune=" + commune + ", latitude=" + latitude + ", longitude="
				+ longitude + ", create_date=" + create_date + ", telephone=" + telephone + ", menus=" + menus
				+ ", images=" + images + ", getId()=" + getId() + ", getSub_id()=" + getSub_id() + ", getName()="
				+ getName() + ", getDesc()=" + getDesc() + ", getDelivery()=" + getDelivery() + ", getHome()="
				+ getHome() + ", getStreet()=" + getStreet() + ", getType()=" + getType() + ", getProvince()="
				+ getProvince() + ", getDistrict()=" + getDistrict() + ", getCommune()=" + getCommune()
				+ ", getLatitude()=" + getLatitude() + ", getLongitude()=" + getLongitude() + ", getCreate_date()="
				+ getCreate_date() + ", getTelephone()=" + getTelephone() + ", getMenus()=" + getMenus()
				+ ", getImages()=" + getImages() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
		
}
