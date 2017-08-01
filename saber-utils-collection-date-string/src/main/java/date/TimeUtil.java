package date;

import constant.CommonConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by wangzhen on 2017/8/1.
 */
public class TimeUtil {
    private static final Logger logger = Logger.getLogger(TimeUtil.class);
    public final static long HALF_AN_HOUR_IN_MINISECONDS = 60L * 60 * 1000;
    public final static long HOUR_IN_MINISECONDS = 60L * 60 * 1000;
    public final static long DAY_IN_MINISECONDS = 24L * 60 * 60 * 1000;
    public final static long WEEK_IN_MINISECONDS = 7L * 24 * 60 * 60 * 1000;
    public final static long LEAP_YEAR_IN_MINISECONDS = 366L * 24 * 60 * 60 * 1000;

    public static final String DATE_TO_YEAR_MONTH = "yyyy-MM";
    public static final String DATA_FORMAT_YEAR_MONTH = "yyyy年MM月";
    public static final String DATE_TO_YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_IN_SLASH_FORMAT = "yyyyMMdd'T'HH:mm:ss";
    public static final String DEFAULT_CHINA_TIME_FORMAT = "yyyy年MM月dd日 HH时mm分";

    public static final String TIME_IN_DETAIL_STRING_FORMAT = "yyyyMMddHHmmss";
    private static final String DATA_FORMAT_MONTH_DAY = "M月d日";
    private static final String TIME_FORMAT_IN_DAY = "HH:mm";

    private static final String DATA_FORMAT_MONTH_DAY_TIME = "M月d日 HH:mm";

    public static final Date SYSTEM_END_TIME = stringToDate("2099-12-30");

    private TimeUtil() {
    }

    public static String timestampToString(Timestamp time, String formart) {
        try {
            DateFormat sdf = new SimpleDateFormat(formart);
            if (null == time) {
                return "";
            }
            return sdf.format(time);
        } catch (Exception e) {
            logger.error("erro in timestampToString",e);
            return "";
        }
    }

