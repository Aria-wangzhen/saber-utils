package executor;


/**
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2018/2/6.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("测试前：");

        currentTest();
        System.out.println("测试后：");
    }

    private static void currentTest() {
        PushVoiceBoxExecutorService.getInstance().start(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("--------");
                }
            }
        });
    }
}
