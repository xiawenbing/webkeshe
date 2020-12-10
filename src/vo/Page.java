package vo;

import java.util.HashMap;

public class Page {
	private Integer pageSize;
	private Integer pageNumber;
	private String sort;
	private String sortOrder;
	
	
	public Page(Integer pageSize, Integer pageNumber, String sort, String sortOrder) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.sort = sort;
		this.sortOrder = sortOrder;
	}
	public Page getByHashMap(HashMap<String, Object> mapPage) {
		Page page = new Page();
		page.setPageSize(Integer.parseInt(mapPage.get("pageSize").toString()));
		page.setPageNumber(Integer.parseInt(mapPage.get("pageNumber").toString()));
		page.setSort((String)mapPage.get("sort"));
		page.setSortOrder((String)mapPage.get("sortOrder"));
		return page;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", sort=" + sort + ", sortOrder="
				+ sortOrder + "]";
	}
	
	
}
