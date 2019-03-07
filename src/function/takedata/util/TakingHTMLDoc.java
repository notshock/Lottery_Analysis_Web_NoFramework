package function.takedata.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class TakingHTMLDoc{
	
	/* after httpURLConnection init
	 * TakingHTMLDoc takingHTML = new TakingHTMLDoc(httpURLConnection);
		list = takingHTML.doToSolveAboutRequestMethodPost(httpURLConnection)
		 		  .startToTakeAndEndToDisconnect()
		 		  .getOrignStringArray();
	 * 
	 * */
	
	
	private List<String> orignStringArray;
	private HttpURLConnection httpURLConnection;
	private String stateString;
	
	public TakingHTMLDoc(HttpURLConnection httpURLConnection) {
		this.httpURLConnection = httpURLConnection;
	}
	
	public TakingHTMLDoc setTakingHTMLDoc(HttpURLConnection httpURLConnection){
		this.httpURLConnection = httpURLConnection;
		return this;
	}
	
	public TakingHTMLDoc doToSolveAboutRequestMethodPost(HttpURLConnection httpURLConnection) {
		//<solve 411 error> https://blog.csdn.net/pfyuit/article/details/8137777
		/* http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
		 * 
		 * The server refuses to accept the request without a defined Content- Length. 
		 * The client MAY repeat the request if it adds a valid Content-Length header field 
		 * containing the length of the message-body in the request message.
		 */
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestProperty("Content-Length","0");
        DataOutputStream os = null;
		try {
			os = new DataOutputStream( httpURLConnection.getOutputStream() );
	        os.write( "".getBytes("UTF-8"), 0, 0);
	        os.flush();
			//</solve 411 error>
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return this;
	}
	public TakingHTMLDoc startToTakeAndEndToDisconnect() {
		this.orignStringArray = new ArrayList<>();
		if(httpURLConnection!=null) {
			stateString = "httpURLConnection alive";
			InputStream inputStream = null;
			BufferedReader bufferedReader = null;
			try {
				httpURLConnection.connect();
				inputStream = httpURLConnection.getInputStream();
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
				String data;
				while((data=bufferedReader.readLine())!=null) {
					orignStringArray.add(data);
				}
			} catch (IOException e) {
				stateString = "httpURLConnection error";
				e.printStackTrace();
			} finally {
				if(bufferedReader!=null) {
					try {
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(inputStream!=null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				httpURLConnection.disconnect();
			}
		}else {
			System.err.println("httpURLConnection null");
			stateString = "httpURLConnection null";
		}
		return this;
	}
	
	public String getStateString() {
		return stateString;
	}
	
	public List<String> getOrignStringArray(){
		return orignStringArray;
	}
}
