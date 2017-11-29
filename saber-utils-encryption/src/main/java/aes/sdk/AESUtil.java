package aes.sdk;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * Created by wangzhen on 2017/8/23.
 */
public class AESUtil {

    private static final Logger LOGGER = Logger.getLogger(AESUtil.class);
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//算法/模式/补码方式
    private static final String CBC = "AES/CBC/PKCS5Padding";

    public AESUtil() {
    }

    public static String ecbEncrypt(String content, String key, String mode) {
        try {
            return AESUtil.encrypt(content, key, mode);
        } catch (Exception e) {
            LOGGER.info("加密异常" + e);
            return null;
        }
    }

    public static String ecbDecrypt(String content, String key, String mode) {
        try {
            return AESUtil.decrypt(content, key, mode);
        } catch (Exception e) {
            LOGGER.info("解密异常" + e);
            return null;
        }
    }

    private static String encrypt(String content, String key, String mode) throws Exception {
        if (StringUtils.isBlank(content) | StringUtils.isBlank(key)) {
            LOGGER.info("解密内容或者秘钥为空");
        }
        if (mode.equals("CBC")) {
            Cipher cipher = Cipher.getInstance(CBC);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), KEY_ALGORITHM), new IvParameterSpec(key.getBytes()));
            byte[] bytes = cipher.doFinal(content.getBytes("utf-8"));
            return new BASE64Encoder().encode(bytes);
        }
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), KEY_ALGORITHM));
        byte[] bytes = cipher.doFinal(content.getBytes("utf-8"));
        return parseByte2HexStr(bytes);
        //new BASE64Encoder().encode(bytes);
    }

    private static String decrypt(String content, String key, String mode) throws Exception {
        if (StringUtils.isBlank(content) || StringUtils.isBlank(key)) {
            LOGGER.info("解密内容或者秘钥为空");
        }
        if (mode.equals("CBC")) {
            Cipher cipher = Cipher.getInstance(CBC);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), KEY_ALGORITHM), new IvParameterSpec(key.getBytes()));
            byte[] bytes = new BASE64Decoder().decodeBuffer(content);

            bytes = cipher.doFinal(bytes);
            return new String(bytes, "utf-8");
        }
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), KEY_ALGORITHM));
       // byte[] bytes = new BASE64Decoder().decodeBuffer(content);
        byte[] bytes= parseHexStr2Byte(content);
        bytes = cipher.doFinal(bytes);
        return new String(bytes, "utf-8");
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


}

