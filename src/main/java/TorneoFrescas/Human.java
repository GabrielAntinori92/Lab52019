package TorneoFrescas;

public class Human {
    private String name;
    private int age;
    private float weight;
    private int endurance;
    private Drink drinks;
    private Pee pee;

    public Human(){

    }

    public Human(String name, int age, float weight, Drink drinks, Pee pee){
        this.name = name;
        this.age = age;
        this.weight = weight = weight;
        this.drinks = drinks;
        this.pee = pee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Drink getDrinks() {
        return drinks;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setDrinks(Drink drinks) {
        this.drinks = drinks;
    }

    public Pee getPee() {
        return pee;
    }

    public void setPee(Pee pee) {
        this.pee = pee;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + " " + "Weight: " + getWeight();
    }
}
