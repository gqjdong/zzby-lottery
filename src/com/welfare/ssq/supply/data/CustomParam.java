package com.welfare.ssq.supply.data;

/**
 * 自定义彩票条件数据
 * @author Administrator
 *
 */
public enum CustomParam {
	
	READ_AREA_SCALE(new Integer[]{3,1,2,2,1,2,4,2,4,1,0,3,3,2,4,1,2,3,2,1,2,3,4,2,1,2}),
	
	READ_ODD_EVEN_SCALE(new Integer[]{1,3,2,4,0,2,4,3,5,4,6,2,3,3,2,4,1,2,3,4,2,2,3,4,2,4,5}),
	
	READ_BIG_SMALL_SCALE(new Integer[]{1,3,2,4,0,2,4,3,5,4,6,2,3,3,2,4,1,2,3,4,2,2,3,4,2,4,5});
	
	private Integer[] value;
	
	public Integer[] getValue() {
		return value;
	}

	public void setValue(Integer[] value) {
		this.value = value;
	}

	private CustomParam(Integer[] value){
		this.value = value;
	}
	
}
