package com.vineethds.designpatterns.singletonpattern;

/*
 * In Eager Initialization the instance of the Singleton class is created at the time of class loading.
 * This is the easiest method to implement the singleton class.
 * It has a drawback that the instance of the singleton class is created even though the client application is not using it.
 */

public class EagerInitialization {

    private static final EagerInitialization instance = new EagerInitialization();

    private EagerInitialization(){}

    public static EagerInitialization getInstance(){
        return instance;
    }

}
