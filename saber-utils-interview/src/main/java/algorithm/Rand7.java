package algorithm;

import java.util.Random;

/**
 * 题目：给定一个函数rand5()，该函数可以随机生成1-5的整数，且生成概率一样。现
 * 要求使用该函数构造函数rand7()，使函数rand7()可以随机等概率的生成1-7
 * 的整数。
 * <p>
 * 解题：这种思想是基于，rand()产生[0,N-1]，把rand()视为N进制的一位数产生器，
 * 那么可以使用rand()*N+rand()来产生2位的N进制数，以此类推，可以产生3位，
 * 4位，5位...的N进制数。这种按构造N进制数的方式生成的随机数，必定能保证
 * 随机，而相反，借助其他方式来使用rand()产生随机数(如 rand5() + rand()%3 )
 * 都是不能保证概率平均的。 此题中N为5，因此可以使用rand5()*5+rand5()来产生
 * 2位的5进制数，范围就是1到25。再去掉22-25，剩余的除3，以此作为rand7()的
 * 产生器。
 * https://blog.csdn.net/agfagafsdfas/article/details/22330947
 */
public class Rand7 {
    Random random = new Random();

    int rand5() {
        return random.nextInt(5) + 1;
    }

    int rand7() {
        int x = 0;
        do {
            x = 5 * (rand5() - 1) + rand5();
        } while (x > 21);
        return 1 + x % 7;
    }

    public static void main(String args[]) {
        Rand7 r = new Rand7();
        for (int i = 0; i < 100; i++) {
            int res = r.rand10From7();
            System.out.println(res);
        }
    }

    /**
     * https://blog.csdn.net/yunzhongguwu005/article/details/9191609
     * @return
     */
    int rand10From7() {
        int x = 0;
        do {
            x = 7 * (rand7() - 1) + rand7();
        } while (x > 40);
        return 1 + x % 10;
    }



}
