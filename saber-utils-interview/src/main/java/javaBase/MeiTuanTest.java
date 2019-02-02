package javaBase;

/**
 * @author Aria
 * @time on 2019-01-25.
 */
public class MeiTuanTest {
    public static void main(String[] args) {
        //int b = a++;他的详细过程是,先将a现有的值赋值给b，然后对a进行自加操作a+=1;
        int a = 10 >> 1;
        int b = a++;
        int c = ++a;
        int d = b * a++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
