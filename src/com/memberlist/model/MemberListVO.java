package com.memberlist.model;

import java.io.Serializable;

public class MemberListVO implements Serializable{

	private static final long serialVersionUID = -3024452151494079362L;
	
	private String memNo;
	private String memAccount;
	private String memPassword;
	private String memPasswordHint;
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public String getMemAccount() {
		return memAccount;
	}
	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemPasswordHint() {
		return memPasswordHint;
	}
	public void setMemPasswordHint(String memPasswordHint) {
		this.memPasswordHint = memPasswordHint;
	}
	
	
	
	
	
}
