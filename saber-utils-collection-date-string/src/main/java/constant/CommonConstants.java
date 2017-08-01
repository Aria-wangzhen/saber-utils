package constant;

/**
 * Created by wangzhen on 2017/8/1.
 */
public class CommonConstants {
    public static final String DATE_FORMART_CH = "yyyy年MM月dd日  HH:mm";
    public static final String DATE_FORMART_SPACES = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMART_HOUR = "HH:mm";
    public static final String DATE_FORMART_DATE_CH = "yyyy年MM月dd日";
    public static final String DATE_FORMART_DATE_SPACES = "yyyy-MM-dd";
    public static final String DATE_FORMART_MONTH_SPACES = "yyyy-MM";
    public static final String DATE_FORMART_MONTH_CH = "yyyy年MM月";
    public static final String DATE_FORMART_DATE_SPRIT = "yyyy/MM/dd";
    public static final String DATE_FORMART_DAY = "MM月dd日";
    public static final String DATE_FORMART_DAY_HOUR = "MM月dd日 HH:mm";
    public static final String DATE_FORMART_DAY_ONLY = "dd日";
    public static final String DATE_FORMART_TOTAL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMART_DATE_NUM = "yyyyMMdd";
    /**
     * yyyyMMddHHmmss
     */
    public static final String DATE_FORMAT_NUMBER = "yyyyMMddHHmmss";
//	public static final int PICTURE_TYPE_LEFT_PHOTE=0;
//	public static final int PICTURE_TYPE_SOUND=1;
//	public static final int PICTURE_TYPE_ICON=2;
//	public static final int PICTURE_TYPE_VIDEO=3;
//
//	public static final String PICTURE_SIZE_SMALL="s";
//	public static final String PICTURE_SIZE_MIDDLE="m";
//	public static final String PICTURE_SIZE_BIG="b";
    /**
     * 00:00:00
     */
    public static final String START_DAY_TIME = " 00:00:00";

    /**
     * 23:59:59
     */
    public static final String END_DAY_TIME = " 23:59:59";
    public static final int PIC_SIZE_SAMLLIMAGE = 0;
    public static final int PIC_SIZE_BIGIMAGE = 1;

    public static final int PIC_TYPE_TEACHERIMAGE = 0;
    public static final int PIC_TYPE_THIRDIMAGE = 1;
    public static final int PIC_TYPE_HEADIMAGE = 2;

    public static final int PAGING_SIZE = 20;

    public static final int CONFIG_PAGING_SIZE = 10;

    //设置分层比例
    public static final String ASSISTANT_OPERATION_TYPE_SETRATE = "SETRATE";

    //order_course_operation_log
    public static final int ORDER_COURSE_LOG_TYPE_TEACHER_LATE = 2;//老师迟到
    public static final int ORDER_COURSE_LOG_TYPE_BAD_APPRAISE = 3;//差评课程
    public static final int ORDER_COURSE_LOG_TYPE_DELETE_COURSE = 4;//后台处理删除课程 TA或运营
    /**
     * TA删除课程申请，此状态为兼容4.8.0以前的版本，在4.8.0及以后版本没有此状态，因为
     * 退课审核在TA和运营端都是直接删除课程，所以没有此状态
     */
    public static final int ORDER_COURSE_LOG_TYPE_DELETE_COURSE_TA = 7;//
    public static final int ORDER_COURSE_LOG_TYPE_FREEZE_COURSE = 5;//课程冻结
    public static final int ORDER_COURSE_LOG_TYPE_GOOD_APPRAISE = 6;//好评
    public static final String UTF8 = "UTF-8";
    public static final int connectionTimeout = 5000;

    public static final int EXPORT_MAX_LENGTH = 5000;

    public static final int START_TIME_BLOCK = 0;
    public static final int END_TIME_BLOCK = 27;
    public static final int START_TIME_BLOCK_EXTEND = -4;
    public static final int END_TIME_BLOCK_EXTEND = 31;

    public static final String IS_TIME_TABLE_EXPAND = "is_time_table_expand";
    //不支持时间扩展(8am-10pm)
    public static final String TIME_TABLE_DEFAULT = "0";
    //支持时间扩展(6am-12pm)
    public static final String TIME_TABLE_EXPAND = "1";
    //一天的毫秒数
    public static final long DATE_TIME_MILISECONDS = 24 * 3600 * 1000;
    //绩效万做单位
    public static final long PERFORMANCE_COUNT = 10000;

    //绩效百分比
    public static final long PERFORMANCE_RATE = 100;

}
