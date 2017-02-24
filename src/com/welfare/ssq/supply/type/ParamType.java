package com.welfare.ssq.supply.type;

import com.welfare.ssq.build._param.BuildCustomParam;

/**
 * 彩票条件数据类型
 * @author Administrator
 *
 */
public enum ParamType {

	// 自定义类型
	CUSTOM_TYPE(BuildCustomParam.class);

	private ParamType(Class<?> build) {
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
