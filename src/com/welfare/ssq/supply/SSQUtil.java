package com.welfare.ssq.supply;

import com.welfare.ssq.bean.SSQLottery;
import com.welfare.ssq.bean.SSQLotteryParam;
import com.welfare.common.util.NumUtil;

public class SSQUtil {

	/**
	 * 生成的双色球是否符合最终的比例
	 * @param lottery
	 * @param param
	 * @return
	 */
	public static boolean isCorrectScale(SSQLottery lottery,SSQLotteryParam param) {
		return NumUtil.isCorrectOddEvenScale(lottery.getAllRedArea(),
				param.getOddScale(), param.getEvenScale());
	}

}
