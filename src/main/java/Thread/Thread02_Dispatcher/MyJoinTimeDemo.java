package Thread.Thread02_Dispatcher;

/**
 * @program: LetsJava
 * @title: Thread02_线程调度 之 2-线程合并 （线程调度：线程休眠、线程合并、线程礼让、线程中断）
 * @description: 主线程进行到j=10时，使用join()合并子线程，实现线程合并。
 * 期望结果：j=10前，主线程和子线程正常竞争，交替打印。j=10之后，先执行join线程600ms，600ms后再正常线程
 * @author: poooooi
 * @create: 2021-04-20 13:14
 **/
class JoinTimeRunnable implements Runnable {
    @Override
    public void run() { // 子线程实现1~20的打印
        for (int i = 1; i <= 20; i++) {
            System.out.println("--------JoinRunnable" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MyJoinTimeDemo {
    public static void main(String[] args) throws InterruptedException {
        JoinTimeRunnable joinTimeRunnable = new JoinTimeRunnable();
        Thread joinTimeThread = new Thread(joinTimeRunnable);
        joinTimeThread.start();
        for (int j = 1; j <= 20; j++) {
            if (j == 10) { //主线程进行到i=10时，加入join子线程
                joinTimeThread.join(600);  //直到600ms之后，CPU资源不再被独占，子线程和主线程回到竞争状态
            }
            System.out.println("MainThread+++++++++" + j);
            Thread.sleep(100);
        }
    }
}
