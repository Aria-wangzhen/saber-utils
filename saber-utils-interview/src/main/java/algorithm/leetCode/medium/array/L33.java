package algorithm.leetCode.medium.array;

/**
 * 搜索旋转排序数组
 *
 * @author Aria
 * @time on 2019-04-30.
 */
public class L33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //和传统二分不同
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
                //和传统二分不同
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
