package Thread.Thread01_Create;

/**
 * @program: LetsJava
 * @title: Thread01_创建线程 之 2-实现Runnable接口
 * @description: 重写MyRunnable1和MyRunnable2的run()方法，分别放在不同的线程中，并启动两个子线程。期望输出："+++"和"---"的字符串交替打印
 * @author: poooooi
 * @create: 2021-04-19 15:54
 **/

class MyRunnable1 implements Runnable {
    @Override
    public void run() { //重写MyRunnable1的run()
        for (int i = 0; i < 100; i++) {
            System.out.println("-------------MyRunnable1");
        }
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() { //重写MyRunnable2的run()
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable2+++++++++++");
        }
    }
}

public class MyRunnableDemo {
    public static void main(String[] args) {
        // 实例化 MyRunnable1和 MyRunnable2
        MyRunnable1 runnable1 = new MyRunnable1();
        MyRunnable2 runnable2 = new MyRunnable2();
        // 将MyRunnable1 和 MyRunnable2放入两个不同的线程
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        //启动这两个线程
        thread1.start();
        thread2.start();
    }
}
