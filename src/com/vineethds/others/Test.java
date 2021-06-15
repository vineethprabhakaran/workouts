package com.vineethds.others;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Student {
    int rollno;
    String name;
    int age;
    Student(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }


}
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(101,"Vijay",23));
        al.add(new Student(106,"Ajay",27));
        al.add(new Student(105,"Jai",21));

        Collections.sort(al,(s1, s2)-> s2.name.compareTo(s1.name));

        for(Student st:al){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
    }

}
