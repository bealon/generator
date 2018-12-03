package com.polyman.common.generator.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 */
public class DateUtil {
	
	public static final String FULL_TIMESTAMP = "yyyyMMddHHmmssSSS";
	
	public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String TIME_PATTERN_NO_SPLIT = "yyyyMMddHHmmss";
	
	public static final String TIME_PATTERN1 = "yyyyMMdd HH:mm:ss";
	
	public static final String TIME_PATTERN_CH = "yyyy年MM月dd日 HH时mm分ss秒";
	
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	public static final String DATE_PATTERN_1 = "yyyyMMdd";

	public static final String DATE_PATTERN_2 = "yyyy/MM/dd";
	
	public static final String DATE_PATTERN_CH = "yyyy年MM月dd日";
	
	private static final int[] TIME_FIELD_LEVELS = { Calendar.YEAR, Calendar.MONTH, Calendar.DATE,
			Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND };

	private static final Map<String, Integer> PERIOD_UNITS;

	private static final Pattern TERM_PATTERN = Pattern.compile("^[ ]*([0-9]+)[ ]*([Y|M|W|D|h|m|s]).*$");

	static {
		PERIOD_UNITS = new HashMap<String, Integer>();
		PERIOD_UNITS.put("Y", new Integer(Calendar.YEAR));
		PERIOD_UNITS.put("M", new Integer(Calendar.MONTH));
		PERIOD_UNITS.put("W", new Integer(Calendar.WEEK_OF_MONTH));
		PERIOD_UNITS.put("D", new Integer(Calendar.DATE));
		PERIOD_UNITS.put("h", new Integer(Calendar.HOUR_OF_DAY));
		PERIOD_UNITS.put("m", new Integer(Calendar.MINUTE));
		PERIOD_UNITS.put("s", new Integer(Calendar.SECOND));
	}

	/**
	 * 对齐日期对象到指定精度
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            要对齐的时间域，参考Calendar中field的定义
	 * @return 对齐后的日期
	 */
	public static Date roundDate(Date date, int field) {
		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		roundDate(cal, field);

		return cal.getTime();
	}

	public static void roundDate(Calendar cal, int field) {
		boolean clearFlag = false;
		for (int i = 0; i < TIME_FIELD_LEVELS.length; i++) {
			if (clearFlag) {
				cal.set(TIME_FIELD_LEVELS[i], cal.getMinimum(TIME_FIELD_LEVELS[i]));
			} else if (TIME_FIELD_LEVELS[i] == field) {
				clearFlag = true;
			}
		}
	}

	/**
	 * 调整日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @param amount
	 *            调整数量
	 * @return 调整后的日期对象
	 */
	public static Date rollDate(Date date, int field, int amount) {
		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(field, amount);
		return cal.getTime();
	}

	/**
	 * 调整SQL日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @param amount
	 *            调整数量
	 * @return 调整后的日期对象
	 */
	public static java.sql.Date rollDate(java.sql.Date date, int field, int amount) {
		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(field, amount);
		return new java.sql.Date(cal.getTimeInMillis());
	}

	/**
	 * 获得日期对象的时间域值
	 * 
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @return 对应时间域的值
	 */
	public static int getDateField(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}

	/**
	 * 获得修改时间域值后的日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @param value
	 *            时间域的值
	 * @return 修改后的日期对象
	 */
	public static Date setDateField(Date date, int field, int value) {
		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(field, value);
		return cal.getTime();
	}

	/**
	 * 获得修改时间域值后的日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @param value
	 *            时间域的值
	 * @return 修改后的日期对象
	 */
	public static java.sql.Date setDateField(java.sql.Date date, int field, int value) {
		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(field, value);
		return new java.sql.Date(cal.getTimeInMillis());
	}


	/**
	 * 根据给定参数打造时间对象, 毫秒数为零.
	 * 
	 * @param year
	 *            年. 例 2009
	 * @param month
	 *            月. 从1开始, 例 1
	 * @param date
	 *            日. 从1开始, 例 10
	 * @return 日期对象. 如果参数错误, 则返回null, 例 year=0; month=2, date=30
	 */
	public static Date getDate(int year, int month, int date) {
		return getDate(year, month, date, 0, 0, 0);
	}

