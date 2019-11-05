package edu.tongji.designpattern.CommonClass.Employee;


import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.CommonClass.Other.BroadcastType;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.AirConditionerAPI;
import edu.tongji.designpattern.DevideByPattern.FacadePattern.OpenerMaker;
import edu.tongji.designpattern.DevideByPattern.StrategyPattern.*;

public class Waiter extends Employee {

    Customer customer;
    private double temperature;
    public OpenerMaker openerMaker;
    private Order currentOrder = null;
    private OrderRecordingStrategy strategy = null;


    /**
     * @author ruanby
     * @date 11/2
     * @return
     * @function 服务员的默认构造函数
     */
    public Waiter(){
        super();
    }

    /**
     * @description: 构造函数，除去父类参数，还有温度参数temperature
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public Waiter(String employeeID, EmployeeTitle employeeTitle,AirConditionerAPI airConditionerAPI) {
        super(employeeID,employeeTitle,airConditionerAPI);
        this.employeeTitle = EmployeeTitle.WAITER;
    }


    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
    * @description: 用于实现桥接模式
     *              重写的改变空调温度函数
     *              支持Waiter操作
    * @Param:
    * @return:
    * @author: Cheng
    **/
    @Override
    public void changeTemperature() {
        System.out.println("服务员修改空调温度——");
        airConditionerAPI.changeTem(temperature);
    }


    /**
     * @description: 用于实现状态模式
     *              获取顾客状态
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public void getState(Customer customer){
        System.out.println("顾客现在的状态是：");
    }



    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 将order参数从服务员的构造函数中分离，订单创建后，将服务员加入订单的通知列表中
     */
    @Override
    public void setOrder(Order order) {
        this.order=order;
        this.order.addEmploy(this);
    }


    //服务员处理顾客投诉的函数，使用的是责任链模式，zhujitao
    @Override
    public void settleComplaint() {
        System.out.println("您好，请问您有什么问题吗?");
        System.out.println("好的，我们会催促后厨尽快为您准备食物，请您稍等片刻！");
        System.out.println("非常抱歉，同时祝您就餐愉快！");
    }

    public void  print(){
        System.out.println(temperature);
    }

    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 订单状态改变后，更新服务员的行为：新订单创建，服务员等待接菜；订单完成，服务员开始上菜
     */
    @Override
    public void update() {
        if(order.getOrderState()==0)
            System.out.println("classname:"+this.getClass().getName()+"method: update action desc: 新订单创建！服务员等待接菜");
        else
            System.out.println("classname:"+this.getClass().getName()+"method: update action desc: 订单完成！服务员开始上菜");
    }

    @Override
    public void getMessage(String msg, Employee sender) {
        if (msg == "NewService") { //// 处理新的服务
            System.out.println(this.employeeID + " received " + msg);
            String returnMsg;
            if (this.currentOrder == null){ //// 如果没空
                returnMsg = this.employeeID+"Busy";
            }
            else{
                returnMsg = this.employeeID+"Free";
            }
            this.myInterphoneChannel.notify(this,returnMsg,BroadcastType.MANAGER_REPORT);//// 回复
        }
    }



    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {

    }


    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 服务员调用该方法，遍历当前订单，找到顾客点的饮品并为顾客打开
     */
    public void getDrinkList(Order order){
        openerMaker=new OpenerMaker();
        for (Item item : order.getDishList()) {
            if (item.getName() == "百威啤酒" || item.getName() == "酸梅汁"|| item.getName() == "可乐"|| item.getName() == "雪碧") {
                if (item.getName() == "百威啤酒") {
                    openerMaker.openBeer();
                }
                else if(item.getName() == "可乐")
                    openerMaker.openCock();
                else if (item.getName() == "雪碧")
                    openerMaker.openSprite();
                else
                    openerMaker .openDarkPlumJuice();
            }
        }
    }

    public void clearOrder(){
        this.order = null;
    }

    public Order getCurrentOrder(){ return this.currentOrder; }

    public void createOrderForCustomer(){
        OrderCreateStrategy strategy = new OrderCreateStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(null,null);
    }

    public void confirmOrderForCustomer(){
        OrderConfirmStrategy strategy = new OrderConfirmStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(null,this.currentOrder);
        //// send order...
    }

    public void addDishForCustomer(Item item){
        AddDishStrategy strategy = new AddDishStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(item,this.currentOrder);
    }

    public void dropDishForCustomer(Item item){
        DropDishStrategy strategy = new DropDishStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(item,this.currentOrder);
    }

    public void showOrderForCustomer(){
        ShowOrderStrategy strategy = new ShowOrderStrategy();
        this.setStrategy((OrderRecordingStrategy) strategy);
        this.currentOrder = this.strategy.execute(null,this.currentOrder);
    }
    private void setStrategy(OrderRecordingStrategy strategy) {
        this.strategy = strategy;
    }


}
