package table.egexp;

import sun.jvm.hotspot.bugspot.Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.input.KeyCode.M;


/**
 * Created by wangzhen on 2017/6/5.
 */
public class TableRegexp {


    public static void main(String[] args) {

        String msg = "CREATE TABLE [dbo].[cy_bt_Rec_Info] (\n" +
                "\t[SysRec_Id] [char] (40) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[Person_Num] [int] NULL ,\n" +
                "\t[Table_Id] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Table_Name] [char] (50) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[TabType] [char] (50) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[OpenDateTime] [datetime] NULL ,\n" +
                "\t[EndDateTime] [datetime] NULL ,\n" +
                "\t[CashType] [char] (40) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[OpenManId] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[OpenMan] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[CashManId] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[CashMan] [char] (50) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[CkFlag] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[MemCard_Id] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[BillTotal] [numeric](18, 2) NULL ,\n" +
                "\t[DscTotal] [numeric](18, 2) NULL ,\n" +
                "\t[OtherDscTotal] [numeric](18, 2) NULL ,\n" +
                "\t[OtherFee] [numeric](18, 2) NULL ,\n" +
                "\t[MoLing] [numeric](18, 2) NULL ,\n" +
                "\t[InComeTotal] [numeric](18, 2) NULL ,\n" +
                "\t[Station_Id] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[DscType] [char] (40) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[DscInfo] [char] (60) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Gd_Person] [char] (60) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Response_Person] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Hold_Id] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Hold_Person_Name] [char] (40) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Rec_Memo] [char] (200) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[CsmTime] [int] NULL ,\n" +
                "\t[Operator_Id] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[Operator_Name] [char] (20) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[rowguid] [uniqueidentifier] NOT NULL ,\n" +
                "\t[FaPiao] [char] (10) COLLATE Chinese_PRC_CI_AS NULL ,\n" +
                "\t[MngDateTime] [datetime] NULL ,\n" +
                "\t[Automatic_Consumption] [char] (30) COLLATE Chinese_PRC_CI_AS NOT NULL ,\n" +
                "\t[ID] [uniqueidentifier] NOT NULL ,\n" +
                "\t[BT] [char] (30) COLLATE Chinese_PRC_CI_AS NOT NULL \n" +
                ") ON [PRIMARY]\n" +
                "GO";


        List<String> list = extractMessageByRegular(msg);
        list = removeUseless(list);

        System.out.println("\n数据库表名:\n\n"+list.get(1)+"\n");
        System.out.println("字段名\n");
        for (int i = 2; i < list.size(); i++) {
            if(i<list.size()-1) {
                System.out.println(list.get(i)+",");
            }else{
                System.out.println(list.get(i));
            }

        }
    }

    private static List<String> removeUseless(List<String> list) {
        //构建所有字段类型
        List<String> fieldTypes = buildFieldTypes();
        for (String type : fieldTypes) {
            Iterator<String> ftIter = list.iterator();
            while (ftIter.hasNext()) {
                String ftTypr = ftIter.next();
                if (ftTypr.equals(type))
                    ftIter.remove();//这里要使用Iterator的remove方法移除当前对象，如果使用List的remove方法，则同样会出现ConcurrentModificationException
            }
        }
        return list;
    }

    private static List<String> buildFieldTypes() {
        List<String> fieldTypes = new ArrayList<String>();

        fieldTypes.add("bit");
        fieldTypes.add("int");
        fieldTypes.add("smallint");
        fieldTypes.add("tinyint");
        fieldTypes.add("decimal");
        fieldTypes.add("numeric");
        fieldTypes.add("money");
        fieldTypes.add("smallmoney");
        fieldTypes.add("float");
        fieldTypes.add("real");
        fieldTypes.add("datetime");
        fieldTypes.add("smalldatetime");
        fieldTypes.add("timestamp");
        fieldTypes.add("uniqueidentifier");
        fieldTypes.add("char");
        fieldTypes.add("varchar");
        fieldTypes.add("text");
        fieldTypes.add("nchar");
        fieldTypes.add("nvarchar");
        fieldTypes.add("ntext");
        fieldTypes.add("binary");
        fieldTypes.add("varbinary");
        fieldTypes.add("image");
        //主键
        fieldTypes.add("PRIMARY");


        return fieldTypes;

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

}
