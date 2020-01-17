package com.fastech.utils;

import java.sql.Timestamp;

public class TimeUtils {
	//获取Timestamp类型的当前时间
	public static Timestamp getTime() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return time;
	}
}
