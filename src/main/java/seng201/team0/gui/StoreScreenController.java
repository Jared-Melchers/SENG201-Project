package seng201.team0.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import seng201.team0.CharacterManager;
import seng201.team0.models.Car;
import seng201.team0.models.Player;
import seng201.team0.services.Store;

import java.util.ArrayList;

/**
 * controller for the store gui, shows the purchasable cars and owned cars, allows the player to repair cars,
 * as well as a way to get to the upgrade screen
 * @author Jayden
 */
public class StoreScreenController extends ScreenController {
    /**
     * constructor for the store screen
     * @param characterManager manager class that holds values that can be accessed
     */
    public StoreScreenController(CharacterManager characterManager) {super(characterManager);}
    ObservableList<String> buyList = FXCollections.observableArrayList(); //observable list of purchasable cars
    ObservableList<String> playerCars = FXCollections.observableArrayList(); //observable list of owned cars
    ArrayList<String> availableCars = new ArrayList<>(); //list of the purchasable cars in string form
    ArrayList<String> carStrings = new ArrayList<>(); //list of the owned cars in string form

    /**
     * sets the title of the screen
     * @return "Store Screen"
     */
    @Override
    protected String getTitle() {return "Store Screen";}

    /**
     * gets the gui for the store screen
     * @return  "/fxml/store_screen.fxml"
     */
    @Override
    protected String getFxmlFile() {return "/fxml/store_screen.fxml";}
    @FXML private Label noCarSelected;
    @FXML private Label noCarSelected1;
    @FXML private ListView ownedCars;
    @FXML private ListView buyableCars;
    @FXML private Label moneyAmount;
    @FXML private Label resultDisplay;
    @FXML private Label repairLabel;
    @FXML private Label noOwnedCars;
    Store store = new Store();
    /**
     * loads the listviews for the owned and purchasable cars with each list of strings
     */
    @FXML
    public void initialize() {
        for (Car car:CharacterManager.getAvailableCars()) {
            availableCars.add(car.toString());
        }
        for (Car car:Player.getCars()) {
            carStrings.add(car.shortString());
        }
        buyList.addAll(availableCars);
        playerCars.addAll(carStrings);
        moneyAmount.setText(String.valueOf(Player.getMoney()));
        buyableCars.setItems(buyList);
        ownedCars.setItems(playerCars);
    }

    /**
     * transfers the selected car from the purchasable cars to owned cars, displaying a notification for if
     * no car is selected or the player doesn't have enough money
     */
    @FXML
    private void onBuyPressed() {
        int index = buyableCars.getSelectionModel().getSelectedIndex();
        if (index > -1){
            String result = Store.buyCar(index);
            if (result.equals("Your car has been purchased")) {
                playerCars.add(Player.getCars().getLast().shortString());
                buyList.remove(index);
                buyableCars.setItems(buyList);
                ownedCars.setItems(playerCars);
                moneyAmount.setText(String.valueOf(Player.getMoney()));
            }
            noCarSelected1.setVisible(false);
            resultDisplay.setText(result);
            resultDisplay.setVisible(true);
        }else{
            resultDisplay.setVisible(false);
            noCarSelected1.setVisible(true);
        }
    }

    /**
     * repairs the selected car by 25 health, a notification will alert the player if they didn't select a car
     * or don't have enough money
     */
    @FXML
    private void onRepairPressed() {
        int index = ownedCars.getSelectionModel().getSelectedIndex();
        if (index > -1){
            String repairResult = Store.repairCar(index);
            playerCars.set(index, Player.getCars().get(index).shortString());
            noCarSelected.setVisible(false);
            repairLabel.setText(repairResult);
            repairLabel.setVisible(true);
            moneyAmount.setText(String.valueOf(Player.getMoney()));
        }else{
            repairLabel.setVisible(false);
            noCarSelected.setVisible(true);}
    }

    /**
     * sends the player to the main screen if they have a car otherwise shows a notification that they have no cars
     */
    @FXML
    private void onBackPressed() {
        if (Player.getCars().isEmpty()){
            noOwnedCars.setVisible(true);
        }else{getCharacterManager().backToMenu();}
    }

    /**
     * sends the player to the upgrade screen
     */
    @FXML
    private void goToUpgrades(){
        int index = ownedCars.getSelectionModel().getSelectedIndex();
        if (index > -1){
            getCharacterManager().goToUpgrades(index);
        }else{
            noCarSelected.setVisible(true);
        }

    }
}