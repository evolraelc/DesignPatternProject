package code;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static Menu menu=new Menu();
    private List<Item> menuList=new ArrayList<>();
    private Menu() {
        Item dish=new Item("burger",5);
        menuList.add(dish);
    }
    public List<Item> getMenu() {
        return menuList;
    }
}
