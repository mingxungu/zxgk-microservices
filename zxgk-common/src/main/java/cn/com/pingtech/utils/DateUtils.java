package cn.com.pingtech.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author gumx
 * @title: DateUtils
 * @description: 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @date 2019/8/27 13:31
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};


	public static String getLastDate(){
	   Calendar calendar = Calendar.getInstance();
	   calendar.add(Calendar.MONTH,-1);
	   int year = calendar.get(Calendar.YEAR);
	   int month = calendar.get(Calendar.MONTH)+1;
	   int day = calendar.get(Calendar.DATE);
	   return year+"-"+month+"-"+day;
    }
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	public static int getWeekInt() {
		Calendar ca = Calendar.getInstance();
		return ca.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date parseDateByPattern(Object str, String...pattern) {
		if (str == null){
			return null;
		}
		if(pattern == null || pattern.length == 0){
			pattern = parsePatterns;
		}
		try {
			return parseDate(str.toString(), pattern);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 获取当前日期（yyyy-MM-dd）
	 * @return
	 */
	public static Date getCurDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0); 
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	
	public static String getCurrentQuarter() {
		return formatDate(new Date(), "yyMM");
	}

	public static String getNextQuarter(){
		Calendar startCalendar = Calendar.getInstance();
		//年份最后两位
		int yearLast=Integer.parseInt(new SimpleDateFormat("yy", Locale.CHINESE).format(startCalendar.getTime()));
		int month=startCalendar.get(Calendar.MONTH)+1;
		if(month==12){
			yearLast=yearLast+1;
			return yearLast+"01";
		}else{
			String newMonth="";
			month=month+1;
			if(month<10){
				newMonth="0"+month;
			}else{
				newMonth=String.valueOf(month);
			}
			return String.valueOf(yearLast).concat(newMonth);

		}
	}
	
	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = System.currentTimeMillis()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		StringBuffer buffer = new StringBuffer();
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		if(day>0){
			buffer.append(day+",");
		}
		if(hour>0){
			buffer.append(hour+":");
		}
		if(min>0){
			buffer.append(min+":");
		}
		if(s>0){
			buffer.append(s+".");
		}
		if(sss>0){
			buffer.append(sss);
		}
		return buffer.toString();
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	/**
	 * 获取两个日期之间的秒
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static long getSecondOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / 1000;
	}
	
	/**
	 * 获取两个日期之间的分
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static long getMinuteOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60);
	}
	
	/**
	 * 获取两个日期之间的分(四舍五入)
	 * @param before
	 * @param after
	 * @return
	 */
	public static int getRoundMinuteOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		BigDecimal bg1 = BigDecimal.valueOf(afterTime - beforeTime);
		BigDecimal bg2 = BigDecimal.valueOf(1000 * 60d);
		return bg1.divide(bg2, BigDecimal.ROUND_HALF_UP).intValue();
	}
	
	/**
	 * 
	 * @方法名：getTimeBySecond
	 * @功能说明：获取当前时间多少秒之前或之后的数据  之前负号
	 * @author 顾明训
	 * @param @param second
	 * @param @return
	 * @return String
	 * @date Sep 22, 20171:12:57 PM
	 */
	public static String getTimeBySecond(Date now,int second){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.SECOND, second);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
		
	}
	
	
	/**
	 * 
	 * @方法名：getAge
	 * @功能说明：根据日期计算年龄
	 * @author kongls
	 * @param @param birthDay
	 * @param @return
	 * @return String
	 * @date Sep 22, 20171:12:57 PM
	 */
	public static int getAge(Date birthDay) {
		
		Calendar cal = Calendar.getInstance();
		if (birthDay != null && cal.before(birthDay)) {
			return 0;
		}

		int yearNow = cal.get(Calendar.YEAR);

		cal.setTime(birthDay);
		
		int yearBirth = cal.get(Calendar.YEAR);

		int age = yearNow - yearBirth;
		

		return age;
	}
	
	/**
	 * 功能描述: <br>
	 * 〈〉
	 * @Param: 
	 * @Return: 
	 * @Author: gumx
	 * @Date: 2019/8/27 14:03
	 */
	public static Date nextDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, day+1);
		return calendar.getTime();
	}

	/**
	 * 功能描述: <br>
	 * 〈〉
	 * @Param:
	 * @Return:
	 * @Author: gumx
	 * @Date: 2019/8/27 14:05
	 */
	public static Date beforeDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, day-1);
		return calendar.getTime();
	}
	
	//任意天数之前的日期
	public static Date intervalBeforeDay(Date date,int interval){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, day-interval);
		return calendar.getTime();
	}
	
	//任意天数之前的日期
		public static Date intervalBeforeHour(Date date,int interval){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.HOUR, -interval);
			return calendar.getTime();
		}
	
	//获取指定月的天数
	public static int getMonthLastDay(int year,int month){
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR,year);
		a.set(Calendar.MONTH, month-1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
	
	/**
	 * 返回上个月的今天，时分秒为0
	 */
	public static Date getLastMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 返回当月的今天，时分秒为0
	 */
	public static Date getCurrentMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 
	 * getCurrDayStart:获取当天的开始日期   
	 *  
	 * @author gumx  
	 * @return  
	 * @since JDK 1.8
	 */
	public static Date getCurrDayStart(){
		Date day = parseDateByPattern(getDate()+" 00:00:00","yyyy-MM-dd HH:mm:ss");
		return day;
	}
	
	/**
	 * 
	 * getCurrDayEnd:获取当前天数的结束日期    
	 *  
	 * @author gumx  
	 * @return  
	 * @since JDK 1.8
	 */
	public static Date getCurrDayEnd(){
		Date day = parseDateByPattern(getDate()+" 23:59:59","yyyy-MM-dd HH:mm:ss");
		return day;
	}
	
	/**
	 * 根据输入有效期计算有效状态
	 * @param validStartDate
	 * @param validEndDate
	 * @return Integer
	 * @author kongls
	 */
	public static Integer getValidStatus(Date validStartDate,Date validEndDate){
		
		Integer in = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		
		validStartDate = setDefaultValue(validStartDate, df.format(now));
		validEndDate = setDefaultValue(validEndDate, "2099-12-30");
		
		if (validStartDate.getTime()<=now.getTime() && validEndDate.getTime()>= now.getTime()) {
			in = 1;
		}else{
			in = 2;
		}
		
		return in;
	}

	/**
	 * 如果给定的validDate为null，给它一个默认值date
	 * @param validDate
	 * @param date
	 * @return Date
	 */
	public static Date setDefaultValue(Date validDate, String date) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if (validDate == null) {
			try {
				validDate = df.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return validDate;
	}


	public static void main(String[] args) {
		
		Calendar ca = Calendar.getInstance();
		System.out.println(ca.get(Calendar.YEAR));
		System.out.println(ca.get(Calendar.MONTH) + 1);
		
		System.out.println(intervalBeforeHour(new Date(),2));
	}

	/**
	 * 获取文件名
	 * @param jgCode
	 * @return String
	 */
	public static String getFileName(String jgCode){
		String fileName = "";
		
		Date name = new Date();
		String time = formatDateTime(name);
		fileName = fileName + time.substring(0, 4) + time.substring(5, 7) + time.substring(8, 10) + time.substring(11, 13)+time.substring(14, 16)+ time.substring(17, 19);
		fileName = fileName + "-" + jgCode;
		return fileName;
	}

	/**
	 * 获取当前年字符串
	 * @return String
	 */
	public static String getNowYear(){
		String fileName = "";
		
		Date name = new Date();
		String time = formatDateTime(name);
		fileName = time.substring(5, 7) + time.substring(8, 10);
		return fileName;
	}

	/**
	 * 获取当前月日字符串
	 * @return String
	 */
	public static String getNowMonthDay(){
		String fileName = "";
		
		Date name = new Date();
		String time = formatDateTime(name);
		fileName = fileName + time.substring(0, 4);
		return fileName;
	}

	/**
	 * @Description: 获取2个时间之间所有的天数
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param pattern 格式化日期参数
	 * @return
	 * List<String>
	 * @throws
	 */
	public static List<String> getTimeBetweenTwoDays(Date startDate, Date endDate, String pattern){
		if(startDate == null || endDate == null || startDate.after(endDate)){
			return null;
		}
		List<String> dateList = new ArrayList<String>();
		Calendar calStart = Calendar.getInstance();
		calStart.setTime(startDate);
		while(calStart.getTime().before(endDate)){
			String dateStr = formatDate(calStart.getTime(), pattern);
			dateList.add(dateStr);
			calStart.add(Calendar.DAY_OF_MONTH, 1);
		}
		return dateList;
	}

}
