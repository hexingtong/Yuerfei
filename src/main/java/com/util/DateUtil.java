package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 时间类处理工具
 */
public class DateUtil {

	public final static String YYYYMM = "yyyyMM";

	public final static String YYYYMMDD = "yyyy-MM-dd";

	public final static String YYYYMMDDHHMMSS_24 = "yyyy-MM-dd HH:mm:ss";

	public final static String YYYYMMDDHHMMSS_12 = "yyyy-MM-dd hh:mm:ss";


	public static Date getUSToDate(String usDate) {
		SimpleDateFormat simp = new SimpleDateFormat("MM/dd/yyyy");
		Date dateTime;
		try {
			dateTime = simp.parse(usDate);
		} catch (ParseException e) {
			return null;
		}
		return dateTime;
	}


	public static String getUSToChinaStr(String usDate) {
		SimpleDateFormat simp = new SimpleDateFormat("MM/dd/yyyy");
		Date dateTime;
		try {
			dateTime = simp.parse(usDate);
			String yMd = format(dateTime, "yyyy-MM-dd");
			return yMd;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 
	 * @Description: 获取当前日期 ，返回07/13/2017格式
	 * @return
	 * @return String
	 */
	public static String getNowDate() {
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = simp.format(date);
		return dateTime;
	}
	/**
	 * 
	 * @Description: 获取当前时间YYYYMMDDHHMMSS_24
	 * @return
	 * @return String
	 */
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat(YYYYMMDDHHMMSS_24);
		String dateTime = simp.format(date);
		return dateTime;
	}
	public static String getUSDateStr() {
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("MMddyyyy");
		String dateTime = simp.format(date);
		return dateTime;
	}

	/**
	 *
	 * @Description: 日期减计算 默认是当天,返回07/13/2017格式
	 * @param diff 传入正数负数即可，程序取绝对值
	 * @return
	 * @return String
	 */
	public static String getSubDate(int diff) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -Math.abs(diff));
		Date date = c.getTime();
		SimpleDateFormat simp = new SimpleDateFormat("MM/dd/yyyy");
		String dateTime = simp.format(date);
		return dateTime;
	}

	/**
	 *
	 * @Description: 日期天数加减运算

	 * @param dateY
	 * @param diff
	 * @return
	 * @return String
	 */
	public static Date getSubDate(Date dateY, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(dateY);
		c.add(Calendar.DAY_OF_YEAR, -Math.abs(diff));
		Date date = c.getTime();
		return date;
	}
	/**
	 * 
	 * @Description: 日期添加运算
	 * @author Blue
	 * @date 2018年10月28日 下午10:16:28 
	 * @param dateY  要操作的日期
	 * @param diff  正数增加，负数减少
	 * @return
	 * @return Date
	 */
	public static Date addDate(Date dateY, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(dateY);
		c.add(Calendar.DAY_OF_YEAR, diff);
		Date date = c.getTime();
		return date;
	}

	/**
	 * 
	 * @Description: 返回昨天的日期
	 * @author
	 * @date 	 * @return
	 * @return Date
	 */
	public static Date getYesterdayDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -1);
		Date date = c.getTime();
		return date;
	}

	/**
	 * 
	 * @Description: 日期减计算,返回2017-01-01 13:12:01格式
	 * @author
	 * @date
	 * @param subDiff 传入正数负数即可，程序取绝对值
	 * @return
	 * @return String
	 */
	public static String getSubDateStr(int subDiff) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -Math.abs(subDiff));
		Date date = c.getTime();
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = simp.format(date);
		return dateTime;
	}

	/**
	 * 
	 * @Description: 美国格式日期04/20/2018 05:57 PM转成date
	 * @author
	 * @date 2018年7月25日 上午10:41:48
	 * @param dateStr
	 * @return
	 * @return String
	 */
	public static Date formatUSDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy K:m a", Locale.ENGLISH);
		Date d2 = null;
		try {
			d2 = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d2;
	}

	/**
	 * 按给出的格式化时间
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 获取当前月的第一天时间戳
	 * 
	 * @return
	 */
	public static int getFirstDayOfMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前月最后一天时间戳
	 * 
	 * @return
	 */
	public static int getLastDayOfMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前时间戳
	 *
	 * @return
	 */
	public static int getCurrentTime() {
		Calendar c = Calendar.getInstance();
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前时间戳
	 *
	 * @return
	 */
	public static int getCurrentDayTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		int rtn = 0;
		try {
			rtn = (int) (formatter.parse(formatter.format(new Date())).getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rtn;
	}

	/**
	 * 获取当前时间戳
	 *
	 * @return
	 */
	public static int getDayTime(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int rtn = 0;
		try {
			rtn = (int) (formatter.parse(date).getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rtn;
	}

	/**
	 * 获取当前时间戳
	 *
	 * @return
	 */
	public static int getDayTime1(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int rtn = 0;
		try {
			rtn = (int) (formatter.parse(date).getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rtn;
	}

	/**
	 * 
	 * @Description: yyyy-MM-dd格式字符串转date
	 * @author
	 * @date
	 * @param
	 * @return
	 * @return
	 */
	public static Date stringToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式的字符要和字符串的一样哦
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		/*
		 * int s = getCurrentTime(); System.out.println(s);
		 * System.out.println(unixTimeStampToDate(1488511536));
		 * System.out.println(timeToDateTime(1488470400));
		 * System.out.println(getCurrentDayTime());
		 */
		System.out.println(formatUSDate("04/20/2018 05:57 PM"));
	}

	// 11位时间戳转为具体日期
	public static String unixTimeStampToDateTime(int timestamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date(timestamp * 1000L));
		return dateStr;
	}

	// 11位时间戳转为具体日期
	public static String unixTimeStampToDate(int timestamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(new Date(timestamp * 1000L));
		return dateStr;
	}

	// 11位时间戳转为具体日期
	public static int timeToDateTime(int timestamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int rtn = 0;
		try {
			rtn = (int) (format.parse(format.format(new Date(timestamp * 1000L))).getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rtn;
	}

	/**
	 * 获取日期字符串
	 * 
	 * @return
	 */
	public static String getDateString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
		String rdNum = df.format(new Date());

		return rdNum;
	}

	/**
	 * 获取日期字符串(当前时间yyyy-MM-dd)
	 * 
	 * @return
	 */
	public static String getDateYMD() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String rdNum = df.format(new Date());
		return rdNum;
	}

	/**
	 * 
	 * @Description: 计算两个Date相差多少天
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 * @return long
	 */
	public static long getInterval(Date beginDate, Date endDate) {
		long day = 0;
		if (beginDate == null) {
			return day;
		}
		if (endDate == null) {
			return day;
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * @Description 获取过去第几天的日期
	 */
	public static Date pastDate(int past, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		return calendar.getTime();
	}

	/**
	 * @Description 获取未来 第 past 天的日期
	 */
	public static Date fetureDate(int past, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
		return calendar.getTime();
	}

	/**
	 * @Description 获取两个日期之间的日期
	 * @param start   开始日期
	 * @param end     结束日期
	 * @param pattern 日期格式
	 * @return 日期集合
	 */
	public static List<String> betweenDates(Date start, Date end, String pattern) {

		List<String> result = new ArrayList<String>();
		result.add(format(start, pattern));
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd)) {
			result.add(format(tempStart.getTime(), pattern));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(format(end, pattern));
		return result;
	}

	/**
	 * long类型时间转化指定格式字符串
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String longToDate(long time, String format) {

		Date date = new Date(time);

		SimpleDateFormat sd = new SimpleDateFormat(format);

		return sd.format(date);

	}
	public final static int SUNDAY = 1;

	public final static int MONDAY = 2;
	/**
	 * Description：获取当前的周数
	 * @author boyang
	 * @date 2019/3/26 9:11
	 * @param
	 * @return
	 */
	public static Integer getWeeked() {

		Date today = new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(today);
		int weekday=c.get(Calendar.DAY_OF_WEEK);

		return  weekday;

	}

}
