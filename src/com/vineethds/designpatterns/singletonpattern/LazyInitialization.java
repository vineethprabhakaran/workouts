package com.vineethds.designpatterns.singletonpattern;
/*
* Lazy Initialization creates an instance in the global access method.
* This is fine in single-threaded environment.
* In multi-threaded environment there can be multiple threads inside the if condition at the same time.
* and it will destroy the singleton pattern and both the threads will get different instances of singleton class.
 */

public class LazyInitialization {

    private static LazyInitialization instance;

    private LazyInitialization(){}

    public static LazyInitialization getInstance(){
        if(instance == null)
            instance = new LazyInitialization();

        return  instance;
    }

}
