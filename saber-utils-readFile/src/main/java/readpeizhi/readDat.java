package readpeizhi;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by wangzhen on 2017/6/12.
 */
public class readDat {


    //关键进程名
    private static final String[] PROCESS_NAMES = {"吧台收银.exe", "后台管理.exe", "后厨打印.exe", "电子菜谱.exe", "连锁云服务.exe"};
    //配置文件名
    private static final String CFG_NAME = "conn" + File.separator + "conn.dat";

    private static BufferedReader bufferedReader;
    private static FileReader fileReader;

    //应用于.xml.含有节点的类型
    public static String getPosBaseConfig() {
        String cfgLocation = "/Users/wangzhen/dianping/" + CFG_NAME;


        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File(cfgLocation));
        } catch (DocumentException e) {

            //logger.error("读取配置文件出错", e);
            return null;
        }

        Element root = document.getRootElement();
        if (null == root) {
            //logger.info("获取节点错误");
            return null;
        }
        String configLine = root.getText().replace(" ", "");
        String[] connectionArr = configLine.split(";");
        String hostName = null;
        String userName = null;
        String pwd = null;
        String port = null;
        String db = null;

        for (int i = 0; i < connectionArr.length; i++) {
            int from = connectionArr[i].indexOf('=');
            String name = connectionArr[i].substring(0, from);
            String value = connectionArr[i].substring(from + 1);
            if (name.equals("UserID")) {
                userName = value;
                //logger.info("获取数据库userName成功, userName=" + value);
            }
            if (name.equals("Password")) {
                pwd = value;
                //logger.info("获取数据库pwd成功, pwd=" + value);

            }
            if (name.equals("InitialCatalog")) {
                db = value;
               // logger.info("获取数据库db名称成功, db=" + value);

            }
            if (name.equals("DataSource")) {
                String[] ipAndPort = value.split(",");
                hostName = ipAndPort[0];
                port = ipAndPort[ipAndPort.length - 1];
               // logger.info(String.format("获取数据库ip和port成功, ip = %s and port = %s", ipAndPort[0], ipAndPort[ipAndPort.length - 1]));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:jtds:sqlserver://")
                .append(hostName)
                .append(":" + port + "/")
                .append(db);
       // logger.info("数据库Url拼装成功" + sb.toString());


        return sb.toString();
    }


    /**
     * 获取配置完整路径
     *
     * @param path
     * @return
     */
    private String getCfgPath(String path) {
        int index = path.lastIndexOf(File.separator);
        String rootPath = path.substring(0, index);
        return rootPath + File.separator + CFG_NAME;
    }

    public static void main(String[] args) throws IOException {
        String s = get();
        System.out.println(s);


    }

    //应用于直接是文字的类型如:Provider=SQLOLEDB.1;Password=admin;Persist Security Info=True;UserID=sa;InitialCatalog=cyerp;DataSource=127.0.0.1,7788
    public static String get() throws IOException {
        StringBuilder sb = new StringBuilder();
        String configAddress = "/Users/" + CFG_NAME;

        File file = new File(configAddress);
        if (file.isFile() && file.exists()) {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String configLine = null;

            String hostName = null;
            String userName = null;
            String pwd = null;
            String port = null;
            String db = null;
            while ((configLine = bufferedReader.readLine()) != null) {
                String[] connectionArr = configLine.replace(" ", "").split(";");
                for (int i = 0; i < connectionArr.length; i++) {
                    int from = connectionArr[i].indexOf('=');
                    String name;
                    name = connectionArr[i].substring(0, from);
                    String value = connectionArr[i].substring(from + 1);
                    if (name.equals("UserID")) {
                        userName = value;
                       // logger.info("获取数据库userName成功, userName=" + value);
                    }
                    if (name.equals("Password")) {
                        pwd = value;
                       // logger.info("获取数据库pwd成功, pwd=" + value);
                    }
                    if (name.equals("InitialCatalog")) {
                        db = value;
                       // logger.info("获取数据库db名称成功, db=" + value);
                    }
                    if (name.equals("DataSource")) {
                        String[] ipAndPort = value.split(",");
                        hostName = ipAndPort[0];
                        port = ipAndPort[ipAndPort.length - 1];
                       // logger.info(String.format("获取数据库ip和port成功, ip = %s and port = %s", ipAndPort[0], ipAndPort[ipAndPort.length - 1]));
                    }
                }


            }

            sb.append("jdbc:jtds:sqlserver://")
                    .append(hostName)
                    .append(":" + port + "/")
                    .append(db);
            //logger.info("数据库Url拼装成功" + sb.toString());

        } else {
            //logger.warn("未找到数据库配置文件");
        }


        //logger.info("获取数据库配置成功");

        return sb.toString();
    }


}



