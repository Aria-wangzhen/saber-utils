/*
package aes;

import com.google.common.base.Strings;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class EncryptAESManager {

    private static final Logger LOGGER = Logger.getLogger(EncryptAESManager.class);

    private static SecretKeySpec key;

    private  String appKey;

    private  String name;


    //encriptCipher负责完成加密工作
    private  static ThreadLocal<Cipher> encriptCipher = new ThreadLocal<Cipher>(){

        @Override
        protected Cipher initialValue() {
            try {
                //加密对象,指定其支持的AES算法
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                return cipher;
            }catch (Exception e){
                LOGGER.error("获取encriptCipher失败", e.getMessage());
                return null;
            }
        }
    };
    //decriptCipher负责完成解密工作
    private static  ThreadLocal<Cipher>  decriptCipher = new ThreadLocal<Cipher>(){

        @Override
        protected Cipher initialValue() {
            try {
                //加密对象,指定其支持的AES算法
                Cipher cipher =  Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                return cipher;
            }catch (Exception e){
                LOGGER.error("获取decriptCipher失败"+e.getMessage());
                return null;
            }
        }
    };


    @PostConstruct
    public void init (){
        //生成密钥
        key = generateKey();
    }


    //生成key
    private  SecretKeySpec generateKey() {
        try {
            String keyStr = Kms.getByName(appKey, name);
            byte[] keyValue = keyStr.getBytes("UTF-8");
            keyValue = Arrays.copyOf(DigestUtils.sha(keyValue), 16);// use only first 128 bit
            SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
            return key;
        }catch (Exception e){
            LOGGER.error("生成key失败"+e.getMessage());
            return null;
        }
    }

    */
/**
     * 对字符串加密
     *
     * @param content
     * @return
     *//*

    public String encryptor(String content){
        String encryptedValue = "";
        if(Strings.isBlank(content)){
            return encryptedValue;
        }
        try {
            byte[] value = content.getBytes("utf-8");
            // 加密，结果保存进cipherByte
            Cipher cipher = encriptCipher.get();
            if(cipher != null) {
                byte[] cipherByte = cipher.doFinal(value);
                encryptedValue = Base64.getEncoder().encodeToString(cipherByte);
            }
        }catch (Exception e){
            LOGGER.error("AES加密错误,content:{}" + content+ e.getMessage());
        }
        return encryptedValue;
    }

    */
/**
     * 对字符串解密
     *
     * @param content
     * @return
     *//*

    public String decryptor(String content) {
        String decryptedValue = "";
        if(Strings.isBlank(content)){
            return decryptedValue;
        }
        try {
            byte[] value = Base64.getDecoder().decode(content);
            // 解密，结果保存进cipherByte
            Cipher cipher = decriptCipher.get();
            if(cipher != null) {
                byte[] cipherByte = cipher.doFinal(value);
                decryptedValue = new String(cipherByte, "UTF-8");
            }
        }catch (Exception e){
            LOGGER.error("AES解密错误,content:{}" + content, e.getMessage());
        }
        return decryptedValue;
    }

    protected void finalize( )
    {
        if(encriptCipher != null) {
            encriptCipher.remove();
        }
        if(decriptCipher != null){
            decriptCipher.remove();
        }
    }
}*/
