package edu.tongji.designpattern.supply;

/**
 * @program: MagicRestaurant
 * @description: 抽象访问接口（操作)
 * @author: Mr.King
 * @create: 2019-10-23 21:47
 **/

public abstract class Visitor {
    public abstract void visit(Element element);
}
