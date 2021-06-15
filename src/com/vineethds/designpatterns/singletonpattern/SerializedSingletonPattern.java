package com.vineethds.designpatterns.singletonpattern;

import java.io.Serializable;

/*
* Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that
* we can store its state in the file system and retrieve it at a later point of time.
*
* The problem with serialized singleton class is that whenever we deserialize it, it will create a new instance of the class.
* So it destroys the singleton pattern, to overcome this scenario all we need to do it provide the implementation of readResolve() method.
*
    protected Object readResolve() {
        return getInstance();
    }
 */
public class SerializedSingletonPattern implements Serializable {

    private SerializedSingletonPattern(){}

    private static class SerializeSingetonHelper{
        private static SerializedSingletonPattern instance = new SerializedSingletonPattern();
    }

    public static SerializedSingletonPattern getInstance(){
        return SerializeSingetonHelper.instance;
    }

}
