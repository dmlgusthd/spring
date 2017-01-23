package com.blog.dmlgusthd.service;

public class Member {
	
	private String mName;
	private int mPhone;
	private String mAddress;
	private char mSpecial;
	
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmPhone() {
		return mPhone;
	}
	public void setmPhone(int mPhone) {
		this.mPhone = mPhone;
	}
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public char getmSpecial() {
		return mSpecial;
	}
	public void setmSpecial(char mSpecial) {
		this.mSpecial = mSpecial;
	}
	@Override
	public String toString() {
		return "Member [mName=" + mName + ", mPhone=" + mPhone + ", mAddress=" + mAddress + ", mSpecial=" + mSpecial
				+ "]";
	}
	
}
