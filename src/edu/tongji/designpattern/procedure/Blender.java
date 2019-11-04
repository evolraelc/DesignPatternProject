package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:19
 * @description
 * @project MagicRestaurant
 */
public class Blender extends Device {
    public Blender(){
        this.time = 6000L;
        this.deviceName = "blender";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用blender进行了搅拌操作");
    }
}
