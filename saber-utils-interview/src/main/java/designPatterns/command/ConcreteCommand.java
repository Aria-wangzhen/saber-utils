package designPatterns.command;

/**
 * 具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法。
 *
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2017/11/29.
 */
public class ConcreteCommand implements Command {
    //持有相应的接收者对象
    private Receiver receiver = null;

    /**
     * 构造方法
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        //通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }
}
