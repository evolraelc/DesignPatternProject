package edu.tongji.designpattern.common;


import edu.tongji.designpattern.dispatch.ChefFactory;
import edu.tongji.designpattern.meal.DishFactory;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/2 17:51
 * @description
 * @project MagicRestaurant
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String factory){
        if (factory.equals("chef")) return ChefFactory.getChefFactory();
        else if (factory.equals("dish")) return new DishFactory();
        return null;
    }
}
