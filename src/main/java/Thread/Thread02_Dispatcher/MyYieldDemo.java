package Thread.Thread02_Dispatcher;

import static java.lang.Thread.yield;

/**
 * @program: LetsJava
 * @title: Thread02_线程调度 之 3-线程礼让 （线程调度：线程休眠、线程合并、线程礼让、线程中断）
 * @description: 线程1和线程2正常竞争CPU资源，每当线程2循环至5的倍数时，进行一次礼让。期望结果：每当5的倍数时，线程1占据资源输出
 * @author: poooooi
 * @create: 2021-04-20 13:33
 **/
class YieldRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + "-----" + i);
        }
    }
}

class YieldRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 200; i++) {
            System.out.println(i + "++++++" + Thread.currentThread().getName());
            if (i % 5 == 0) {
                yield();
            }
        }
    }
}

public class MyYieldDemo {
    public static void main(String[] args) {
        YieldRunnable1 yieldRunnable1 = new YieldRunnable1();
        YieldRunnable2 yieldRunnable2 = new YieldRunnable2();
        Thread thread1 = new Thread(yieldRunnable1);
        Thread thread2 = new Thread(yieldRunnable2);
        thread1.setName("Thread 1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}
