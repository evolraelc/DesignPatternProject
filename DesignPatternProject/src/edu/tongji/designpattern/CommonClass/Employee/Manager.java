package edu.tongji.designpattern.CommonClass.Employee;


import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Other.BroadcastType;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.AirConditionerAPI;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private double temperature;

    /**
     * @description: 构造函数，除去父类参数，还有温度参数temperature
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public Manager( String employeeID, EmployeeTitle employeeTitle, AirConditionerAPI airConditionerAPI) {
        super(employeeID,employeeTitle,airConditionerAPI);
        this.employeeTitle = EmployeeTitle.MANAGER;
    }

    //经理解决顾客投诉的方法，使用的是责任链模式，zhujitao
    @Override
    public void settleComplaint(){
        System.out.println("您好，我是本店的经理，请问您有什么问题吗?");
        System.out.println("我已经了解了事情的经过，确实是我们的工作疏忽，我们一定会妥善解决的。");
        System.out.println("您好，我们会为您的本次就餐提供A类优惠卷，在结账时会提供6.8折优惠。");
        System.out.println("非常抱歉，同时祝您就餐愉快！");
    }


    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @description: 用于实现桥接模式
     *               重写的改变空调温度函数
     *               支持Manager操作
     * @Param:
     * @return:
     * @author: Cheng
     **/
    @Override
    public void changeTemperature() {
        System.out.println("大堂经理修改空调温度——");
        airConditionerAPI.changeTem(temperature);
    }

    @Override
    public void update() {

    }


    @Override
    public void getMessage(String msg, Employee sender) {

    }

    public boolean notifyWaitersToService(){
        if (this.myInterphoneChannel == null)
            return false;
        return this.myInterphoneChannel.notify(this,
                    "NewService",
                    BroadcastType.ALL_EMPLOYEE);
    }

    /**
     * @author  steve
     * @description 选择有空的服务员进行调度服务
     * @param customer  被服务对象
     * @param employeelst   所有 Employee
     */
    public void scheduleWaiterToService(Customer customer, ArrayList<Employee> employeelst){
        for (Employee e:employeelst) {
            if (e.employeeTitle == EmployeeTitle.WAITER && e.order == null) {
                customer.served((Waiter) e);
                System.out.println("customer 正被"+e.employeeID+"服务");
                return;
            }
            System.out.println("customer 没有被服务，当前所有 waiter 正忙");
            return;
        }
    }

    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {

    }


}
