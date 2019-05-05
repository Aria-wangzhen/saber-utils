package algorithm.leetCode.medium.array;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * http://www.cnblogs.com/grandyang/p/4409379.html
 *
 * @author Aria
 * @time on 2019-05-04.
 */
public class L34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length <= 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[right] != target) {
            return res;
        }
        res[0] = right;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        res[1] = left - 1;
        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length <= 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        //查找第一个与key相等的元素
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            res[0] = left;
        }


        //查找最后一个与key相等的元素
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            res[1] = right;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(findLastEqual(arr, 8));
    }

    static int findLastEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }

        return -1;
    }

    static int findFirstEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }

        return -1;
    }

}
