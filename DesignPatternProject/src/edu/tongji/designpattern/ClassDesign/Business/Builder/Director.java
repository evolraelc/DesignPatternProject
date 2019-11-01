package edu.tongji.designpattern.ClassDesign.Business.Builder;

import edu.tongji.designpattern.ClassDesign.Tools.Combo;

public class Director {
    private ComboBuilder comboBuilder;
    public Director(ComboBuilder comboBuilder){
        this.comboBuilder=comboBuilder;
    }

    public Combo construct(){
        System.out.println("套餐内容：");
        comboBuilder.buildDishA();
        comboBuilder.buildDishB();
        comboBuilder.buildDrink();
        comboBuilder.buildPrice();
        return comboBuilder.getResult();
    }

}
