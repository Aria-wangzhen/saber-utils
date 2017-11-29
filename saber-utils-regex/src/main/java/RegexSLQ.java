

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangzhen on 2017/6/12.
 */
public class RegexSLQ {

    private static final Logger logger = Logger.getLogger(RegexSLQ.class);
    //配置文件名
    private static BufferedReader bufferedReader;
    private static FileReader fileReader;

    public static void main(String[] args) {
        //路径
        String location = "CREATE TABLE [dbo].[xs_rb] (\n" +
                "\t[xsrq] [T_RQ] NOT NULL ,\n" +
                "\t[yyje] [T_JG] NOT NULL ,\n" +
                "\t[xsje] [T_JG] NOT NULL ,\n" +
                "\t[jycs] [int] NOT NULL ,\n" +
                "\t[jdxf] [T_JG] NOT NULL ,\n" +
                "\t[zts] [int] NOT NULL ,\n" +
                "\t[mzxf] [T_JG] NOT NULL ,\n" +
                "\t[rs] [int] NOT NULL ,\n" +
                "\t[rjxf] [T_JG] NOT NULL ,\n" +
                "\t[xsyh] [T_JG] NOT NULL ,\n" +
                "\t[mlje] [T_JG] NOT NULL ,\n" +
                "\t[czje] [T_JG] NOT NULL ,\n" +
                "\t[yczje] [T_JG] NOT NULL ,\n" +
                "\t[fdnm] [int] NOT NULL ,\n" +
                "\t[bcje] [T_JG] NOT NULL ,\n" +
                "\t[fsrq] [T_RQ] NOT NULL ,\n" +
                "\t[jsrq] [T_RQ] NOT NULL ,\n" +
                "\t[bxje] [T_JG] NOT NULL ,\n" +
                "\t[thsl] [T_JG] NOT NULL ,\n" +
                "\t[thje] [T_JG] NOT NULL ,\n" +
                "\t[jyqxsl] [T_JG] NOT NULL ,\n" +
                "\t[jyqxje] [T_JG] NOT NULL ,\n" +
                "\t[zcje] [T_JG] NOT NULL ,\n" +
                "\t[hkje] [T_JG] NOT NULL ,\n" +
                "\t[wmsl] [T_JG] NOT NULL ,\n" +
                "\t[wmje] [T_JG] NOT NULL ,\n" +
                "\t[xdsl] [T_JG] NOT NULL ,\n" +
                "\t[xdje] [T_JG] NOT NULL ,\n" +
                "\t[yywsrje] [T_JG] NOT NULL ,\n" +
                "\t[fyzcje] [T_JG] NOT NULL ,\n" +
                "\t[sjje] [T_JG] NOT NULL ,\n" +
                "\t[wcje] [T_JG] NOT NULL ,\n" +
                "\t[gz] [decimal](15, 2) NOT NULL ,\n" +
                "\t[lsqkje] [T_JG] NOT NULL ,\n" +
                "\t[yhkczje] [T_JG] NOT NULL ,\n" +
                "\t[yhkzcje] [T_JG] NOT NULL ,\n" +
                "\t[wdsl] [int] NOT NULL ,\n" +
                "\t[wdje] [T_JG] NOT NULL ,\n" +
                "\t[czzsje] [T_JG] NOT NULL ,\n" +
                "\t[ktkje] [T_JG] NOT NULL ,\n" +
                "\t[khsje] [T_JG] NOT NULL ,\n" +
                "\t[mtwmds] [int] NOT NULL ,\n" +
                "\t[mtwmje] [decimal](15, 2) NOT NULL ,\n" +
                "\t[mtwmpsf] [decimal](15, 2) NOT NULL ,\n" +
                "\t[zzdcds] [int] NOT NULL ,\n" +
                "\t[zzdcje] [decimal](15, 2) NOT NULL ,\n" +
                "\t[dbf] [decimal](15, 2) NOT NULL ,\n" +
                "\t[wxczje] [decimal](15, 2) NOT NULL ,\n" +
                "\t[zfbczje] [decimal](15, 2) NOT NULL ,\n" +
                "\t[zsje] [decimal](15, 2) NOT NULL ,\n" +
                "\t[jfksl] [int] NOT NULL ,\n" +
                "\t[jfksysl] [int] NOT NULL ,\n" +
                "\t[hdaczje] [T_JG] NOT NULL \n" +
                ") ON [PRIMARY]";
        //logger.info("配置文件路径:" + location);
        /*//读取文件
        File file = new File(location);
        String  destZoneCode = readFile(file);*/
        List<String> list = extractMessageByRegular(location);
        list = removeType(list);
        for (int i = 1; i < list.size(); i++) {
            if (i == 1) {
                System.out.println("数据库名称:\n" + list.get(i));
                System.out.println("字段名称:\n");
            } else {
                System.out.println(list.get(i)+",");
            }
        }
    }

    private static String readFile(File file) {
        StringBuffer sb = new StringBuffer();
        try {

            String configLine = null;
            if (file.isFile() && file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                while ((configLine = bufferedReader.readLine()) != null) {
                    sb = sb.append(configLine);
                }

            } else {
                logger.warn("未找到数据库配置文件");
            }

        } catch (IOException e) {
            logger.error("读取配置文件时发生IO异常", e);

        } catch (Exception e) {
            logger.error("发生未知异常", e);

        } finally {
            releaseResource();
        }
        return sb.toString();

    }

    /**
     * 使用正则表达式提取中括号中的内容
     *
     * @param msg
     * @return
     */
    public static List<String> extractMessageByRegular(String msg) {

        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile("(\\[[^\\]]*\\])");
        Matcher m = p.matcher(msg);
        while (m.find()) {
            list.add(m.group().substring(1, m.group().length() - 1));
        }
        return list;
    }

    private static void releaseResource() {
        try {
            if (fileReader != null) {
                fileReader.close();
            }
        } catch (IOException e) {
            logger.error("关闭filereader错误", e);
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            logger.error("关闭bufferedreader错误", e);
        }
    }

    private static List<String> removeType(List<String> list) {
        List<String> types = allTypes();
        for (String type : types) {
            for (int i = 0; i < list.size(); i++) {
                if (type.equals(list.get(i))) {
                    list.remove(i);
                }
            }
        }
        return list;
    }


    private static List<String> allTypes() {
        List<String> list = new ArrayList<String>();
        list.add("bit");
        list.add("int");
        list.add("smallint");
        list.add("tinyint");
        list.add("decimal");
        list.add("numeric");
        list.add("money");
        list.add("smallmoney");
        list.add("float");
        list.add("real");
        list.add("datetime");
        list.add("smalldatetime");
        list.add("timestamp");
        list.add("uniqueidentifier");
        list.add("char");
        list.add("varchar");
        list.add("text");
        list.add("nchar");
        list.add("nvarchar");
        list.add("ntext");
        list.add("binary");
        list.add("varbinary");
        list.add("image");
        list.add("T_JG");
        list.add("PRIMARY");
        list.add("T_ZK");
        list.add("T_RQ");
        list.add("T_JG");
        list.add("");
        return list;
    }


}
