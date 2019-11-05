package edu.tongji.designpattern;

import edu.tongji.designpattern.CommonClass.Customer.AbstractCustomer;
import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Customer.CustomerFactory;
import edu.tongji.designpattern.CommonClass.Customer.VIPType;
import edu.tongji.designpattern.CommonClass.Employee.*;
import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Items.Menu;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.AdapterPattern.RealDiscount;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.FloorAirConditioner;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.HangingAirConditioner;
import edu.tongji.designpattern.DevideByPattern.BuilderPattern.*;
import edu.tongji.designpattern.DevideByPattern.ChainofResponsibilityPattern.Complaint;
import edu.tongji.designpattern.DevideByPattern.DecoratorPattern.VIPCashierDecorator;
import edu.tongji.designpattern.DevideByPattern.FilterPattern.CustomerCriteria;
import edu.tongji.designpattern.DevideByPattern.FilterPattern.VIPCustomerCriteria;
import edu.tongji.designpattern.DevideByPattern.InterpreterPattern.ExpressForFree;
import edu.tongji.designpattern.DevideByPattern.MediatorPattern.InterPhoneChannel;
import edu.tongji.designpattern.DevideByPattern.PrototypeAndMemetoPattern.Memento;
import edu.tongji.designpattern.DevideByPattern.PrototypeAndMemetoPattern.OrderClone;
import edu.tongji.designpattern.dispatch.OrderDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    //// 合并的时候这里写单元测试，加上自己的函数
    public class Debug{
        public class Eyisheng{

        }
    }

    /*
        我定义了一些 Enum type，修改了你们的参数，但是输出时没有改
     */
    public static void main(String[] args) throws InterruptedException{

        EmployeeTitle waiter=EmployeeTitle.WAITER;
        EmployeeTitle manager=EmployeeTitle.MANAGER;
        EmployeeTitle cook=EmployeeTitle.COOK;
        EmployeeTitle cashier=EmployeeTitle.CASHIER;

        /*
            创建所有 Employee
         */
        List<Employee> allEmployeeList = new ArrayList<>(); // 保存所有 Employee
        Waiter waiter1 = new Waiter("002",waiter,new FloorAirConditioner());
        Waiter waiter2 = new Waiter("000",waiter,new FloorAirConditioner());
        Manager manager1 = new Manager("001",manager,new HangingAirConditioner());
        Cashier cashier1 = new Cashier("003", cashier, new HangingAirConditioner(),"A");
        Cook cook1 =new Cook("004",cook,new HangingAirConditioner(),new Order());

        //组合模式：生成两个CustomerList，即VIP顾客和非VIP顾客
        // null object 模式 生成 NullCustomer
        AbstractCustomer nullCustomer = CustomerFactory.getCustomer("",Gender.MALE,VIPType.VIP);
        Customer VIPCustomer = new Customer("java",Gender.MALE,VIPType.VIP);
        Customer NONVIPCustomer = new Customer("notjava",Gender.NONE,VIPType.NONVIP);

        allEmployeeList.add(waiter1);
        allEmployeeList.add(waiter2);
        allEmployeeList.add(manager1);
        allEmployeeList.add(cashier1);
        allEmployeeList.add(cook1);

        /*
            创建 Channel
         */
        InterPhoneChannel interPhoneChannel = InterPhoneChannel.getInstance(allEmployeeList);

        System.out.println("第一个顾客他来了，脚下生风，虎虎生威");
        Customer customer1=new Customer("java", Gender.MALE, VIPType.VIP);
        System.out.println("欢迎"+customer1.getCustomerName()+"\n");

        //对讲机通知服务员顾客到了
        System.out.println("大堂经理通过对讲机告诉所有服务员有客人到了");
        manager1.notifyWaitersToService();
        manager1.scheduleWaiterToService(customer1,(ArrayList<Employee>) allEmployeeList);
        System.out.println("\n");

        /*
            显示菜单
         */
        System.out.println("菜单如下，请您点餐：（输入编号即可,每个编号中间以空格隔开，换行结束）");
        Menu menu = Menu.getInstance();
        menu.showMenu();

        /*
            顾客点菜
         */
        Order currentOrder =new Order();
        Scanner scan = new Scanner(System.in);
        System.out.println("\n"+"当前有两种套餐组合，是否选择套餐？（是选择1，否选择0）");
        String comboOrNot = scan.nextLine().toString();
        if(comboOrNot.equals("1")){
            System.out.println("classname:"+Director.class.getName()+"method: construct action desc: 显示套餐内容");
            ComboBuilder comboBuilder1= new ConcreteComboBuilderA();
            ComboBuilder comboBuilder2= new ConcreteComboBuilderB();
            Director director1 =new Director(comboBuilder1);
            Director director2 =new Director(comboBuilder2);
            Combo comboA=director1.construct();
            Combo comboB=director2.construct();
            System.out.println("\n"+"请选择套餐编号:");
            String comboNum =scan.nextLine().toString();
            if(comboNum.equals("1")){
                System.out.println("classname:"+Order.class.getName()+"method: setItemList action desc: 将套餐内容放入订单中");
                System.out.println("classname:"+Order.class.getName()+"method: setPrice action desc: 将套餐价格输入订单");
                comboBuilder1.buildItemList();
                currentOrder.setItemList(comboBuilder1.getItemList());
                currentOrder.setPrice(comboBuilder1.getPrice());
            }
            else{
                comboBuilder2.buildItemList();
                currentOrder.setItemList(comboBuilder2.getItemList());
                currentOrder.setPrice(comboBuilder2.getPrice());
            }
        }else {
            while (true){
                System.out.println("======请输入命令======");
                System.out.println(
                        "1***创建订单\n" +
                                "2***添加菜品\n" +
                                "3***删除菜品\n" +
                                "4***确认订单\n" +
                                "5***查看菜单\n" +
                                "6***查看订单\n" +
                                "====================="
                );

                boolean flag = false;
                String line = scan.nextLine();
//            Waiter servingWaiter = customer1.getServingWaiter();
                if (line.equals("1")){
                    customer1.createOrderDemand();
                    System.out.println("订单已创建，请继续操作");
                }
                else if (line.equals("2")){
                    System.out.println("请输入菜名所对应的编号");
                    Integer idx = -1;
                    boolean normal = true;
                    while (true) {
                        try {
                            idx = scan.nextInt()-1; //// indexation bias
                            break;
                        } catch (Exception e) {
                            System.out.println("ERROR: invalid input");
                            normal = false;
                            break;
                        }finally {
                            scan = new Scanner(System.in);
                        }
                    }
                    if (normal) {
                        Item newItem = menu.getItem(idx);
                        if (newItem != null)
                            customer1.addDishDemand(newItem);
                    }
                }
                else if (line.equals("3")){
                    System.out.println("请输入菜名所对应的编号");
                    Integer idx = -1;
                    boolean normal = true;
                    while (true) {
                        try {
                            idx = scan.nextInt()-1;// indexation bias
                            break;
                        } catch (Exception e) {
                            System.out.println("ERROR: invalid input");
                            normal = false;
                            break;
                        }finally {
                            scan = new Scanner(System.in);
                        }
                    }
                    if (normal) {
                        Item delItem = menu.getItem(idx);
                        if (delItem != null)
                            customer1.dropDishDemand(delItem);
                    }
                }
                else if (line.equals("4")){
                    while (true) {
                        try {
                            System.out.println("确实? y/[n]");
                            String ch = scan.next();
                            if (ch.equals("y")){
                                customer1.confirmOrderDemand();
                                flag = true;
                                Waiter servingWaiter = customer1.getServingWaiter();
                                currentOrder = servingWaiter.getCurrentOrder();
                                servingWaiter.clearOrder();
                                customer1.serviceEnd();
                                break;
                            }
                            else if (ch.equals("n")){
                                break;
                            }
                        }catch (Exception e){
                            System.out.println("ERROR: invalid input");
                        }finally {
                            scan = new Scanner(System.in);
                        }
                    }
                }
                else if (line.equals("5")){
                    menu.showMenu();
                }
                else if (line.equals("6")){
                    customer1.showOrderDemand();
                }
                else{
                    System.out.println("**********\n命令错误，请重新输入\n**********");
                }
                if (flag){
                    break;
                }
            }
        }



        //传给后厨菜单order并设置订单状态
        Order order = currentOrder;

        //观察者模式
        waiter1.setOrder(order);
        cook1.setOrder(order);
        order.setOrderState(0);

        //使用备忘录来备份order
        OrderClone orderClone = new OrderClone(order);
        OrderClone orderClone1 = (OrderClone)orderClone.clone();
        Memento memento = new Memento();
        memento.addOrderClone(orderClone1);
        //获取备份的order
        //memento.getOrderClone(1);


        //分支事件
        System.out.println("\n"+"请您耐心等候，正在为您处理订单，如果有需要请联系服务员！");
        System.out.println("如果想要修改空调温度，请输入 1 :");
        System.out.println("如果想要进行投诉，请输入 2 :");
        System.out.println("如果没有什么需求，请输入 3 :");
        String ask = scan.nextLine().toString();
        //通过状态进行推出
        while (!ask.equals("3")){
            if(ask.equals("2")){
                System.out.println("classname:"+Complaint.class.getName()+"method: settleComplaint action desc: 处理顾客投诉");
                System.out.println("请您选择投诉的类型:");
                System.out.println("上菜太慢请输入1");
                System.out.println("其他投诉请输入2");
                String complaintType = scan.nextLine().toString();
                Complaint complaint = new Complaint(complaintType, manager1, waiter1);
                complaint.setCurHanlder();
                complaint.getEmployee().settleComplaint();
            }else if(ask.equals("1")){
                System.out.println("classname:"+Waiter.class.getName()+"method: changeTemperature action desc: 改变空调温度");
                System.out.println("请输入您想选择的温度:");
                String temperature = scan.nextLine().toString();
                Double t=Double.parseDouble(temperature);
                waiter1.setTemperature(t);
                waiter1.changeTemperature();
            }
            System.out.println("请您耐心等候，正在为您处理订单，如果有需要请联系服务员！");
            System.out.println("如果想要修改空调温度，请输入 1 :");
            System.out.println("如果想要进行投诉，请输入 2 :");
            System.out.println("如果没有什么需求，请输入 3 :");
            ask = scan.nextLine().toString();
        }


        //后厨需要的参数和调度器设置
        order.setID(1);
        OrderDispatcher dispatcher = new OrderDispatcher();
        dispatcher.addOrder(order);

        //判断order是否完成
        while (order.getOrderState()!=1) {
            Thread.sleep(100L);
        }

        //外观模式：服务员检查订单是否有酒水，如果有则取酒水
        waiter1.getDrinkList(order);

        //菜做完、酒水取完后，订单状态改变
        //order.setOrderState(1);
        //顾客开始就餐到就餐结束
        System.out.println("祝您就餐愉快！");

        ExpressForFree expressForFree = new ExpressForFree(customer1.getCustomerName() + "," +
                customer1.getCustomerGender());
        boolean isFree = expressForFree.isFree();
        isFree = false;
        //System.out.println("isFree? " + isFree);
        if(isFree){
            System.out.println("今天是店长小伙子 java 的生日，所有和 java 同名的男人都能免单！");
        }else {
            //就餐结束去结账
            System.out.println("您是否持有优惠券？如果有请输入对应的优惠卷类型A，B，C，如果没有请输入N！");
            String type = scan.nextLine().toString();
            cashier1.setOrder(order);
            cashier1.setCouponType(type);

            //通过优惠劵类型来结账
            RealDiscount realDiscount = new RealDiscount(type);


            //结完账之后来推荐一个VIP办理
            //先判断是不是VIP，然后再推荐
            List<Customer> customerList = new ArrayList<>();
            customerList.add(customer1);
            CustomerCriteria vipCriteria = new VIPCustomerCriteria(customerList);
            vipCriteria.meetCriteria();
            boolean isVIP = vipCriteria.isMetCriteria(customer1);

            //System.out.println("这个顾客 isVIP? " + isVIP);

            VIPCashierDecorator vipCashierDecorator = new VIPCashierDecorator(cashier1);
            vipCashierDecorator.settleAccount();
        }






        ////<<<< eatamath debug
//        ArrayList<Employee> arr = new ArrayList<>();
//        Manager manager = new Manager("manager");
//        arr.add(manager);
//        Waiter wt1 = new Waiter("waiter 1");
//        Waiter wt2 = new Waiter("waiter 2");
//        arr.add(wt1);
//        arr.add(wt2);
//
//        InterPhoneChannel phone = InterPhoneChannel.getInstance(arr);
//
//        var res = manager.notifyWaitersToService();
//        System.out.println(res);


        //打折的测试
        //RealDiscount realDiscount = new RealDiscount("A");
        //System.out.printf("discount = "+realDiscount.getDiscount());

        //投诉处理的测试
//        Manager manager = Manager.getInstance();
//        Waiter waiter = new Waiter();
//
//        Complaint complaint = new Complaint(1, manager, waiter);
//        complaint.setCurHanlder();
//        complaint.getEmployee().settleComplaint();
//
//        Complaint complaint1 = new Complaint(3, manager, waiter);
//        complaint1.setCurHanlder();
//        complaint1.settleProblem();

        //结账处理的测试
//        Order order = new Order();
//        order.setPrice(100.0);
//        Cashier cashier = new Cashier(order, "N");
//
//        VIPCashierDecorator vipCashierDecorator = new VIPCashierDecorator(cashier);
//        vipCashierDecorator.settleAccount();


        //原型和备忘录模式的测试
//        Order order = new Order();
//        order.setPrice(100.0);
//
//        OrderClone orderClone = new OrderClone(order);
//
//        OrderClone orderClone1 = (OrderClone)orderClone.clone();
//        Memento memento = new Memento();
//        memento.addOrderClone(orderClone1);
//        //memento.getOrderClone(1);
//        int length = memento.getSize();
//        System.out.println(memento.getOrderClone(length-1).getPrice());



        //输出菜单测试
//        Menu menu = Menu.getInstance();
//        menu.showMenu();

        //观察者模式测试
//        Order order= new Order();
//        Employee waiter2 = new Waiter(24,new FloorAirConditioner(),order);
//        Employee cook2= new Cook(24,new FloorAirConditioner(),order);
//        order.setOrderState(0);
//        order.setOrderState(1);
//        //facade测试
//        List<Item> items=new ArrayList<>();
//        items.add(new Item("可乐",20.2));
//        items.add(new Item("雪碧",20.2));
//        items.add(new Item("酸梅汁",20.2));
//        items.add(new Item("百威啤酒",20.2));
//        order.setItemList(items);
//        ((Waiter) waiter2).getDrinkList(order);


//
//        int id = 1;
//        List<Item> itemList = new ArrayList<Item>();
//        itemList.add(new Item("汉堡", 22));
//        itemList.add(new Item("薯条", 12));
//        itemList.add(new Item("果汁", 18));
//        OrderDispatcher dispatcher = new OrderDispatcher();
//        Order order = new Order();
//        order.setID(id);
//        order.setItemList(itemList);
//        dispatcher.addOrder(order);
//        int n = 3;
//        while(n > 0){
//            n--;
//            id++;
//            Thread.sleep(10000L);
//            int number = (new Random().nextInt(4)) + 1;
//            List<Item> items = new ArrayList<Item>();
//            while(number-- != 0){
//                items.add(Menu.getInstance().getItem(new Random().nextInt(18)));
//            }
//            StringBuilder builder = new StringBuilder();
//            for (Item item : items) {
//                builder.append(item.getName()).append(" ");
//            }
//            System.out.println(id + " " + builder.toString());
//            dispatcher.addOrder(new Order(id, items));
//        }
//        while(true);



    }



}
