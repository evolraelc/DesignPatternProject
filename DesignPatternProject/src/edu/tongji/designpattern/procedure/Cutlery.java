package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:02
 * @description
 * @project MagicRestaurant
 */
public class Cutlery extends Device {
    public Cutlery(){
        this.time = 5000L;
        this.deviceName = "cutlery";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用cutlery进行了切碎操作");
    }
//    @Override
//    void act() {
//        System.out.println("classname:procedure.Cut method name:act action des:使用");
//        try {
//            Thread.sleep(this.time);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
}
