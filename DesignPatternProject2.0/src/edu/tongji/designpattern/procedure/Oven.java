package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:14
 * @description 烤箱
 * @project MagicRestaurant
 */
public class Oven extends Device {
    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
