package edu.tongji.designpattern.supply;


import edu.tongji.designpattern.common.Watcher;

/**
 * @program: MagicRestaurant
 * @description: 采购者，观察仓库库存，及时补货
 * @author: Mr.King
 * @create: 2019-10-22 21:34
 **/

public class Procurement extends Watcher {
    @Override
    public void update() {
        new Thread(new Buyer(Warehouse.getInstance(),this)).start();
    }


}
