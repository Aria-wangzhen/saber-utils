package algorithm.leetCode.simple;

/**
 * Input array is sorted 两数之和之二 - 输入数组有序
 * http://www.cnblogs.com/grandyang/p/5185815.html
 *
 * @author Aria
 * @time on 2019-03-23.
 */
public class L167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start != end) {
            if(target > numbers[start] + numbers[end]){
                ++start;
            }else if(target == numbers[start] + numbers[end]){
                result[0] = start;
                result[1] = end;
                return result;
            }else {
                --end;
            }
        }
        return null;

    }
}
