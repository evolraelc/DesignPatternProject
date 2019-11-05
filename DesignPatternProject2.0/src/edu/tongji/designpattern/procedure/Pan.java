package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/23 16:45
 * @description 煎锅
 * @project MagicRestaurant
 */
public class Pan extends Device {
    @Override
    public void run() {
        try {
            Thread.sleep(6000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
