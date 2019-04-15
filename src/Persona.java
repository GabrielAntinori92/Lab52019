public class Persona {
    private String name;
    private int age;
    private String dni;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Persona(String name, int age, String dni){
        this.age = age;
        this.name = name;
        this.dni = dni;
    }

    public String toString(){
        return "Nombre: " + getName() + " " + "DNI: " + getDni();
    }


}
