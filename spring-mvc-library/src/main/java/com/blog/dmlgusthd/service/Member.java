package com.blog.dmlgusthd.service;

public class Member {
	
	private int mNo;
	private String mName;
	private String mPhone;
	private String mAddress;
	private char mSpecial;

	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
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
