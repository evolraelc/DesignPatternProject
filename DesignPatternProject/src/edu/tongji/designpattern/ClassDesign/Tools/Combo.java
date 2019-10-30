package edu.tongji.designpattern.ClassDesign.Tools;

public class Combo {
    private String dishA;
    private String dishB;
    private String drink;
    private String price;

    public void setDishA(String dishA) {
        System.out.println("热菜："+dishA+" ");
    }

    public void setDishB(String dishB) {
        System.out.println("冷菜："+dishB+" ");
    }

    public void setDrink(String drink) {
        System.out.println("饮料："+drink+" ");
    }

    public void setPrice(String price){
        System.out.println("总价："+price+" ");
    }
}
