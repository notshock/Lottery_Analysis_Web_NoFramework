package com.biglottorecord.model;

import java.util.List;

public class BigLottoRecordService {

	private BigLottoRecordDAO_interface dao;
	
	public BigLottoRecordService() {
		dao = new BigLottoRecordDAO();
	}
	
	public void createOrUpdate(String gameRecordNo, String gameNo, java.sql.Date gameLotteryDate,
			Integer number1, Integer number2, Integer number3, Integer number4, Integer number5, Integer number6, Integer specialNumber) {
		BigLottoRecordVO bigLottoRecordVO = new BigLottoRecordVO();
		bigLottoRecordVO.setGameRecordNo(gameRecordNo);
		bigLottoRecordVO.setGameNo(gameNo);
		bigLottoRecordVO.setGameLotteryDate(gameLotteryDate);
		bigLottoRecordVO.setNumber1(number1);
		bigLottoRecordVO.setNumber2(number2);
		bigLottoRecordVO.setNumber3(number3);
		bigLottoRecordVO.setNumber4(number4);
		bigLottoRecordVO.setNumber5(number5);
		bigLottoRecordVO.setNumber6(number6);
		bigLottoRecordVO.setSpecialNumber(specialNumber);
		createOrUpate(bigLottoRecordVO);
	}
	public void createOrUpate(BigLottoRecordVO bigLottoRecordVO) {
		BigLottoRecordVO tempVO = dao.findOneByPK(bigLottoRecordVO.getGameNo());		
		if(tempVO==null) {
			dao.insert(bigLottoRecordVO);
		}else {
			dao.update(bigLottoRecordVO);
		}
	}
	public BigLottoRecordVO getOneByPK(String gameRecordNo) {
		return dao.findOneByPK(gameRecordNo);
	}
	public List<BigLottoRecordVO> getAll(){
		return dao.getAll();
	}
}
