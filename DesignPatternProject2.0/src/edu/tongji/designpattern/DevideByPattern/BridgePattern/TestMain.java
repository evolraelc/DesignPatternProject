package edu.tongji.designpattern.DevideByPattern.BridgePattern;


import edu.tongji.designpattern.CommonClass.Employee.EmployeeTitle;
import edu.tongji.designpattern.CommonClass.Employee.Manager;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.DevideByPattern.BuilderPattern.*;

import java.util.Scanner;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-05-13-48
 **/
public class TestMain {
    public static void main(String[] args) {

       //test for BridgePattern
       //注册不同的职工来调用同一个接口API的不同实体类
        EmployeeTitle waiter=EmployeeTitle.WAITER;
        EmployeeTitle manager=EmployeeTitle.MANAGER;
        EmployeeTitle cook=EmployeeTitle.COOK;
        EmployeeTitle cashier=EmployeeTitle.CASHIER;

        Waiter waiter1 = new Waiter("002",waiter,new FloorAirConditioner());
        Manager manager1 = new Manager("001",manager,new HangingAirConditioner());

        Scanner scan = new Scanner(System.in);

        System.out.println("请输入您想选择的温度:");
        String temperature = scan.nextLine().toString();
        Double t=Double.parseDouble(temperature);
        waiter1.setTemperature(t);
        waiter1.changeTemperature();

    }
}


