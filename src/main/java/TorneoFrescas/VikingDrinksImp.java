package TorneoFrescas;

import java.util.Random;

public class VikingDrinksImp implements Drink {

    private Random dado;

    public VikingDrinksImp(){
        this.dado = new Random();
    }

    public int drink(){

        return  dado.nextInt(10);
    }
}
