package com.membiglottorecord.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemBigLottoRecordVO implements Serializable{

	private static final long serialVersionUID = 4025582126939174857L;

	private Integer recordNo;
	private String memNo;
	private String gameNo;
	private Integer number1;
	private Integer number2;
	private Integer number3;
	private Integer number4;
	private Integer number5;
	private Integer number6;
	private Timestamp writeDate;
	private String bingoState;
	public Integer getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(Integer recordNo) {
		this.recordNo = recordNo;
	}
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
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public String getBingoState() {
		return bingoState;
	}
	public void setBingoState(String bingoState) {
		this.bingoState = bingoState;
	}
	
	
}
