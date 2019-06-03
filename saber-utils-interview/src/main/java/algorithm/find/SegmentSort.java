package algorithm.find;

/**
 * @author Aria
 * @time on 2019-06-03.
 */
public class SegmentSort {
    /**
     * 线段快排：起点小在前，起点相同则终点小在前面
     *
     * @param set
     * @param low
     * @param high
     */
    public static void quickSort(SegmentNode[] set, int low, int high) {
        if (low < high) {
            int port = findPort(set, low, high);
            quickSort(set, low, port - 1);
            quickSort(set, port + 1, high);
        }

    }

    private static int findPort(SegmentNode[] set, int low, int high) {
        SegmentNode temp = set[low];
        while (low < high) {
            while (low < high && compare(set[high], temp) == 1) {
                high--;
            }
            set[low] = set[high];
            while (low < high && compare(set[low], temp) <= 0) {
                low++;
            }
            set[high] = set[low];
        }
        set[low] = temp;
        return low;

    }

    private static int compare(SegmentNode segmentNode, SegmentNode segmentNode1) {
        if (segmentNode.start < segmentNode1.start
                || (segmentNode.start == segmentNode1.start && segmentNode.end < segmentNode1.end)) {
            return -1;
        } else if (segmentNode.start == segmentNode1.start && segmentNode.end == segmentNode1.end) {
            return 0;
        } else {
            return 1;
        }


    }
}
