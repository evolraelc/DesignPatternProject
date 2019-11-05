package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:33
 * @description 烧烤架
 * @project MagicRestaurant
 */
public class Grill extends Device {
    @Override
    public void run() {
        try {
            Thread.sleep(7000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
