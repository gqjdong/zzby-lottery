package com.zzby.test;

import com.welfare.ssq.SSQBootstrap;
import com.welfare.ssq.supply.type.DataType;
import com.welfare.ssq.supply.type.ParamType;

public class BootstrapTest {
	
	public static void main(String[] args){
		//SSQBootstrap.start(DataType.ORIGINAL_TYPE,ParamType.CUSTOM_TYPE,2);
		SSQBootstrap.startDifferentParam(DataType.CRAWL_TYPE,ParamType.CUSTOM_TYPE,2);
	}
	
}
