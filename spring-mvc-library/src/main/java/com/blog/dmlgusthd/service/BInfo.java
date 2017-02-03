package com.blog.dmlgusthd.service;

import java.sql.Date;

public class BInfo {
	private String bmName;
	private Date biFirstrent;
	private int biCount;
	private int biDay;
	
	public String getBmName(){
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	public Date getBiFirstrent() {
		return biFirstrent;
	}
	public void setBiFirstrent(Date biFirstrent) {
		this.biFirstrent = biFirstrent;
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
		return "BInfo [bmName=" + bmName + ", biFirstrent=" + biFirstrent + ", biCount=" + biCount + ", biDay=" + biDay
				+ "]";
	}
	
	
}
