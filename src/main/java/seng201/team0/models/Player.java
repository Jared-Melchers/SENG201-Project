package seng201.team0.models;

import java.util.ArrayList;
import java.util.List;

/**
 * the Player class used to keep the values directly tied to the player like money,name and the cars they've bought
 */
public class Player {
    String name; //player name
    static int money; //current amount of money
    static List<Car> cars;// = new ArrayList<Car>(); //list of owned cars
    /**
     * constructor for the Player class
     * @param name the players name
     */
    public Player(String name) {
        this.name = name;
        cars = new ArrayList<>();
    }

    /**
     * used to get player name for end of race and game
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     *  used at start of game to set starting money
     * @param amount new value for money
     */
    public void setMoney(int amount) {
        money = amount;
    }
    /**
     * used to change current money amount
     * @param amount amount to increase or decrease the players current money
     */
    public static void changeMoney(int amount) {
        money += amount;
    }
    /**
     * used to show the players total money for store and gas station
     * @return money
     */
    public static int getMoney() {
        return money;
    }
    /**
     * used to show the cars the player owns
     * @return cars
     */
    public static List<Car> getCars() {
        return cars;
    }
    /**
     * used to give a car to the player when buying a car
     * @param car the car the player has bought
     */
    public static void addCar(Car car) {
        cars.add(car);
    }
}
