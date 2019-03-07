package function.takedata.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.util.HashSetOfInt;

public class TestGetStringOrigin {
	
public static void main(String args[]) {
		
		URL url = null;

		try {
//			url = new URL("https://tw.yahoo.com"); // 建立URL物件url
//			url = new URL("http://www.taiwanlottery.com.tw/lotto/Lotto649/history.aspx");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("http://www.taiwanlottery.com.tw/lotto/Lotto649/history.aspx")
//						 .append("?").append("Lotto649Control_history$DropDownList1").append("=").append("2")
//						 .append("&").append("Lotto649Control_history$chk").append("=").append("radNO")
//						 .append("&").append("Lotto649Control_history$txtNO").append("=").append("103000001")
//						 .append("&").append("Lotto649Control_history$btnSubmit").append("=").append(encodeUrlString("查詢"))
//						 .append("&").append("__VIEWSTATEGENERATOR").append("=").append("C3E8EA98")
//						 .append("&").append("__VIEWSTATE").append("=").append("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")
//						 .append("&").append("__EVENTVALIDATION").append("=").append("BZmEpvIhYZncmlt/1qD7sgeck1u8VTmakMlbhxkzQLkyFnlk5iwhlu3pXzTSe+OAZeqN2nY2BXGF+fpn03rVn51Ys+MlPWde0G2gBfFJNywcHkAlvgxPynWRGdpuC+94ejrrDcKMO2RWPluo+pEdsq2QArBWly+bgets6W0ffWigzJwANrGpzra37IfFj90pz5WRWoRyJMH+lKo5/Prek1r65f4FPQRMUNlUS+WZqAk9n8R2oJkHARf8CnSi3n6j/Dc1QCGAIy8gLdmDwK7oLP4rzRSGZ9PnXBQqMnZeOcrY039JER/H9UydNm+LK4rhQAHmojMm40F/UwExFYlmhmXTlYO2vrFmqgfnPgNx4zJi8ph7F5+kEy9UExzFnEtHb9C/xrpiiXES8h+dAJ8guhbXf9UYmkDnvdxtRs4RYjlthvT+9IIaNCEX/wN5ToD1V3t1Ghu2NYcOCXRoq/OT4jBARhPgXVqTtcS9K2D5sIcvoxKlEiUSR6pRjmVgxm1XG0Ckgajqqb05tTjJHLuHrlpSVtt/TtRJSB/M0y9bQ19si1j3Zh9CE3Orhr/pG7yk0jwdGXSKwkTlkNcODYKupVjT4nGxyT6SL3vD1rq7STOWvk6pQg5RHFLL9VL/y2Trzpi8jkdEy7DLyrJJM+b44u0zgFtamRUl9ne4eNaCOM8Ir4SAJaU7C7V0FuugJYGur9Vx/UGJs7/FdH/BD+UPrnws9kInTeFyX+xr7Hp9lQFDD3x2sYwfUfPtyoHAE6diALTBAfLTlUBYUPMQeCKSLRqnF6t3ndNfj+xElMI8stzFeM3xbrWtPpXXNhly3Km72sb2GY5IONQPea3Yk1pKyqhAc8s=")
						 ;
			
			
			
			url = new URL(stringBuilder.toString());
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		HttpURLConnection urlConn = null;
		
		try {
			// 以URL物件建立URLConnection物件 HttpURLConnection
//			URLConnection urlConn = url.openConnection();
			urlConn = (HttpURLConnection)url.openConnection();
			// 以下模擬瀏覽器的user-agent請求標頭(Servlet講義p79-範例HeaderSnoop.java ; 或講義p185-範例EL10.jsp)
			Map<String, String> map = new HashMap<>();
			map.put("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");
//			map.put("Accept-Encoding","gzip, deflate"); // <-這個不能加上去
//			map.put("Connection", "keep-alive");
//			map.put("Upgrade-Insecure-Requests", "1");
//			map.put("Origin", "http://www.taiwanlottery.com.tw");
//			map.put("Content-Type", "application/x-www-form-urlencoded");
//			map.put("Referer", "http://www.taiwanlottery.com.tw/lotto/Lotto649/history.aspx");
			setUrlConnRequestProperty(urlConn,map);
//			urlConn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");

//			Accept-Language: zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7
//			Cookie: ASPSESSIONIDSQRBDATD=FGMBAGNDADJJCCPAJMNBCFMN; ASPSESSIONIDSSRADCQD=DDEKMBNDIIBNNJMMJOICLHJH; ASPSESSIONIDSSSDDATD=OGBJPLPDMLBKPJCOMCGLIHAB; ASPSESSIONIDSQTBCDRC=CDIKIDPDFEBCPDAFHJOHNPMP; ASPSESSIONIDSSTCDDQD=PLDGKFPDADFCIDGEIDOHKDAG; ASPSESSIONIDSSTACBTC=GMJGDNODHCFFLBHCJJAJFHCO; ASPSESSIONIDQQRBDATD=BDAGBOPDPJKKNBMMAMCGOIJE; ASPSESSIONIDQSSDDCQC=HEHDFPODHDPFHLMKDPFNHKEK; ASPSESSIONIDSSSBCATD=GKONNJPDHAEAMMNFEEIPEEAH; ASPSESSIONIDSSTCAATD=EEFEMHPDBADICDFFNDGIBGFA; ASPSESSIONIDSSSDDDRC=OECDMIKDNOPPNKADMGBLIEKC; ASPSESSIONIDQQSDBASC=LLEIDOJDEOBFEKHIEFNFGPDC; ASPSESSIONIDSSQCABTC=MABEFAKDLPLOHNDALIEKONAN; ASPSESSIONIDSSSACATD=DFMPPJJDMIMFIBFGJMPBAKCN; ASPSESSIONIDSQSBDDRD=GLNPGCKDGJNFDGAGDPIIFLLF; ASPSESSIONIDSQQCDATD=LFBGOHJDHOGOGCMIAOCNKPGH; ASPSESSIONIDQQTCDDQC=EPEKMFJDOEOLFDGBBDNAHCAP; ASPSESSIONIDQQQCDCQC=OAJMBMJDKFFBHJBEGFNCBDJH; ASPSESSIONIDQQTADARD=CCHPIJCBCJAMAGCECELIBAEO; ASPSESSIONIDQQQBDCSA=IFPJEILBLKHFAGAFIOELPMGM; ASPSESSIONIDSQTCCDTB=ILMJMAABGBMPAMFCEGAKBOJI; ASPSESSIONIDSSRBCBSB=IEHEODKBLBDLCBFFKLMNEKNM; ASPSESSIONIDQSRDDCSA=IPNNLGGBAELJCGFGBEOMMBML; ASPSESSIONIDSSRADBQD=OFGNCFBBJMHBFJMHOKJHPOEC; ASPSESSIONIDSSQABDSB=JEJFFCFBEDDNIABICPNCCNCH; ASPSESSIONIDQQRADDSB=BMAECLHBKAEDBBINENNFGHEL; ASPSESSIONIDSQRDCATA=NCNPHPIBIBHFHNEKJEPMOBOC; ASPSESSIONIDSSSBBDSB=CFMJKMMBOAEDAJMJPFBIKGLA; ASPSESSIONIDSQSAACTC=NHJFIGOBLLEGOHBPPGFKFNOD; ASPSESSIONIDSQTACASC=DGECDAOBAIANJLLEIFJAIGJH; ASPSESSIONIDSSRDABSC=BENJGEOBODMMKNFGDIFMKNHL; ASPSESSIONIDQSTDABTC=KIBONJNBFHMAEFGBNJNLEHDA
			// 以URLConnection物件取得輸入資料流
			urlConn.setDoOutput(true); 
			urlConn.setDoInput(true); 
			urlConn.setAllowUserInteraction(true); 
		    HttpURLConnection.setFollowRedirects(true); 
		    urlConn.setInstanceFollowRedirects(true); 
			
			urlConn.setRequestMethod("POST");
			urlConn.setUseCaches(false);
			urlConn.setConnectTimeout(5000);
			//<解決 411 error> https://blog.csdn.net/pfyuit/article/details/8137777
			/* http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
			 * 
			 * The server refuses to accept the request without a defined Content- Length. 
			 * The client MAY repeat the request if it adds a valid Content-Length header field 
			 * containing the length of the message-body in the request message.
			 */
			urlConn.setRequestProperty("Content-Length","0");
	        DataOutputStream os = new DataOutputStream( urlConn.getOutputStream() );
	        os.write( "".getBytes("UTF-8"), 0, 0);
	        os.flush();
	        os.close();
			//</解決 411 error>
	        
			urlConn.connect();
			InputStream ins = urlConn.getInputStream();
			
			// 建立URL資料流
			BufferedReader br = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
			String data;
			List<String> list = new ArrayList<String>();
			boolean readOpen = false;
			StringBuilder stringBuilder = null;
			boolean hasString = false;
			while ((data = br.readLine()) != null) {
				if (data.contains("<table class=\"table_org td_hm\">")) {
					readOpen = true;
					stringBuilder = new StringBuilder();
					hasString = true;
				}
				if(readOpen==true) {
					if(data.contains("</table>")) {
						stringBuilder.append(data.trim());
						list.add(stringBuilder.toString());
						readOpen = false;
					}else {
						stringBuilder.append(data.trim());
					}
				}
			}
			if(!hasString)
				System.out.println("--------------");
			for(String string :list) {
				System.out.println(string);
			}
			br.close();
			ins.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(urlConn!=null) {
				urlConn.disconnect();
			}
		}
	}
	
	public static void setUrlConnRequestProperty(HttpURLConnection urlConn,Map<String, String> map) {
		for(String key : map.keySet()) {
			urlConn.setRequestProperty(key, map.get(key));
		}
	}
	
	
	public static String encodeUrlString(String urlString) {
		try {
			return java.net.URLEncoder.encode(urlString,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return urlString;
		}
	}
		
		
	
}
