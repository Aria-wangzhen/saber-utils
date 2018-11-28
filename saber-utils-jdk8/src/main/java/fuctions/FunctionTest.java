package fuctions;

import java.util.concurrent.CompletableFuture;

/**
 * {@link https://www.jianshu.com/p/4897ccdcb278}
 *
 * @author Aria
 * @time on 2018/10/31.
 */
public class FunctionTest {
    public static void main(String[] args) throws Exception {
        //test1();
        test3();
    }

    public static void test1() throws Exception {
        CompletableFuture<String> completableFuture = new CompletableFuture();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //模拟执行耗时任务
                System.out.println("task doing...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //告诉completableFuture任务已经完成
                completableFuture.complete("my name is result");
            }
        }).start();
        //获取任务结果，如果没有完成会一直阻塞等待
        String result = completableFuture.get();
        System.out.println("计算结果:" + result);
    }

    public static void test3() throws Exception {
        //supplyAsync内部使用ForkJoinPool线程池执行任务
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task doing...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return "result";
        });
        System.out.println("计算结果:" + completableFuture.get());
    }


}
