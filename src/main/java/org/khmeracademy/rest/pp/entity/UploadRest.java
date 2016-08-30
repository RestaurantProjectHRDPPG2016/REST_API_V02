package org.khmeracademy.rest.pp.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadRest {
	private int id;
	private String name;
	private String description;
	private String delivery;
	private String province;
	private String district;
	private String commune;
	private String home;
	private String street;
	private int type;
	private String latitude;
	private String longitude;
	private String create_date;
	
	private List<Telephone> telephone;
	private List<MultipartFile> menus;
	private List<MultipartFile> image;
	private List<Integer> deletedImageIds;
	private List<Integer> deletedMenuIds;
	private List<String> telephones;
	private int views;
	private int likes;
	
	public List<String> getTelephones() {
		return telephones;
	}
	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}
	public UploadRest(){
		
	}
	public UploadRest(int likes,int views,int id,String create_date,String longitude,String latitude,String province,String name, String description, String delivery, String district, String commune,
			String home, String street, int type, List<Telephone> telephone, List<MultipartFile> menus,
			List<MultipartFile> image,List<Integer> deleteImageIds,List<Integer> deleteMenuIds) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
		this.delivery = delivery;
		this.district = district;
		this.commune = commune;
		this.home = home;
		this.street = street;
		this.type = type;
		this.telephone = telephone;
		this.menus = menus;
		this.image = image;
		this.create_date = create_date;
		this.deletedImageIds = deletedImageIds;
		this.deletedMenuIds = deletedImageIds;
		this.views = views;
		this.likes = likes;
	}
	
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
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
				+ district + ", commune=" + commune + ", home=" + home + ", street=" + street + ", type="
				+ type + ", telephone=" + telephone + ", menus=" + menus + ", image=" + image + ", telephones="
				+ telephones + "]";
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Integer> getDeletedImageIds() {
		return deletedImageIds;
	}
	public void setDeletedImageIds(List<Integer> deletedImageIds) {
		this.deletedImageIds = deletedImageIds;
	}
	public List<Integer> getDeletedMenuIds() {
		return deletedMenuIds;
	}
	public void setDeletedMenuIds(List<Integer> deletedMenuIds) {
		this.deletedMenuIds = deletedMenuIds;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
}
