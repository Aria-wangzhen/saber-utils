package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = {10, 20, 40, 32, 67, 40, 20, 89, 300, 400, 15,123,445};
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < n; i++) {
            int num = (arr[i] - min) / n;
            if (!bucketArr.get(num).contains(arr[i]))
                bucketArr.get(num).add(arr[i]);
        }
        //将每个元素放入桶
        for (int i = 0; i < n; i++) {
            int num = (arr[i] - min) / n;
            if (!bucketArr.get(num).contains(arr[i]))
                bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        int temp = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                temp = bucketArr.get(i).get(j);
                System.out.println(temp);
            }
        }
    }
}

