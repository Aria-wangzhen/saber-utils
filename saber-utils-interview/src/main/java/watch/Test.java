package watch;

/**
 * @author Aria
 * @time on 2018/8/10.
 */
public class Test {
    public static void main(String[] args) {
        Watched girl = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();

        girl.addWatcher(watcher1);
        girl.addWatcher(watcher2);
        girl.addWatcher(watcher3);

        girl.notifyWatchers("hello world");

        girl.removeWatcher(watcher2);
        girl.notifyWatchers("world");
    }
}
