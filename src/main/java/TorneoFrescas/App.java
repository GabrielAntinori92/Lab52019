package TorneoFrescas;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args ) {

        List<Spartan> spartans = Arrays.asList(
                new Spartan("Spartan 1", 22, 90f,new SpartanDrinksImp(), new SpartanPeesImp()),
                new Spartan("Spartan 2", 23,70f, new SpartanDrinksImp(),new SpartanPeesImp()),
                new Spartan("Spartan 3",25,50f,new SpartanDrinksImp(),new SpartanPeesImp()),
                new Spartan("Spartan 4", 21, 95f, new SpartanDrinksImp(), new SpartanPeesImp())
        );
        spartans = spartans.stream().sorted(Comparator.comparing(Spartan::getWeight)).collect(Collectors.toList());
        System.out.println(String.format("Team Sparta: %s", spartans));
        spartans.remove(spartans.stream().findFirst().get());
        System.out.println(String.format("Team Sparta: %s",spartans));

        List<Viking> vikings = Arrays.asList(
                new Viking("Viking 1", 22, 120f, new VikingDrinksImp(), new VikingPeesImp()),
                new Viking("Viking 2",24,100f,new VikingDrinksImp(),new VikingPeesImp()),
                new Viking("Viking 3", 21,90f,new VikingDrinksImp(),new VikingPeesImp()),
                new Viking("Viking 4",25,140f,new VikingDrinksImp(),new VikingPeesImp())
        );

        vikings = vikings.stream().sorted(Comparator.comparing(Viking::getWeight)).collect(Collectors.toList());
        System.out.println(String.format("Team Viking: %s", vikings));
        vikings.remove(vikings.stream().findFirst().get());
        System.out.println(String.format("Team Viking: %s",vikings));

        Random dado = new Random();
        int vikingsresistance = vikings.stream().mapToInt(Viking -> Viking.getEndurance()).sum();  //resistencia total del team
        int spartansresistance = spartans.stream().mapToInt(Spartan -> Spartan.getEndurance()).sum();

        while(vikingsresistance > 0 && spartansresistance > 0){

            Spartan spartan = spartans.get(dado.nextInt(spartans.size()));
            Viking viking = vikings.get(dado.nextInt(vikings.size()));

            int spartanresistance = spartan.getEndurance();//resistencia individual del concursante
            int vikingresistance = viking.getEndurance();

            while(vikingresistance > 0 && spartanresistance > 0){

                System.out.println(String.format("Name Contestant: %s Endurance: %d",spartan.getName(),spartanresistance));
                System.out.println(String.format("Name Contestant: %s Endurance: %d",viking.getName(),vikingresistance));

                spartanresistance -= spartan.startDrinking();
                if(spartanresistance < 0){
                    spartanresistance = 0;

                }

                vikingresistance -= viking.startDrinking();
                if(vikingresistance < 0){
                    vikingresistance = 0;
                }

                System.out.println(String.format("Name Contestant: %s Endurance: %d",spartan.getName(),spartanresistance));
                System.out.println(String.format("Name Contestant: %s Endurance: %d",viking.getName(),vikingresistance));

            }

            if(spartanresistance > 0){
                System.out.println(viking.startPee());
                System.out.println("Spartan contestant wins round");
            }else
                if(vikingresistance > 0){
                    System.out.println(spartan.startPee());
                System.out.println("Viking contestant wins round");
            }else{
                    spartan.startPee();
                    viking.startPee();
                    System.out.println("It's a Draw");
                }

            spartansresistance -= (spartan.getEndurance() - spartanresistance); //se reduce la resistencia perdida de los concursantes del total del team despues de la ronda
            vikingsresistance -= (viking.getEndurance() - vikingresistance);
        }

        if(spartansresistance > 0){
            System.out.println("Spartans wins Tournament");
        }else if(vikingsresistance > 0){
            System.out.println("Vikings wins Tournament");
        }else{
            System.out.println("Tournament ends in Draw");
        }
    }
}
