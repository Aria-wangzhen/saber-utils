package aes.u2;

import aes.utils.MTGuardUtils;

import java.security.Security;

/**
 * Created by wangzhen on 2017/8/23.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String content = "wangzhen";
        String key = "1111111111111111";

        String bytes = EncryptUtil.aesEncrypt(content, key);
        System.out.println("加密后：" + bytes);

        String bytes1 = EncryptUtil.aesDecrypt(bytes, key);

        System.out.println("解密后：" + bytes1);
    }
}
