package function.takedata.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

import com.biglottorecord.model.BigLottoRecordVO;

public class AnalysisStringForBigLotto {
	// product BigLottoRecordVO
	
	private String originString;
	private BigLottoRecordVO bigLottoRecordVO;
	private String gameNo = "G0001";
	
	private AnalysisStringForBigLotto(String originString) {
		this.originString = originString;
	}
	
	public static AnalysisStringForBigLotto getAnalysisStringObject(String originString) {
		AnalysisStringForBigLotto analysisStringForBigLotto = new AnalysisStringForBigLotto(originString);
		return analysisStringForBigLotto;
	}
	public BigLottoRecordVO getBigLottoRecordVO() {
		return this.bigLottoRecordVO;
	}
	
	public AnalysisStringForBigLotto startToAnalysis() {
		// TODO: 未來要改成XML解析文檔的套件使用
		bigLottoRecordVO = new BigLottoRecordVO();
		bigLottoRecordVO.setGameNo(this.gameNo); // TODO: 先行寫死，未來改成查一記憶體的資料再取得設定
		StringTokenizer stringTokenizer = new StringTokenizer(originString, "<");
		while(stringTokenizer.hasMoreTokens()) {
			String string = stringTokenizer.nextToken();
			if(string.contains("Lotto649Control_history_dlQuery_L649_DrawTerm_")) {
				bigLottoRecordVO.setGameRecordNo(string.substring(string.length()-9, string.length()));
				continue;
			} // 108000024
			if(string.contains("Lotto649Control_history_dlQuery_L649_DDate_")) {
				String temp = string.substring(string.length()-9,string.length());
				StringTokenizer tempTokens = new StringTokenizer(temp, "/");
				int year = Integer.parseInt(tempTokens.nextToken())+1911;
				String month = tempTokens.nextToken();
				String day = tempTokens.nextToken();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date date = simpleDateFormat.parse(year+"-"+month+"-"+day);
					java.sql.Date gameLotteryDate = new java.sql.Date(date.getTime());
					bigLottoRecordVO.setGameLotteryDate(gameLotteryDate);
				} catch (ParseException e) {
					bigLottoRecordVO.setGameLotteryDate(new java.sql.Date(0L));
					e.printStackTrace();
				}
				continue;
			} // 108/02/26
			if(string.contains("Lotto649Control_history_dlQuery_SNo1_")) {
				String temp = string.substring(string.length()-2,string.length());
				bigLottoRecordVO.setNumber1(Integer.parseInt(temp));
				continue;
			}
			if(string.contains("Lotto649Control_history_dlQuery_SNo2_")) {
				String temp = string.substring(string.length()-2,string.length());
				bigLottoRecordVO.setNumber2(Integer.parseInt(temp));
				continue;
			}
			if(string.contains("Lotto649Control_history_dlQuery_SNo3_")) {
				String temp = string.substring(string.length()-2,string.length());
				bigLottoRecordVO.setNumber3(Integer.parseInt(temp));
				continue;
			}
			if(string.contains("Lotto649Control_history_dlQuery_SNo4_")) {
				String temp = string.substring(string.length()-2,string.length());
				bigLottoRecordVO.setNumber4(Integer.parseInt(temp));
				continue;
			}
			if(string.contains("Lotto649Control_history_dlQuery_SNo5_")) {
				String temp = string.substring(string.length()-2,string.length());
				bigLottoRecordVO.setNumber5(Integer.parseInt(temp));
				continue;
			}
			if(string.contains("Lotto649Control_history_dlQuery_SNo6_")) {
				String temp = string.substring(string.length()-2,string.length());
				bigLottoRecordVO.setNumber6(Integer.parseInt(temp));
				continue;
			}
			if(string.contains("Lotto649Control_history_dlQuery_SNo_")) {
				String temp = string.substring(string.length()-2,string.length());
				bigLottoRecordVO.setSpecialNumber(Integer.parseInt(temp));
				continue;
			}
		}
		
		return this;
	}
	
	
}
