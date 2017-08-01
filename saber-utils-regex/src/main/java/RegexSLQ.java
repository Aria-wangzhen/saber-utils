

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
        String location = "if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[cy_bt_Menu_Info]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)\n" +
                "drop table [dbo].[cy_bt_Menu_Info]\n" +
                "GO\n" +
                "\n" +
                "CREATE TABLE [dbo].[cy_bt_Menu_Info] (\n" +
                "\t[Recipes_id] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Recipes_Name] [char] (60) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Menu_Id] [char] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[Menu_Name] [char] (60) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Menu_English_name] [char] (60) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Menu_Japanese_name] [char] (60) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Menu_PyCode] [char] (50) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Menu_PyCode_bx] [char] (50) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Sale_Price] [numeric](18, 4) NULL ,\n" +
                "\t[Sale_Price2] [numeric](18, 4) NULL ,\n" +
                "\t[Sale_Price3] [numeric](18, 4) NULL ,\n" +
                "\t[Sale_Price_hy] [numeric](18, 4) NULL ,\n" +
                "\t[Sale_Price_hy2] [numeric](18, 4) NULL ,\n" +
                "\t[Sale_Price_hy3] [numeric](18, 4) NULL ,\n" +
                "\t[Percentage_price] [numeric](18, 4) NULL ,\n" +
                "\t[Cost_Price] [numeric](18, 4) NULL ,\n" +
                "\t[Warehousing] [numeric](18, 4) NULL ,\n" +
                "\t[Menu_Unit] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Type_Id] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Type_Id_bx] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Type_Code] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[IsSaleCode] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Timing_Sale] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Weighing_whether] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Discount] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Pack_Tag] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Cook_Name] [char] (30) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Hide] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Image_x] [image] NULL ,\n" +
                "\t[Image_d] [image] NULL ,\n" +
                "\t[Menu_PX] [char] (100) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[Menu_bz] [varchar] (500) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[KCCJ] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[F_DeptUp] [char] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[F_DeptDown] [char] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[换算数量] [numeric](18, 4) NULL ,\n" +
                "\t[仓库调用单位] [char] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[换算单位] [char] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[仓库备注] [varchar] (500) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[拼菜] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[出品部门] [char] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[财务类别] [char] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[录入数量] [char] (50) COLLATE Chinese_PRC_CI_AS NOT NULL \n" +
                ") ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]\n" +
                "GO\n" +
                "\n";
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
                System.out.println(list.get(i));
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
        list.add("PRIMARY");
        list.add("");
        return list;
    }


}
