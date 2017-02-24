package com.zzby.test;

import com.welfare.ssq.crawl.CrawlCaiKeHtml;
import com.welfare.ssq.crawl.CrawlLuckyGateHtml;
import com.welfare.ssq.crawl.CrawlTiTanHtml;
import com.welfare.ssq.crawl.spi.ICrawlSSQLotteryHtml;

public class CrawlTest {
	
	public static void main(String[] args) {
		ICrawlSSQLotteryHtml luckyCrawl = CrawlLuckyGateHtml.getInstance();
		System.out.println(luckyCrawl.crawlHtml());
		ICrawlSSQLotteryHtml caikeCrawl = CrawlCaiKeHtml.getInstance();
		System.out.println(caikeCrawl.crawlHtml());
		ICrawlSSQLotteryHtml titanCrawl = CrawlTiTanHtml.getInstance();
		System.out.println(titanCrawl.crawlHtml());
	}
	
}
