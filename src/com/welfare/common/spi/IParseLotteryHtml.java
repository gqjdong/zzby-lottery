package com.welfare.common.spi;

import com.welfare.common.bean.Lottery;

/**
 * 解析预测网站html
 * @author Administrator
 *
 * @param <T>
 */
public interface IParseLotteryHtml<T extends Lottery> {
	
	/**
	 * 解析html
	 * @param html
	 * @param lottery
	 */
	public void parseHtml(String html,T lottery);
	
}
