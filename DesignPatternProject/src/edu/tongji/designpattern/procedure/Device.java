package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 22:45
 * @description 厨具基类
 * @project MagicRestaurant
 */
public abstract class Device implements Cloneable {
    public abstract void run();
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
