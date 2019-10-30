package edu.tongji.designpattern.ClassDesign.Business.Builder;

public class ConcreteComboBuilderB extends ComboBuilder{
    @Override
    public void buildDishA() {
        combo.setDishA("蒸肉");
    }

    @Override
    public void buildDishB() {
        combo.setDishB("番茄沙拉");

    }
    @Override
    public void buildDrink() {
        combo.setDrink("雪碧");
    }

    @Override
    public void buildPrice() {
        combo.setPrice("41");
    }
}
