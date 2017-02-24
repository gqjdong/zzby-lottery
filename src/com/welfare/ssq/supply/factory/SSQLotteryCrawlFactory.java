package com.welfare.ssq.supply.factory;

import java.lang.reflect.Method;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.crawl.spi.ICrawlSSQLotteryHtml;
import com.welfare.ssq.parse.spi.IParseSSQLotteryHtml;
import com.welfare.common.spi.LotteryCrawlFactory;

/**
 * 抓取和解析类的制造工厂
 * @author Administrator
 *
 */
public class SSQLotteryCrawlFactory implements LotteryCrawlFactory{

	private static SSQLotteryCrawlFactory factory;
	
	private SSQLotteryCrawlFactory(){
		
	}
	
	public synchronized static SSQLotteryCrawlFactory getInstance(){
		if(factory == null){
			factory = new SSQLotteryCrawlFactory();
		}
		return factory;
	}
	
	/**
	 * 获得抓取类的单例
	 * @param crawl
	 * @return
	 */
	@Override
	public ICrawlSSQLotteryHtml getCrawlInstance(Class<?> crawl){
		ICrawlSSQLotteryHtml service = null;
		try {
			Method method = crawl.getMethod(METHOD_NAME);
			service = ((ICrawlSSQLotteryHtml)method.invoke(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
	
	/**
	 * 获得解析类的单例
	 * @param parse
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IParseSSQLotteryHtml<SSQLottery> getParseInstance(Class<?> parse){
		IParseSSQLotteryHtml<SSQLottery> service = null;
		try {
			Method method = parse.getMethod(METHOD_NAME);
			service = ((IParseSSQLotteryHtml<SSQLottery>)method.invoke(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
	
}
