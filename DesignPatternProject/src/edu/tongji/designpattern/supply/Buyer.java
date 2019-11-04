package edu.tongji.designpattern.supply;

import java.util.Map;

/**
 * @program: MagicRestaurant
 * @description: 进货员，多线程
 * @author: Mr.King
 * @create: 2019-10-23 13:52
 **/

public class Buyer implements Runnable {
    private Procurement procurement;
    private Warehouse warehouse;
    public Buyer(Warehouse warehouse,Procurement procurement){
        this.warehouse=warehouse;
        this.procurement=procurement;

    }
    @Override
    public void run() {
        //System.out.println( this.getClass().getName()+":"+" run：多线程检查库存");
        for(Map.Entry<String, Ingredient> entry: warehouse.ingredientMap.entrySet()){
            if (entry.getValue().getNumber() < 10){
                System.out.println(entry.getValue().getName()+"库存:"+entry.getValue().getNumber()+",即将耗尽，正在安排进货...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(entry.getValue().getName()+"补货完毕,库存:"+(entry.getValue().getNumber()+90));
                entry.getValue().setNumber(entry.getValue().getNumber()+90);

            }

        }

        procurement.isBusy=false;
    }
}
