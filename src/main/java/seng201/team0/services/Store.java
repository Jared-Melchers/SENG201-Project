package seng201.team0.services;

import seng201.team0.CharacterManager;
import seng201.team0.models.Car;
import seng201.team0.models.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * the class Store manages the functions of the store gui like purchasing and repairing cars.
 */
public class Store {
    static List<Car> cars = CharacterManager.getAvailableCars();
    static Player player = CharacterManager.getPlayer();

    /**
     * constructor for the player entering the store
     */
    public Store() {
        player = CharacterManager.getPlayer();
    }

    /**
     * overflow constructor for testing purposes
     * @param player testing player
     * @param cars testing cars
     */
    public Store(Player player, List<Car> cars) {
        this.player = player;
        this.cars = cars;
    }

    /**
     * buys selected car from list if player has enough money
     * @param index index of the chosen car in the players list of owned cars
     * @return String response for if they successfully bought the car or didn't have enough money
     */
    public static String buyCar(int index){
        Car car = cars.get(index);
        int cost = car.getCost();
        if (Player.getMoney() >= cost) {
            Player.addCar(car);
            Player.changeMoney(-cost);
            cars.remove(car);
            return "Your car has been purchased";
        }
        else{
            return "You don't have enough money";
        }
    }

    /**
     * used to repair car
     * @param car index of the car the player is repairing in their owned car list
     * @return String showing the outcome of the repair, successfully repaired the car, not enough money or cant repair any further
     */
    public static String repairCar(int car) {
        if (Player.getCars().get(car).getCurrentHealth() + 25 <= 100) {
            Car repairedCar = Player.getCars().get(car);
            int cost = (int) Math.round((Math.pow(repairedCar.getCurrentHealth(),1.7))/100)*100+200;
            if (Player.getMoney() >= cost) {
                repairedCar.changeHealth(25);
                Player.changeMoney(-cost);
                return "Your car has been repaired to " + repairedCar.getCurrentHealth();
            } else {
                return "You don't have enough money";
            }
        }else{
            return "Can't repair your car any further";
        }
    }


}
