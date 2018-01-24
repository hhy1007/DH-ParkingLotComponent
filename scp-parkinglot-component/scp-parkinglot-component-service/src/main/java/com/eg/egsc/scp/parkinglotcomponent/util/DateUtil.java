/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期/时间工具类
 * 
 * @author zhangli
 * @since 2017年12月15日
 */
public class DateUtil extends DateUtils {

    private DateUtil () {}
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String AMERICAN = "MMM dd, yyyy hh:mm:ss a";
    public static final String ISO_DATETIME_TIME_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String MMM_DD_YYYY_HH_MM_SS_AAA = "MMM dd,yyyy HH:mm:ss aaa";
    public static final String MM_DD = "MM-dd";
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final String YMD = "yyyyMMdd";

    public static final String YEAR = "年";
    public static final String MONTH = "月";
    public static final String DAY = "日";
    public static final String HOUR = "时";
    public static final String MINITE = "分";
    public static final String SECOND = "秒";
    public static final String DAY_TI = "天";

    /** HH:mm:ss */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /** HH:mm */
    public static final String DEFAULT_TIME_FORMAT_HM = "HH:mm";

    /** 修改linux系统日期时间格式 */
    public static final String DATE_FORMAT_FOR_LINUX = "yyyy.MM.dd-HH:mm:ss";

    public static final long DAY_SECOND = 24 * 3600 * 1000L;
    
    public static final Long HOUR_SECOND = 1000 * 60 * 60L;

    /**
     * 获取当前时间戳 ：yyyy-MM-dd HH:mm:ss
     * 
     * @return String
     */
    public static String getCurrentTimeStr() {
        return dateToString(new Date(), YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 将日期转换为指定格式的字符串
     *  
     * @param dateValue
     * @param strFormat
     * @return String
     */
    public static String dateToString(Date dateValue, String strFormat) {
        return new SimpleDateFormat(strFormat).format(dateValue);
    }

    /**
     * 根据格式将字符串转换为日期对象
     * 
     * @param strValue
     * @param strFormat
     * @return Date
     */
    public static Date stringToDate(String strValue, String strFormat) {
        Date date = null;
        try {
            date = new SimpleDateFormat(strFormat).parse(strValue);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * Object类型的日期 转换为String
     * 
     * @param obj
     * @param strFormat
     * @return String
     */
    public static String objectToString(Object obj, String strFormat) {
        String result = null;
        if (obj != null) {
            if (obj instanceof Date) {
                result = dateToString((Date) obj, strFormat);
            } else {
                result = obj.toString();
            }
        }
        return result;
    }

    /**
     * Date转化为Timestamp
     * 
     * @param date
     * @return Timestamp
     */
    public static Timestamp dateToTimestamp(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        String time = df.format(date);
        return Timestamp.valueOf(time);
    }

    /**
     * 根据格式字符串将日期转化为Timestamp
     * 
     * @param date
     * @param format
     * @return Timestamp
     */
    public static Timestamp dateToTimestamp(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String time = df.format(date);
        return Timestamp.valueOf(time);
    }

    /**
     * 获取今天的零点时刻00:00:00
     * 
     * @return Date
     */
    public static Date getTodayBegin() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取今天的结束时刻23:59:59
     * 
     * @return Date
     */
    public static Date getTodayEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取某天的零点时刻00:00:00
     * 
     * @param date
     * @return Date
     */
    public static Date getDayBegin(Date date) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某天的结束时刻23:59:59
     * 
     * @param date
     * @return Date
     */
    public static Date getDayEnd(Date date) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取传入日期n天后的日期,如果传入日期为null，则表示当前日期n天后的日期
     * 
     * @param date
     * @param plusDays
     * @return Date
     */
    public static Date getAddDayDate(Date date, int plusDays) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.DAY_OF_MONTH, plusDays);
        return cal.getTime();
    }

    /**
     * 获取传入日期几天后（plusDays>0）or 几天前（plusDays<0）的指定格式的字符串日期
     * 
     * @param date
     * @param plusDays
     * @param dateFormat
     * @return String
     */
    public static String getAddDayDateFromToday(Date date, int plusDays, String dateFormat) {
        return dateToString(getAddDayDate(date, plusDays), dateFormat);
    }

    /**
     * 获取指定时间再加上指定小时数后的日期,如果传入日期为null，则以当前时间计算
     * 
     * @param date
     * @param plusHours
     * @return Date
     */
    public static Date getAddHourDate(Date date, int plusHours) {
        if (date == null)
            date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, plusHours);

        return cal.getTime();
    }

    /**
     * 获取指定时间再加上指定分钟数后的日期,如果传入日期为null，则以当前时间计算
     * 
     * @param date
     * @param plusMinutes
     * @return Date
     */
    public static Date getAddMinuteDate(Date date, int plusMinutes) {
        if (date == null)
            date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, plusMinutes);

        return cal.getTime();
    }

    /**
     * 获取指定时间再加上指定秒数后的日期,如果传入日期为null，则以当前时间计算
     *
     * @param date
     * @param plusMinutes
     * @return Date
     */
    public static Date getAddSecondDate(Date date, int plusMinutes) {
        if (date == null)
            date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, plusMinutes);

