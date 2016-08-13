package org.khmeracademy.rest.pp.entity;

import java.util.List;

public class Location {

	private int id;
	private String type;
	private int type_code;
	private int code;
	private String khmer_name;
	private String english_name;
	private String reference;
	private String official_note;
	private String checker_note;
	private int parent_id;
	

	
	
	public Location(){
		
	}
	
	public Location(int id, String type, int type_code, int code, String khmer_name, String english_name,
			String reference, String official_note, String checker_note, int parent_id) {
		super();
		this.id = id;
		this.type = type;
		this.type_code = type_code;
		this.code = code;
		this.khmer_name = khmer_name;
		this.english_name = english_name;
		this.reference = reference;
		this.official_note = official_note;
		this.checker_note = checker_note;
		this.parent_id = parent_id;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getType_code() {
		return type_code;
	}
	public void setType_code(int type_code) {
		this.type_code = type_code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getKhmer_name() {
		return khmer_name;
	}
	public void setKhmer_name(String khmer_name) {
		this.khmer_name = khmer_name;
	}
	public String getEnglish_name() {
		return english_name;
	}
	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getOfficial_note() {
		return official_note;
	}
	public void setOfficial_note(String official_note) {
		this.official_note = official_note;
	}
	public String getChecker_note() {
		return checker_note;
	}
	public void setChecker_note(String checker_note) {
		this.checker_note = checker_note;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
	
	
}
