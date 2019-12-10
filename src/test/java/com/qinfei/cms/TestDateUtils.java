package com.qinfei.cms;

import java.util.Date;

import org.junit.Test;

import com.qinfei.cms.utils.DateUtils;

public class TestDateUtils {
	@Test
	public void testAge() {
		
		Date now = new Date(119,10,6);
		int age = DateUtils.getAge(now);
		System.out.println("age is " + age);
	}
	
	@Test
	public void testRemainDays() {
		
		Date future =  new Date(120,0,1);
		int remainDay = DateUtils.getRemainDays(future);
		System.out.println(" 璺濈鍏冩棪杩樺墿涓�?  " + remainDay);
		
	}
	
	
	@Test
	public void testIstoday() {
		Date future =  new Date(120,0,1);
		boolean isToday = DateUtils.isToday(future);
		System.out.println(" 11111 鏄粖澶�? " + isToday);
		isToday = DateUtils.isToday(new Date());
		System.out.println(" 2 =========== 鏄粖澶�? " + isToday);
	}
	
	@Test
	public void testGetBeginOfMonth() {
		
		Date beginOfMonth = DateUtils.getBeginOfMonth();
		System.out.println(" beginOfMonth is " + beginOfMonth);
		
	}
	
	
	@Test
	public void testGetEndOfMonth() {
		
		Date beginOfMonth = DateUtils.getEndOfMonth();
		System.out.println(" getEndOfMonth is " + beginOfMonth);
		
		
	}
}
