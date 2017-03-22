package com.study.thread.d;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yksoul
 * @date 2017/2/23
 */
@SuppressWarnings("Duplicates")
public class BuyTicketDemo implements Runnable {

    private static int TOTAL_TICKET = 100;
    private Object obj = new Object();
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
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
            } finally {
                lock.unlock();
            }
        }
    }


}
