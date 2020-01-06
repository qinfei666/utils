package com.qinfei.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	/**
	 * ����ÿ���ж��ٺ���
	 */
	static final int millSecondsPerDay =  1000*60*60*24; 
	
	/**
	 * ��������
	 * @param birthday  ����
	 * @return  ��������
	 */
	public static int getAge(Date birthday) {
		//2018 12 4 // 5 // 6
		Calendar calendar = Calendar.getInstance();
		//����������ꡢ�¡���
		calendar.setTime(birthday);
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH);
		int birthDate = calendar.get(Calendar.DATE);
		
		
		//���㵱ǰ���ꡢ�¡���
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentDate = calendar.get(Calendar.DATE);
		
		int age = currentYear - birthYear;
		// �����ǰ���·�С ���������1
		if(currentMonth<birthMonth) {
			age--;
		}else if(currentMonth==birthMonth && currentDate<birthDate) {
			// ����·���ͬ ��ǰ������С ���������1
			age--;
		}
		return age;	
	}
	/**
	 * ���㻹ʣ�������
	 * @param future
	 */
	public static int getRemainDays(Date future) {
		
		return (int )((future.getTime()- new Date().getTime())/millSecondsPerDay);
		
	}
	/**
	 *  �ж��Ƿ�Ϊ���B
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		String formatSrc = dateFormat.format(date);// ������ʽ����د���ַ���
		
		String formatToday = dateFormat.format(new Date());// �ѵ�ǰ���ڸ�ʽ�����ַ���
		
		return formatSrc.equals(formatToday);
		
	}
	/**
	 * ��ȡ���µ�����
	 */
	public static Date getBeginOfMonth() {
		
		// ��ȡ������ʵ��
		Calendar instance = Calendar.getInstance();
		// ���óɵ�ǰ��ʱ��
		instance.setTime(new Date());
		instance.set(Calendar.SECOND, 0);// ����0��
		instance.set(Calendar.MINUTE, 0);// ����0��
		instance.set(Calendar.HOUR, 0);// ����0Сʱ
		instance.set(Calendar.AM_PM, Calendar.AM);// ��������
		instance.set(Calendar.DATE, 1);// ����1�J
		
		return instance.getTime();
	}
	/**
	 * ��ȡ��ǰ�µ���ĩ
	 * @return
	 */
	public static Date getEndOfMonth() {
		// ��ȡ������ʵ��
		Calendar instance = Calendar.getInstance();
		// ���óɵ�ǰ��ʱ��
		instance.setTime(new Date());
		instance.add(Calendar.MONTH, 1);// �·���1
		
		// ���д������ó�����
		instance.set(Calendar.SECOND, 0);// ����0��
		instance.set(Calendar.MINUTE, 0);// ����0��
		instance.set(Calendar.HOUR, 0);// ����0Сʱ
		instance.set(Calendar.AM_PM, Calendar.AM);// ��������
		instance.set(Calendar.DATE, 1);// ����1�J
		
		// ��ȥد�� ��ɵ��µ��c
		instance.add(Calendar.SECOND, -1);// �����1
		return instance.getTime();
		
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static boolean  isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day+1+1);// ������+1����Ϊ�����Տ���

		// ����د���Ֆc

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7-day+1);

		// ���������������

		System.out.println(format.format(lastDayOfWeek.getTime()));
		
		return (date.getTime()<lastDayOfWeek.getTime().getTime() &&
				date.getTime()>firstDayOfWeek.getTime().getTime() );

	}
	
}
