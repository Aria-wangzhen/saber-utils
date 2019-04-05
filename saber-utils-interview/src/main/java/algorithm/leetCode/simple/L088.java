package algorithm.leetCode.simple;

/**
 * Merge Sorted Array 混合插入有序数组
 *
 * @author Aria
 * @time on 2019-02-28.
 */
public class L088 {
    public static void main(String[] args) {
        int[] nums1 = {3, 45, 455};
        int[] nums2 = {3, 45, 45, 90};
        int k = 5;
        while (k >= 0) {
            k--;
            System.out.println("-----:" + k);
        }
        System.out.println("+----:" + k);
        //merge(nums1,3,nums2,4);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
            System.out.println("-----:" + k);
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
