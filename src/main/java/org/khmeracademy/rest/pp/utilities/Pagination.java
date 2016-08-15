package org.khmeracademy.rest.pp.utilities;

public class Pagination {
	private int page;
	private int limit;
	private int totalPage;
	private int totalCount;
	public Pagination(){
		this(1,18,0,0);
	}
	public Pagination(int page, int limit, int totalPage, int totalCount) {
		super();
		this.page = page;
		this.limit = limit;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
