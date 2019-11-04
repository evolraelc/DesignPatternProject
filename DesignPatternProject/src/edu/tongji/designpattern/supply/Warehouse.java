package edu.tongji.designpattern.supply;

import edu.tongji.designpattern.common.Watcher;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @program: MagicRestaurant
 * @description: 仓库
 * @author: Mr.King
 * @create: 2019-10-22 19:52
 **/

public class Warehouse {
    private boolean isBuying = false;

    private static Warehouse instance =new Warehouse();

    private Warehouse(){
        this.loadWarehouse();
        Procurement procurement=new Procurement();
        this.attach(procurement);
    }

    public Hashtable<String,Ingredient> ingredientMap = new Hashtable<String,Ingredient>();

    private List<Watcher> watchers= new ArrayList<Watcher>();

    public synchronized List<Ingredient> getIngredientByName(String ingredientName, Integer ingredientNumber){
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        Ingredient cachedIngredient = ingredientMap.get(ingredientName);
        if (cachedIngredient.getNumber() - ingredientNumber < 0){
            return null;
        }
        cachedIngredient.setNumber(cachedIngredient.getNumber() - ingredientNumber);
        if(cachedIngredient.getNumber() < 10 && !isBuying) notifyAllObservers();
        for (int i = 0; i < ingredientNumber; i++) {
            ingredients.add((Ingredient) cachedIngredient.clone());
        }
        return ingredients;
    }

    public static Warehouse getInstance(){
        //System.out.println( "Warehouse:"+"getInstance ：通过单例模式获得仓库对象");
        return instance;//单例模式
    }

    public void attach(Watcher watcher){
        watchers.add(watcher);
    }//观察者模式

    public void notifyAllObservers(){
        for (Watcher watcher : watchers) {
            watcher.update();
        }
    }

    public void finished() {
        this.isBuying = false;
    }

    public void show(){
        System.out.println( this.getClass().getName()+":"+" show：展示仓库库存情况");
        for(Map.Entry<String, Ingredient> entry: this.ingredientMap.entrySet()){
            System.out.println(entry.getKey()+"---"+entry.getValue().getNumber());
        }
    }

    public  void loadWarehouse() {
        Ingredient lettuce =new Ingredient("lettuce",100,10);
        ingredientMap.put(lettuce.getName(),lettuce);

        Ingredient tomato =new Ingredient("tomato",100,10);
        ingredientMap.put(tomato.getName(),tomato);

        Ingredient cucumber =new Ingredient("cucumber",100,10);
        ingredientMap.put(cucumber.getName(),cucumber);

        Ingredient fish =new Ingredient("fish",100,10);
        ingredientMap.put(fish.getName(),fish);

        Ingredient shrimp =new Ingredient("shrimp",100,10);
        ingredientMap.put(shrimp.getName(),shrimp);

        Ingredient nori =new Ingredient("nori",100,10);
        ingredientMap.put(nori.getName(),nori);

        Ingredient rice =new Ingredient("rice",100,10);
        ingredientMap.put(rice.getName(),rice);

        Ingredient pasta =new Ingredient("pasta",100,10);
        ingredientMap.put(pasta.getName(),pasta);

        Ingredient mushroom =new Ingredient("mushroom",100,10);
        ingredientMap.put(mushroom.getName(),mushroom);

        Ingredient meat =new Ingredient("meat",100,10);
        ingredientMap.put(meat.getName(),meat);

        Ingredient chicken =new Ingredient("chicken",100,10);
        ingredientMap.put(chicken.getName(),chicken);

        Ingredient tortilla =new Ingredient("tortilla",100,10);
        ingredientMap.put(tortilla.getName(),tortilla);

        Ingredient potato =new Ingredient("potato",100,10);
        ingredientMap.put(potato.getName(),potato);

        Ingredient bread =new Ingredient("bread",100,10);
        ingredientMap.put(bread.getName(),bread);

        Ingredient cheese =new Ingredient("cheese",100,10);
        ingredientMap.put(cheese.getName(),cheese);

        Ingredient vegetable =new Ingredient("vegetable",100,10);
        ingredientMap.put(vegetable.getName(),vegetable);

        Ingredient pineapple =new Ingredient("pineapple",100,10);
        ingredientMap.put(pineapple.getName(),pineapple);

        Ingredient paste  =new Ingredient("paste ",100,10);
        ingredientMap.put(paste .getName(),paste );

        Ingredient sausage =new Ingredient("sausage",100,10);
        ingredientMap.put(sausage.getName(),sausage);

        Ingredient egg =new Ingredient("egg",100,10);
        ingredientMap.put(egg.getName(),egg);

        Ingredient chocolate =new Ingredient("chocolate",100,10);
        ingredientMap.put(chocolate.getName(),chocolate);

        Ingredient strawberry =new Ingredient("strawberry",100,10);
        ingredientMap.put(strawberry.getName(),strawberry);

        Ingredient honey =new Ingredient("honey",100,10);
        ingredientMap.put(honey.getName(),honey);

        Ingredient flour =new Ingredient("flour",100,10);
        ingredientMap.put(flour.getName(),flour);

        Ingredient carrot =new Ingredient("carrot",100,10);
        ingredientMap.put(carrot.getName(),carrot);

        Ingredient banana =new Ingredient("banana",100,10);
        ingredientMap.put(banana.getName(),banana);

        Ingredient watermelon =new Ingredient("watermelon",100,10);
        ingredientMap.put(watermelon.getName(),watermelon);
    }

    public List<Ingredient> getIngredient(String name ,Integer number){
        Boolean isasked=false;
        List<Ingredient> ingredients = null;
//        System.out.println( this.getClass().getName()+":"+" getIngredientByName：通过配料名和数量并使用原型模式得到配料队列，对库存进行了相关管理");
        ingredients=this.getIngredientByName(name,number);
        if (ingredients!=null){
            return ingredients;
        }
        else{
            do{
                if (!isasked){
                    System.out.println(name+"不足，无法取出，等一会");
                    isasked=true;
                }
                ingredients=this.getIngredientByName(name,number);
            }while(ingredients==null);
            return ingredients;
        }

    }
}
