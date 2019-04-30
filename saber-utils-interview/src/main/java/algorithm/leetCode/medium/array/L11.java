package algorithm.leetCode.medium.array;

/**
 * Container With Most Water 装最多水的容器
 *
 * @author Aria
 * @time on 2019-04-30.
 */
public class L11 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int res = 0;
        int j = height.length - 1;
        int i = 0;
        while (i < j) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;

    }
}
