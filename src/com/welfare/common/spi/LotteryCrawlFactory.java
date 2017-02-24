package com.welfare.common.spi;

import com.welfare.common.bean.Lottery;

public interface LotteryCrawlFactory {
	
	public static final String METHOD_NAME = "getInstance";
	
	public ICrawlLotteryHtml getCrawlInstance(Class<?> crawl);
	
	public IParseLotteryHtml<? extends Lottery> getParseInstance(Class<?> parse);
}
