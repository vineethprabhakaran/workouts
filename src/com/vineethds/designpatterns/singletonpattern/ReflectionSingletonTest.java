package com.vineethds.designpatterns.singletonpattern;

import java.lang.reflect.Constructor;

/*
 * Reflection can be used to destroy the singleton implementation
 */

public class ReflectionSingletonTest {
    public static void main(String[] args) {
        EagerInitialization instanceOne = EagerInitialization.getInstance();
        // Second instance of singleton class
        EagerInitialization instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitialization.class.getDeclaredConstructors();
            for(Constructor constructor : constructors){
                constructor.setAccessible(true);
                instanceTwo = (EagerInitialization)constructor.newInstance();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());

    }
}