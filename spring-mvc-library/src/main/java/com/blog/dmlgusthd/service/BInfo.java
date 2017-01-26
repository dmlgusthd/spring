package com.blog.dmlgusthd.service;

import java.sql.Date;

public class BInfo {
	private String bmName;
	private Date biFirstretn;
	private int biCount;
	private int biDay;
	
	public String getBmName(){
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	public Date getBiFirstretn() {
		return biFirstretn;
	}
	public void setBiFirstretn(Date biFirstretn) {
		this.biFirstretn = biFirstretn;
	}
	public int getBiCount() {
		return biCount;
	}
	public void setBiCount(int biCount) {
		this.biCount = biCount;
	}
	public int getBiDay() {
		return biDay;
	}
	public void setBiDay(int biDay) {
		this.biDay = biDay;
	}
	@Override
	public String toString() {
		return "BInfo [bmName=" + bmName + ", biFirstretn=" + biFirstretn + ", biCount=" + biCount + ", biDay=" + biDay
				+ "]";
	}
	
	
}
