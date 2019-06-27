package org.clesun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DateUtil {
    private static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Get the previous time, from how many days to now.
     *
     * @param days How many days.
     * @return The new previous time.
     *  获取当前时间几天前的日期
     */
    public static Date previous(int days) {
        return new Date(System.currentTimeMillis() - days * 3600000L * 24L);
    }

    /**
     * Convert date and time to string like "yyyy-MM-dd HH:mm".
     */
    public static String formatDateTime(Date d) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(d);
    }

    /**
     * Convert date and time to string like "yyyy-MM-dd HH:mm".
     */
    public static String formatDateTime(long d) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(d);
    }

    /**
     * Convert date to String like "yyyy-MM-dd".
     */
    public static String formatDate(Date d) {
        return new SimpleDateFormat(DATE_FORMAT).format(d);
    }
    /**
     * 格式化日期
     * @param d
     * @param format yyyyMMddHHmmssSSS
     * @return
     *
     */
    public static String formatDate(Date d,String format) {
        return new SimpleDateFormat(format).format(d);
    }

    /**
     * Parse date like "yyyy-MM-dd".
     */
    public static Date parseDate(String d) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(d);
        }
        catch(Exception e) {}
        return null;
    }

    /**
     * Parse date and time like "yyyy-MM-dd hh:mm".
     */
    public static Date parseDateTime(String dt) {
        try {
            return new SimpleDateFormat(DATETIME_FORMAT).parse(dt);
        }
        catch(Exception e) {}
        return null;
    }

    public static void main(String[] args){
        System.out.println(DateUtil.add());
    }
    public static Set<String> add(){
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 100; i++) {
            set.add(""+i);
        }
        return set;
    }
}
