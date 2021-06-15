package com.vineethds.designpatterns.singletonpattern;

/*
* This is the double checked locking implementation of Singleton pattern.
* In this approach synchronized block is used inside the if condition
 */

public class ThreadSafeSingletonPattern2 {

    private static volatile ThreadSafeSingletonPattern2 instance;

    private ThreadSafeSingletonPattern2(){}

    public static ThreadSafeSingletonPattern2 getInstance(){
        if(instance == null){
            synchronized (ThreadSafeSingletonPattern2.class){
                if(instance == null)
                    instance = new ThreadSafeSingletonPattern2();
            }
        }
        return  instance;
    }

}
