package com.biglottorecord.model;

import java.io.Serializable;
import java.sql.Date;

public class BigLottoRecordVO implements Serializable{

	private static final long serialVersionUID = -554467392072580607L;

	private String gameRecordNo;
	private String gameNo;
	private Date gameLotteryDate;
	private Integer number1;
	private Integer number2;
	private Integer number3;
	private Integer number4;
	private Integer number5;
	private Integer number6;
	private Integer specialNumber;
	public String getGameRecordNo() {
		return gameRecordNo;
	}
	public void setGameRecordNo(String gameRecordNo) {
		this.gameRecordNo = gameRecordNo;
	}
	public String getGameNo() {
		return gameNo;
	}
	public void setGameNo(String gameNo) {
		this.gameNo = gameNo;
	}
	public Date getGameLotteryDate() {
		return gameLotteryDate;
	}
	public void setGameLotteryDate(Date gameLotteryDate) {
		this.gameLotteryDate = gameLotteryDate;
	}
	public Integer getNumber1() {
		return number1;
	}
	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}
	public Integer getNumber2() {
		return number2;
	}
	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}
	public Integer getNumber3() {
		return number3;
	}
	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}
	public Integer getNumber4() {
		return number4;
	}
	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}
	public Integer getNumber5() {
		return number5;
	}
	public void setNumber5(Integer number5) {
		this.number5 = number5;
	}
	public Integer getNumber6() {
		return number6;
	}
	public void setNumber6(Integer number6) {
		this.number6 = number6;
	}
	public Integer getSpecialNumber() {
		return specialNumber;
	}
	public void setSpecialNumber(Integer specialNumber) {
		this.specialNumber = specialNumber;
	}
	@Override
	public String toString() {
		return "BigLottoRecordVO [gameRecordNo=" + gameRecordNo + ", gameNo=" + gameNo + ", gameLotteryDate="
				+ gameLotteryDate + ", number1=" + number1 + ", number2=" + number2 + ", number3=" + number3
				+ ", number4=" + number4 + ", number5=" + number5 + ", number6=" + number6 + ", specialNumber="
				+ specialNumber + "]";
	}
	
	
	
	
}
