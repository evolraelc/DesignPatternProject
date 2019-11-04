package edu.tongji.designpattern.meal;


import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.common.AbstractFactory;
import edu.tongji.designpattern.dispatch.Chef;

import java.util.Hashtable;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/2 17:52
 * @description
 * @project MagicRestaurant
 */
public class DishFactory extends AbstractFactory {
    private Hashtable<String, Dish> dishMap;

    public DishFactory(){
        dishMap = new Hashtable<>();
        dishMap.put("沙拉", new Salad());
        dishMap.put("刺身", new Sashimi());
        dishMap.put("寿司", new Sushi());
        dishMap.put("意大利面", new Spaghetti());
        dishMap.put("炸鸡", new FriedChicken());
        dishMap.put("薯条", new Chips());
        dishMap.put("卷饼", new Burrito());
        dishMap.put("汉堡", new Burger());
        dishMap.put("披萨", new Pizza());
        dishMap.put("煎饼", new Pancake());
        dishMap.put("蛋糕", new Cake());
        dishMap.put("蒸菜", new Steamed());
        dishMap.put("果汁", new Juice());
        dishMap.put("烧烤", new Barbecue());
    }

    @Override
    public Chef getChef(String name) {
        return null;
    }

    @Override
    public Chef searchFreeChef() {
        return null;
    }

    @Override
    public Dish getDish(Item item) {
        return dishMap.get(item.getName());
    }
}
