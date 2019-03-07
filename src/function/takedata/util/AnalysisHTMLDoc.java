package function.takedata.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class AnalysisHTMLDoc {

	private List<String> htmlDocOrigin;
//	private String startLabelString;
//	private String endLabelString;
	private List< String> startLabelStringList;
	private List< String> endLabelStringList;
	private List<String> resultList;
	private Map<Integer, String> resultMap;
	private Integer currInteger = 1;
	
	public AnalysisHTMLDoc(List<String> htmlDocOrigin) {
		this.htmlDocOrigin = new LinkedList<String>();
		for(String string : htmlDocOrigin) {
			this.htmlDocOrigin.add(string);
		}
	}
	
//	public String getStartLabelString() {
//		return startLabelString;
//	}
	public List<String> startLabelStringList() {
		return startLabelStringList;
	}
//	public String getEndLabelString() {
//		return endLabelString;
//	}
	public List<String> endLabelStringList() {
		return endLabelStringList;
	}
	public List<String> getResultList() {
		return resultList;
	}
	public Map<Integer, String> getResultMap(){
		return resultMap;
	}
	
	
//	public AnalysisHTMLDoc setStartLabelString(String startLabelString) {
//		this.startLabelString = startLabelString;
//		return this;
//	}
	public AnalysisHTMLDoc setStartLabelString(String... startLabelStrings ) {
		startLabelStringList = new ArrayList<>();
		for(String string : startLabelStrings) {
			startLabelStringList.add(string);
		}
		return this;
	}

//	public AnalysisHTMLDoc setEndLabelString(String endLabelString) {
//		this.endLabelString = endLabelString;
//		return this;
//	}
	public AnalysisHTMLDoc setEndLabelString(String... endLabelStrings) {
		endLabelStringList = new ArrayList<>();
		for(String string : endLabelStrings) {
			endLabelStringList.add(string);
		}
		return this;
	}

	public AnalysisHTMLDoc setResultMapInitLinkedHashMap() {
		currInteger = 1;
		resultMap = new LinkedHashMap<>();
		return this;
	}
	
	public AnalysisHTMLDoc pickNeedPartStringMap() {
		if(resultMap==null) {
			setResultMapInitLinkedHashMap();
		}
		boolean readStart = false;
		boolean readEnd = false;
		List<String> list = new ArrayList<>();
		for(String string : htmlDocOrigin) {
			if(hasStringContainsList(string, startLabelStringList)) {
//			if(string.contains(startLabelString)) {
				readStart = true;
			}else if(readStart==true && hasStringContainsList(string,endLabelStringList)) {
//			}else if(readStart==true && string.contains(endLabelString)) {
				readStart = false;
				readEnd = true;
			}
			if(readStart || readEnd) {
				if(string!=null)
					list.add(string.trim());
				if(readEnd) {
					readEnd = false;
					StringBuilder stringBuilder = new StringBuilder();
					for(String string2 : list) {
						stringBuilder.append(string2);
					}
					resultMap.put(currInteger++, stringBuilder.toString());
					//list.clear(); 
					//<- cannot do it, because this list is the same as that list in resultMap
					//    Hence we make a new one list to assign.
					list = new ArrayList<>();
				}
			}
		}
		return this;
	}
	
	public AnalysisHTMLDoc pickNeedPartStringMap(List<String> startLabelStringList, List<String> endLabelStringList) {
		this.startLabelStringList = startLabelStringList;
		this.endLabelStringList = endLabelStringList;
		return pickNeedPartStringMap();
	}
	
	private Boolean hasStringContainsList(String originString, List<String> list) {
		for(String string : list) {
			if(originString.contains(string)) {
				return true;
			}
		}
		return false;
	}
	
	public AnalysisHTMLDoc setResultListInitLinkedList() {
		resultList = new LinkedList<String>();
		for(String string : htmlDocOrigin) {
			if(!string.isEmpty())
				resultList.add(string.trim());
		}
		return this;
	}
	
	public AnalysisHTMLDoc pickNeedPartStringList() {
		if(resultList==null) {
			setResultListInitLinkedList();
		}
		Iterator<String> iterator = resultList.iterator();
		boolean readOpen = false;
		boolean readEnd = false;
		while(iterator.hasNext()) {
			String string = iterator.next(); // Exception in thread "main" java.util.ConcurrentModificationException
			string = string.trim();
//			if(string.contains(startLabelString)) {
			if(hasStringContainsList(string, startLabelStringList)) {
				readOpen = true;
//			}else if(readOpen == true && string.contains(endLabelString)) {
			}else if(readOpen == true && hasStringContainsList(string, endLabelStringList)) {
				readOpen = false;
				readEnd = true;
			}
			
			if(!readOpen) {
				if(!readEnd) {
					iterator.remove();
				}else {
					readEnd = false;
				}
				//resultList.remove(index); -> ConcurrentModificationException
			}
		}
		return this;
	}
	
	public AnalysisHTMLDoc pickNeedPartStringList(List<String> startLabelStringList, List<String> endLabelStringList) {
		this.startLabelStringList = startLabelStringList;
		this.endLabelStringList = endLabelStringList;
		return pickNeedPartStringList();
	}
	
	/*Exception in thread "main" java.util.ConcurrentModificationException
	 * https://www.cnblogs.com/dolphin0520/p/3933551.html
	 * 
	 * */
	
	
}
