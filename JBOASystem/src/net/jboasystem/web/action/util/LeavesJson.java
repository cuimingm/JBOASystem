package net.jboasystem.web.action.util;

import java.util.List;

import net.jboasystem.entity.Leave;

public class LeavesJson {
	private int total;
	private List<Leave> rows;
	
	
	public LeavesJson(int total, List<Leave> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public LeavesJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Leave> getRows() {
		return rows;
	}
	public void setRows(List<Leave> rows) {
		this.rows = rows;
	}
	
	
}
