package com.welfare.ssq.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.parse.spi.IParseSSQLotteryHtml;
import com.welfare.common.util.NumUtil;

/**
 * 幸运门
 * @author Administrator
 *
 */
public class ParseLuckyGateHtml implements IParseSSQLotteryHtml<SSQLottery> {

	private static IParseSSQLotteryHtml<SSQLottery> service = null;
	
	public static synchronized IParseSSQLotteryHtml<SSQLottery> getInstance(){
		if(service == null){
			service = new ParseLuckyGateHtml();
		}
		return service;
	}
	
	@Override
	public void parseHtml(String html, SSQLottery lottery) {
		Pattern pattern = Pattern.compile("((?:\\d{1,2},){5}\\d{1,2})\\s*[+]\\s*((\\d{1,2}))\\s*<br />");
		Matcher matcher = pattern.matcher(html);
		while(matcher.find()){
			addRed(lottery,matcher.group(1));
			addBlue(lottery,matcher.group(2));
		}
	}

	private void addRed(SSQLottery lottery,String red){
		for(String redStr : red.split(",")){
			lottery.addRed(NumUtil.digitStrToInt(redStr));
		}
	}
	
	private void addBlue(SSQLottery lottery,String blue){
		lottery.addBlue(NumUtil.digitStrToInt(blue));
	}
	
}
