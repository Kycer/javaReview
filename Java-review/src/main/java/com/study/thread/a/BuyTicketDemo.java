package com.study.thread.a;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class BuyTicketDemo implements Runnable{

    private static int TOTAL_TICKET = 100;

    @Override
    public void run() {
        while (true){
            if(TOTAL_TICKET  > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + "正在出售第" + (TOTAL_TICKET--)+ "张票");
            }else{
                break;
            }
        }
    }
}
