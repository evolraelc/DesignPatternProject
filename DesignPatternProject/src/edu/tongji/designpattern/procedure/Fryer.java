package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:23
 * @description
 * @project MagicRestaurant
 */
public class Fryer extends Device {
    @Override
    public void run() {
        try {
            Thread.sleep(8000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
