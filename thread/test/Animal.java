package com.thread.test;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;//动物名字
    private String desc;//动物描述
    private boolean flag = true ;//风向标，为true时可以生产，为false时可以消费

    public synchronized void set(String name, String desc) {
        if (!this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.desc = desc;

        flag = false;
        super.notify();//唤醒消费者线程
    }

    public synchronized void get() {
        if (this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.name + "---->" + this.desc);

        this.flag = true;
        //唤醒生产者线程
        super.notify();
    }
}
