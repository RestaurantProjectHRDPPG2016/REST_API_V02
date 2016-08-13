package org.khmeracademy.rest.pp.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadRest {
	private String name;
	private String description;
	private String delivery;
	private String district;
	private String commune;
	private String homenumber;
	private String street;
	private int type;
	
	private List<Telephone> telephone;
	private List<MultipartFile> menus;
	private List<MultipartFile> image;
	private List<String> telephones;
	
	public List<String> getTelephones() {
		return telephones;
	}
	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}
	public UploadRest(){
		
	}
	public UploadRest(String name, String description, String delivery, String district, String commune,
			String homenumber, String street, int type, List<Telephone> telephone, List<MultipartFile> menus,
			List<MultipartFile> image) {
		super();
		this.name = name;
		this.description = description;
		this.delivery = delivery;
		this.district = district;
		this.commune = commune;
		this.homenumber = homenumber;
		this.street = street;
		this.type = type;
		this.telephone = telephone;
		this.menus = menus;
		this.image = image;
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
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
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
	public String getHomenumber() {
		return homenumber;
	}
	public void setHomenumber(String homenumber) {
		this.homenumber = homenumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Telephone> getTelephone() {
		return telephone;
	}
	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}
	public List<MultipartFile> getMenus() {
		return menus;
	}
	public void setMenus(List<MultipartFile> menus) {
		this.menus = menus;
	}
	public List<MultipartFile> getImage() {
		return image;
	}
	public void setImage(List<MultipartFile> image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "UploadRest [name=" + name + ", description=" + description + ", delivery=" + delivery + ", district="
				+ district + ", commune=" + commune + ", homenumber=" + homenumber + ", street=" + street + ", type="
				+ type + ", telephone=" + telephone + ", menus=" + menus + ", image=" + image + ", telephones="
				+ telephones + "]";
	}
	
	
	
}
