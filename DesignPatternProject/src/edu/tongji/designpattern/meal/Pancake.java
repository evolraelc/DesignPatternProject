package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/29 23:09
 * @description
 * @project MagicRestaurant
 */
public class Pancake extends Dish{
    Pancake(){
        this.name="pancake";
        this.ID=1;
        this.Price=20;
    }

    @Override
    void initOperations() {
        Hashtable<String, Integer> ingredients = new Hashtable<>();
        ingredients.put("flour", 1);
        ingredients.put("egg", 3);
        ingredients.put("strawberry", 4);
        this.operationList.add(new Operation(ingredients, "fetch"));
        this.operationList.add(new Operation("strawberry", 4, "cutlery"));
        this.operationList.add(new Operation(ingredients, "blender"));
        this.operationList.add(new Operation(ingredients, "pan"));
    }
}
