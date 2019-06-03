package algorithm.find;

/**
 * 求在一维坐标轴上有n个区间段,求线段A是否可以被n个区间段完全覆盖
 *
 * @author Aria
 * @time on 2019-06-03.
 */
public class SegmentPdd {
    public static void main(String[] args) {

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
            if (node.start >= point.start && node.start <= node.end) {
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
            if (node.start >= endNode.start && endNode.start <= node.end) {
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
