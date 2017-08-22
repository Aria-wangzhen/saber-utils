package aes;



import utils.MTGuardUtil;

import java.io.UnsupportedEncodingException;


/**
 * Created by wangzhen on 2017/8/22.
 */
public class Encrypt {
    public static void main(String[] args) throws Exception {
       test();
    }

    private static  void test() throws UnsupportedEncodingException {
        String bytes = MTGuardUtil.encrypt("加密", "1111111111111111");

        String bytes1 = MTGuardUtil.decrypt(bytes,"1111111111111111");


       System.out.println(new String(bytes1));
    }

}
