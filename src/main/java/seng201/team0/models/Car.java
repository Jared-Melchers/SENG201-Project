package seng201.team0.models;

import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * the Car is a class that holds all the information about the stats of each car and what upgrades they might have purchased.
 * @author Jayden
 */
public class Car {
    String name;
    int topSpeed;
    int handling;
    int fuel;
    double reliability;
    int currentHealth;
    int acceleration;
    int cost;
    ArrayList<Integer> upgrades;

    /**
     * constructor for Car
     * @param name the name of the car
     * @param topSpeed the maximum speed the car can reach
     * @param handling ability for cars to take turns out of 100
     * @param reliability modifier for how much health is taken away during race from 1-0
     * @param acceleration the acceleration of the car out of 100
     * @param cost the amount of money it takes to purchase the car from the store
     * other values like health, fuel and the list for owned upgrades are initialized to the same values for all cars
     */
    public Car(String name , int topSpeed, int handling, double reliability, int acceleration, int cost) {
        this.topSpeed = topSpeed;
        this.handling = handling;
        this.reliability = reliability;
        this.acceleration = acceleration;
        this.fuel = 100;
        this.currentHealth =100;
        this.cost = cost;
        this.name = name;
        this.upgrades = new ArrayList<>(asList(0,0,0,0));
    }

    /**
     * used to change health value during hazards
     * @param health amount the health will be changed by
     */
    public void changeHealth(int health) {
        currentHealth += health;
        if (currentHealth > 100) {
            currentHealth = 100;
        }
    }

    /**
     * shows the health of the car for repairing and selecting car
     * @return currentHealth
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * used to change fuel when refueling and traversing routes
     * @param fuel amount the fuel will be changed by
     */
    public void changeFuel(int fuel) {
        this.fuel += fuel;
        if (this.fuel > 100) {
            this.fuel = 100;
        }
    }

    /**
     * shows current fuel of the car for when buying gas
     * @return fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * used to get top speed of car when traversing routes
     * @return topSpeed
     */
    public int getTopSpeed() {
        return topSpeed;
    }

    /**
     * used to get handling when traversing routes
     * @return handling
     */
    public int getHandling() {
        return handling;
    }

    /**
     * used to get reliability when traversing routes
     * @return reliability
     */
    public double getReliability() {
        return reliability;
    }

    /**
     * used to get acceleration when traversing routes
     * @return acceleration
     */
    public int getAcceleration() {
        return acceleration;
    }

    /**
     * gets cost of car used in purchasing it from store
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * gets a list showing the upgrades currently on the car
     * @return upgrades
     */
    public ArrayList<Integer> getUpgrades() {
        return upgrades;
    }

    /**
     * method used for the purchasable cars in the store to show name, stats and cost
     * @return String containing the cars name, stats and cost
     */
    public String toString(){
        return name + "\nMaxSpeed:" + topSpeed + "  Handling:" + handling + "   Reliability:" + reliability + " Acceleration:" + acceleration + " \n$" + cost;
    }

    /**
     * method used for the owned cars in the store
     * @return String containing the cars name and cost of repairing
     */
    public String shortString(){
        return name + "\nHealth:" + currentHealth + " RepairCost:$"+ (int)Math.round((Math.pow(currentHealth,1.7))/100)*100+200;
    }

    /**
     * method used in the map for when the player has to choose a car to race with
     * @return String containing the cars name, stats, fuel and health
     */
    public String statString() {
        return name + "\nMaxSpeed:" + topSpeed + "  Handling:" + handling + "\nReliability:" + reliability + " Acceleration:" + acceleration + "\nheath:" + currentHealth + " Fuel:" + fuel;
    }

    /**
     * adds the spoiler upgrade to the car, increases the cars handling
     */
    public void spoiler (){
        handling += 10;
        upgrades.set(0, 1);
    }

    /**
     * adds the engine upgrade to the car, increases the cars topSpeed
     */
    public void engine (){
        topSpeed += 30;
        upgrades.set(1, 1);
    }

    /**
     * adds the tires upgrade to the car, increases the cars handling and topSpeed
     */
    public void tires (){
        handling += 10;
        topSpeed += 30;
        upgrades.set(2, 1);
    }

    /**
     * adds the transmission upgrade to the car, increases the cars acceleration
     */
    public void transmission (){
        acceleration += 20;
        upgrades.set(3, 1);
    }
}
