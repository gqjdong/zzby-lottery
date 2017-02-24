package com.welfare.ssq.crawl;

import com.welfare.ssq.crawl.spi.ICrawlSSQLotteryHtml;
import com.welfare.ssq.supply.httprpc.HttpClientRpc;
import com.zzby.httpclient.client.IHttpClient;
import com.zzby.httpclient.modle.ReqModle;
import com.zzby.httpclient.modle.ResModle;

/**
 * 体坛
 * @author Administrator
 *
 */
public class CrawlTiTanHtml implements ICrawlSSQLotteryHtml {

	private static final String URL = "http://lottery.titan24.com/ssqzj/";
	
	private static ICrawlSSQLotteryHtml service = null;
	
	public static synchronized ICrawlSSQLotteryHtml getInstance(){
		if(service == null){
			service = new CrawlTiTanHtml();
		}
		return service;
	}
	
	private CrawlTiTanHtml(){
		
	}
	
	@Override
	public String crawlHtml() {
		String result = "";
		try {
			IHttpClient client = HttpClientRpc.TITAN.getInstance(false);
			ReqModle request = new ReqModle(URL);
			request.setBodyDecode("gbk");
			ResModle response = client.sendGet(request);
			result = response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
