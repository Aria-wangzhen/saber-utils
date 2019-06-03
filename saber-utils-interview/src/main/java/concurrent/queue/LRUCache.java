package concurrent.queue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 写一个最近最少使用的缓存
 * https://blog.csdn.net/elricboa/article/details/78847305
 * 最近最少使用
 * https://mp.weixin.qq.com/s/E60I9RLLT1lw3ZxCH0IPVA
 *
 * @author Aria
 * @time on 2019-04-15.
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    /**
     * true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
     *
     * @param cacheSize
     */
    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }


    /**
     * 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
