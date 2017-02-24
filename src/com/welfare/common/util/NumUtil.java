package com.welfare.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumUtil {
	
	/**
	 * 从数组中获取随机整数
	 * @param rang
	 * @return
	 */
	public static Integer makeRandNum(Integer[] rang){
		if(rang == null || rang.length < 1){
			return -1;
		}
		Random rand = new Random();
		return rang[rand.nextInt(rang.length)];
	}
	
	/**
	 * 从数组中获取不大于max的随机整数
	 * @param rang
	 * @param max
	 * @return
	 */
	public static Integer makeRandNum(Integer[] rang,int max){
		if(rang == null || rang.length < 1){
			return -1;
		}
		Random rand = new Random();
		Integer result = rang[rand.nextInt(rang.length)];
		while(result > max){
			result = rang[rand.nextInt(rang.length)];
		}
		return result;
	}
	
	/**
	 * 从list获得随机整数
	 * @param rang
	 * @return
	 */
	public static Integer makeRandNum(List<Integer> rang){
		if(rang == null || rang.size() < 1){
			return -1;
		}
		Random rand = new Random();
		return rang.get(rand.nextInt(rang.size()));
	}
	
	/**
	 * 从rang中获取不重复的count个随机整数
	 * @param rang
	 * @param count
	 * @return
	 */
	public static List<Integer> makeRandNumList(List<Integer> rang,int count){
		if(rang == null || rang.size() < 1 || count < 1){
			return new ArrayList<Integer>();
		}
		
		List<Integer> resultList = new ArrayList<Integer>();
		Set<Integer> resultSet = new HashSet<Integer>();
		while(resultSet.size() < count){
			resultSet.add(makeRandNum(rang));
		}
		
		resultList.addAll(resultSet);
		return resultList;
	}
	
	/**
	 * list中的奇数个数
	 * @param List
	 */
	public static int getOddCount(List<Integer> list) {
		int count = 0;
		if(list == null || list.size() < 1){
			return count;
		}
		for(Integer num : list){
			if(num % 2 != 0){
				count ++;
			}
		}
		return count;
	}

	/**
	 * list中的偶数个数
	 * @param list
	 */
	public static int getEvenCount(List<Integer> list) {
		int count = 0;
		if(list == null || list.size() < 1){
			return count;
		}
		for(Integer num : list){
			if(num % 2 == 0){
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * list中的奇偶比例是否正确
	 * @param list
	 * @param odd
	 * @param even
	 */
	public static boolean isCorrectOddEvenScale(List<Integer> list,int odd,int even){
		return getOddCount(list) == odd && getEvenCount(list) == even;
	}
	
	/**
	 *  字符串转数字(格式如：'03'转为3)
	 * @param digitStr
	 * @return
	 */
	public static Integer digitStrToInt(String digitStr){
		if(digitStr == null || digitStr.equals("")){
			return 0;
		}
//		while(digitStr.charAt(0) == '0'){
//			digitStr = digitStr.replaceFirst("0","");
//		}
//		return Integer.valueOf(digitStr);
		return Integer.valueOf(digitStr.replaceAll("^0+$", ""));
	}
	
}
