package edu.tongji.designpattern.procedure;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 22:45
 * @description 厨具基类
 * @project MagicRestaurant
 */
public abstract class Device implements Cloneable {
    protected Long time;
    protected String deviceName;

    public void run(){
        try {
            Thread.sleep(this.time);
            //print();
            DeviceCache.getInstance().freeDevice(this.deviceName);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public abstract void print();
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
