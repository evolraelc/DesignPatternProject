package edu.tongji.designpattern.dispatch;

import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.common.Container;
import edu.tongji.designpattern.common.Iterator;

//迭代器模式
public class DishRepository implements Container {
	private Order order;

	public DishRepository(Order order) {
		this.order = order;
	}

	//获得迭代器
	@Override
	public Iterator getIterator() {
		return new DishIterator();
	}

	//创建迭代器
	public class DishIterator implements Iterator{
		int index = 0;

		//判断是否有下一个
		@Override
		public boolean hasNext() {
			return index < order.getDishList().size();
		}

		//获取下一个
		@Override
		public Object next() {
			if(this.hasNext()) {
				return order.getDishList().get(index++);
			}
			return null;
		}

		//移除已经取出的元素
		@Override
		public void remove() {
			if(index != 0) {
				index--;
				order.getDishList().remove(index);
			}
		}


	}
}
