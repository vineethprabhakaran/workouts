package com.vineethds.designpatterns.singletonpattern;

/*
* To overcome situation with the reflection we can use enum implementation of singleton pattern as java ensures that any enum value is
* instantiated only once in the java program.
* The drawback of this approach is enum is inflexible and does not allow lazy initialization.
 */
public enum EnumSingleton {
    instance;
    public void doSomething(){
        // do something here
    }
}
