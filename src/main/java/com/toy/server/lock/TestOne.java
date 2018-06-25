package com.toy.server.lock;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/6/4 21:39
 *
 * wait、notify的用法
 */
public class TestOne {

    private String lock = "lock1";
//    private String lock2 = "lock2";

    public static void main(String[] args) {

        TestOne testOne = new TestOne();
        WaitThread waitThread1 = testOne.new WaitThread("wait1");
        waitThread1.start();

        WaitThread waitThread2 = testOne.new WaitThread("wait2");
        waitThread2.start();

        NotifyThread notify = testOne.new NotifyThread("notify");
        notify.start();
    }

    class WaitThread extends Thread {

        public WaitThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    try {
                        System.out.println(this.getName() + "wait...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName() + "wait后的操作");
                }
            }
        }
    }


    class NotifyThread extends Thread {

        public NotifyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(this.getName() + "notify方法被调用");
                lock.notify();
            }
        }
    }


}
