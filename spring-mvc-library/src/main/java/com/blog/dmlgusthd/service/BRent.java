package com.blog.dmlgusthd.service;

import java.util.Date;

public class BRent {
	private String brNo;
	private String bmName;
	private String mName;
	private Date brStart;
	private Date brEnd;
	private int brPay;
	
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public Date getBrStart() {
		return brStart;
	}
	public void setBrStart(Date brStart) {
		this.brStart = brStart;
	}
	public Date getBrEnd() {
		return brEnd;
	}
	public void setBrEnd(Date brEnd) {
		this.brEnd = brEnd;
	}
	public int getBrPay() {
		return brPay;
	}
	public void setBrPay(int brPay) {
		this.brPay = brPay;
	}
	@Override
	public String toString() {
		return "BRent [brNo=" + brNo + ", bmName=" + bmName + ", mName=" + mName + ", brStart=" + brStart + ", brEnd="
				+ brEnd + ", brPay=" + brPay + "]";
	}
	
	
}
