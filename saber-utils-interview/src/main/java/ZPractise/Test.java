package ZPractise;

import java.util.Scanner;

/**
 * @author Aria
 * @time on 2019-02-18.
 */
public class Test {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(rotateWord(str));
    }

    private static String rotateWord(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        char[] chas = str.toCharArray();
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
        return String.valueOf(chas);

    }

    public static void reverse(char[] chas, int start, int end){
        char tmp = 0;
        while(start < end){
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }

    }
}
