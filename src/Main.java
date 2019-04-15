import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
        List<Persona> personas = Arrays.asList(

        new Persona("p1", 22,"12345678"),
        new Persona("p2", 16, "12345679"),
        new Persona("p3", 23, "23000000")
        );

        System.out.println(String.format("Nombre: %s", personas));

        System.out.println(String.format("Mayor a 21: %s", personas.stream()
            .filter(Persona -> Persona.getAge() > 21)
            .collect(Collectors.toList())));

        System.out.println(String.format("Menor a 18: %s", personas.stream()
            .filter(Persona -> Persona.getAge() < 18)
            .collect(Collectors.toList())));

        System.out.println(String.format("Menor a 21 y DNI mayor a 20000000: %s", personas.stream()
                .filter(Persona -> Persona.getAge() > 21)
                .filter(Persona -> Persona.getDni().compareTo("20000000")>0)
                .collect(Collectors.toList())));

    }
}
