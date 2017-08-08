package aes;

/**
 * Created by wangzhen on 2017/8/8.
 */
public class Test {
    public static void main(String[] args) {
        String content = "美女，约吗？";
        String password = "123";
        System.out.println("加密之前：" + content);

        // 加密
        byte[] encrypt = AesTest.encrypt(content, password);
        System.out.println("加密后的内容：" + new String(encrypt));

        // 解密
        byte[] decrypt = AesTest.decrypt(encrypt, password);
        System.out.println("解密后的内容：" + new String(decrypt));
    }
}
