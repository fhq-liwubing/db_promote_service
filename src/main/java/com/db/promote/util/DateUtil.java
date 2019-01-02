package com.db.promote.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by weijianglong on 2015/9/5.
 */
public class DateUtil {

    private static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    private static final String PATTERN_DATE = "yyyy-MM-dd";

    private static final String PATTERN_FOURTEEN = "yyyyMMddHHmmss";

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(PATTERN_DATETIME);

    public static String formatDateTime(Date date) {
        return format(PATTERN_DATETIME, date);
    }

    public static String formatDate(Date date) {
        return format(PATTERN_DATE, date);
    }

    /**
     * @param date
     * @param pattern
     * @return
     * @description 解析字符串为日期对象
     */
    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        ParsePosition pp = new ParsePosition(0);
        return sdf.parse(date, pp);
    }

    public static String formatDateFourteen(Date date) {
        return format(PATTERN_FOURTEEN, date);
    }

    public static Date parseDateTime(String str) {
        return parse(PATTERN_DATETIME, str);
    }

    public static Date parseDate(String str) {
        return parse(PATTERN_DATE, str);
    }

    public static Date parseFormateDate(String str) {
        return parse(PATTERN_FOURTEEN, str);
    }

    public static String formatCurrentDateTime() {
        return formatDateTime(new Date());
    }

    public static String formatCurrentDate() {
        return formatDate(new Date());
    }

    /**
     * 计算两个时间之间相差天数：date1-date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long diffDays(Date date1, Date date2) {
        Date d1 = truncateToDate(date1);
        Date d2 = truncateToDate(date2);

        long diff = d1.getTime() - d2.getTime();

        return diff / 1000 / 3600 / 24;
    }

    public static Date truncateToDate(Date date) {
        return truncateToCalendar(date).getTime();
    }

    public static Calendar truncateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal;
    }

    public static Calendar truncateToCalendar(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar;
    }

    public static String format(String pattern, Date date) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat FORMATTER = new SimpleDateFormat();
        FORMATTER.applyPattern(pattern);
        return FORMATTER.format(date);
    }

    public static Date parse(String pattern, String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        SimpleDateFormat FORMATTER = new SimpleDateFormat();
        FORMATTER.applyPattern(pattern);

        try {
            return FORMATTER.parse(str);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 获取当月起止日期时间
     * <p>
     * 以2015年10月份为例，返回的是2015-10-01 00:00:00 和 2015-11-01 00:00:00
     *
     * @param now
     * @return
     */
    public static Pair<Date, Date> getMonthRange(Date now) {
        Calendar tmp = Calendar.getInstance();
        tmp.setTime(now);

        tmp.set(Calendar.DAY_OF_MONTH, 1);
        tmp.set(Calendar.HOUR_OF_DAY, 0);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        Date startDate = tmp.getTime();

        tmp.add(Calendar.MONTH, 1);
        Date endDate = tmp.getTime();

        return Pair.of(startDate, endDate);
    }

    /**
     * date类型时间转换为LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * String类型时间转换为LocalDateTime
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime toLocalDateTime(String dateTime) {
        Date date = parseDateTime(dateTime);
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    public static String format(LocalDateTime dateTime) {
        if (dateTime != null) {
            return FORMATTER.format(dateTime);
        }
        return null;
    }

}
