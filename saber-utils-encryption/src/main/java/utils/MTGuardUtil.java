package utils;

import com.alibaba.fastjson.JSONObject;

import java.util.TreeSet;
import java.util.zip.Inflater;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;


public class MTGuardUtil {
    public MTGuardUtil() {
    }

    /**
     * @deprecated
     *//*
    @Deprecated
    public static String decryptReportData(byte[] data) {
        return decryptReportData(data, "meituan0sankuai1");
    }*/
/*
    public static String decryptReportData(byte[] data, String key) {
        if(data != null && data.length != 0 && key != null && !key.isEmpty()) {
            byte[] encrypt = Base64.decodeBase64(data);
            byte[] decrypt = AESUtils.decrypt(encrypt, key);
            Inflater inflater = new Inflater();
            inflater.setInput(decrypt, 0, decrypt.length);
            byte[] result = new byte[1024];
            String dataString = "";

            try {
                int len = inflater.inflate(result);
                dataString = new String(result, 0, len, "UTF-8");
            } catch (Exception var9) {
                var9.printStackTrace();
            }

            return dataString;
        } else {
            return null;
        }
    }*/

    /*public static JSONObject parseReportData2JsonByConfigString(String[] data, String configString) {
        if(data != null && data.length != 0 && configString != null && !configString.isEmpty()) {
            JSONObject configJson = JSONObject.parseObject(configString);
            return parseData2JSON(data, configJson);
        } else {
            return null;
        }
    }
*/
   /* private static JSONObject parseData2JSON(String[] sections, JSONObject config) {
        JSONObject jsonObject = new JSONObject();
        TreeSet keySet = new TreeSet(config.keySet());
        String[] keys = new String[keySet.size()];
        keySet.toArray(keys);

        for(int i = 1; i < sections.length; ++i) {
            JSONObject sectionJSON = new JSONObject();
            if(i - 1 >= keys.length) {
                break;
            }

            String section = sections[i];
            String sectionName = keys[i - 1].substring(1);
            String[] infos = section.split("\\|");
            String[] infoKeys = config.getString(keys[i - 1]).split(",");

            for(int j = 0; j < infos.length && j < infoKeys.length; ++j) {
                sectionJSON.put(infoKeys[j], infos[j]);
            }

            jsonObject.put(sectionName, sectionJSON);
        }

        return jsonObject;
    }*/
    public static String encrypt(String data, String key) {
        if (StringUtils.isNotBlank(data) && StringUtils.isNotBlank(key) ) {
            return  AESUtils.encrypt(data, key);
        } else {
            return null;
        }
    }

    public static String decrypt(String data, String key) {
        if (StringUtils.isNotBlank(data) && StringUtils.isNotBlank(key)) {
            return AESUtils.decrypt(data, key);
        } else {
            return null;
        }
    }
}