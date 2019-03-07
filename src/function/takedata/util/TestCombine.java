package function.takedata.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.biglottorecord.model.BigLottoRecordVO;

public class TestCombine {
	 public static void main(String[] args) {
		 URL url = null;
		 try {
			url = new URL("http://www.taiwanlottery.com.tw/lotto/Lotto649/history.aspx");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		List<String> list = null;
		Map<Integer, String> map = null;
		try {
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			
			httpURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(50000);
			
			TakingHTMLDoc takingHTML = new TakingHTMLDoc(httpURLConnection);
			list = takingHTML.doToSolveAboutRequestMethodPost(httpURLConnection)
			 		  .startToTakeAndEndToDisconnect()
			 		  .getOrignStringArray();
			AnalysisHTMLDoc analysisHTMLDoc = new AnalysisHTMLDoc(list);
			String startLabelString = "td_hm";
			String endLableString = "</table>";
//			list = analysisHTMLDoc.setStartLabelString(startLabelString)
//								  .setEndLabelString(endLableString)
//								  .pickNeedPartStringList()
//								  .getResultList();
//			for(String string : list)
//				System.out.println(string);
			map = analysisHTMLDoc.setStartLabelString("<table class=\"table_gre td_hm\">", "<table class=\"table_org td_hm\">")
								 .setEndLabelString(endLableString)
								 .pickNeedPartStringMap()
								 .getResultMap();
			System.out.println("map.size() = " + map.size());
			for(Integer integer : map.keySet()) {
				System.out.println(integer+" --- "+map.get(integer));
				BigLottoRecordVO bigLottoRecordVO = 
							AnalysisStringForBigLotto.getAnalysisStringObject(map.get(integer))
													 .startToAnalysis()
													 .getBigLottoRecordVO();
				System.out.println(bigLottoRecordVO);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		 
	}
	 
}
