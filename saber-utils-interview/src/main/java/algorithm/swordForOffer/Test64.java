package algorithm.swordForOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-17
 * Time: 07:56
 * Declaration: All Rights Reserved !!!
 */
public class Test64 {
    private static class Heap<T> {
        // ����Ԫ�ش�ŵļ���
        private List<T> data;
        // �Ƚ���
        private Comparator<T> cmp;

        /**
         * ���캯��
         *
         * @param cmp �Ƚ�������
         */
        public Heap(Comparator<T> cmp) {
            this.cmp = cmp;
            this.data = new ArrayList<>(64);
        }

        /**
         * ���ϵ�����
         *
         * @param idx ������Ԫ�ص���ʼλ��
         */
        public void shiftUp(int idx) {
            // �����λ���Ƿ���ȷ
            if (idx < 0 || idx >= data.size()) {
                throw new IllegalArgumentException(idx + "");
            }

            // ��ȡ��ʼ������Ԫ�ض���
            T intent = data.get(idx);

            // ������Ǹ�Ԫ�أ�����Ҫ����
            while (idx > 0) {
                // �Ҹ�Ԫ�ض����λ��
                int parentIdx = (idx - 1) / 2;
                // ��ȡ��Ԫ�ض���
                T parent = data.get(parentIdx);
                //���Ƶ��������ӽڵ�ȸ��ڵ�󣬴˴�����Ĵ����ԱȽ�������ֵΪ׼
                if (cmp.compare(intent, parent) > 0) {
                    // �����ڵ����·�
                    data.set(idx, parent);
                    idx = parentIdx;
                    // ��¼���ڵ��·ŵ�λ��
                }
                // �ӽڵ㲻�ȸ��ڵ��˵������·���Ѿ����Ӵ�С�ź�˳���ˣ�����Ҫ������
                else {
                    break;
                }
            }

            // index��ʱ��¼�ǵ����һ�����·ŵĸ��ڵ��λ�ã�Ҳ������������
            // ���Խ��ʼ�ĵ�����Ԫ��ֵ����indexλ�ü���
            data.set(idx, intent);
        }

        /**
         * ���µ�����
         *
         * @param idx �����Ƶ�Ԫ�ص���ʼλ��
         */
        public void shiftDown(int idx) {
            // �����λ���Ƿ���ȷ
            if (idx < 0 || idx >= data.size()) {
                throw new IllegalArgumentException(idx + "");
            }

            // ��ȡ��ʼ������Ԫ�ض���
            T intent = data.get(idx);
            // ��ȡ��ʼ������Ԫ�ض�������ӽ���Ԫ��λ��
            int leftIdx = idx * 2 + 1;
            // ��������ӽ��
            while (leftIdx < data.size()) {
                // ȡ���ӽ���Ԫ�ض��󣬲��Ҽٶ���Ϊ�����ӽ��������
                T maxChild = data.get(leftIdx);
                // �����ӽڵ������ڵ�Ԫ�ص�λ�ã��ٶ���ʼʱΪ���ӽ���λ��
                int maxIdx = leftIdx;

                // ��ȡ���ӽ���λ��
                int rightIdx = leftIdx + 1;
                // ��������ӽ��
                if (rightIdx < data.size()) {
                    T rightChild = data.get(rightIdx);
                    // �ҳ������ӽڵ��е�����ӽ��
                    if (cmp.compare(rightChild, maxChild) > 0) {
                        maxChild = rightChild;
                        maxIdx = rightIdx;
                    }
                }

                // �������ӽڵ�ȸ��ڵ������Ҫ���µ���
                if (cmp.compare(maxChild, intent) > 0) {
                    // ���ϴ���ӽڵ�������
                    data.set(idx, maxChild);
                    // ��¼���ƽڵ��λ��
                    idx = maxIdx;
                    // �ҵ����ƽڵ�����ӽڵ��λ��
                    leftIdx = 2 * idx + 1;
                }
                // ����ӽڵ㲻�ȸ��ڵ��˵������·���Ѿ����Ӵ�С�ź�˳���ˣ�����Ҫ������
                else {
                    break;
                }

            }
            // index��ʱ��¼�ǵ����һ�������Ƶ��ӽڵ��λ�ã�Ҳ������������
            // ���Խ��ʼ�ĵ�����Ԫ��ֵ����indexλ�ü���
            data.set(idx, intent);
        }

        /**
         * ���һ��Ԫ��
         *
         * @param item ��ӵ�Ԫ��
         */
        public void add(T item) {
            // ��Ԫ����ӵ����
            data.add(item);
            // ���ƣ�������ع�
            shiftUp(data.size() - 1);
        }

