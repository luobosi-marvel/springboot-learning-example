/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * DateUtil
 *
 * @author 萝卜丝
 * @since 2017-11-06
 */
public class DateUtil {

    public static String YYMMDD = "yyyy-MM-dd";
    public static String YYMMDD_HHmm = "yyyy-MM-dd HH:mm";
    public static String YYMMDD_HHmmSS = "yyyy-MM-dd HH:mm:ss";
    public static String HHmmSS = "HH:mm:ss";
    public static String YYMMDDHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static String HHmm = "HH:mm";

    public static String HHMMSS_000000= " 00:00:00";


    /**
     * DateIntUtil start
     */

    /**
     * 返回当前int时间类型
     *
     * @return
     */
    public static int currentTime() {
        return Integer.parseInt(System.currentTimeMillis() / 1000 + "");
    }

    /**
     * 将数字日期解析成日期对象
     *
     * @param date
     * @return
     */
    public static Date parseInt(int date) {
        if (date == 0) {
            return null;
        }
        long dt = (long) date * 1000;
        Date d = new Date(dt);
        return d;
    }

    /**
     * 将日期转换为int 型时间
     *
     * @param date
     * @return
     */
    public static int parseInt(Date date) {
        if (date == null) {
            return 0;
        }
        return Integer.parseInt(date.getTime() / 1000 + "");
    }


    /**
     * 将数字日期解析成日期对象
     *
     * @param date
     * @return
     */
    public static String formatInt(int date) {
        if (date == 0) {
            return null;
        }
        return formatInt(date, YYMMDD_HHmmSS);

    }

    /**
     * 将数字日期解析成日期对象
     *
     * @param date
     * @param format 取值如：DateUtil.YYMMDD
     * @return
     */
    public static String formatInt(int date, String format) {
        if (date == 0) {
            return null;
        }
        long dt = (long) date * 1000;
        long dtt = Long.parseLong(dt + "");
        Date d = new Date(dtt);
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            return formater.format(d);
        } catch (Exception e) {
            return null;
        }

    }


    /**
     * DateIntUtil end
     */

    /**
     * 将数字日期解析成日期对象
     *
     * @param date
     * @return
     */
    public static Date parse(int date) {
        if (date == 0) {
            return null;
        }
        long dt = (long) date * 1000;
        long dtt = Long.parseLong(dt + "");
        Date d = new Date(dtt);
        return d;
    }

    /**
     * 将字符串日期解析成日期对象
     *
     * @param date
     * @param format 取值如：DateUtil.YYMMDD
     * @return
     */
    public static Date parse(String date, String format) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            return formater.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 将字符串日期解析成日期对象用于查询的结束时间
     *
     * @param strDate
     * @return
     */
    public static Date parseLastTime(String strDate) {
        return new Date(DateUtil.parse(strDate, DateUtil.YYMMDD).getTime() + 24 * 60 * 60 * 1000 - 1);

    }

    /**
     * 将字符串日期解析成日期对象
     *
     * @param date yyyy-MM-dd HH:mm
     * @return
     */
    public static Date parse(String date) {
        return parse(date, YYMMDD_HHmm);
    }


    /**
     * 将字符串日期解析成日期对象
     *
     * @param strDate
     * @return
     */
    public static Date parseYMD(String strDate) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        }

        SimpleDateFormat formater = new SimpleDateFormat(YYMMDD);
        try {
            return formater.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将字符串日期解析成日期对象
     *
     * @param strDate
     * @param endDate
     * @return
     */
    public static Date parseYMDHMS(String strDate, String endDate) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        }

        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return formater.parse(strDate + " " + endDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将日期对象解析成字符串
     *
     * @param date
     * @param format 取值如：DateUtil.YYMMDD
     * @return
     */
    public static String format(Date date, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        return formater.format(date);
    }

    /**
     * 将数字日期解析成日期对象
     *
     * @param date
     * @return
     */
    public static String format(int date) {
        if (date == 0) {
            return null;
        }
        return format(date, YYMMDD_HHmmSS);

    }

    /**
     * 将数字日期解析成日期对象
     *
     * @param date
     * @param format 取值如：DateUtil.YYMMDD
     * @return
     */
    public static String format(int date, String format) {
        if (date == 0) {
            return null;
        }
        long dt = (long) date * 1000;
        long dtt = Long.parseLong(dt + "");
        Date d = new Date(dtt);
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            return formater.format(d);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 将日期对象解析成字符串
     *
     * @param date yyyy-MM-dd HH:mm
     * @return
     */
    public static String format(Date date) {
        return format(date, YYMMDD_HHmm);
    }


    /**
     * 将日期格式化成年月日 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatYMD(Date date) {
        String strDate = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            strDate = format.format(date);
        } catch (Exception e) {
            return null;
        }
        return strDate;

    }

    public static String formatTimestamp() {
        return format(new Date(), YYMMDDHHmmssSSS);
    }

    /*
     * yyyy年MM月dd日 HH时mm分 yyyy-MM-dd HH:mm
     */
    public static String formatSimple(Date date) {
        return format(date, YYMMDD_HHmm);
    }

    /*
         * yyyy年MM月dd日 yyyy-MM-dd
         */
    public static String formatFully(Date date) {
        return format(date, YYMMDD_HHmmSS);
    }

    /**
     * 获得距当前时间多少天之后的日期
     *
     * @return
     */
    public static Date getAfterDate(int days) {

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
        return now.getTime();
    }

    /**
     * 当前时间，n个月之后的日期
     *
     * @return
     */
    public static Date getNmonthDate(int n) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, n);//
        return ca.getTime();
    }

    /**
     * 指定时间，n个月之后的日期
     *
     * @return
     */
    public static Date getNmonthDate(Date date, int n) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
