package code;

import code.DrinkOpener;

public class RedWineOpener implements DrinkOpener {

    @Override
    public void Open() {
        System.out.println("class RedWineOpener：method Open：服务员为您打开了红酒！");
    }
}
