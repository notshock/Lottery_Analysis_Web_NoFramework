package com.memberplayinglist.model;

import java.io.Serializable;

public class MemberPlayingListVO implements Serializable{

	private static final long serialVersionUID = 5305747235289648494L;

	private String memNo;
	private String gameNo;
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public String getGameNo() {
		return gameNo;
	}
	public void setGameNo(String gameNo) {
		this.gameNo = gameNo;
	}
	
	
}
