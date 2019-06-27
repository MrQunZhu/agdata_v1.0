package org.clesun.utils;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by clesun on 2017/5/17.
 */
public class DateUtils {
    private static Calendar cal = Calendar.getInstance();

    public static void main(String[] args) throws ParseException {
        // Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2013-04-24");
        // Date d1, d2, d3, d4, d5, d6;
        // d1 = DateUtils.firstDayOfMonth(date);
        // d2 = DateUtils.lastDayOfMonth(date);
        // d3 = DateUtils.firstDayOfWeek(date);
        // d4 = DateUtils.lastDayOfWeek(date);
        // d5 = DateUtils.firstDayOfYear(date);
        // d6 = DateUtils.lastDayOfYear(date);
        //
        // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d1));
        // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d2));
        // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d3));
        // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d4));
        // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d5));
        // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d6));

        Date d = new Date();

        System.out.println(getWeekNumOfYear(d));

    }

    /**
     * long型时间戳转日期型
     *
     * @param datetime
     *            long型时间戳
     * @param formatOption
     *            日期格式 :"yyyy-MM-dd"、"yyyy-MM-dd HH:mm:ss";默认格式："yyyy-MM-dd"
     * @return
     */
    public static Date longToDate(long datetime, String formatOption) {
        if (formatOption == null || "".equals(formatOption)) {
            formatOption = "yyyy-MM-dd";
        }
        try {
            SimpleDateFormat dateStyle = new SimpleDateFormat(formatOption);
            String d = dateStyle.format(datetime);
            Date date = dateStyle.parse(d);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按指定格式格式化日期
     *
     * @Description:
     * @param d
     *            日期参数
     * @param formatOption
     *            日期格式 :"yyyy-MM-dd"、"yyyy-MM-dd HH:mm:ss";默认格式："yyyy-MM-dd"
     * @return 格式化后的字符串
     * @author OvO
     * @date 2013-4-1
     */
    public static String formatDate(Date d, String formatOption) {
        String newDate = "";
        if (d == null) {
            return newDate;
        }
        if (formatOption == null) {
            formatOption = "yyyy-MM-dd";
        }
        try {
            SimpleDateFormat dateStyle = new SimpleDateFormat(formatOption);
            newDate = dateStyle.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /**
     * 按指定格式格式化日期
     *
     * @Description:
     * @param dt
     *            日期参数
     * @param formatOption
     *            日期格式 :"yyyy-MM-dd"、"yyyy-MM-dd HH:mm:ss";默认格式：
     *            "yyyy-MM-dd HH:mm:ss"
     * @return 格式化后的字符串
     * @author OvO
     * @date 2013-4-1
     */
    public static String formatTimestamp(Timestamp dt, String formatOption) {
        String newDate = "";
        if (dt == null) {
            return newDate;
        }
        if (formatOption == null) {
            formatOption = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            SimpleDateFormat dateStyle = new SimpleDateFormat(formatOption);
            newDate = dateStyle.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 获取当前日期是星期几的数字序号<br>
     *
     * @param dt
     * @return 当前日期是星期几的数字序号
     */
    public static int getDateNumOfWeek(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    /**
     * 获取给定时间所在年的周数
     * @param date
     * @return
     */
    public static int getWeekNumOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当前时间所在年的最大周数
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekNumOfYear(c.getTime());
    }

    /**
     * 获取某年的第几周的开始日期
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 获取某年的第几周的结束日期
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 获取当前时间所在周的开始日期
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());// Monday
        return c.getTime();
    }

    /**
     * 获取当前时间所在周的结束日期
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);// Sunday
        return c.getTime();
    }

    /**
     * 验证日期字符串是否符合给定的格式
     *
     * @Description:
     * @param dateStr
     *            日期字符串
     * @param format
     *            格式
     * @return true:符合，false:错误
     * @author OvO
     * @date 2013-4-1
     */
    public static boolean verifyDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d = sdf.parse(dateStr);
            if (dateStr.equals(sdf.format(d))) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 按指定格式将字符串转换为Date类型，如果转换失败刚返回当前日期
     *
     * @Description:
     * @param dateStr
     *            需要转换的字符串
     * @param format
     *            日期格式 如:"yyyy-MM-dd"、"yyyy-MM-dd HH:mm:ss"
     * @return
     * @author OvO
     * @date 2013-4-1
     */
    public static Date stringToDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d = sdf.parse(dateStr);
            return d;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取字符串转日期
     * @param dateStr 处理格式依次为：yyyy-MM-dd HH:mm:ss、yyyy-MM-dd HH:mm、yyyy-MM-dd、dd/MM/yyyy HH:mm:ss、dd/MM/yyyy HH:mm、dd/MM/yyyy
     * @return
     * @author linsf
     */
    public static Date stringToDate(String dateStr) {
        Date d=null;
        if(null==d)	{
            d=DateUtils.stringToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        }
        if(null==d)	{
            d=DateUtils.stringToDate(dateStr, "yyyy-MM-dd HH:mm");
        }
        if(null==d)	{
            d=DateUtils.stringToDate(dateStr, "yyyy-MM-dd");
        }
        if(null==d)	{
            d=DateUtils.stringToDate(dateStr, "dd/MM/yyyy HH:mm:ss");
        }
        if(null==d)	{
            d=DateUtils.stringToDate(dateStr, "dd/MM/yyyy HH:mm");
        }
        if(null==d)	{
            d=DateUtils.stringToDate(dateStr, "dd/MM/yyyy");
        }
        return d;
    }

    /**
     * 为给定的日期添加days天数，
     *
     * @Description:
     * @param date
     *            需要增加天数的日期
     * @param days
     *            天数 正数为增加， 负数为减少
     * @return 返回增加后的日期
     * @author OvO
     * @date 2013-4-1
     */
    public static Date addDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // System.out.println(calendar.get(Calendar.DAY_OF_MONTH));// 今天的日期
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);// 让日期加1
        // System.out.println(calendar.get(Calendar.DATE));// 加1之后的日期Top
        return calendar.getTime();
    }

    /**
     * 为给定的日期添加hours小时数，
     *
     * @param date
     * @param hours
     * @return
     * @author OvO
     * @date 2013-4-18
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hours);// 让日期加1
        return calendar.getTime();
    }

    /**
     * 为给定的日期添加minute分钟数，
     *
     * @param date
     * @param minute
     * @return
     * @author OvO
     * @date 2013-4-18
     */
    public static Date addMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);// 让日期加1
        return calendar.getTime();
    }
    /**
     *  为给定的日期添加second秒数
     * @param date
     * @param second
     * @return
     * @author linsf
     */
    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + second);// 让日期加1
        return calendar.getTime();
    }

