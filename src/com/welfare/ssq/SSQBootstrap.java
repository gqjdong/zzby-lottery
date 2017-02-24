package com.welfare.ssq;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.bean.SSQLotteryParam;
import com.welfare.ssq.supply.SSQManager;
import com.welfare.ssq.supply.type.DataType;
import com.welfare.ssq.supply.type.ParamType;

/**
 * 启动类
 * @author Administrator
 *
 */
public class SSQBootstrap {
	
	/**
	 * 根据相同的条件获得多注双色球
	 * @param type(原始数据的来源类型,1:自然规则    2:网络预测网站  3:自定义)
	 * @param count(注数)
	 */
	public static void start(DataType dataType,ParamType paramType,int count){
		SSQLottery lottery = SSQManager.getSSQLotteryData(dataType);
		SSQLotteryParam param = SSQManager.getSSQLotteryParam(paramType);
		SSQManager.getFinalSSQLottery(lottery, param,count);
	}
	
	/**
	 * 根据不同的条件获得多注
	 * @param type(原始数据的来源类型,1:自然规则    2:网络预测网站  3:自定义)
	 * @param count(注数)
	 */
	public static void startDifferentParam(DataType dataType,ParamType paramType,int count){
		SSQLottery lottery = SSQManager.getSSQLotteryData(dataType);
		for(int i = 0;i < count;i ++){
			SSQLotteryParam param = SSQManager.getSSQLotteryParam(paramType);
			SSQManager.getFinalSSQLottery(lottery, param,1);
		}
	}
	
}
