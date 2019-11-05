package edu.tongji.designpattern.CommonClass.Items;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private static Menu menu=new Menu();
	private List<Item> menuList=new ArrayList<>();
	private String[] foodName = {
			"沙拉", "刺身", "寿司", "意大利面", "炸鸡", "薯条",
			"卷饼", "汉堡", "披萨", "煎饼", "蛋糕", "蒸菜", "果汁",
			"烧烤", "可乐", "雪碧", "百威啤酒", "酸梅汁"
	};

	//初始化菜单，向里面添加菜
	private Menu() {
		for(int i=0; i<foodName.length; i++) {
			double[] foodPrice = {
					12, 22, 25, 22, 28, 18,
					24, 26, 28, 27, 25, 25,
					13, 27, 5, 6, 12, 5
			};
			Item dish = new Item(this.foodName[i], foodPrice[i]);
			menuList.add(dish);
		}
	}

	public static Menu getInstance() {
		return menu;
	}

	public void showMenu() {
		System.out.println("classname:"+this.getClass().getName()+"method : showMenu action desc:展示菜单");
		System.out.println("---------奇妙厨房---------");
		System.out.println("  ---------菜单---------  ");
		System.out.println("**菜名** **价格** **编号**");
		for(int i = 0; i < this.foodName.length; i++){
			System.out.printf("%-8s", menuList.get(i).getName());
			System.out.printf("%-8.2f", menuList.get(i).getPrice());
			System.out.printf("%4d", i);
			System.out.print("\n");
		}
	}

	public Item getItem(Integer index) {
		try {
			return menuList.get(index);
		}catch (IndexOutOfBoundsException e){
			System.out.println("ERROR: index out of bound of Menu");
			return null;
		}
	}
}
