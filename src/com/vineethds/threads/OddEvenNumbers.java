package com.vineethds.threads;

public class OddEvenNumbers {

    public void printEven(int n )  {
        synchronized(this){
            for(int i = 2; i <= n ; i++){
                if(i % 2 == 0){
                    System.out.println("Even :"+i);
                    notify();
                    try{
                        wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }

                }
            }
        }
        notifyAll();
    }

    public void printOdd(int n )  {
        synchronized(this){
            for(int i = 2; i <= n ; i++){
                if(i % 2 != 0){
                    System.out.println("Odd: "+i);
                    notify();
                    try{
                        wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        }
        notifyAll();
    }

    public static void main(String[] args) {
        OddEvenNumbers oe = new OddEvenNumbers();
        Thread th = new Thread(){
          public void run(){
              try {
                  oe.printEven(20);
              }catch (Exception e){
                  e.printStackTrace();
              }
          }
        };

        Thread th1 = new Thread(){
            public void run(){
                try {
                    oe.printOdd(20);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        th.start();
        th1.start();
    }
}
