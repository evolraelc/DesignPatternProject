package edu.tongji.designpattern.ClassDesign.Business.Builder;

import edu.tongji.designpattern.ClassDesign.Tools.Combo;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;



public abstract class ComboBuilder {
    protected Combo combo=new Combo();
    public abstract void buildDishA();
    public abstract void buildDishB();
    public abstract void buildDrink();
    public abstract void buildPrice();
    public Combo getResult(){
        return combo;
    }

}
