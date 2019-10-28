package edu.tongji.designpattern;

import edu.tongji.designpattern.ClassDesign.Person.Cook;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class Main {

    public class data{

    }
    public class A{
        public data d = new data();
    }
    public class B{
        public data d = null;
        public B(data d){
            this.d = d;
        }
    }
    public static void main(String[] args) {
        System.out.println("hello world");
        Cook c = new Cook();
        Main m = new Main();

        List<A> ls;
        

    }
}
