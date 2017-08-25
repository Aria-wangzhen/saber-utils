package aes.utils;

import static aes.a1.A1.decrypt;
import static aes.a1.A1.encrypt;

/**
 * Created by wangzhen on 2017/8/23.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String content = "test";
        String password = "1111111111111111";
        byte[] bytes = MTGuardUtils.encrypt1(content, password);
        byte[] bytes1 = MTGuardUtils.decrypt1(new String(bytes),password);

        System.out.println("解密后：" + new String(bytes1));
    }
}
