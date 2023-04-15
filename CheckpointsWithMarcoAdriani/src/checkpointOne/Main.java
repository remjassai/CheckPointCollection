package checkpointOne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("RI23OT", "riot", "Jet", 20000.00, 30,false);
        Car car2 = new Car("MA29RC", "dont", "Tesla", 23000.00,33,true);
        Car car3 = new Car("RM43DC", "get", "Stunt", 20000.00,25,false);
        Car car4 = new Car("JA55AI","weary", "Hyjack", 23000.00,50,true);

        List<Car> listCars = new ArrayList<Car>();
        listCars.add(car1);
        listCars.add(car2);
        Concessionaria concA = new Concessionaria("MyCoolCar","Via Nano Ninja 23",listCars);
        Concessionaria concB = new Concessionaria("YourCoolCar","Via Buddha Boost 37");
        concB.addCar(car3);
        concB.addCar(car4);

        for(Car car : concA.listaAutoInVendita){
            if(car.getIsElectric()){
                System.out.println(car);
            }
        }

       if(concA.getPriceAverage() > concB.getPriceAverage()){
           System.out.println("The dealer with the highest average price is: '"+concA+"'.");
        }else if(concA.getPriceAverage() < concB.getPriceAverage()){
           System.out.println("The dealer with the highest average price is: '"+concB+"'.");
        }else{
           System.out.println("These dealers: '"+concA.getNome() +"' and '" + concB.getNome() + "' have the same average prices for cars.");
       }

//       Create a set of objects of type Car
        Set<Car> superConcC = new HashSet<Car>();

//       Insert all cars of the ArrayLists concA and concB in the newly created set.
        superConcC.addAll(concA.listaAutoInVendita);
        superConcC.addAll(concB.listaAutoInVendita);
//        Print the sum of all Car prices contained in the set.
        double sum = 0.0;
        for (Car car : superConcC) {
            sum += car.getPrice();
        }
        System.out.println("The sum of all car prices contained in the set is " + sum);
    }



}