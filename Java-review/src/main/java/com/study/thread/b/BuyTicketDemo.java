package com.study.thread.b;

/**
 * @author yksoul
 * @date 2017/2/23
 */
@SuppressWarnings("Duplicates")
public class BuyTicketDemo implements Runnable {

    private static int TOTAL_TICKET = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (TOTAL_TICKET > 0) {

                        System.out.println(Thread.currentThread().getName()
                                + "正在出售第" + (TOTAL_TICKET--) + "张票");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
