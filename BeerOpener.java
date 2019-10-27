package code;

public class BeerOpener implements DrinkOpener {

    @Override
    public void Open() {
        System.out.println("class BeerOpener：method Open：服务员为您打开了啤酒！");
    }
}
