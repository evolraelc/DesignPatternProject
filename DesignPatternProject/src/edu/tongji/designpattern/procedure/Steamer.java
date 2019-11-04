package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:26
 * @description
 * @project MagicRestaurant
 */
public class Steamer extends Device {
    public Steamer(){
        this.time = 8000L;
        this.deviceName = "steamer";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用steamer进行了蒸操作");
    }
}