        /**
         * ɾ���Ѷ����
         *
         * @return �Ѷ����
         */
        public T deleteTop() {
            // ������Ѿ�Ϊ�գ����׳��쳣
            if (data.isEmpty()) {
                throw new RuntimeException("The heap is empty.");
            }

            // ��ȡ�Ѷ�Ԫ��
            T first = data.get(0);
            // ɾ�����һ��Ԫ��
            T last = data.remove(data.size() - 1);

            // ɾ��Ԫ�غ������Ϊ�յ������˵��ɾ����Ԫ��Ҳ�ǶѶ�Ԫ��
            if (data.size() == 0) {
                return last;
            } else {
                // ��ɾ����Ԫ�ط���Ѷ�
                data.set(0, last);
                // �������µ�����
                shiftDown(0);
                // ���ضѶ�Ԫ��
                return first;
            }
        }

        /**
         * ��ȡ�Ѷ�Ԫ�أ�����ɾ��
         *
         * @return �Ѷ�Ԫ��
         */
        public T getTop() {
            // ������Ѿ�Ϊ�գ����׳��쳣
            if (data.isEmpty()) {
                throw new RuntimeException("The heap is empty.");
            }

            return data.get(0);
        }

        /**
         * ��ȡ�ѵĴ�С
         *
         * @return �ѵĴ�С
         */
        public int size() {
            return data.size();
        }

        /**
         * �ж϶��Ƿ�Ϊ��
         *
         * @return ���Ƿ�Ϊ��
         */
        public boolean isEmpty() {
            return data.isEmpty();
        }

        /**
         * ��ն�
         */
        public void clear() {
            data.clear();
        }

        /**
         * ��ȡ�������е�����
         *
         * @return �������ڵ�����
         */
        public List<T> getData() {
            return data;
        }
    }

    /**
     * ����Ƚ���
     */
    private static class IncComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    /**
     * ����Ƚ���
     */
    private static class DescComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static class DynamicArray {
        private Heap<Integer> max;
        private Heap<Integer> min;

        public DynamicArray() {
            max = new Heap<>(new IncComparator());
            min = new Heap<>(new DescComparator());
        }

        /**
         * ��������
         *
         * @param num �����������
         */
        public void insert(Integer num) {
            // �Ѿ���ż���������ˣ�����û�����ݣ�
            // ����������ż����ʱ�������ݲ��뵽С����
            if ((min.size() + max.size()) % 2 == 0) {
                // ����������ݣ����Ҳ����Ԫ�رȴ���е�Ԫ��С
                if (max.size() > 0 && num < max.getTop()) {
                    // ��num����Ĵ����ȥ
                    max.add(num);
                    // ɾ���Ѷ�Ԫ�أ�����е����Ԫ��
                    num = max.deleteTop();
                }

                // num���뵽С���У���numС�ڴ���е����ֵ����
                // num�ͻ��ɴ���е����ֵ���������if����
                // ���num��С�ڴ���е����ֵ��num��������
                min.add(num);
            }
            // ����������������ʱ�������ݲ��뵽�����
            else {
                // С���������ݣ����Ҳ����Ԫ�ر�С���е�Ԫ�ش�
                if (min.size() > 0 && num > min.size()) {
                    // ��num�����С����ȥ
                    min.add(num);
                    // ɾ���Ѷ�Ԫ�أ�С���е���СԪ��
                    num = min.deleteTop();
                }
                // num���뵽����У���num����С���е���Сֵ����
                // num�ͻ���С���е���Сֵ���������if����
                // ���num�����ڴ���е���Сֵ��num��������
                max.add(num);
            }
        }

        public double getMedian() {
            int size = max.size() + min.size();

            if (size == 0) {
                throw new RuntimeException("No numbers are available");
            }

            if ((size & 1) == 1) {
                return min.getTop();
            } else {
                return (max.getTop() + min.getTop()) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.insert(5);
        System.out.println(array.getMedian()); // 5

        array.insert(2);
        System.out.println(array.getMedian()); // 3.5

        array.insert(3);
        System.out.println(array.getMedian()); // 3

        array.insert(4);
        System.out.println(array.getMedian()); // 3.5

        array.insert(1);
        System.out.println(array.getMedian()); // 3

        array.insert(6);
        System.out.println(array.getMedian()); // 3.5

        array.insert(7);
        System.out.println(array.getMedian()); // 4

        array.insert(0);
        System.out.println(array.getMedian()); // 3.5

        array.insert(8);
        System.out.println(array.getMedian()); // 4

    }
}