        return cal.getTime();
    }


    /**
     * 判断currentTime是否在startTime和endTime之间
     * 
     * @param startTime
     * @param endTime
     * @param currentTime
     * @return boolean
     */
    public static boolean compareDate(Date startTime, Date endTime, Date currentTime) {
        Long startMin = startTime.getTime();
        Long endMin = endTime.getTime();
        Long currentMin = currentTime.getTime();
        return (startMin <= currentMin && currentMin <= endMin) ? true : false;
    }

    /**
     * 判断currentTime是否在startTime和endTime之间
     * 
     * @param startTime
     * @param endTime
     * @param currentTime
     * @return boolean
     */
    public static boolean compareFeeRuleDate(Date startTime, Date endTime, Date currentTime) {
        Long startMin = startTime.getTime();
        Long endMin = endTime.getTime();
        Long currentMin = currentTime.getTime();
        return (startMin < currentMin && currentMin < endMin) ? true : false;
    }

    /**
     * 将Date转换为int形 格式(yyyyMMdd)
     * 
     * @param date
     * @return int
     */
    public static int toInteger(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR) * 10000 + (c.get(Calendar.MONTH) + 1) * 100
                + c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 按yyyyMMdd格式比较两个日期的大小
     * 
     * @param startTime
     * @param endTime
     * @param currentTime
     * @return boolean
     */
    public static boolean compareDateByYMD(Date startTime, Date endTime, Date currentTime) {
        int start = toInteger(startTime);
        int end = toInteger(endTime);
        int current = toInteger(currentTime);
        return (start <= current && current <= end) ? true : false;
    }

    /**
     * 按HMSS格式比较两个日期的大小
     * 
     * @param startTime
     * @param endTime
     * @param currentTime
     * @return boolean
     */
    public static boolean compareDateByHMSS(Date startTime, Date endTime, Date currentTime) {
        Long start = startTime.getTime() % 86400000;
        Long end = endTime.getTime() % 86400000;
        Long current = currentTime.getTime() % 86400000;
        return (start <= current && current <= end) ? true : false;
    }

    /**
     * 按yyyyMMdd格式比较两个日期的大小
     * 
     * @param time1
     * @param time2
     * @return int
     */
    public static int compareDateByYMD(Date time1, Date time2) {
        int t1 = toInteger(time1);
        int t2 = toInteger(time2);
        if (t1 > t2) {
            return 1;
        } else if (t2 == t1) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 计算间隔时间，m天n时i分j秒格式
     * 
     * @param beginTime
     * @param endTime
     * @return String
     */
    public static String getIntervalTime(Date beginTime, Date endTime) {
        long m = beginTime.getTime();
        long n = endTime.getTime();
        long interval = n - m;
        String result = "";
        if (interval >= 0) {
            interval = interval / 1000;
            int day = (int) (interval / 86400);
            int hour = 0;
            int minite = 0;
            if (day > 0) {
                interval = interval - day * 86400;
            }
            hour = (int) (interval / 3600);
            if (hour > 0) {
                interval = interval - hour * 3600;
            }
            minite = (int) (interval / 60);
            if (minite > 0) {
                interval = interval - minite * 60;
            }
            if (day > 0) {
                result = day + DAY_TI + hour + HOUR + minite + MINITE + interval + SECOND;
            } else if (hour > 0) {
                result = hour + HOUR + minite + MINITE + interval + SECOND;
            } else if (minite > 0) {
                result = minite + MINITE + interval + SECOND;
            } else {
                result = interval + SECOND;
            }
        }
        return result;
    }
    
    /**
     * 计算间隔时间相差小时数
     * 
     * @param beginTime
     * @param endTime
     * @return Long
     */
    public static Long getIntervalHours(Date beginTime, Date endTime) {
      long m = beginTime.getTime();
      long n = endTime.getTime();
      long interval = n - m;
      return interval / HOUR_SECOND;
    }

    /**
     * 在时间基础上加上 分钟数
     * 
     * @param minute
     * @return Date
     */
    public static Date getPlusMinuteDate(int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + minute);
        return cal.getTime();
    }

    /**
     * 把当前时间的年月日去掉
     * 
     * @param date
     * @return Date
     */
    public static Date dateSubYearMonthDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DEFAULT_TIME_FORMAT); 
        return DateUtil.stringToDate(sdf.format(date),
                DateUtil.DEFAULT_TIME_FORMAT);
    }

    /**
     * 把string格式HH:mm:ss日期加上年月日再加1天
     * 
     * @param time
     * @return Date
     */
    public static Date dateAddDay(Date time) {
        Calendar now = Calendar.getInstance();
        now.setTime(time);
        now.add(Calendar.DAY_OF_MONTH, 1);
        return now.getTime();
    }

    /**
     * 在时间基础上加上 月份数
     * 
     * @param originalDate
     * @param month
     * @return Date
     */
    public static Date getPlusMonthDate(Date originalDate, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(originalDate);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

}
