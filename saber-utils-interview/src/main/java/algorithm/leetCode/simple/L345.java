package algorithm.leetCode.simple;

/**
 * @author Aria
 * @time on 2019-04-14.
 */
public class L345 {

    public static void main(String[] args) {
        String str = "hello";
        reverseVowels(str);
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (isYx(arr[low]) && isYx(arr[high])) {
                char temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
            if (!isYx(arr[low])) {
                low++;
            }
            if (!isYx(arr[high])) {
                high--;
            }
        }
        return arr.toString();

    }

    private static boolean isYx(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';

    }

    private static void swap(char low, char high) {
        char temp = low;
        low = high;
        high = temp;
        low++;
        high--;

    }
}
