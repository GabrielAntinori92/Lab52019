package TorneoFrescas;

public class Viking extends Human {

    private int bebedorprofesional;

    public Viking(){
        super();
    }

    public Viking(String name, int age, float weight, Drink drinks, Pee pees){
        super(name,age,weight,drinks,pees);
        super.setEndurance(20);
        this.bebedorprofesional = 5;
    }

    public int startDrinking(){

        return bebedorprofesional + getDrinks().drink();
    }

    public String startPee(){
        return getName() + " " + getPee().pee();
    }

}
