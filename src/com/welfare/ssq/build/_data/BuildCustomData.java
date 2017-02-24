package com.welfare.ssq.build._data;

import java.util.Arrays;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.build._data.spi.IBuildSSQLotteryData;
import com.welfare.ssq.supply.data.CustomData;

/**
 * 创建自定义的彩票数据
 * @author Administrator
 *
 */
public class BuildCustomData implements IBuildSSQLotteryData{

	private static IBuildSSQLotteryData service = null;

	public static synchronized IBuildSSQLotteryData getInstance() {
		if (service == null) {
			service = new BuildCustomData();
		}
		return service;
	}

	private BuildCustomData() {

	}
	
	@Override
	public SSQLottery buildData() {
		SSQLottery lottery = new SSQLottery();
		lottery.addRedArea1(Arrays.asList(CustomData.READ_AREA1.getValue()));
		lottery.addRedArea2(Arrays.asList(CustomData.READ_AREA2.getValue()));
		lottery.addRedArea3(Arrays.asList(CustomData.READ_AREA3.getValue()));
		lottery.addBlueArea(Arrays.asList(CustomData.BLUE_AREA.getValue()));
		return lottery;
	}

}
