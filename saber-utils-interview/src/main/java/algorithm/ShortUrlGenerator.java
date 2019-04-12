package algorithm;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * https://www.oschina.net/code/snippet_136226_25713
 */
public class ShortUrlGenerator {
    public static void main(String[] args) {
        String sLongUrl = "http://blog.csdn.net/sunset716/article/details/9229491";
        String[] results = generateShortUrl(sLongUrl);
        for (String result : results) {
            System.out.println("生成的短链接地址：http://goo.gl/" + result);
        }
        //运行结果如下所示
        //生成的短链接地址：http://goo.gl/NV3yYb
        //生成的短链接地址：http://goo.gl/Bb6zAj
        //生成的短链接地址：http://goo.gl/RjqIvm
        //生成的短链接地址：http://goo.gl/MrUvqa
    }

    private static String[] generateShortUrl(String url) {
        /**
         *  对传入网址进行 MD5 加密
         */
        String sMD5EncryptResult = getMd5(key + url);
        String hex = sMD5EncryptResult;
        String[] resUrl = new String[4];

        for (int i = 0; i < 4; i++) {
            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);
            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }

    public static String getMd5(String urlStr) {
        byte[] urlByte = urlStr.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(urlByte);
            byte[] b2 = md.digest();
            char str[] = new char[b2.length << 1];
            int len = 0;
            for (int i = 0; i < b2.length; i++) {
                byte val = b2[i];
                str[len++] = hexChar[(val >>> 4) & 0xf];
                str[len++] = hexChar[val & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 可以自定义生成 MD5 加密字符传前的混合 KEY
     */

    static String key = "wanzghen";
    /**
     * 要使用生成 URL 的字符
     */
    static char hexChar[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    static String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};
}
