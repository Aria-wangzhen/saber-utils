package algorithm.leetCode.simple;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author Aria
 * @time on 2019-04-30.
 */
public class L001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 2, 6};
        int target = 4;
        System.out.println(JSON.toJSONString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (m.containsKey(t) && m.get(t) != i) {
                res[0] = i;
                res[1] = m.get(t);
                break;
            }
        }
        return res;
    }
}
