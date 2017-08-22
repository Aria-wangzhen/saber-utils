package aes;

import static aes.EncryptUtil.encrypt;

/**
 * Created by wangzhen on 2017/8/22.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String s =  EncryptUtil.encrypt("王振","王振");
        System.out.println(s);
        System.out.println(EncryptUtil.decrypt(s,"王振"));
    }
}
