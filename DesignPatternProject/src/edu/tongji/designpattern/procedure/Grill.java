package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:33
 * @description
 * @project MagicRestaurant
 */
public class Grill extends Device {
    public Grill(){
        this.time = 7000L;
        this.deviceName = "grill";
    }

    @Override
    public void print() {
        System.out.println("classname:" + this.getClass().getName() + " method name:act" +
                " action desc:使用grill进行了烧烤操作");
    }
//    @Override
//    void act() {
//        System.out.println("classname:barbecue method name:act");
//        try {
//            Thread.sleep(this.time);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
}
