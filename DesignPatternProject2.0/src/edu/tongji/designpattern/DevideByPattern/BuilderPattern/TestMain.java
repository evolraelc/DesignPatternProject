package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-05-13-48
 **/
public class TestMain {
    public static void main(String[] args) {
       // test for BuilderPattern
        ComboBuilder comboBuilder1= new ConcreteComboBuilderA();
        ComboBuilder comboBuilder2= new ConcreteComboBuilderB();
        Director director1 =new Director(comboBuilder1);
        Director director2 =new Director(comboBuilder2);
        Combo comboA=director1.construct();
        Combo comboB=director2.construct();
    }
}


