package utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
    private static String iv = "0102030405060708";

    public AESUtils() {
    }

    public static String decrypt(String encrypted, String key) {
        try {
            return decrypt(key.getBytes(), encrypted);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    private static String decrypt(byte[] raw, String encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, skeySpec, new IvParameterSpec(iv.getBytes()));
        byte[] byte_content = (new BASE64Decoder()).decodeBuffer(encrypted);
        byte[] byte_decode = cipher.doFinal(byte_content);
        String AES_decode = new String(byte_decode, "utf-8");
        return AES_decode;
    }

    public static String encrypt(String decrypted, String key) {
        try {
            String e = encrypt(key.getBytes(), decrypted);
            return e;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    private static String encrypt(byte[] raw, String decrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, skeySpec, new IvParameterSpec(iv.getBytes()));
        byte[] byte_encode = decrypted.getBytes("utf-8");
        byte[] byte_AES = cipher.doFinal(byte_encode);
        String AES_encode = new String((new BASE64Encoder()).encode(byte_AES));
        return AES_encode;
    }
}
