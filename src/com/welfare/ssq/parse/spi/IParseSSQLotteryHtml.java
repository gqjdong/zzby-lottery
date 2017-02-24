package com.welfare.ssq.parse.spi;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.common.spi.IParseLotteryHtml;

/**
 * 解析双色球预测网站html
 * @author Administrator
 *
 * @param <T>
 */
public interface IParseSSQLotteryHtml<T extends SSQLottery> extends IParseLotteryHtml<T>{
	
}
