package seng201.team0;

import seng201.team0.gui.ScreenNavagator;
import seng201.team0.models.Car;
import seng201.team0.services.Mapmaker;
import seng201.team0.models.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * main class that manages the order of the gui screens and variables that need to be transferred between them
 */
public class CharacterManager {
    public static Player player;
    private int dayCount;
    public static List<Car> availableCars;
    private final ScreenNavagator navigator;
    private String mapSelected;
    public String selectedImage;
    private List<String> mapList = Mapmaker.getMaps();
    private ArrayList<String> mapImages = Mapmaker.getMapImages();
    private List<Integer> mapTimes;
    private int prize;
    private int score;
    private int playerTime;
    private int carIndex;

    /**
     * constructor of the CharacterManager, takes the player to the start screen
     * @param navigator navigate used to go between gui screens
     */
    public CharacterManager(ScreenNavagator navigator) {
        this.navigator = navigator;
        navigator.launchStartScreen(this);
    }

    /**
     * takes the player to the setup screen
     */
    public void onStartDone(){
        navigator.launchSetupScreen(this);
    }

    /**
     * takes the setup information and takes the player to the store screen
     * @param playerName players name
     * @param dayCount season length the player has chosen
     * @param startMoney amount of money the player starts with
     */
    public void onSetupDone(String playerName, int dayCount,int startMoney){
        player = new Player(playerName);
        player.setMoney(startMoney);
        this.dayCount = dayCount;
        ArrayList<Car> cars = new ArrayList<>();
        Car car1 = new Car("Toyota corolla",130,80,.9,70,5000);
        Car car2 = new Car("Yugo",80,30,0.3,10,1000);
        cars.add(car2);
        Car car3 = new Car("Reliant Robin",90,10,.8,30,2000);
        cars.add(car3);
        Car car4 = new Car("Citroen 2CV",80,80,.5,40,3000);
        cars.add(car4);
        Car car6 = new Car("Buggy",120,80,.2,60,3500);
        cars.add(car6);
        Car car5 = new Car("Trabant 601",90,50,.7,60,4000);
        cars.add(car5);
        cars.add(car1);
        availableCars = cars;
        navigator.launchStoreScreen(this);
    }

    /**
     * takes the player to the store screen
     */
    public void goToStore(){
        navigator.launchStoreScreen(this);
    }

    /**
     * takes the player to the map selector screen
     */
    public void goToRaceSelector(){
        navigator.launchMapSelectScreen(this);
    }

    /**
     * takes the player to the race screen with the map they have chosen
     * @param selectedRace race the player has chosen to do
     */
    public void goToRace(int selectedRace){
        mapSelected = mapList.get(selectedRace);
        selectedImage = mapImages.get(selectedRace);
        mapList.remove(selectedRace);
        mapImages.remove(selectedRace);
        navigator.launchMapScreen(this);
    }

    /**
     * takes the player to the upgrade screen with the car they want to upgrade
     * @param index index of the car they want to upgrade in their owned cars
     */
    public void goToUpgrades(int index){
        carIndex = index;
        navigator.launchUpgradeScreen(this);}

    /**
     * takes the player back to the main screen
     */
    public void backToMenu(){navigator.launchMainScreen(this);}

    /**
     * takes the player to the final screen
     */
    public void goToFinalScreen(){navigator.launchFinalScreen(this);}

    /**
     * takes the player to the race results screen
     */
    public void goToResults(){navigator.launchRaceResultsScreen(this);}

    /**
     * gets the current player
     * @return player
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * gets the number of remaining races in the season
     * @return dayCount
     */
    public int getDayCount() {
        return dayCount;
    }

    /**
     * gets the index of the car the player has chosen to upgrade
     * @return carIndex
     */
    public int getCarIndex(){
        return carIndex;
    }

    /**
     * gets the list of the cars available to purchase in the shop
     * @return availableCars
     */
    public static List<Car> getAvailableCars() {
        return availableCars;
    }

    /**
     * reduces the indicator for the amount of races left by 1
     */
    public void nextSeason (){
        dayCount--;
    }

    /**
     * gets the map the player has selected
     * @return mapSelected
     */
    public String getMapSelected() { return mapSelected; }

    /**
     * sets the variable mapTimes
     * @param mapTimes list of integers containing the mapTimes
     */
    public void setMapTimes(List<Integer> mapTimes) { this.mapTimes = mapTimes; }

    /**
     * gets the list of mapTimes
     * @return mapTimes
     */
    public List<Integer> getMapTimes() { return mapTimes; }

    /**
     * gets the list holding the URL of the map images
     * @return mapImages
     */
    public ArrayList<String> getMapImages() { return mapImages; }

    /**
     * sets the value of the Players time in the last race
     * @param playerTime int of the players final time in the race
     */
    public void setPlayerTime(int playerTime) { this.playerTime = playerTime; }

    /**
     * gets the value of the players time in the last race
     * @return playerTime
     */
    public int getPlayerTime() { return playerTime; }

    /**
     * sets the value of the prize for first place on the last race
     * @param prize int of the amount the prize is
     */
    public void setPrize(int prize) { this.prize = prize; }

    /**
     * gets the value of the prize for first place for the last race
     * @return prize
     */
    public int getPrize() { return prize; }

    /**
     * sets the scone that the player has gotten for the final screen
     * @param score int total score the player has gotten
     */
    public void setScore(int score) {this.score = score; }

    /**
     * gets the score the player has gotten to be used in the final screen
     * @return score
     */
    public int getScore() { return score; }
}

