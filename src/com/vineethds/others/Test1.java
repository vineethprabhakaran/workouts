package com.vineethds.others;
class Parent{
    private void display(){
        System.out.print("Prent");
    }
}
class Child extends  Parent{
    public void display(){
        System.out.print("Chi");
    }
}
public class Test1 {
    public static void main(String[] args) {
       String s1 = "abc";
       String s2 = s1;
       s1 += "d";
       System.out.println(s1 + " "+ s2 + " "+ (s1 ==s2));
    }

}
