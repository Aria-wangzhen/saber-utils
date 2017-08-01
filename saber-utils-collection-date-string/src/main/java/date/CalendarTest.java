package date;

import sun.applet.Main;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wangzhen on 2017/6/19.
 */
public class CalendarTest {
    private static final long ONE_DAY = 24 * 60 * 60 * 1000;
    private static final long ONE_HOUR = 60 * 60 * 1000;
    private static final long ONE_MINUTE = 60 * 1000;
    private static final long ONE_SECOND = 1000;
    private static final int THREEE_DAYS_THRESHOLD = 3; //离线超过三天，不再监控（产品要求）
    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
       /* calendar.add(Calendar.DATE, -THREEE_DAYS_THRESHOLD);
        calendar.set(Calendar.HOUR_OF_DAY, 0);//年月日为0*/
        calendar.set(Calendar.MINUTE, 1);
      /*  calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);*/
        Date threeDaysBefore = calendar.getTime();

        System.out.println(threeDaysBefore);
    }
}
