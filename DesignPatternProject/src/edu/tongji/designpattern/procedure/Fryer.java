package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:23
 * @description
 * @project MagicRestaurant
 */
public class Fryer extends Device {
    public Fryer(){
        this.time = 8000L;
        this.deviceName = "fryer";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用fryer进行了油炸操作");
    }
}
