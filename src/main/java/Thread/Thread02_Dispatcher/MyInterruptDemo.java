package Thread.Thread02_Dispatcher;

/**
 * @program: LetsJava
 * @title: Thread02_线程调度 之 4-线程中断 （线程调度：线程休眠、线程合并、线程礼让、线程中断）
 * @description: 新建线程并中断，查看各个状态是否中断
 * @author: poooooi
 * @create: 2021-04-20 14:18
 **/

public class MyInterruptDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() { //使用匿名内部类的方式初始化线程
            @Override
            public void run() {
                for(int i = 0; i < 10;i++) {
                    System.out.println(i+"---main");
                }
            }
        });

        System.out.println("new对象之后的状态："+thread.getState()+"   是否中断："+thread.isInterrupted());
        thread.start();
        System.out.println("start之后的状态："+thread.getState()+"   是否中断："+thread.isInterrupted());
        thread.interrupt();
        System.out.println("interrupt之后的状态："+thread.getState()+"   是否中断："+thread.isInterrupted());
    }
}
