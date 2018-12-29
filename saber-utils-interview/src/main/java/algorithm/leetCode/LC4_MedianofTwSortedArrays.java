package algorithm.leetCode;

/**
 * @author Aria
 * @time on 2018-12-29.
 */
public class LC4_MedianofTwSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //要找的数的位置
        int leftK = (m + n + 1) / 2;
        int rightK = (m + n + 2) / 2;
        int value1 =  findKth(nums1, 0, nums2, 0, leftK);
        int value2 = findKth(nums1, 0, nums2, 0, rightK);
        return (value1 + value2) / 2.0;
    }

    static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            //从第j个数起始数到第K个
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        //从第j个数起始数到第k / 2个数字
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
    public int findK(int[] nums1, int i, int[] nums2, int j , int k) {
        if(i>=nums1.length){
            return nums2[j+k-1];
        }
        if(j>=nums2.length){
            return nums1[i+k-1];
        }

        if(k == 1){
            return Math.min(nums1[i],nums2[j]);
        }
        int value1 = ((i + k/2 -1) < nums1.length) ? nums1[i + k/2 -1] : Integer.MAX_VALUE;
        int value2 = ((j + k/2 -1) < nums2.length) ? nums2[j + k/2 -1] : Integer.MAX_VALUE;

        if(value1 < value2){
            return findK(nums1, i + k/2, nums2 ,j, k - k/2);
        }else{
            return findK(nums1, i, nums2 ,j + k/2, k - k/2);
        }

    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int leftK = ( m + n + 1 )/2;
        int righK = ( m + n + 2 )/2;
        int value1 = findK(nums1, 0, nums2 ,0,leftK);
        int value2 = findK(nums1, 0, nums2 ,0,righK);
        return (value1+value2)/2;

    }




    public static void main(String[] args) {
        int[] nums1 = new int[7];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        nums1[3] = 4;
        nums1[4] = 5;
        nums1[5] = 6;
        nums1[6] =7;

        int[] nums2 = new int[3];
        nums2[0] = 1;
        nums2[1] = 3;
        nums2[2] = 4;
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
