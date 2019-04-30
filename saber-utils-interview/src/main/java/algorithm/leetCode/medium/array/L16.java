package algorithm.leetCode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最接近的三数之和
 *
 * @author Aria
 * @time on 2019-04-30.
 */
public class L16 {
    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        for (int k = 0; k <= nums.length - 3; k++) {
            int low = k + 1;
            int high = nums.length - 1;
            //有序数组查找，双指针
            while (low < high) {
                int sum = nums[k] + nums[low] + nums[high];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (target > sum) {
                    ++low;
                } else {
                    --high;
                }

            }
        }
        return closest;
    }
}
