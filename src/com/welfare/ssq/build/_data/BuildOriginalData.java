package com.welfare.ssq.build._data;

import java.util.Arrays;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.build._data.spi.IBuildSSQLotteryData;
import com.welfare.ssq.supply.data.OriginalData;

/**
 * 创建原始的彩票数据
 * @author Administrator
 *
 */
public class BuildOriginalData implements IBuildSSQLotteryData{

	private static IBuildSSQLotteryData service = null;

	public static synchronized IBuildSSQLotteryData getInstance() {
		if (service == null) {
			service = new BuildOriginalData();
		}
		return service;
	}

	private BuildOriginalData() {

	}
	
	@Override
	public SSQLottery buildData() {
		SSQLottery lottery = new SSQLottery();
		lottery.addRedArea1(Arrays.asList(OriginalData.READ_AREA1.getValue()));
		lottery.addRedArea2(Arrays.asList(OriginalData.READ_AREA2.getValue()));
		lottery.addRedArea3(Arrays.asList(OriginalData.READ_AREA3.getValue()));
		lottery.addBlueArea(Arrays.asList(OriginalData.BLUE_AREA.getValue()));
		return lottery;
	}

}
