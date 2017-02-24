package com.welfare.ssq.exception;

import com.welfare.common.exception.LotteryException;

public class SSQLotteryException extends LotteryException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4933323595688173359L;

	public SSQLotteryException() {
		super("SSQLotteryException:");
	}

	public SSQLotteryException(String message, Throwable cause) {
		super(message, cause);
	}

	public SSQLotteryException(String message) {
		super(message);
	}
	
}
