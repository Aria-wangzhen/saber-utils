package algorithm.swordForOffer.me;

/**
 * 旋转数组的最小值
 *
 * @author Aria
 * @time on 2019-04-06.
 */
public class S8 {

    public int min(int[] arr) throws Exception {
        if (arr == null || arr.length <= 0) {
            throw new Exception();
        }

        int low = 0;
        int high = arr.length - 1;
        int mid = low;
        while (arr[low] >= arr[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (arr[low] == arr[mid] && arr[high] == arr[mid]) {
                return getMin(arr, low, high);
            }
            if (arr[mid] >= arr[low]) {
                low = mid;
            }
            if (arr[mid] <= arr[high]) {
                high = mid;
            }

        }
        return arr[mid];
    }

    private int getMin(int[] arr, int low, int high) {
        int min = arr[low];
        for (int i = low + 1; i <= high; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
