package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:14
 * @description
 * @project MagicRestaurant
 */
public class Oven extends Device {
    public Oven(){
        this.time = 5000L;
        this.deviceName = "oven";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用oven进行了烘焙操作");
    }
//    @Override
//    void act() {
//        System.out.println("classname:procedure.Bake method name:act");
//        try {
//            Thread.sleep(this.time);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
}
