package algorithm.leetCode.simple;

/**
 * @author Aria
 * @time on 2019-04-13.
 */
public class L283 {
    public static void main(String[] args) {
        int[] arr = {1};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                if (pos != i) {
                    nums[i] = 0;
                }
                pos++;

            }
        }
        for (int i = pos; pos < nums.length; pos++) {
            nums[pos++] = 0;
        }

    }
}
