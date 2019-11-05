package edu.tongji.designpattern.procedure;

import edu.tongji.designpattern.supply.Element;
import edu.tongji.designpattern.supply.IngredientElement;
import edu.tongji.designpattern.supply.Visitor;
import edu.tongji.designpattern.supply.Warehouse;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 感觉好想睡觉
 * @date 2019/10/22 22:44
 * @description 操作类
 * @project MagicRestaurant
 */
public class Operation extends Visitor {
    //原料集合，用来接受原料
    private Hashtable<String, Integer> ingredients;
    //厨具
    private String device;

    //单配料
    public Operation(String ingredient, Integer number, String device){
        this.ingredients = new Hashtable<String, Integer>();
        this.ingredients.put(ingredient, number);
        this.device = device;
    }

    //多配料
    public Operation(Hashtable<String, Integer> ingredients, String device){
        this.ingredients = ingredients;
        this.device = device;
    }

    //原型模式
    public String getDevice() {
        return device;
    }

    //操作主函数
    public void execute() {
        Set<String> keys = ingredients.keySet();
        Iterator<String> iterator = keys.iterator();
        //取原料操作
        if(device.equals("fetch")) {
            while (iterator.hasNext()){
                String ingredient = iterator.next();
                IngredientElement element = new IngredientElement(ingredient, ingredients.get(ingredient), Warehouse.getInstance());
                element.accept(this);
            }
        }
        //做操作
        else {
            Device realDevice = DeviceCache.getInstance().getDevice(device);
            realDevice.run();
//            System.out.print("classname:" + this.getClass().getName() + " method:execute" +
//                    " action desc:消耗了");
//            while (iterator.hasNext()){
//                String ingredient = iterator.next();
//                System.out.print(ingredients.get(ingredient) + "份" +ingredient + "原料 ");
//            }
//            System.out.println("\n");
        }
    }

    //访问者模式取原料
    @Override
    public void visit(Element element) {
        System.out.println("classname:" + this.getClass().getName() + " method:visit" +
                " action desc:" + "从仓库中取了" + element.ingredients.size() + "份" +
                element.ingredients.get(0).getName() + "原料剩余" + element.ingredients.get(0).getNumber());
    }
}