    /**
     * 获取给定日期的当天最大日期时间
     * @param date yyyy-MM-dd
     * @return yyyy-MM-dd 23:59:59
     * @author linsf
     */
    public static Date getDateMaxTime(Date date){
        SimpleDateFormat dateStyle = new SimpleDateFormat("yyyy-MM-dd");
        String d = dateStyle.format(date);
        Date d2;
        try {
            d2 = dateStyle.parse(d);
        } catch (ParseException e) {
            d2=date;
        }
        return addSecond(addDate(d2, 1), -1);
    }

    /**
     * 取当前日期所在年的第一天
     *
     * @Description:
     * @param date
     * @return
     * @author OvO
     * @date 2013-4-1
     */
    public static Date firstDayOfYear(Date date) {
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    /**
     * 取当前日期所在年的最后一天
     *
     * @Description:
     * @param date
     * @return
     * @author OvO
     * @date 2013-4-1
     */
    public static Date lastDayOfYear(Date date) {
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.roll(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }

    /**
     * 取当前日期所在月的第一天
     *
     * @Description:
     * @param date
     * @return
     * @author OvO
     * @date 2013-4-1
     */
    public static Date firstDayOfMonth(Date date) {
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 取当前日期所在月的最后一天
     *
     * @Description:
     * @param date
     * @return
     * @author OvO
     * @date 2013-4-1
     */
    public static Date lastDayOfMonth(Date date) {
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 取当前日期所在星期的第一天（星期日为一周的第一天）
     *
     * @Description:
     * @param date
     * @return
     * @author OvO
     * @date 2013-4-1
     */
    public static Date firstDayOfWeek(Date date) {
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        return cal.getTime();
    }

    /**
     * 取当前日期所在星期的最后一天（星期六为一周的最后一天）
     *
     * @Description:
     * @param date
     * @return
     * @author OvO
     * @date 2013-4-1
     */
    public static Date lastDayOfWeek(Date date) {
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        cal.roll(Calendar.DAY_OF_WEEK, -1);
        return cal.getTime();
    }

    /**
     * 获取对应日期类型的数字值
     *
     * @param date
     *            日期
     * @param type
     *            日期类型："y"年,"M"月,"d"日,"H"时,"m"分,"s"秒
     * @return
     */
    public static String numOfDate(Date date, String type) {
        String datestr = formatDate(date, "yyyy-MM-dd HH:mm:ss");
        if ("y".equals(cTrim(type))) {
            return datestr.substring(0, 4);
        } else if ("M".equals(cTrim(type))) {
            return datestr.substring(5, 7);
        } else if ("d".equals(cTrim(type))) {
            return datestr.substring(8, 10);
        } else if ("H".equals(cTrim(type))) {
            return datestr.substring(11, 13);
        } else if ("m".equals(cTrim(type))) {
            return datestr.substring(14, 16);
        } else if ("s".equals(cTrim(type))) {
            return datestr.substring(17, 19);
        } else {
            return "";
        }
    }


    /**
     * 计算两个日期的时间间隔(秒级)
     *
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @return interval 时间间隔（相差秒数）
     */
    public static int calIntervalM(Date sDate, Date eDate) {
        long s=sDate.getTime()-eDate.getTime();
        if(s<=Integer.MAX_VALUE && s>Integer.MIN_VALUE){
            return (int) s;
        }if(s>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }if(s<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return 0;
    }

    /**
     * 计算两个日期的时间间隔
     *
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @param type 间隔类型
     *            ("Y/y"--年 "M/m"--月 "D/d"--日)
     * @return interval 时间间隔
     * */
    public static int calInterval(Date sDate, Date eDate, String type) {
        // 时间间隔，初始为0
        int interval = 0;
		/* 比较两个日期的大小，如果开始日期更大，则交换两个日期 */
        // 标志两个日期是否交换过
        boolean reversed = false;
        if (compareDate(sDate, eDate) > 0) {
            Date dTest = sDate;
            sDate = eDate;
            eDate = dTest;
            // 修改交换标志
            reversed = true;
        }
		/* 将两个日期赋给日历实例，并获取年、月、日相关字段值 */
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(sDate);
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);
        int sDays = sCalendar.get(Calendar.DAY_OF_YEAR);
        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setTime(eDate);
        int eYears = eCalendar.get(Calendar.YEAR);
        int eMonths = eCalendar.get(Calendar.MONTH);
        int eDays = eCalendar.get(Calendar.DAY_OF_YEAR);
        // 年
        if ("Y".equals(cTrim(type)) || "y".equals(cTrim(type))) {
            interval = eYears - sYears;
            if (eMonths < sMonths) {
                --interval;
            }
        }
        // 月
        else if ("M".equals(cTrim(type)) || "m".equals(cTrim(type))) {
            interval = 12 * (eYears - sYears);
            interval += (eMonths - sMonths);
        }
        // 日
        else if ("D".equals(cTrim(type)) || "d".equals(cTrim(type))) {
            interval = 365 * (eYears - sYears);
            interval += (eDays - sDays);
            // 除去闰年天数
            while (sYears < eYears) {
                if (isLeapYear(sYears)) {
                    --interval;
                }
                ++sYears;
            }
        }
        // 如果开始日期更大，则返回负值
        if (reversed) {
            interval = -interval;
        }
        return interval;
    }

    /**
     *
     * 判定某个年份是否是闰年
     *
     * @param year 待判定的年份
     * @return 判定结果
     * */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    /**
     *
     * 字符串去除两头空格，如果为空，则返回""，如果不空，则返回该字符串去掉前后空格
     *
     * @param tStr 输入字符串
     * @return 如果为空，则返回""，如果不空，则返回该字符串去掉前后空格
     */
    private static String cTrim(String tStr) {
        String ttStr = "";
        if (tStr == null) {
        } else {
            ttStr = tStr.trim();
        }
        return ttStr;
    }

    /**
     * 比较两个Date类型的日期大小
     *
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @return result 返回结果(0--相同 1--前者大 2--后者大)
     * */
    public static int compareDate(Date sDate, Date eDate) {
        int result = 0;
        // 将开始时间赋给日历实例
        Calendar sC = Calendar.getInstance();
        sC.setTime(sDate);
        // 将结束时间赋给日历实例
        Calendar eC = Calendar.getInstance();
        eC.setTime(eDate);
        // 比较
        result = sC.compareTo(eC);
        // 返回结果
        return result;
    }

    public static String getVMNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyMMddHH");
        return df.format(date);
    }

}
