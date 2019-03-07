package com.biglottorecord.model;

import java.util.List;
import java.util.Map;

public interface BigLottoRecordDAO_interface {

	abstract public void insert(BigLottoRecordVO bigLottoRecordVO);
	abstract public void update(BigLottoRecordVO bigLottoRecordVO);
	abstract public BigLottoRecordVO findOneByPK(String gameRecordNo);
	abstract public List<BigLottoRecordVO> getAll();
	abstract public List<BigLottoRecordVO> getAll(Map<String, String[]> map);
	
	
}
