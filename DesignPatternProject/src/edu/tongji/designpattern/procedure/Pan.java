package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/23 16:45
 * @description
 * @project MagicRestaurant
 */
public class Pan extends Device {
    public Pan(){
        this.time = 6000L;
        this.deviceName = "pan";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用pan进行了煎操作");
    }
}
