package edu.tongji.designpattern.common;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.dispatch.Chef;
import edu.tongji.designpattern.meal.Dish;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/2 17:51
 * @description
 * @project MagicRestaurant
 */
public abstract class AbstractFactory {
    public abstract Chef getChef(String name);
    public abstract Chef searchFreeChef();
    public abstract Dish getDish(Item item);
}
