package aes;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by wangzhen on 2017/8/22.
 */
public class EncryptUtil {
    //private static String encodeRules = KmsCommonUtil.getString("DB_FIELDS_ENCRYPT_KEY");
    private static final Logger log = Logger.getLogger(EncryptUtil.class);

    public EncryptUtil() {
    }

    public static String encrypt(String content, String encodeRules) {
        try {
            KeyGenerator e = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(encodeRules.getBytes("utf-8"));
            e.init(128, secureRandom);
            SecretKey original_key = e.generateKey();
            byte[] raw = original_key.getEncoded();


            SecretKeySpec key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, key);
            byte[] byte_encode = content.getBytes("utf-8");
            byte[] byte_AES = cipher.doFinal(byte_encode);
            String AES_encode = new String((new BASE64Encoder()).encode(byte_AES));
            return AES_encode;
        } catch (Exception var11) {
            log.warn("db field encrypt failed,field content=" + content + ",e=", var11);
            return null;
        }
    }

   /* public static String encrypt(String content) {
        return encrypt(content, encodeRules);
    }*/

    public static String decrypt(String content, String encodeRules) {
        try {
            KeyGenerator e = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            //secureRandom.setSeed(encodeRules.getBytes("utf-8"));
            e.init(128, secureRandom);
            SecretKey original_key = e.generateKey();
            byte[] raw = original_key.getEncoded();



            SecretKeySpec key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            byte[] byte_content = (new BASE64Decoder()).decodeBuffer(content);
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, "utf-8");
            return AES_decode;
        } catch (IllegalBlockSizeException var11) {
            log.warn("db field encrypt failed,is not encrypted by this algorithm, content=" + content, var11);
        } catch (Exception var12) {
            log.warn("db field encrypt failed,field content=" + content + ",e=", var12);
        }

        return content;
    }

    /*public static String decrypt(String content) {
        return decrypt(content, encodeRules);
    }*/
}