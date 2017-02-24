package com.welfare.ssq.build._data;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.build._data.spi.IBuildSSQLotteryData;
import com.welfare.ssq.crawl.spi.ICrawlSSQLotteryHtml;
import com.welfare.ssq.parse.spi.IParseSSQLotteryHtml;
import com.welfare.ssq.supply.factory.SSQLotteryCrawlFactory;
import com.welfare.ssq.supply.type.CrawlType;

/**
 * 创建抓取的彩票数据
 * @author Administrator
 *
 */
public class BuildCrawlData implements IBuildSSQLotteryData{

	private static IBuildSSQLotteryData service = null;

	public static synchronized IBuildSSQLotteryData getInstance() {
		if (service == null) {
			service = new BuildCrawlData();
		}
		return service;
	}

	private BuildCrawlData() {

	}
	
	@Override
	public SSQLottery buildData() {
		SSQLottery lottery = new SSQLottery();
		getLotteryDataByCrawl(lottery);
		return lottery;
	}
	
	/**
	 * 获得每个双色球预测网站的彩票数据
	 * @param lottery
	 * @param crawlService
	 * @param parseService
	 */
	private static void getLotteryDataByCrawl(SSQLottery lottery,ICrawlSSQLotteryHtml crawlService,IParseSSQLotteryHtml<SSQLottery> parseService){
		String html = crawlService.crawlHtml();
		parseService.parseHtml(html, lottery);
	}
	
	/**
	 * 获得所有双色球预测网站的彩票数据
	 * @param lottery
	 */
	private static void getLotteryDataByCrawl(SSQLottery lottery){
		SSQLotteryCrawlFactory factory = SSQLotteryCrawlFactory.getInstance();
		for(CrawlType type : CrawlType.values()){
			getLotteryDataByCrawl(lottery,factory.getCrawlInstance(type.getCrawl()),factory.getParseInstance(type.getParse()));
		}
	}
	
}
