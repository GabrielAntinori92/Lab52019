package TorneoFrescas;

public class Spartan extends Human {

    private int toleranciaextra;

    public Spartan(){
        super();
    }

    public Spartan(String name, int age, float weight, Drink drinks, Pee pees) {
        super(name,age,weight,drinks,pees);
        super.setEndurance(10);
        this.toleranciaextra = 3;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int startDrinking(){

        int total = toleranciaextra - getDrinks().drink();

        if(total < 0){
            total = 1;
        }

        return total;
    }

    public String startPee(){
        return getName() + " " + getPee().pee();
    }
}
