package edu.tongji.designpattern;


import edu.tongji.designpattern.ClassDesign.Person.Employee;
import edu.tongji.designpattern.ClassDesign.Person.Manager;
import edu.tongji.designpattern.ClassDesign.Person.Waiter;
import edu.tongji.designpattern.ClassDesign.Tools.InterPhoneChannel;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");

        ArrayList<Employee> arr = new ArrayList<>();
        Manager manager = new Manager("manager");
        arr.add(manager);
        Waiter wt1 = new Waiter("waiter 1");
        Waiter wt2 = new Waiter("waiter 2");
        arr.add(wt1);
        arr.add(wt2);

        InterPhoneChannel phone = InterPhoneChannel.getInstance(arr);

        var res = manager.notifyWaitersToService();
        System.out.println(res);


    }
}
