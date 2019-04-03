package loadBalance;

import java.util.List;
import java.util.Random;

/**
 * @author Aria
 * @time on 2019-04-03.
 */
public class WeightRandomLoadBalance {
    protected Random random = new Random();

    public Client doSelect(List<Client> clients, int[] weights) {
        assert (clients != null && clients.size() >= 1);
        // 连接实例唯一直接返回
        if (clients.size() == 1) {
            return clients.get(0);
        }
        int clientSize = clients.size();
        // 权重和
        int totalWeight = 0;
        // 是否全部权重相同
        boolean weightAllSame = true;
        for (int i = 0; i < clientSize; i++) {
            totalWeight += weights[i];
            if (weightAllSame && i > 0 && weights[i] != weights[i - 1]) {
                // 存在权重不一样的情况
                weightAllSame = false;
            }
        }
        if (!weightAllSame) {
            // 生成区间在0到权重和的随机数，按权重对连接实例分段，看随机数落在哪个连接实例权重区间，返回对应的连接实例
            int weightPoint = random.nextInt(totalWeight);
            for (int i = 0; i < clientSize; i++) {
                Client client = clients.get(i);
                weightPoint -= weights[i];
                if (weightPoint < 0) {
                    return client;
                }
            }
        }
        // 权重都相同，随机返回实例列表的一个
        Client client = clients.get(random.nextInt(clientSize));
        return client;
    }
}
