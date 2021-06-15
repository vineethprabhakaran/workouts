package com.vineethds.designpatterns.singletonpattern;

/*
* The easiest way to create a thread safe singleton pattern is to make the global access method as synchronized.
* So that only one thread can execute the method at the same time.
* This implementation reduces performance because of the cost associated with the synchronized method.
* To avoid this performance issues we need to use double checked locking implementation.
 */

public class ThreadSafeSingletonPattern1 {

    private static ThreadSafeSingletonPattern1 instance;

    private ThreadSafeSingletonPattern1(){}

    public static synchronized ThreadSafeSingletonPattern1 getInstance(){
        if(instance == null)
            instance = new ThreadSafeSingletonPattern1();

        return  instance;
    }

}
