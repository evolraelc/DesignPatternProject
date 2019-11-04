package edu.tongji.designpattern.meal;

import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/30 8:47
 * @description
 * @project MagicRestaurant
 */
public class Barbecue extends Dish{
    Barbecue(){
        this.name="barbecue";
        this.ID=1;
        this.Price=20;
    }

    @Override
    void initOperations() {
        Hashtable<String, Integer> ingredients = new Hashtable<>();
        ingredients.put("meat", 3);
        ingredients.put("mushroom", 3);
        ingredients.put("pineapple", 1);
        this.operationList.add(new Operation(ingredients, "fetch"));
        this.operationList.add(new Operation("meat", 3, "cutlery"));
        this.operationList.add(new Operation("mushroom", 3, "cutlery"));
        this.operationList.add(new Operation("pineapple", 1, "cutlery"));
        this.operationList.add(new Operation(ingredients, "grill"));
    }
}
