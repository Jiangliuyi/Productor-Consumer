package com.thread.test;

public class Costomer implements Runnable {//消费者
    private Animal animal;

    public Costomer() {
    }
    public Costomer(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.animal.get();
        }
    }
}
