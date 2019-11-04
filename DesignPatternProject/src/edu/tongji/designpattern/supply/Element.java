package edu.tongji.designpattern.supply;

import java.util.List;

/**
 * @program: MagicRestaurant
 * @description: 抽象元素
 * @author: Mr.King
 * @create: 2019-10-23 21:55
 **/

public abstract class Element {
    public List<Ingredient> ingredients;
    abstract public void accept(Visitor visitor);
}
