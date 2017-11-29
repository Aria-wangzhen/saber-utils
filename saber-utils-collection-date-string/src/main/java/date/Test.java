package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangzhen on 2017/9/28.
 */
public class Test {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat formatterDate = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat formatterTime = new SimpleDateFormat("HHmmss");

    public static void main(String[] args) {
        System.out.println(formatterDate.format(new Date()));

        //System.out.println(compareDate("2017-09-28 15:11:40.240", "2017-09-28 00:00:00" ));
    }

    private static long compareDate(String current, String before) {
        try {
            Date dt1 = formatter.parse(current);
            Date dt2 = formatter.parse(before);
            System.out.println(dt1.getTime());
            System.out.println(dt2.getTime());
            return dt1.getTime()- dt2.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
