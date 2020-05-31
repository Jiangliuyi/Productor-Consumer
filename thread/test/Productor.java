package com.thread.test;

public class Productor implements Runnable {//生产者
    private Animal animal;

    public Productor() {
    }

    public Productor(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        for (int i = 0; i <50 ; i++) {
            if (i %2 ==0){
                this.animal.set("江琉一" , "是我的笔名");
            }else{
                this.animal.set("柯南","是我喜欢的动漫人物");
            }
        }
    }
}
