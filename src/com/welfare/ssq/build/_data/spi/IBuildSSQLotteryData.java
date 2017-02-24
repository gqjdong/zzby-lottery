package com.welfare.ssq.build._data.spi;

import com.welfare.ssq.bean.SSQLottery;

/**
 * 创建彩票数据的接口
 * @author Administrator
 *
 */
public interface IBuildSSQLotteryData {

	/**
	 * 创建数据
	 * @return
	 */
	public SSQLottery buildData();
	
}
