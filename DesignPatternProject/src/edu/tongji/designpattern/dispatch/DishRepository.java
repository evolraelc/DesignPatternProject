package edu.tongji.designpattern.dispatch;

import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.common.Container;
import edu.tongji.designpattern.common.Iterator;

public class DishRepository implements Container {
	private Order order;

	public DishRepository(Order order) {
		this.order = order;
	}
	
	@Override
	public Iterator getIterator() {
		return new DishIterator();
	}
	
	public class DishIterator implements Iterator{
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < order.getDishList().size();
		}
		
		@Override
		public Object next() {
			if(this.hasNext()) {
				return order.getDishList().get(index++);
			}
			return null;
		}

		@Override
		public void remove() {
			if(index != 0) {
				index--;
				order.getDishList().remove(index);
			}
		}


	}
}
