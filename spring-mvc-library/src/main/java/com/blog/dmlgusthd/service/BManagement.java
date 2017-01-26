package com.blog.dmlgusthd.service;


public class BManagement {
	private int bmSn;
	private String bmName;
	private String bmType;
	private String bmPublisher;
	private String bmWriter;
	private String bmCheck;
	
	public int getBmSn() {
		return bmSn;
	}
	public void setBmSn(int bmSn) {
		this.bmSn = bmSn;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}

	public String getBmType() {
		return bmType;
	}
	public void setBmType(String bmType) {
		this.bmType = bmType;
	}

	public String getBmPublisher() {
		return bmPublisher;
	}
	public void setBmPublisher(String bmPublisher) {
		this.bmPublisher = bmPublisher;
	}
	public String getBmWriter() {
		return bmWriter;
	}
	public void setBmWriter(String bmWriter) {
		this.bmWriter = bmWriter;
	}
	
	public String getBmCheck() {
		return bmCheck;
	}
	public void setBmCheck(String bmCheck) {
		this.bmCheck = bmCheck;
	}
	@Override
	public String toString() {
		return "BManagement [bmSn=" + bmSn + ", bmName=" + bmName + ", bmType=" + bmType + ", bmPublisher=" + bmPublisher + ", bmWriter="
				+ bmWriter + "]";
	}
	
}
