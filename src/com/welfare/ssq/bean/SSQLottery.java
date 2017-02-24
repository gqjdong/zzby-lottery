package com.welfare.ssq.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.welfare.common.bean.Lottery;

/**
 * 双色球类
 * @author Administrator
 *
 */
public class SSQLottery extends Lottery {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3417109093357841859L;

	// 红号分区1[1-11]
	private List<Integer> redArea1 = new ArrayList<Integer>();
	
	// 红号分区2[12-22]
	private List<Integer> redArea2 = new ArrayList<Integer>();
	
	// 红号分区3[23-33]
	private List<Integer> redArea3 = new ArrayList<Integer>();
	
	// 蓝号分区[1-16]
	private List<Integer> blueArea = new ArrayList<Integer>();
	
	public SSQLottery(){
		
	}

	public List<Integer> getRedArea1() {
		return redArea1;
	}

	public List<Integer> getRedArea2() {
		return redArea2;
	}

	public List<Integer> getRedArea3() {
		return redArea3;
	}

	public List<Integer> getBlueArea() {
		return blueArea;
	}

	public void setRedArea1(List<Integer> redArea1) {
		this.redArea1 = redArea1;
	}

	public void setRedArea2(List<Integer> redArea2) {
		this.redArea2 = redArea2;
	}

	public void setRedArea3(List<Integer> redArea3) {
		this.redArea3 = redArea3;
	}

	public void setBlueArea(List<Integer> blueArea) {
		this.blueArea = blueArea;
	}

	public void addRedArea1(List<Integer> redArea1) {
		addList(this.redArea1,redArea1);
	}
	
	public void addRedArea2(List<Integer> redArea2) {
		addList(this.redArea2,redArea2);
	}
	
	public void addRedArea3(List<Integer> redArea3) {
		addList(this.redArea3,redArea3);
	}
	
	public void addBlueArea(List<Integer> blueArea) {
		addList(this.blueArea,blueArea);
	}
	
	public void addRed(Integer red){
		List<Integer> redList = new ArrayList<Integer>();
		redList.add(red);
		if(red > 0 && red <= 11){
			addRedArea1(redList);
		}else if(red > 11 && red <= 22){
			addRedArea2(redList);
		}else if(red > 22 && red <= 33){
			addRedArea3(redList);
		}
	}
	
	public void addBlue(Integer blue){
		List<Integer> blueList = new ArrayList<Integer>();
		blueList.add(blue);
		addBlueArea(blueList);
	}
	
	private void addList(List<Integer> source,List<Integer> desc){
		if(source != null && desc != null){
			source.addAll(desc);
		}
	}
	
	public List<Integer> getAllRedArea(){
		List<Integer> red = new ArrayList<Integer>();
		red.addAll(redArea1);
		red.addAll(redArea2);
		red.addAll(redArea3);
		return red;
	}
	
	public String toString() {
		String redStr = "";
		List<Integer> redList = new ArrayList<Integer>();
		redList.addAll(redArea1);
		redList.addAll(redArea2);
		redList.addAll(redArea3);
		Collections.sort(redList);
		for(Integer red : redList){
			redStr += red + " ";
		}
		String blueStr = "";
		Collections.sort(blueArea);
		for(Integer blue : blueArea){
			blueStr += " " + blue;
		}
		return redStr + "+" + blueStr;
	}
	
}
