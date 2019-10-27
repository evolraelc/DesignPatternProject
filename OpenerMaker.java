package code;

import code.BeerOpener;
import code.DrinkOpener;

public class OpenerMaker {
    private DrinkOpener beerOpener;
    private DrinkOpener redWineOpener;
    public OpenerMaker(){
        beerOpener = new BeerOpener();
        redWineOpener= new RedWineOpener();
    }
    public void openBeer() {
        beerOpener.Open();
    }
    public void openRedWine() {
        redWineOpener.Open();
    }

}