//        ca.set(Calendar.DATE, ca.get(Calendar.DATE) + 1);
        ca.add(Calendar.MONTH, n);//
        return ca.getTime();
    }


    /**
     * 获得距指定时间多少天之后的日期
     *
     * @return
     */
    public static Date getAfterDate(Date date, int days) {

        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
        return now.getTime();
    }


    /**
     * 获得指定月份的周数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getTotalWeeksOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        c.add(Calendar.DATE, -1);// 日期减1
        return c.get(Calendar.WEEK_OF_MONTH);
    }


    /**
     * 获取指定年月的 最后一天
     *
     * @param date yyyyMM
     * @return
     */
    public static String getMonthLastday(String date) {
        Calendar cal = Calendar.getInstance();
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(4, 6));
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获得指定月份的天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        c.add(Calendar.DATE, -1);// 日期减1
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 往后推迟num天
     *
     * @param start
     * @param num
     * @param unit  Calendar.DATE Calendar.MINUTE Calendar.HOUR Calendar.MONTH
     * @return 推迟后的date
     */
    public static Date dateAdd(Date start, int num, int unit) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        switch (unit) {
            case Calendar.DATE:
                c.set(Calendar.DATE, c.get(Calendar.DATE) + num);
                break;
            case Calendar.MINUTE:
                c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + num);
                break;
            case Calendar.HOUR:
                c.set(Calendar.HOUR, c.get(Calendar.HOUR) + num);
                break;
            case Calendar.MONTH:
                c.set(Calendar.MONTH, c.get(Calendar.MONTH) + num);
                break;
            default:
                c.set(Calendar.MONTH, c.get(Calendar.MONTH) + num);
                break;
        }
        return c.getTime();
    }


    /**
     * 往前提前num天
     *
     * @param start
     * @param num
     * @return 提前后的date
     */
    public static Date dateSub(Date start, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - num);
        return c.getTime();
    }


    /**
     * 获得2个时间相减的天数
     *
     * @param unit  Calendar.DATE Calendar.MINUTE Calendar.HOUR
     * @param start
     * @param end
     * @return
     */
    public static long dateSubDays(Date start, Date end, int unit) {

        long mint = (end.getTime() - start.getTime()) / (1000);
        long hour = mint / 3600;
        long day = hour / 24;

        long result;
        switch (unit) {
            case Calendar.DATE:
                result = day;
                break;
            case Calendar.MINUTE:
                result = mint;
                break;
            case Calendar.HOUR:
                result = hour;
                break;
            default:
                result = day;
                break;
        }
        return result;

    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getMonthNowDate() {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DATE);
        String now = "";
        String mop = "-";
        String dop = "-";
        if (month < 10) {
            mop = mop + "0";
        }
        if (day < 10) {
            dop = dop + "0";
        }

        now = year + mop + month + dop + day;
        return now;
    }

    /**
     * 获取当前年份
     *
     * @param date 日期
     * @return
     */
    public static int getNowYear(Date date) {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取指定日期的年份
     *
     * @param p_date
     * @return
     */
    public static int getYearOfDate(Date p_date) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(p_date);
        return c.get(GregorianCalendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @param date 日期
     * @return
     */
    public static int getNowMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取星期名称
     *
     * @param date 日期
     * @return
     */
    public static String getDayweek(Date date) {
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayinweek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weeks[dayinweek];
    }

    /**
     * 获取当前日期起始周(星期日)
     *
     * @param date 日期
     * @return
     */
    public static Date getWeekStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, -day + 1);
        return cal.getTime();
    }

    /**
     * 获取当前日期周末(星期六)
     *
     * @param date 日期
     * @return
     */
    public static Date getWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, 6 - day + 1);
        return cal.getTime();
    }

    /**
     * 获取当月第一天时间
     *
     * @return
     */
    public static Date getMonthFirstDate() {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     * 获取当前月份下个月
     *
     * @return
     */
    public static String getNextMonth() {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String now = "";
        String mop = "-";
        if (month < 10) {
            mop = mop + "0";
            month = month + 1;
        } else if (month == 10 || month == 11) {
            month = month + 1;
        } else if (month == 12) {
            year = year + 1;
            month = 1;
            mop = mop + "0";
        }

        now = year + mop + month;
        return now;
    }

    /**
     * 时间戳转 时分
     *
     * @param beginDate
     * @return
     */
    public static String formatBeginDate(String beginDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(HHmm);
        String sd = sdf.format(new Date(Long.parseLong(beginDate)));
        return sd;
    }

    /**
     * 时间戳转 年月日 时分
     *
     * @param beginDate
     * @return
     */
    public static String formatStemp(String beginDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYMMDD_HHmm);
        String sd = sdf.format(new Date(Long.parseLong(beginDate)));
        return sd;
    }

    /**
     * 时间戳转 年月日
     *
     * @param beginDate
     * @return
     */
    public static String formatStemp2(String beginDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String sd = sdf.format(new Date(Long.parseLong(beginDate)));
        return sd;
    }

    /**
     * 通过时间，获取时间戳
     *
     * @param start
     * @return
     */
    public static long getTimeStemp(String start) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        long timeStemp = 0;
        try {
            date = simpleDateFormat.parse(start);
            timeStemp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return timeStemp;
    }


    /**
     * 通过时间，获取时间戳
     *
     * @param start
     * @return
     */
    public static long getTimeStemp2(String start) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYMMDD_HHmm);
        Date date = null;
        long timeStemp = 0;
        try {
            date = simpleDateFormat.parse(start);
            timeStemp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return timeStemp;
    }

    /**
     * 得到一天的最早时间.
     *
     * @param date 指定日期.
     * @return 一天的最早时间.
     */
    public static Date getZeroTime(Date date) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到一天的最后时刻.
     *
     * @param date 指定日期.
     * @return 一天的最后时刻.
     */
    public static Date getLastTime(Date date) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();

    }


    /**
     * 将日期转换成指定格式的字符串
     *
     * @param date       - 要转换的日期
     * @param dateFormat - 日期格式
     * @return String 日期对应的字符串
     */
    public static String convertDate2String(Date date, String dateFormat) {
        SimpleDateFormat sdf = null;
        if (dateFormat != null && !dateFormat.equals("")) {
            try {
                sdf = new SimpleDateFormat(dateFormat);
            } catch (Exception e) {
                sdf = new SimpleDateFormat(YYMMDD);
            }
        } else {
            sdf = new SimpleDateFormat(YYMMDD);
        }
        return sdf.format(date);
    }

    /**
     * 获取午夜12店的毫秒数
     *
     * @return
     */
    public static long getMidNightTime() {
        long time = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        time = calendar.getTimeInMillis();
        return time;
    }


    /**
     * 获取 前后 月份
     *
     * @param formatStr
     * @param month
     * @return
     */
    public static String getYesterdayMonthDifference(String formatStr, int month) {
        Calendar curr = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        curr.add(Calendar.DATE, -1);
        curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + month);
        return sdf.format(curr.getTime());
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static void main(String[] args) throws ParseException {
        Date sDate = parse("2016-08-03 00:11:11");
        System.out.print(daysBetween(new Date(), sDate));

    }
}