package com.welfare.ssq.bean;


/**
 * 双色球参数类
 * @author Administrator
 *
 */
public class SSQLotteryParam {
	
	// 红号分区比例
	private int redAreaScale1;
	private int redAreaScale2;
	private int redAreaScale3;
	
	// 红号奇偶比例
	private int oddScale;
	private int evenScale;
	
	// 红号大小比例
	private int bigScale;
	private int smallScale;
	
	public SSQLotteryParam(){
		
	}

	public int getRedAreaScale1() {
		return redAreaScale1;
	}

	public void setRedAreaScale1(int redAreaScale1) {
		this.redAreaScale1 = redAreaScale1;
	}

	public int getRedAreaScale2() {
		return redAreaScale2;
	}

	public void setRedAreaScale2(int redAreaScale2) {
		this.redAreaScale2 = redAreaScale2;
	}

	public int getRedAreaScale3() {
		return redAreaScale3;
	}

	public void setRedAreaScale3(int redAreaScale3) {
		this.redAreaScale3 = redAreaScale3;
	}

	public int getOddScale() {
		return oddScale;
	}

	public void setOddScale(int oddScale) {
		this.oddScale = oddScale;
	}

	public int getEvenScale() {
		return evenScale;
	}

	public void setEvenScale(int evenScale) {
		this.evenScale = evenScale;
	}

	public int getBigScale() {
		return bigScale;
	}

	public void setBigScale(int bigScale) {
		this.bigScale = bigScale;
	}

	public int getSmallScale() {
		return smallScale;
	}

	public void setSmallScale(int smallScale) {
		this.smallScale = smallScale;
	}

	@Override
	public String toString() {
		return "红色号码三个分区比例：" + this.getRedAreaScale1() + " " + this.getRedAreaScale2() + " " + this.getRedAreaScale3()
			+ "\r\n红色号码奇偶比例：" + this.getOddScale() + " " + this.getEvenScale()
			+ "\r\n红色号码大小比例：" + this.getBigScale() + " " + this.getSmallScale();
	}
	
}
