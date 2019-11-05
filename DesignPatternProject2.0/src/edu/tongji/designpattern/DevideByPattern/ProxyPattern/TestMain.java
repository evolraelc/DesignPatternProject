package edu.tongji.designpattern.DevideByPattern.ProxyPattern;


import edu.tongji.designpattern.CommonClass.Customer.Customer;

/**
 * @description:
 * @autho: Cheng
 * @created: 2019-11-05-13-28
 **/
public class TestMain {

    public static void main(String[] args) {
        ////test for ProxyPattern
        MenuSource source = new ProxyMenuSource("pictureOfDish.jpg");
        //资源文件需要从磁盘加载
        source.show();
        System.out.println(" ");
        //资源文件不需要从磁盘加载
        source.show();
    }
}

