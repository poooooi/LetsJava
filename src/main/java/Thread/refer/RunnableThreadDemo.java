package Thread.refer;

/**
 * @program: LetsJava
 * @description: 创建线程 之 实现Runnable接口
 * @author: poooooi
 * @create: 2021-03-23 17:12
 **/

/**
 * 大多数情况，通过实例化一个Thread对象来创建一个线程。Java定义了两种方式：
 * 1、实现Runnable接口；
 * 2、继承Thread类。
 */
//主线程和子线程输出会有先后顺序的原因：sleep的时间不同

// Create a second thread.
//创建线程的最简单的方法就是创建一个实现Runnable 接口的类
class RunnableNewThread implements Runnable {
    RunnableNewThread() {
        // Create a new, second thread
        Thread t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
        t.start(); // Start the thread
    }

    // This is the entry point for the second thread.
    //为实现Runnable 接口，一个类仅需实现一个run()的简单方法，该方法声明如下：public void run( )
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}


public class RunnableThreadDemo {
    public static void main(String[] args) {
        new RunnableNewThread(); // create a new thread
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}
