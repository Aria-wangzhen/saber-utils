package algorithm.find;

import com.alibaba.fastjson.JSON;

import javax.swing.text.Segment;

/**
 * 最长重叠线段或区间
 * https://blog.csdn.net/julianxiong/article/details/7338323
 *
 * @author Aria
 * @time on 2019-04-03.
 */
public class FindLongestSegment {

    public static void main(String[] args) {

        SegmentNode node1 = new SegmentNode(1, 5);
        SegmentNode node2 = new SegmentNode(7, 9);
        SegmentNode node3 = new SegmentNode(2, 8);
        SegmentNode node4 = new SegmentNode(3, 7);
        SegmentNode node5 = new SegmentNode(2, 4);
        SegmentNode node6 = new SegmentNode(1, 5);
        SegmentNode[] set = {node1, node2, node3, node4, node5, node6};
        System.out.println(JSON.toJSONString(set));

        int count = findLongestSegmentDP(set);
        System.out.println(JSON.toJSONString(count));
    }

    public static int findLongestSegmentDP(SegmentNode[] set) {
        if (set == null || set.length <= 1) {
            return 0;
        }
        //排序
        quickSort(set, 0, set.length - 1);
        System.out.println(JSON.toJSONString(set));
        //查找
        return overlap(set);
    }

    private static int overlap(SegmentNode[] set) {
        int max = 0;

        for (int i = 0; i < set.length; i++) {
            for (int j = i + 1; j < set.length; j++) {
                boolean flag = isCommon(set[i], set[j]);
                if (flag) {
                    max = Math.max(max, commonSegment(set[i], set[j]));
                } else {
                    break;
                }
            }

        }
        return max;
    }

    private static boolean isCommon(SegmentNode segmentNode, SegmentNode segmentNode1) {
        if (segmentNode.start > segmentNode1.end || segmentNode.end < segmentNode1.start) {
            return false;
        } else {
            return true;
        }
    }

    private static void quickSort(SegmentNode[] set, int low, int high) {
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


    private static int commonSegment(SegmentNode segmentNode, SegmentNode segmentNode1) {
        if (segmentNode.start > segmentNode1.end || segmentNode1.start > segmentNode.end) {
            return 0;
        } else {
            return Math.min(segmentNode.end, segmentNode1.end) - Math.max(segmentNode.start, segmentNode1.start);
        }


    }

    private static class SegmentNode {
        private int start;
        private int end;

        SegmentNode(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
