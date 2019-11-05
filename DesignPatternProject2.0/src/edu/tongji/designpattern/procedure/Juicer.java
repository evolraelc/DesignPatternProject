package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:29
 * @description 榨汁机
 * @project MagicRestaurant
 */
public class Juicer extends Device {
    @Override
    public void run() {
        try {
            Thread.sleep(3000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
