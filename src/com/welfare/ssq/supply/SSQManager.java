package com.welfare.ssq.supply;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.bean.SSQLotteryParam;
import com.welfare.ssq.supply.constant.SSQConstant;
import com.welfare.ssq.supply.factory.SSQLotteryDataFactory;
import com.welfare.ssq.supply.factory.SSQLotteryParamFactory;
import com.welfare.ssq.supply.type.DataType;
import com.welfare.ssq.supply.type.ParamType;
import com.welfare.common.util.NumUtil;

/**
 * 双色球管理类
 * @author Administrator
 *
 */
public class SSQManager {

	/**
	 * 根据类型获得双色球的数据类
	 * @param type
	 * @return
	 */
	public static SSQLottery getSSQLotteryData(DataType type){
		SSQLotteryDataFactory factory = SSQLotteryDataFactory.getInstance();
		return factory.getBuildDataInstance(type.getBuild()).buildData();
	}
	
	/**
	 * 根据类型获得双色球的条件类
	 * @return
	 */
	public static SSQLotteryParam getSSQLotteryParam(ParamType type){
		SSQLotteryParamFactory factory = SSQLotteryParamFactory.getInstance();
		return factory.getBuildParamInstance(type.getBuild()).buildParam();
	}
	
	/**
	 * 获得单注最终的双色球信息
	 * @param lottery
	 * @param param
	 * @return
	 */
	public static SSQLottery getFinalSSQLottery(SSQLottery lottery,SSQLotteryParam param){
		SSQLottery finalLottery = new SSQLottery();
		while(!SSQUtil.isCorrectScale(finalLottery,param)){
			finalLottery.setRedArea1(NumUtil.makeRandNumList(lottery.getRedArea1(), param.getRedAreaScale1()));
			finalLottery.setRedArea2(NumUtil.makeRandNumList(lottery.getRedArea2(), param.getRedAreaScale2()));
			finalLottery.setRedArea3(NumUtil.makeRandNumList(lottery.getRedArea3(), param.getRedAreaScale3()));
		}
		finalLottery.setBlueArea(NumUtil.makeRandNumList(lottery.getBlueArea(),SSQConstant.LOTTERY_SSQ_BLUR_COUNT));
		//System.out.println("最终比例：" + param.toString());
		System.out.println("最终号码：" + finalLottery.toString());
		return finalLottery;
	}
	
	/**
	 * 获得最终多注双色球信息
	 * @param lottery
	 * @param param
	 * @param count
	 */
	public static void getFinalSSQLottery(SSQLottery lottery,SSQLotteryParam param,int count){
		for(int i = 0;i < count;i ++){
			getFinalSSQLottery(lottery,param);
		}
	}
	
}
