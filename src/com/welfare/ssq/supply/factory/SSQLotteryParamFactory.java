package com.welfare.ssq.supply.factory;

import java.lang.reflect.Method;

import com.welfare.ssq.build._param.spi.IBuildSSQLotteryParam;
import com.welfare.ssq.supply.constant.SSQConstant;

/**
 * 彩票条件数据制造工厂
 * @author Administrator
 *
 */
public class SSQLotteryParamFactory {
	
	private static SSQLotteryParamFactory factory;

	private SSQLotteryParamFactory() {

	}

	public synchronized static SSQLotteryParamFactory getInstance() {
		if (factory == null) {
			factory = new SSQLotteryParamFactory();
		}
		return factory;
	}

	public IBuildSSQLotteryParam getBuildParamInstance(Class<?> build) {
		IBuildSSQLotteryParam service = null;
		try {
			Method method = build.getMethod(SSQConstant.METHOD_NAME);
			service = ((IBuildSSQLotteryParam)method.invoke(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
}
