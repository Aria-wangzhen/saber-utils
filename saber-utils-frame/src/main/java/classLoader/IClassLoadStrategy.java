package classLoader;

/**
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2018/2/12.
 */
/**
 * 类加载策略接口
 */
public interface IClassLoadStrategy {

    ClassLoader getClassLoader(ClassLoadContext ctx);
}
