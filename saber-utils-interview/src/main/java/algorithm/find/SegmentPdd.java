package algorithm.find;

import com.alibaba.fastjson.JSON;

/**
 * 求在一维坐标轴上有n个区间段,求线段A是否可以被n个区间段完全覆盖
 *
 * @author Aria
 * @time on 2019-06-03.
 */
public class SegmentPdd {
    public static void main(String[] args) {
        SegmentNode node1 = new SegmentNode(1, 3);
        SegmentNode node2 = new SegmentNode(2, 2);
        SegmentNode node3 = new SegmentNode(2, 3);
        SegmentNode node4 = new SegmentNode(7, 7);
        SegmentNode node5 = new SegmentNode(2, 4);

        SegmentNode[] set = {node1, node2, node3, node4, node5};

        SegmentNode node6 = new SegmentNode(1, 5);
        System.out.println(isCover(set, node6));


    }

    public static boolean isCover(SegmentNode[] segmentNodes, SegmentNode point) {
        if (segmentNodes == null || segmentNodes.length <= 1 || point == null) {
            return false;
        }
        //排序:拼多多现场，面试让只需要写个sort表示一下就好了，只需要说明：起点小在前，起点相同则终点小在前面
        SegmentSort.quickSort(segmentNodes, 0, segmentNodes.length - 1);
        Integer start = null;
        for (int i = 0; i <= segmentNodes.length - 1; i++) {
            SegmentNode node = segmentNodes[i];
            //找到起点落入的线段
            if (point.start >= node.start && point.start <= node.end) {
                start = i;
            } else {
                continue;
            }
        }

        //找不到起点落入的线段
        if (start == null) {
            return false;
        }

        //搜索终点是否在区间，需要满足：（1）起点落入的线段向后不可出现断层   （2）终点落入区间
        SegmentNode endNode = segmentNodes[start];
        for (int i = start; i <= segmentNodes.length - 1; i++) {
            SegmentNode node = segmentNodes[i];
            if (node.start >= endNode.start && node.start <= endNode.end) {
                if (node.end >= endNode.end) {
                    endNode = node;
                    if (endNode.end >= point.end) {
                        return true;
                    }
                }
            }

        }
        return endNode.end >= point.end;
    }
}
