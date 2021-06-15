package com.vineethds.designpatterns.singletonpattern;

/*
* Similar to Eager initialization.
* Both eager initialization and static block initialization creates the instance even before it is being used.
* This is not the best practice.
 */

public class StaticBlockInitialization {

    private static StaticBlockInitialization instance;

    static{
        try{
            instance = new StaticBlockInitialization();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    private StaticBlockInitialization(){}

    public static StaticBlockInitialization getInstance(){
        return instance;
    }

}
