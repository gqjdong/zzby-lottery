package com.welfare.ssq.supply.type;

import com.welfare.ssq.build._data.BuildCrawlData;
import com.welfare.ssq.build._data.BuildCustomData;
import com.welfare.ssq.build._data.BuildOriginalData;

/**
 * 彩票数据类型
 * @author Administrator
 *
 */
public enum DataType {
	
	// 原始类型
	ORIGINAL_TYPE(BuildOriginalData.class),
	
	// 抓取类型
	CRAWL_TYPE(BuildCrawlData.class),
	
	// 自定义类型
	CUSTOM_TYPE(BuildCustomData.class);
	
	private DataType(Class<?> build) {
		this.build = build;
	}

	private Class<?> build;

	public Class<?> getBuild() {
		return build;
	}

	public void setBuild(Class<?> build) {
		this.build = build;
	}
	
}
