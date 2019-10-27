package code;

public class Cook extends Employee {
    //这里可能需要发生变化，具体变化来自于cook的其他属性，形参改变
    public Cook(Order order){
        this.order=order;
        this.order.addEmploy(this);
    }

    @Override
    public void update() {
    if(order.getOrderState()==0)
        //这里需要get cook的名字
        System.out.println("class Cook: method update:接受到新订单！厨师开始做菜");
    else

        System.out.println("class Cook: method update:订单完成！厨师等待服务员接菜");
    }

}
