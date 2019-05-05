package algorithm.leetCode.medium.array;

/**
 * 寻找旋转排序数组中的最小值
 * 复杂度log N
 * http://www.cnblogs.com/grandyang/p/4032934.html
 *
 * @author Aria
 * @time on 2019-05-05.
 */
public class L153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0;
        int right = nums.length - 1;

        //确保，没有等于
        if (nums[left] > nums[right]) {
            //终止条件左右相邻
            while (left != (right - 1)) {
                int mid = left + (right - left) / 2;
                //没有等于
                if (nums[mid] > nums[left]) {
                    //这里没有加一,,防止出现[1,1,1,0,1,1]
                    left = mid;
                } else {
                    //这里没有加一,防止出现[1,1,1,0,1,1]
                    right = mid;
                }
            }
            return Math.min(nums[left], nums[right]);
        }

        //特殊情况未旋转
        return nums[0];

    }
}
