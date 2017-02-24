package com.welfare.ssq.crawl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.welfare.ssq.crawl.spi.ICrawlSSQLotteryHtml;
import com.welfare.ssq.supply.httprpc.HttpClientRpc;
import com.zzby.httpclient.client.IHttpClient;
import com.zzby.httpclient.modle.ResModle;

/**
 * 幸运门
 * @author Administrator
 *
 */
public class CrawlLuckyGateHtml implements ICrawlSSQLotteryHtml {
	
	private static final String BASE_URL = "http://news.50018.com";
	
	private static ICrawlSSQLotteryHtml service = null;
	
	public static synchronized ICrawlSSQLotteryHtml getInstance(){
		if(service == null){
			service = new CrawlLuckyGateHtml();
		}
		return service;
	}
	
	private CrawlLuckyGateHtml(){
		
	}
	
	@Override
	public String crawlHtml(){
		Pattern pattern = null;
		Matcher matcher = null;
		String result = "";
		try {
			IHttpClient client = HttpClientRpc.LUCKYGATE.getInstance(false);
			ResModle response = client.sendGet(BASE_URL);
			String nextUrl = "";
			Document doc = Jsoup.parse(response.getBody()); 
			Elements as = doc.select("div#news_panel_left a");
			pattern = Pattern.compile("双色球第(\\d{7,8})期.*专家推荐号码");
			for(Element a : as){
				matcher = pattern.matcher(a.text());
				if(matcher.find()){
					nextUrl = a.attr("href");
					break;
				}
			}
			response = client.sendGet(BASE_URL + nextUrl);
			result = response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