	/**
	 * 根据给定参数打造时间对象, 毫秒数为零.
	 * 
	 * @param year
	 *            年. 例 2009
	 * @param month
	 *            月. 从1开始, 例 1
	 * @param date
	 *            日. 从1开始, 例 10
	 * @param hourOfDay
	 *            小时. 24小时制, 从0开始, 例 23
	 * @param minute
	 *            分. 从0开始, 例 59
	 * @param second
	 *            秒. 从0开始, 例 59
	 * @return 日期对象. 如果参数错误, 则返回null, 例 year=0; month=2, date=30
	 */
	public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second) {
		try {
			Calendar c = Calendar.getInstance();
			c.setLenient(false);
			c.clear();
			c.set(year, month - 1, date, hourOfDay, minute, second);

			return c.getTime();
		} catch (Exception ex) {
			return null;
		}
	}

	// 获取当前年
	public static String getYear() {
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.YEAR));
	}
	
	// 获取当前月
	public static String getMonth() {
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.MONTH));
	}
	
	// 获取当前日
	public static String getDay() {
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
	}
	
	
	public static java.util.Date parse(String pattern, Locale locale, String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		
			return sdf.parse(str);
	
	}

	public static java.util.Date parse(String pattern, String str) throws ParseException {
		return parse(pattern, Locale.getDefault(), str);
	}

	public static String format(String pattern, Locale locale, java.util.Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		return sdf.format(date);
	}

	public static String format(String pattern, java.util.Date date) {
		return format(pattern, Locale.getDefault(), date);
	}

	/**
     * 取得当前日期时间，省略毫秒数。
     * yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    /**
     * 获取当前时间(带毫秒数)
     * @return
     */
    public static Date getCurrentDateFullTime() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
    
	/**
	 * 获取java.util.Date副本
	 * @param date 日期对象
	 * @return 日期对象
	 */
	public static Date getDate(Date date) {
		return (date != null ? new Date(date.getTime()) : null);
	}

	/**
	 * 获取java.sql.Date副本(自动重启)
	 * 
	 * @param date
	 *            日期对象
	 * @return 日期对象
	 */
	public static java.sql.Date getSQLDate(Date date) {
		return (date != null ? new java.sql.Date(DateUtil.roundDate(date, Calendar.DATE).getTime()) : null);
	}

	/**
	 * 根据给定参数打造java.sql.Date对象
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @return 日期对象. 如果参数错误, 则返回null
	 */
	public static java.sql.Date getSQLDate(int year, int month, int date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setLenient(false);
			c.clear();
			c.set(year, month - 1, date);

			return new java.sql.Date(c.getTimeInMillis());
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 在指定日期上增加指定时间(单位: 毫秒)
	 * 
	 * @param date
	 * @param millis
	 * @return
	 */
	public static Date addMillis(Date date, long millis) {
		return new Date(date.getTime() + millis);
	}

	/**
	 * 获取两个日期间隔的天数, 非正数天向上取整, 为正代表date1大于date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws NullpointerException
	 */
	public static int daysBetween(Date date1, Date date2) {
		return (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));
	}

	/**
	 * 获取两个日期间隔的月份数, 为正代表date1大于date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws NullpointerException
	 */
	public static int monthsBetween(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);

		return ((c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * 12 + (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH)));
	}

	/**
	 * 获取两个日期间隔的年数，为正代表date1大于date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws NullpointerException
	 */
	public static int yearsBetween(Date date1, Date date2) {
		return (getDateField(date1, Calendar.YEAR) - getDateField(date2, Calendar.YEAR));
	}

	public static int getCurrentQuarter(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return month / 3;
	}

	public static Date nextQuarterFirstMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		month = month % 3;
		cal.add(Calendar.MONTH, 3 - month);
		return cal.getTime();
	}

	public static boolean inTerm(String term, java.util.Date startTime, java.util.Date nowTime) {
		Matcher matcher = TERM_PATTERN.matcher(term);
		boolean matchFound = matcher.find();
		if (matchFound == false) {
			throw new IllegalArgumentException("Illegal term=[" + term + "].");
		}

		int num = Integer.valueOf(matcher.group(1), 10);
		String unit = matcher.group(2);

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(startTime.getTime());
		cal.add(PERIOD_UNITS.get(unit), num);

		return cal.getTime().compareTo(nowTime) >= 0;
	}


	public static boolean isSameDay(java.util.Date date1, java.util.Date date2) {
		String s1 = DateUtil.format("yyyy-MM-dd", date1);
		String s2 = DateUtil.format("yyyy-MM-dd", date2);

		return s1.equals(s2);
	}
}
