package aes.sdk;


/**
 * Created by wangzhen on 2017/8/23.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String content = "123";
        String key = "1111111111111111";
        String mode = "CBC";

        //String bytes = AESUtil.ecbEncrypt(content, key, mode);
        //System.out.println("加密后：" + bytes);

        String  test = "cMG/J1tISIeQJDIOYNgxUCJhGrq/CHiV/PKUyK3EnSShRaZtoWEs//CYP3OsDk03MCWOmaylC6Iu954gCbmWxvX64IJzf1J826Lkcq/oLGM=";
        String bytes1 = AESUtil.ecbDecrypt(test, key, mode);

        System.out.println("解密后：" + bytes1);
    }
}
