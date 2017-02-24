package com.welfare.ssq.supply.data;

/**
 * 自定义彩票数据
 * @author Administrator
 *
 */
public enum CustomData {
	
	READ_AREA1(new Integer[]{1,2,3,4,5,6,7,8,9,10,11}),
	
	READ_AREA2(new Integer[]{12,13,14,15,16,17,18,19,20,21,22}),
	
	READ_AREA3(new Integer[]{23,24,25,26,27,28,29,30,31,32,33}),
	
	BLUE_AREA(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
	
	private Integer[] value;
	
	public Integer[] getValue() {
		return value;
	}

	public void setValue(Integer[] value) {
		this.value = value;
	}

	private CustomData(Integer[] value){
		this.value = value;
	}
	
}
