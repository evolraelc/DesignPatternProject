package code;
public class Waiter extends Employee {

    public OpenerMaker openerMaker;
    public Waiter(Order order){
        this.order=order;
        this.order.addEmploy(this);
    }

    @Override
    public void update() {
    if(order.getOrderState()==0)
        System.out.println("class Waiter: method update:新订单创建！服务员等待接菜");
    else
        System.out.println("class Waiter: method update:订单完成！服务员开始上菜");
    }
public void getDrinkList(Order order){
     openerMaker=new OpenerMaker();
     for (Item item : order.items) {
         if (item.getName() == "beer" || item.getName() == "redwine") {
             if (item.getName() == "beer") {
                 openerMaker.openBeer();
             }
             else
                 openerMaker.openRedWine();
         }
     }
}
}
