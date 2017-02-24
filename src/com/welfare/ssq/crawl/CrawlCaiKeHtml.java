package com.welfare.ssq.crawl;

import java.util.HashMap;
import java.util.Map;

import com.welfare.ssq.crawl.spi.ICrawlSSQLotteryHtml;
import com.welfare.ssq.supply.httprpc.HttpClientRpc;
import com.zzby.httpclient.client.IHttpClient;
import com.zzby.httpclient.modle.ReqModle;
import com.zzby.httpclient.modle.ResModle;

/**
 * 彩客网
 * @author Administrator
 *
 */
public class CrawlCaiKeHtml implements ICrawlSSQLotteryHtml {

	private static final String URL = "http://www.310win.com/shuangseqiu/yuce.html";
	
	private static ICrawlSSQLotteryHtml service = null;
	
	public static synchronized ICrawlSSQLotteryHtml getInstance(){
		if(service == null){
			service = new CrawlCaiKeHtml();
		}
		return service;
	}
	
	private CrawlCaiKeHtml(){
		
	}
	
	@Override
	public String crawlHtml() {
		String result = "";
		try {
			IHttpClient client = HttpClientRpc.CAIKE.getInstance(false);
			ReqModle request = new ReqModle(URL,getHeader());
			ResModle response = client.sendGet(request);
			result = response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private Map<String,String> getHeader(){
		Map<String,String> header = new HashMap<String,String>();
		header.put("Accept", "*/*");
		header.put("Accept-Encoding", "gzip");
		header.put("Connection", "Keep-Alive");
		return header;
	}
	
}
