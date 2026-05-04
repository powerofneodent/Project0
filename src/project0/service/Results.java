package project0.service;

import java.util.List;

public class Results<T> {

	private List<T> page;
	private int total;
	
	public Results() {
		
	}
	
	public List<T> getPage() {
		return page;
	}
	public void setPage(List<T> page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
