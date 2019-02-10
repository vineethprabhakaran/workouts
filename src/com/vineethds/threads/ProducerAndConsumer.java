package com.vineethds.threads;
import java.util.*;

/*
@Author : Vineeth
 */
class ProduceConsumeImpl{
    private final int maxSize = 5;
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void produce(int data) throws InterruptedException {
        synchronized(this){
            if(list.size() == maxSize){
                System.out.println("Cache is full producer is waiting");
                wait();
            }else{
                list.add(data);
                System.out.println("Cache filled: "+data);
                notify();
            }
        }
    }


    public void consume() throws InterruptedException {
        synchronized(this){
            if(list.size() == 0){
                System.out.println("Cache is empty consumer is waiting");
                wait();
            }else {
                System.out.println("Cache removed: "+list.remove(0));
                notify();
            }
        }
    }

}


public class ProducerAndConsumer {

    public static void main(String args[]){
        ProduceConsumeImpl pc = new ProduceConsumeImpl();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10; i++){
                    try {
                        Thread.sleep(1000);
                        pc.produce(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10; i++){
                    try {
                        pc.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

}
