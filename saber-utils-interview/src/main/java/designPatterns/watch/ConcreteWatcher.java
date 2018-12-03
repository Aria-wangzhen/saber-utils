package designPatterns.watch;

/**
 * 具体观察者角色具体观察者角色
 *
 * @author Aria
 * @time on 2018/8/10.
 */
public class ConcreteWatcher implements Watcher {

    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
