package com.welfare.ssq.build._param;

import com.welfare.ssq.bean.SSQLotteryParam;
import com.welfare.ssq.build._param.spi.IBuildSSQLotteryParam;
import com.welfare.ssq.supply.constant.SSQConstant;
import com.welfare.ssq.supply.data.CustomParam;
import com.welfare.common.util.NumUtil;

/**
 * 随机创建自定义的彩票条件数据
 * @author Administrator
 *
 */
public class BuildCustomParam implements IBuildSSQLotteryParam {

	private static IBuildSSQLotteryParam service = null;

	public static synchronized IBuildSSQLotteryParam getInstance() {
		if (service == null) {
			service = new BuildCustomParam();
		}
		return service;
	}

	private BuildCustomParam() {

	}

	@Override
	public SSQLotteryParam buildParam() {
		SSQLotteryParam param = new SSQLotteryParam();

		param.setRedAreaScale1(NumUtil.makeRandNum(CustomParam.READ_AREA_SCALE.getValue()));
		param.setRedAreaScale2(NumUtil.makeRandNum(CustomParam.READ_AREA_SCALE.getValue(),SSQConstant.SSQ_RED_COUNT - param.getRedAreaScale1()));
		param.setRedAreaScale3(SSQConstant.SSQ_RED_COUNT - param.getRedAreaScale1() - param.getRedAreaScale2());

		param.setOddScale(NumUtil.makeRandNum(CustomParam.READ_ODD_EVEN_SCALE.getValue()));
		param.setEvenScale(SSQConstant.SSQ_RED_COUNT - param.getOddScale());

		param.setBigScale(NumUtil.makeRandNum(CustomParam.READ_BIG_SMALL_SCALE.getValue()));
		param.setSmallScale(SSQConstant.SSQ_RED_COUNT - param.getBigScale());

		return param;
	}

}
