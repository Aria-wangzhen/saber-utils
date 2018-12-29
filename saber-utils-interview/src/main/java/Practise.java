import static algorithm.TestSort.printArr;

/**
 * @author Aria
 * @time on 2018-12-28.
 */
public class Practise {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};

        /*---------------------------------------------------排序和查找---------------------------------------------------*/

        System.out.print("排序前：");
        printArr(numbers);
        //快排
       /* quickSort(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);*/
        //归并
        mergeSort(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);
        //二分查找
        System.out.print("二分查找：" + twoSearch(numbers, 2));
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");

    }
    /*---------------------------------------------------排序和查找---------------------------------------------------*/

    /**
     * 快排
     */
    public static int[] quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        return quick(arr, 0, arr.length - 1);

    }

    private static int[] quick(int[] arr, int low, int high) {
        if (low < high) {
            int mid = getMid(arr, low, high);
            quick(arr, 0, mid);
            quick(arr, mid + 1, high);
        }
        return arr;

    }

    private static int getMid(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] > temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[high] < temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;

    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        return mergeSort(arr, 0, arr.length - 1);

    }

    private static int[] mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, 0, mid);
            mergeSort(arr, mid + 1, high);
            twoMerge(arr, low, mid, high);
        }
        return arr;
    }

    private static void twoMerge(int[] arr, int low, int mid, int high) {
        int[] newArr = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left < mid && right < high) {
            if (arr[left] < arr[right]) {
                newArr[k++] = arr[left++];
            } else {
                newArr[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            newArr[k++] = arr[left++];
        }

        while (right <= high) {
            newArr[k++] = arr[right++];
        }
        for (int i = 0; i < newArr.length; i++) {
            arr[i + low] = newArr[i];
        }

    }

    /**
     * 二分查找
     *
     * @param arr
     * @return
     */
    public static Integer twoSearch(int[] arr, int key) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        if (key < arr[0] || key > arr[arr.length - 1]) {
            return null;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key < arr[mid]) {
                high = mid - 1;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            }
            if (key == arr[mid]) {
                return mid;
            }
        }
        return null;
    }


    /*---------------------------------------------------链表---------------------------------------------------*/

    // 1.链表长度
    //  2.得到链表倒数第k个节点的值
    // 3.删除链表的倒数第k个节点
    //  4.求单链表的中间节点
    //  5.判断链表是否有环
    //  6.找出有环链表的环的入口
    //  7.判断两个单链表是否相交
    //  8.找出两个相交链表的第一个交点
    //  9.从尾到头打印单链表
    // 10.逆置单链表
    //  11.合并两个有序链表，使合并后的链表依然有序
    //  12.在o(1)的时间复杂度删除单链表中指定的某一节点
    //  13.在指定节点前插入一个节点
    //  14.无序链表排序
    //  15.链表首尾交叉排序
    /*---------------------------------------------------二叉树---------------------------------------------------*/

    //* 1.二叉树的遍历，前序中序后序，递归和非递归
    // *
    // * @see dataStructure.BinaryBaseTree
    // * http://blog.csdn.net/sheepmu/article/details/28941285
    // * 2.二叉树的层序遍历（广度优先遍历）
    // * 3.二叉树的高度/最小高度
    // * 4.二叉树的节点个数
    // * 5.求二叉树的镜像
    // * 6.判断两颗二叉树是否互为镜像
    // * 7.判断一棵树是否本身就是镜像树
    // * 8.判断两颗二叉树是不是相同的树
    // * 9.判断树1是不是树2的子结构
    // * 10.判断二叉树是否是平衡二叉树
    // * 11.二叉树第k层的节点个数
    // * 12.二叉树叶子节点的个数
    // * 13.由前序遍历和中序遍历重构二叉树
    // * 14.由中序遍历和后序遍历重构二叉树
    // * 15.二叉树中两节点的最大距离
    // * 16.二叉树中和为某一值的路径
    // * 17.求二叉树中两个节点的最低公共祖先节点

    /*--------------------------------------------------红黑树---------------------------------------------------*/


    /*---------------------------------------------------动态规划---------------------------------------------------*/

    //数塔取数
    //最长回文字符串
    //编辑距离
    //编辑距离的代价
    //矩阵取数问题
    //背包问题
    //最长递增子序列
    //最长递增连续子序列
    //最大子段和,当全为负数时候合为0
    //最长公共子序列路径
    //最长公共子序列路径长度
    //最长公共子串
    //最长公共子串路径
    //正整数分组
    //斐波那契数列
    //台阶
    //奶牛
    //矩阵最小路径和
    //换钱最少货币数(重复)
    //换钱最少货币数(不重复)
    //换钱的方法数
    //汉诺塔问题
    //字符串交错组成
    //数字字符串转成字母组合的种数
    //跳跃游戏
    //数组中最长连续的序列
    //N皇后问题
}
