package com.welfare.ssq.supply.factory;

import java.lang.reflect.Method;

import com.welfare.ssq.build._data.spi.IBuildSSQLotteryData;
import com.welfare.ssq.supply.constant.SSQConstant;

/**
 * 彩票数据制造工厂
 * @author Administrator
 *
 */
public class SSQLotteryDataFactory {

	private static SSQLotteryDataFactory factory;

	private SSQLotteryDataFactory() {

	}

	public synchronized static SSQLotteryDataFactory getInstance() {
		if (factory == null) {
			factory = new SSQLotteryDataFactory();
		}
		return factory;
	}
	
	public IBuildSSQLotteryData getBuildDataInstance(Class<?> build){
		IBuildSSQLotteryData service = null;
		try {
			Method method = build.getMethod(SSQConstant.METHOD_NAME);
			service = ((IBuildSSQLotteryData)method.invoke(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
	
}
