package command;

/**
 * 命令(Command)角色：声明了一个给所有具体命令类的抽象接口。
 *
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2017/11/29.
 */
public interface Command {
    /**
     * 执行方法
     */
    void execute();
}
