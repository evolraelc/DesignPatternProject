package edu.tongji.designpattern.meal;



import edu.tongji.designpattern.procedure.Operation;

import java.util.Hashtable;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/30 8:43
 * @description
 * @project MagicRestaurant
 */
public class Juice extends Dish{
    Juice(){
        this.name="juice";
        this.ID=1;
        this.Price=20;
    }

    @Override
    void initOperations() {
        Hashtable<String, Integer> ingredients = new Hashtable<>();
        ingredients.put("banana", 2);
        ingredients.put("watermelon", 1);
        ingredients.put("pineapple", 1);
        ingredients.put("strawberry", 3);
        this.operationList.add(new Operation(ingredients, "fetch"));
        this.operationList.add(new Operation("banana", 2, "cutlery"));
        this.operationList.add(new Operation("watermelon", 1, "cutlery"));
        this.operationList.add(new Operation("pineapple", 1, "cutlery"));
        this.operationList.add(new Operation("strawberry", 3, "cutlery"));
        this.operationList.add(new Operation(ingredients, "juicer"));
    }
}
