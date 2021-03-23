package Thread;

/**
 * @program: LetsJava
 * @description: 主线程
 * @author: poooooi
 * @create: 2021-03-23 16:52
 **/

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();      //当前线程（自然是主线程）的引用通过调用currentThread()获得，该引用保存在局部变量t中
        System.out.println("Current thread: " + t);     //显示线程的信息
        t.setName("My Thread");     // change the name of the thread,调用setName()改变线程的内部名称
        System.out.println("After name change: " + t);      //显示新的线程的信息

        try {
            for(int n = 5; n > 0; n--) {    //实现打印递减的n值
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
