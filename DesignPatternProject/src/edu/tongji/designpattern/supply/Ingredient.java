package edu.tongji.designpattern.supply;

/**
 * @program: MagicRestaurant
 * @description: 食材类，实现克隆接口
 * @author: Mr.King
 * @create: 2019-10-22 18:01
 **/

public class Ingredient implements Cloneable {

    private String name;
    private Integer number;
    private Integer price;

    public Ingredient(String name, Integer number, Integer price) {

        this.name = name;
        this.number = number;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    @Override
    public Object clone() {//原型模式
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