    public static Date stringToDate(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(DATE_TO_YEAR_MONTH_DAY);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in stringToDate" , e);
            return null;
        }
        return date;
    }

    public static Date stringToMoth(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(DATE_TO_YEAR_MONTH);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in stringToMoth" , e);
            return null;
        }
        return date;
    }

    public static Timestamp getStartTimeOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Timestamp(cal.getTimeInMillis());
    }

    public static Timestamp dateToTimeStamp(Date date) {
        if (null == date) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    public static Timestamp stringToTimeStamp(String date, String formart) {
        Timestamp ts = null;
        if (null == date || "".equals(date)) {
            return ts;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
        try {
            Date dateTime = dateFormat.parse(date);
            ts = new Timestamp(dateTime.getTime());
        } catch (ParseException e) {
            logger.error("erro in stringToTimeStamp",e);
        }
        return ts;
    }

    /**
     * @param @param  date
     * @param @return
     * @return Timestamp
     * @throws
     * @Title: WDateToTimeStamp
     * @Description: WDate时间yyyy-MM-dd 默认为8点，此处将时间提前8小时，接受前台空间时间专用
     */
    public static Timestamp WDateToTimeStamp(Date date) {
        if (null == date) {
            return null;
        }
        Calendar Cal = java.util.Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(java.util.Calendar.HOUR_OF_DAY, -8);
        return new Timestamp(Cal.getTime().getTime());
    }

    /**
     * @param @param  date
     * @param @return
     * @return Timestamp
     * @throws
     * @Title: WDateToTimeStamp
     * @Description: WDate时间yyyy-MM-dd 默认为8点，此处将时间提前8小时，接受前台空间时间专用
     */
    public static Timestamp WDateToTimeStamp(String date) {
        if (null == date) {
            return null;
        }
        return stringToTimeStamp(date, "yyyy-MM-dd");
    }

    // 负数为前 正式为后
    public static Date timeAround(Date date, int hour) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(java.util.Calendar.HOUR_OF_DAY, hour);
        return Cal.getTime();
    }
    public static Date timeAroundMinute(Date date, int minute) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(java.util.Calendar.MINUTE, minute);
        return Cal.getTime();
    }

    public static Timestamp timeAround(Timestamp time, int hour) {
        java.util.Calendar Cal = java.util.Calendar.getInstance();
        Cal.setTime(time);
        Cal.add(java.util.Calendar.HOUR_OF_DAY, hour);
        return new Timestamp(Cal.getTime().getTime());
    }

    public static Date dayAfter(Date date, int dayLength) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, dayLength);
        return cal.getTime();
    }

    public static Date dayBefore(Date date, int dayLength) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1 * dayLength);
        return cal.getTime();
    }

    public static Date monthAfter(Date date, int monthLength) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthLength);
        return cal.getTime();
    }

    public static Map<String, String> defaultQueryTime() {
        Map<String, String> defaultTime = new HashMap<String, String>();
        Date startDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        String startTime = sdf.format(startDate);
        defaultTime.put("endTime", startTime);
        defaultTime.put("startTime", startTime);
        return defaultTime;
    }

    public static String dateToString(Date date, String formart) {
        SimpleDateFormat sdf = new SimpleDateFormat(formart);
        if (date == null) {
            return "";
        }
        return sdf.format(date);
    }

    /**
     * @param @param  strDate
     * @param @param  formart
     * @param @return
     * @return String
     * @throws
     * @Title: getWeek
     * @Description: 根据日期获取星期几
     */
    public static String getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return new SimpleDateFormat("EEEE", Locale.CHINA).format(calendar.getTime());
    }

    /**
     * @param @param  strDate
     * @param @param  formart
     * @param @return
     * @return Date
     * @throws
     * @Title: getMondayOfPreviousWeek
     * @Description: 获取上周周一日期
     */
    public static String getMondayOfPreviousWeek(String strDate, String formart) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(formart);
        try {
            date = shortDateFormat.parse(strDate);
        } catch (ParseException e) {
            logger.error("erro in getMondayOfPreviousWeek" , e);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 1);
        calendar.add(Calendar.DATE, -7);
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * @param @param  strDate
     * @param @param  formart
     * @param @return
     * @return Date
     * @throws
     * @Title: getMondayOfNextWeek
     * @Description: 获取下周周一日期
     */
    public static String getMondayOfNextWeek(String strDate, String formart) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(formart);
        try {
            date = shortDateFormat.parse(strDate);
        } catch (ParseException e) {
            logger.error("erro in getMondayOfNextWeek" , e);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 1);
        calendar.add(Calendar.DATE, +7);
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * @param @param  strDate
     * @param @param  formart
     * @param @return
     * @return Date
     * @throws
     * @Title: getMondayOfThisWeek
     * @Description: 获取当周周一
     */
    public static String getMondayOfThisWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 1);
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        return shortDateFormat.format(calendar.getTime());
    }

    public static Date getMondayDateOfThisWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 1);
        return calendar.getTime();
    }

    /**
     * @param @param  dateStr
     * @param @return
     * @return Timestamp
     * @throws
     * @Title: getSundayDateOfThisWeek
     * @Description: 获取本周周日
     */
    public static Timestamp getSundayDateOfThisWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 7);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * @param @param  dateStr
     * @param @return
     * @return Timestamp
     * @throws
     * @Title: getMondayDateOfThisWeek
     * @Description: 获取本周周一
     */
    public static Timestamp getMondayDateOfThisWeek(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in getMondayDateOfThisWeek", e);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 1);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * @param @param  dateStr
     * @param @return
     * @return Timestamp
     * @throws
     * @Title: getSundayDateOfThisWeek
     * @Description: 获取本周周日
     */
    public static Timestamp getSundayDateOfThisWeek(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in getSundayDateOfThisWeek", e);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 7);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * @param @param  dateStr
     * @param @return
     * @return Timestamp
     * @throws
     * @Title: getMondayDateOfThisWeek
     * @Description: 获取上周周一
     */
    public static Timestamp getMondayDateOfLastWeek(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in getMondayDateOfLastWeek", e);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 1);
        calendar.add(Calendar.DATE, -7);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * @param @param  dateStr
     * @param @return
     * @return Timestamp
     * @throws
     * @Title: getSundayDateOfThisWeek
     * @Description: 获取上周周日
     */
    public static Timestamp getSundayDateOfLastWeek(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in getSundayDateOfLastWeek", e);
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + 7);
        calendar.add(Calendar.DATE, -7);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 获取第二天时间
     */
    public static Date getFollowingDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
        return cal.getTime();
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        return cal.getTime();
    }

    public static String getFirstDayOfMonth(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_MONTH_SPACES);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in getFirstDayOfMonth", e);
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        return sdf.format(cal.getTime());
    }

    public static String getLastDayOfMonth(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_MONTH_SPACES);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in getLastDayOfMonth" , e);
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        return sdf.format(cal.getTime());
    }

    public static String getFirstMonday(String dateStr) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_MONTH_SPACES);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in getFirstMonday" , e);
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int i = 1;
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            cal.set(Calendar.DAY_OF_MONTH, i++);
        }

        Date firstMonday = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        return sdf.format(firstMonday);
    }

    public static int getDaysBetween(Date startDate, Date endDate) {
        GregorianCalendar fromCalendar = new GregorianCalendar();

        GregorianCalendar toCalendar = new GregorianCalendar();

        fromCalendar.setTime(startDate);

        toCalendar.setTime(endDate);

        return (int) ((toCalendar.getTimeInMillis() - fromCalendar.getTimeInMillis()) / (1000 * 3600 * 24)) + 1;
    }

    /**
     * 计算两个时间相隔天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDayNumByDate(Date startDate, Date endDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(startDate);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(endDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;

    }


    public static Date stringToDate(String dateStr, String dateFormartDate2) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(dateFormartDate2);
        try {
            date = shortDateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("erro in stringToDate" , e);
            return null;
        }
        return date;
    }

    public static String getFollowingDay(String beginDate) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        try {
            date = shortDateFormat.parse(beginDate);
        } catch (ParseException e) {
            logger.error("erro in getFollowingDay" , e);
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        return sdf.format(cal.getTime());
    }

    public static String getPreviousDay(String beginDate) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        try {
            date = shortDateFormat.parse(beginDate);
        } catch (ParseException e) {
            logger.error("erro in getPreviousDay" , e);
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATE_FORMART_DATE_SPACES);
        return sdf.format(cal.getTime());
    }

    public static Timestamp getTimesmorning(Timestamp time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Date getStartOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime();
        }
    }

    public static Date getEndOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            return cal.getTime();
        }
    }

    public static Timestamp getStartTimeOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return new Timestamp(cal.getTime().getTime());
        }
    }

    public static Timestamp getEndTimeOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            return new Timestamp(cal.getTime().getTime());
        }
    }

    public static Date getStartOfMonth(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime();
        }
    }

    public static Date getEndOfMonth(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            return cal.getTime();
        }
    }

    public static long getMinBetweenTime(Timestamp time1, Timestamp time2) {
        return (time1.getTime() - time2.getTime()) / 60000;
    }

    public static Date timeToDate(long time) {
        if (time == 0) {
            return null;
        }
        Date dat = new Date(time);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dat);
        return gc.getTime();
    }

    /**
     * 指定时间到当前时间剩余天、时、分
     *
     * @param endTime
     * @return
     */
    public static String diffTime(long endTime) {
        long minutesDiff = (endTime - System.currentTimeMillis()) / (1000 * 60);
        String remianTime = "";
        int days = (int) (minutesDiff / (60 * 24));
        int hours = (int) (minutesDiff / (60) - days * 24);
        int minutes = (int) (minutesDiff - hours * 60 - days * 24 * 60);
        if (days < 0) {
            hours = -hours;
            minutes = -minutes;
        }
        if (hours < 0) {
            minutes = -minutes;
        }
        if (days == 0) {
            if (hours == 0) {
                remianTime = minutes + "分钟";
            } else {
                if (minutes == 0) {
                    remianTime = hours + "小时";
                } else {
                    remianTime = hours + "小时" + minutes + "分钟";
                }
            }
        } else {
            if (hours == 0) {
                remianTime = days + "天" + minutes + "分钟";
            } else {
                if (minutes == 0) {
                    remianTime = days + "天" + hours + "小时";
                } else {
                    remianTime = days + "天" + hours + "小时" + minutes + "分钟";
                }
            }
        }
        return remianTime;
    }

    /**
     * 判断当前时间是否大于传入时间
     */
    public static int overNowTime(long paramTime) {
        int overTime = 0;
        if (paramTime - System.currentTimeMillis() <= 0) {
            overTime = 1;
        }
        return overTime;
    }

    /**
     * 半年前时间
     */
    public static Date halfYearBeforeTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -6);    //得到前六个月
        Date day = calendar.getTime();
        return day;
    }

    public static Timestamp getStartTimeOfOneDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Timestamp(cal.getTimeInMillis());
    }

    public static Timestamp getEndTimeOfOneDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * 取得上个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getStartTimeOfLastMonth(Date date) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 获取上个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getEndTimeOfLastMonth(Date date) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    public static int getWeekNum(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_MONTH);
    }

    public static void main(String[] args){
        System.out.println(timeAround(new Date(),-3));
        int i = overNowTime(timeAround(new Date(),-3).getTime());
        System.out.print(i);
    }
}
