package algorithm.leetCode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element 求众数
 * http://www.cnblogs.com/grandyang/p/4233501.html
 *
 * @author Aria
 * @time on 2019-03-24.
 */
public class L169 {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        majorityElement(nums);
    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int val = map.get(num) + 1;
                if(val > len /2){
                    return map.get(num);
                }
                map.put(num, val);
            }else {
                map.put(num, 1);
            }
        }
        return 0;

    }
}
