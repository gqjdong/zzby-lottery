package com.welfare.ssq.parse;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.parse.spi.IParseSSQLotteryHtml;

/**
 * 体坛
 * @author Administrator
 *
 */
public class ParseTiTanHtml implements IParseSSQLotteryHtml<SSQLottery> {

	private static IParseSSQLotteryHtml<SSQLottery> service = null;
	
	public static synchronized IParseSSQLotteryHtml<SSQLottery> getInstance(){
		if(service == null){
			service = new ParseTiTanHtml();
		}
		return service;
	}
	
	@Override
	public void parseHtml(String html, SSQLottery lottery) {
		
	}
	
}
