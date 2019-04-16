package TorneoFrescas;

import java.util.Random;

public class SpartanDrinksImp implements Drink {

    private Random dado;

    public SpartanDrinksImp(){
        this.dado = new Random();
    }

    public int drink(){

        return dado.nextInt(10);
    }

}
