package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:02
 * @description
 * @project MagicRestaurant
 */
public class Cutlery extends Device {
    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
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
