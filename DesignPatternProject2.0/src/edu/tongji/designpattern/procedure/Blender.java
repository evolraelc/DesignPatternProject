package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:19
 * @description 搅拌机
 * @project MagicRestaurant
 */
public class Blender extends Device {
    @Override
    public void run() {
        try {
            Thread.sleep(6000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
