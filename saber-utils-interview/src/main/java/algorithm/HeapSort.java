package algorithm;

import java.util.Arrays;

/**
 * @author Aria
 * @time on 2018/12/17.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 0, 0, 64};
        int arrayLength = a.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(a, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * http://www.cnblogs.com/chengxiao/p/6129630.html
     * https://www.jianshu.com/p/be966804a2fa
     * https://www.jianshu.com/p/ad3082312012
     * 对data数组从0到lastIndex建大顶堆
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * <p>
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     *
     * 已知arr[0...n-1]是长度为n的最大堆数组，下标从0开始，那么对于下标为i的节点I，有：
     * (1).  如果I的左孩子存在的话，那么I的左孩子节点的下标为 left(i) = 2*i+1；
     * (2).  如果I的右孩子存在的话，那么I的右孩子节点的下标为 right(i) = 2*i+2;
     * (3).  如果I双亲节点存在的话，那么I的双亲节点的下标为  parent(i) = (i-1)/2; (向下取整)
     *
     */

    public static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //cur保存正在判断的节点
            int cur = i;
            //如果当前cur节点的子节点存在
            while (cur * 2 + 1 <= lastIndex) {
                //cur节点的左子节点的索引
                int biggerIndex = 2 * cur + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的cur节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果cur节点的值小于其较大的子节点的值
                if (data[cur] < data[biggerIndex]) {
                    //交换他们
                    swap(data, cur, biggerIndex);
                    //将biggerIndex赋予cur，开始while循环的下一次循环，重新保证cur节点的值大于其左右子节点的值
                    cur = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //交换
    private static void swap(int[] data, int cur, int j) {
        int tmp = data[cur];
        data[cur] = data[j];
        data[j] = tmp;
    }
}