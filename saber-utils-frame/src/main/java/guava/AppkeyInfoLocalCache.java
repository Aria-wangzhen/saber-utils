package guava;


import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.log4j.Logger;

import java.util.concurrent.Callable;


/**
 * Created by wangzhen on 2017/6/22.
 */
public class AppkeyInfoLocalCache {

    private static Logger log = Logger.getLogger(AppkeyInfoLocalCache.class);

    public static void testcallableCache() throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", new Callable<String>() {
            public String call() {
                String strProValue = "hello " + "jerry" + "!";
                return strProValue;
            }
        });
        System.out.println("jerry value : " + resultVal);

        resultVal = cache.get("peida", new Callable<String>() {
            public String call() {
                String strProValue = "hello " + "peida" + "!";
                return strProValue;
            }
        });
        System.out.println("peida value : " + resultVal);
    }

    public static void main(String[] args) throws Exception {
        testcallableCache();
        //System.out.println("-----"+ JSON.toJSONString(getTimeConfig()));}
    }}