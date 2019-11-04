package edu.tongji.designpattern.DevideByPattern.IteratorPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.Order;
import java.util.List;

public class ItemIterator implements MyIterator<Item> {

    private Order order = null;
    private List<Item> lst = null;
    private int position = 0;

    public ItemIterator(Order order, List<Item> dishes){
        this.order = order;
        this.lst = dishes;
    }

    @Override
    public boolean hasNext() {
        return position <= (lst.size() - 1);
    }

    @Override
    public Item getNext() {
        if (position < lst.size()){
            return lst.get(position++);
        }
        System.out.println("out of bound");
        return null;
    }

    @Override
    public void setPosition(int i) {
        if ( (i <= lst.size() - 1) && (i>=0) ){
            position = i;
        }
        else {
            System.out.println("out of bound");
        }
    }

    public Order getOrder(){return this.order;}

//    @Override
//    public Item getCurrent() {
//        if (lst.isEmpty() || (position>=lst.size()) || (position<0) ){
//            return null;
//        }
//        else
//            return lst.get(position);
//    }
}
