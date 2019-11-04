package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:29
 * @description
 * @project MagicRestaurant
 */
public class Juicer extends Device {
    public Juicer(){
        this.time = 3000L;
        this.deviceName = "juicer";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用juicer进行了榨汁操作");
    }
}
