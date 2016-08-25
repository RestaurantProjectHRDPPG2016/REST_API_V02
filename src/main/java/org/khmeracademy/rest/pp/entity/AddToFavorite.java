package org.khmeracademy.rest.pp.entity;

public class AddToFavorite {
	private int id;
	private int r_id;
	private int m_id;
	private int status;
	private String date;
	public AddToFavorite(){
		
	}
	public AddToFavorite(int id, int r_id, int m_id, int status, String date) {
		super();
		this.id = id;
		this.r_id = r_id;
		this.m_id = m_id;
		this.status = status;
		this.date = date;
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
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AddToFavorite [id=" + id + ", r_id=" + r_id + ", m_id=" + m_id + ", status=" + status + ", date=" + date
				+ "]";
	}
	
	
}
