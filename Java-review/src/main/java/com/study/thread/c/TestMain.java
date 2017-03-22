package com.study.thread.c;

/**
 * @author yksoul
 * @date 2017/2/23
 */
@SuppressWarnings("Duplicates")
public class TestMain {
    public static void main(String[] args) {
        BuyTicketDemo buyTicketDemo = new BuyTicketDemo();
        Thread t1 = new Thread(buyTicketDemo, "窗口1");
        Thread t2 = new Thread(buyTicketDemo, "窗口2");
        Thread t3 = new Thread(buyTicketDemo, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
