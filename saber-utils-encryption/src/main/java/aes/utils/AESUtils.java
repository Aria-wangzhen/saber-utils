package aes.utils;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

    private static final Logger LOGGER = Logger.getLogger(MTGuardUtils.class);

    private static String iv = "0102030405060708";

    public AESUtils() {
    }

    public static byte[] decrypt(byte[] encrypted, String key) {

        byte[] e = new byte[0];
        try {
            e = decrypt(encrypted, key.getBytes());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return e;

    }

    private static byte[] decrypt(byte[] encrypted, byte[] raw) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");// 转化成JAVA的密钥格式
        Cipher cipher = Cipher.getInstance("AES//PKCS5Padding");// "算法/模式/补码方式"
        cipher.init(2, skeySpec, new IvParameterSpec(iv.getBytes()));// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    public static byte[] encrypt(byte[] decrypted, String key) {
        try {
            byte[] e = encrypt(decrypted, key.getBytes());
            return e;
        } catch (Exception e) {
            LOGGER.info("加密异常" + e);
            return null;
        }
    }

    private static byte[] encrypt(byte[] decrypted, byte[] raw) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");// 转化成JAVA的密钥格式
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, skeySpec, new IvParameterSpec(iv.getBytes()));
        byte[] encrypted = cipher.doFinal(decrypted);
        return encrypted;
    }

    //自己的
    public static byte[] decrypt1(String encrypted, String key) {
        try {
            byte[] e = decrypt(encrypted.getBytes(), key.getBytes());
            return e;
        } catch (Exception e) {
            LOGGER.info("加密异常" + e);
            return null;
        }
    }


    public static byte[] encrypt1(String decrypted, String key) {
        try {
            return encrypt(decrypted.getBytes(), key.getBytes());
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

}
