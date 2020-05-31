package com.thread.test;

public class Test {//生产者模式和消费者模式

    public static void main(String[] args) {

        Animal animal = new Animal();

        new Thread(new Productor(animal)).start();

        new Thread(new Costomer(animal)).start();
    }

}
