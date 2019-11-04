package edu.tongji.designpattern.supply;


import edu.tongji.designpattern.common.Watcher;

/**
 * @program: MagicRestaurant
 * @description: 采购者，观察仓库库存，及时补货
 * @author: Mr.King
 * @create: 2019-10-22 21:34
 **/

public class Procurement extends Watcher {
    public Boolean isBusy=false;
    @Override
    public void update() {
        //System.out.println( this.getClass().getName()+":"+" update：使用观察者模式，在仓库更新后通知Procurement进行更新");
        while (isBusy);
        isBusy=true;
        new Thread(new Buyer(Warehouse.getInstance(),this)).start();


    }


}
