package edu.tongji.designpattern.CommonClass.Order;


import edu.tongji.designpattern.CommonClass.Employee.Employee;
import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.ItemIterator;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.MyIterator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends AbstractAggregate<Item> {

    private Integer ID;
    private String date;
    private OrderType type = OrderType.UNDETERMINED;
    private List<Item> itemList = new ArrayList<Item>();
    private List<Employee> employeeList = new ArrayList<Employee>();
    private double price = 0.0;
    private Integer orderState; // ?steve

    public Order(){}

    public Order(Integer ID, List<Item> itemList){
        this.ID = ID;
        if (itemList != null)
            this.itemList = itemList;
        orderState = 0;
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        this.date = sdf.format(date);
    }


    //下面是get和set方法，zhujitao
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setItemList(List<Item> itemList) {
        if (itemList != null)
            this.itemList = itemList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Item> getDishList() {
        return itemList;
    }

    public Integer getID(){
        return this.ID;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    /**
     * @author  eyisheng
     */
    public Integer getOrderID() {
        return ID;
    }

    public String getDate(){
        return date;
    }

    public OrderType getType(){
        return type;
    }

    /**
     * @author ruanby
     * @date 11/2
     * @return Integer
     * @function 返回订单的状态，新订单创建或者当前订单完成，用0/1表示
     */
    public Integer getOrderState() {
        return orderState;
    }



    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 订单状态发生变化后，通知所有的职工，更新他们的工作状态
     */
    private void notifyAllEmployees() {
        for (Employee employee : employeeList) {
            employee.update();
        }
    }


    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 向要通知的职工list中添加职工对象
     */
    public void addEmploy(Employee e){
        employeeList.add(e);
    }


    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 设置订单状态
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
        notifyAllEmployees();
    }


    /*
        convert @undetermined-order into @order
     */
    public void setTypeToDetermined(){
        this.type = OrderType.DETERMINED;
    }


    /*
        add new dish to the dish array
     */
    public void addDish(Item dsh){
        this.itemList.add(dsh);
    }

    /*
        remove dish by dishID
     */
    public boolean removeDish(String dishName){
        for (Item dsh: this.itemList){
            if (dishName == dsh.getName()){
                return this.itemList.remove(dsh);
            }
        }
        return false;
    }

//    public void showDishes(){
//        MyIterator<Item> iter = this.createIterator();
//        while(iter.hasNext()){
//            Item dish = iter.getNext();
//        }
//    }

    @Override
    public MyIterator<Item> createIterator() {
        return new ItemIterator(this,this.itemList);
    }
}
