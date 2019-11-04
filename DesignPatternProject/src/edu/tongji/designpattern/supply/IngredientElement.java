package edu.tongji.designpattern.supply;



/**
 * @program: MagicRestaurant
 * @description: 具体元素
 * @author: Mr.King
 * @create: 2019-10-23 22:00
 **/

public class IngredientElement extends Element {

    public IngredientElement(String name,Integer number,Warehouse warehouse){
        this.ingredients = warehouse.getIngredient(name,number);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
