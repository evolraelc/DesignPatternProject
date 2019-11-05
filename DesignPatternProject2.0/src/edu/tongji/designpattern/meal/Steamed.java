package edu.tongji.designpattern.meal;


import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/30 8:39
 * @description
 * @project MagicRestaurant
 */
public class Steamed extends Dish{
    Steamed(){
        this.name="steamed";
        this.ID=1;
        this.Price=20;
    }

    @Override
    void initOperations() {
        Hashtable<String, Integer> ingredients = new Hashtable<>();
        ingredients.put("flour", 1);
        ingredients.put("carrot", 3);
        this.operationList.add(new Operation(ingredients, "fetch"));
        this.operationList.add(new Operation("carrot", 3, "cutlery"));
        this.operationList.add(new Operation(ingredients, "blender"));
        this.operationList.add(new Operation(ingredients, "steamer"));
    }
}
