package algorithm.leetCode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author Aria
 * @time on 2019-04-30.
 */
public class L15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
        for (int k = 0; k <= nums.length - 3; k++) {
            //剪枝优化
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int low = k + 1;
            int high = nums.length - 1;
            int tar = 0 - nums[k];
            //有序数组查找，双指针
            while (low < high) {
                if (tar == nums[low] + nums[high]) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[k]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    res.add(list);
                    while (low < high && nums[low] == nums[low + 1]) {
                        ++low;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        --high;
                    }
                    ++low; --high;
                } else if (tar > nums[low] + nums[high]) {
                    ++low;
                } else {
                    --high;
                }

            }
        }
        return res;

    }
}
