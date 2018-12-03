package designPatterns.watch;

/**
 * 抽象主題角色
 * @author Aria
 * @time on 2018/8/10.
 */
public interface Watched {

    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatchers(String string);
}
