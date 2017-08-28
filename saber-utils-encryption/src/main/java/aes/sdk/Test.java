package aes.sdk;


/**
 * Created by wangzhen on 2017/8/23.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String content = "wangzhen";
        String key = "1111111111111111";
        String mode = "CBC";

        String bytes = AESUtil.ecbEncrypt(content, key, mode);
        System.out.println("加密后：" + bytes);

        String bytes1 = AESUtil.ecbDecrypt(bytes, key, mode);

        System.out.println("解密后：" + bytes1);
    }
}
