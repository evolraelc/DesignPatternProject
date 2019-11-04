package edu.tongji.designpattern.procedure;

import java.util.Hashtable;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 23:36
 * @description
 * @project MagicRestaurant
 */
public class DeviceCache {
    private static DeviceCache instance = new DeviceCache();

    private Hashtable<String, Device> deviceMap;

    private Hashtable<String, Integer> deviceNumber;

    // private List<Observer> observers;

    private DeviceCache(){
        // observers = new ArrayList<>();

        this.deviceMap = new Hashtable<String, Device>();
        Cutlery cutlery = new Cutlery();
        deviceMap.put("cutlery", cutlery);
        Oven oven = new Oven();
        deviceMap.put("oven", oven);
        Fryer fryer = new Fryer();
        deviceMap.put("fryer", fryer);
        Juicer juicer = new Juicer();
        deviceMap.put("juicer", juicer);
        Blender blender = new Blender();
        deviceMap.put("blender", blender);
        Steamer steamer = new Steamer();
        deviceMap.put("steamer", steamer);
        Grill grill = new Grill();
        deviceMap.put("grill", grill);
        Pan pan = new Pan();
        deviceMap.put("pan", pan);

        this.deviceNumber = new Hashtable<String, Integer>();
        deviceNumber.put("cutlery", 5);
        deviceNumber.put("oven", 5);
        deviceNumber.put("fryer", 5);
        deviceNumber.put("juicer", 5);
        deviceNumber.put("blender", 5);
        deviceNumber.put("steamer", 5);
        deviceNumber.put("grill", 5);
        deviceNumber.put("pan", 5);
    }

    public Device getDevice(String deviceName){
        Device cachedDevice = deviceMap.get(deviceName);
        Integer remainingDevice = deviceNumber.get(deviceName);
        if(remainingDevice >= 1) {
            deviceNumber.replace(deviceName, remainingDevice - 1);
            return (Device) cachedDevice.clone();
        }
        else return null;
    }

    public void freeDevice(String deviceName){
        Integer remainingDevice = deviceNumber.get(deviceName);
        deviceNumber.replace(deviceName, remainingDevice + 1);

    }

    public static DeviceCache getInstance(){
        return instance;
    }
}
