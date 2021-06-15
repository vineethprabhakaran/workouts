package com.vineethds.designpatterns.singletonpattern;

/*
* Prior to Java 5, java memory model has a lot of issues and all other singleton approaches used to fail in certain scenarios where
* too many threads try to get the instance of the singleton class simultaneously.
* To avoid this bill pugh provided an different implementation.
* In this implementation when the BillPughSingletonPattern class is loaded the SingletonHelper class is not loaded into the memory
* whenever someone called the getInstance method then the SingletonHelper class is loaded and the instance is returned.
* This is one of the most used implementation.
 */
public class BillPughSingletonPattern {

    private BillPughSingletonPattern(){}

    private static class SingletonHelper{
        private static final BillPughSingletonPattern instance = new BillPughSingletonPattern();
    }

    public static BillPughSingletonPattern getInstance(){
        return SingletonHelper.instance;
    }

}
