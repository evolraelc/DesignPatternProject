package edu.tongji.designpattern.ClassDesign.Business.Builder;

public class ConcreteComboBuilderA extends ComboBuilder {
    @Override
    public void buildDishA() {
        combo.setDishA("蒸鱼");
    }

    @Override
    public void buildDishB() {
        combo.setDishB("生菜沙拉");

    }
    @Override
    public void buildDrink() {
        combo.setDrink("可乐");
    }

    @Override
    public void buildPrice() {
        combo.setPrice("40");
    }
}
