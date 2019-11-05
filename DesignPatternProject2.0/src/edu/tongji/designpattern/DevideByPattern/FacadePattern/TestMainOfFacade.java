package edu.tongji.designpattern.DevideByPattern.FacadePattern;

import edu.tongji.designpattern.CommonClass.Employee.Employee;
import edu.tongji.designpattern.CommonClass.Employee.EmployeeTitle;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.FloorAirConditioner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RUANBY
 * @date 2019/11/5 14:28
 */
public class TestMainOfFacade {
    public static void main(String[] args) {

        EmployeeTitle waiter=EmployeeTitle.WAITER;


        List<Employee> allEmployeeList = new ArrayList<>(); // 保存所有 Employee
        Waiter waiter1 = new Waiter("002",waiter,new FloorAirConditioner());
        List<Item> items=new ArrayList<>();
        items.add(new Item("可乐",20.2));
        items.add(new Item("雪碧",20.2));
        items.add(new Item("酸梅汁",20.2));
        items.add(new Item("百威啤酒",20.2));
        Order order=new Order();
        order.setItemList(items);

        ((Waiter) waiter1).getDrinkList(order);
    }
}
