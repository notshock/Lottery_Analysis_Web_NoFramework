package com.gamelist.model;

import java.io.Serializable;

public class GameListVO implements Serializable{

	private static final long serialVersionUID = -8725806905025496321L;
	
	private String gameNo;
	private String gameName;
	private String lotteryTableName;
	private String memLotteryTableName;
	private String memLotteryTableNameSequence;
	public String getGameNo() {
		return gameNo;
	}
	public void setGameNo(String gameNo) {
		this.gameNo = gameNo;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getLotteryTableName() {
		return lotteryTableName;
	}
	public void setLotteryTableName(String lotteryTableName) {
		this.lotteryTableName = lotteryTableName;
	}
	public String getMemLotteryTableName() {
		return memLotteryTableName;
	}
	public void setMemLotteryTableName(String memLotteryTableName) {
		this.memLotteryTableName = memLotteryTableName;
	}
	public String getMemLotteryTableNameSequence() {
		return memLotteryTableNameSequence;
	}
	public void setMemLotteryTableNameSequence(String memLotteryTableNameSequence) {
		this.memLotteryTableNameSequence = memLotteryTableNameSequence;
	}
	
	
	

}
