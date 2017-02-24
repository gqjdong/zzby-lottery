package com.welfare.ssq.supply.type;

import com.welfare.ssq.crawl.CrawlCaiKeHtml;
import com.welfare.ssq.crawl.CrawlLuckyGateHtml;
import com.welfare.ssq.crawl.CrawlTiTanHtml;
import com.welfare.ssq.parse.ParseCaiKeHtml;
import com.welfare.ssq.parse.ParseLuckyGateHtml;
import com.welfare.ssq.parse.ParseTiTanHtml;

/**
 * 抓取和解析类型
 * 
 * @author Administrator
 * 
 */
public enum CrawlType {

	// 彩客网
	CAIKE(CrawlCaiKeHtml.class, ParseCaiKeHtml.class),

	// 幸运门
	LUCKYGATE(CrawlLuckyGateHtml.class, ParseLuckyGateHtml.class),

	// 体坛
	TITAN(CrawlTiTanHtml.class, ParseTiTanHtml.class);

	private CrawlType(Class<?> crawl, Class<?> parse) {
		this.crawl = crawl;
		this.parse = parse;
	}

	private Class<?> crawl;

	private Class<?> parse;

	public Class<?> getCrawl() {
		return crawl;
	}

	public void setCrawl(Class<?> crawl) {
		this.crawl = crawl;
	}

	public Class<?> getParse() {
		return parse;
	}

	public void setParse(Class<?> parse) {
		this.parse = parse;
	}
}
