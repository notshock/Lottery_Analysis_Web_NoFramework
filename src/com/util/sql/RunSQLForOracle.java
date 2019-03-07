package com.util.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RunSQLForOracle {
	// TODO: maybe use the reflection, but i don't know how to code
	public static String createRunSQL(final String preparedStatementSQL, Object...objects ) {
		StringBuffer stringBuffer = new StringBuffer(preparedStatementSQL);
		List<Integer> parameterList = new ArrayList<>();
		for(int i = 0 ; i<preparedStatementSQL.length(); i++) {
			if("?".equals(preparedStatementSQL.substring(i, i+1))) {
				parameterList.add(i);
			}
		}
		for(int i = 0; i<objects.length;i++) {
//			Class temepClass = objects[i].getClass();
		}
		return "";
	}
	public static String createRunSQL(final String preparedStatementSQL, List<String> parameterList) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("FinalSQL---");
		StringTokenizer stringTokenizer = new StringTokenizer(preparedStatementSQL, "?");
		if(checkForCreateSQLCondiction(preparedStatementSQL, stringTokenizer,parameterList)) {
			int i = 0;
			while(stringTokenizer.hasMoreElements()) {
				stringBuffer.append(stringTokenizer.nextToken());
				if(i<parameterList.size())
					stringBuffer.append(parameterList.get(i));
				i++;
			}
		}else {
			stringBuffer.append("Cannot create SQL. Maybe parameter Error.");
		}
		return stringBuffer.toString();
	}
	private static boolean checkForCreateSQLCondiction(String preparedStatementSQL,StringTokenizer stringTokenizer, List<String> parameterList) {
		if(stringTokenizer.countTokens()==(parameterList.size()+1)) {
			return true;
		}else {
			String string = preparedStatementSQL.toUpperCase();
			if(string.contains("UPDATE") || string.contains("SELECT")) {
				if(stringTokenizer.countTokens()==(parameterList.size())) {
					return true;
				}
			}
			return false;
		}
	}
	
	
	
}
