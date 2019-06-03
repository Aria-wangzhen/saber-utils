package algorithm.find;

/**
 * @author Aria
 * @time on 2019-06-03.
 */
public class SegmentNode {

    public int start;
    public int end;

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
