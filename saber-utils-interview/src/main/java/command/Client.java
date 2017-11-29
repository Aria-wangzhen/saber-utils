package command;

/**
 * 客户端(Client)角色：创建一个具体命令(ConcreteCommand)对象并确定其接收者
 *
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2017/11/29.
 */
public class Client {

    public static void main(String[] args) {
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定它的接收者
        Command command = new ConcreteCommand(receiver);
        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);
        //执行方法
        invoker.action();
    }

}