package algorithm.leetCode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Remove Duplicates from Sorted Array 有序数组中去除重复项
 * http://www.cnblogs.com/grandyang/p/4329128.html
 *
 * @author Aria
 * @time on 2019-02-20.
 */
public class L26 {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], nums[i]);
            }
        }
        return map.size();

    }
}
