package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.CharacterManager;
import seng201.team0.models.Car;
import seng201.team0.models.Player;

import java.util.ArrayList;

/**
 *controller for the upgrade screen gui
 * @author Jayden
 */
public class UpgradeScreenController extends ScreenController {
    /**
     * constructor for the upgrade screen
     * @param characterManager manager class that holds values that can be accessed
     */
    public UpgradeScreenController(CharacterManager characterManager) {
        super(characterManager);
    }
    private Car car = Player.getCars().get(getCharacterManager().getCarIndex());
    private ArrayList<Integer> owned = car.getUpgrades();
    private int playerMoney = Player.getMoney();

    /**
     * sets the title fo the screen
     * @return "Upgrade Screen"
     */
    @Override
    protected String getTitle() {
        return "Upgrade Screen";
    }

    /**
     * gets the gui of the upgrade screen
     * @return "/fxml/upgrades.fxml"
     */
    @Override
    protected String getFxmlFile() {
        return "/fxml/upgrades.fxml";
    }
    @FXML private Label money;
    @FXML private Label notEnoughMoney;
    @FXML private Button upgradeOne;
    @FXML private Button upgradeTwo;
    @FXML private Button upgradeThree;
    @FXML private Button upgradeFour;

    /**
     * disables the buttons for the upgrades that have previously been bought when the screen opens
     */
    @FXML
    public void initialize() {
        money.setText(String.valueOf(playerMoney));
        if (owned.get(0) == 1){
            upgradeOne.setDisable(true);
        }
        if (owned.get(1) == 1){
            upgradeTwo.setDisable(true);
        }
        if (owned.get(2) == 1){
            upgradeThree.setDisable(true);
        }
        if (owned.get(3) == 1){
            upgradeFour.setDisable(true);
        }
    }

    /**
     * buys the spoiler upgrade if the player has enough money notifies the player otherwise
     */
    @FXML
    private void buyOne(){
        if (playerMoney-500>= 0){
            car.spoiler();
            Player.changeMoney(-500);
            playerMoney -= 500;
            money.setText(String.valueOf(playerMoney));
            notEnoughMoney.setVisible(false);
            upgradeOne.setDisable(true);
        }else{
            notEnoughMoney.setVisible(true);
        }
    }

    /**
     * buys the engine upgrade if the player has enough money notifies the player otherwise
     */
    @FXML
    private void buyTwo(){
        if (playerMoney-500>= 0){
            car.engine();
            Player.changeMoney(-500);
            playerMoney -= 500;
            money.setText(String.valueOf(playerMoney));
            notEnoughMoney.setVisible(false);
            upgradeTwo.setDisable(true);
        }else{
            notEnoughMoney.setVisible(true);
        }
    }

    /**
     * buys the tire upgrade if the player has enough money notifies the player otherwise
     */
    @FXML
    private void buyThree(){
        if (playerMoney-1000>= 0){
            car.tires();
            Player.changeMoney(-1000);
            playerMoney -= 1000;
            money.setText(String.valueOf(playerMoney));
            notEnoughMoney.setVisible(false);
            upgradeThree.setDisable(true);
        }else{
            notEnoughMoney.setVisible(true);
        }
    }

    /**
     * buys the transmission upgrade if the player has enough money notifies the player otherwise
     */
    @FXML
    private void buyFour(){
        if (playerMoney-1000>= 0){
            car.transmission();
            Player.changeMoney(-1000);
            playerMoney -= 1000;
            money.setText(String.valueOf(playerMoney));
            notEnoughMoney.setVisible(false);
            upgradeFour.setDisable(true);
        }else{
            notEnoughMoney.setVisible(true);
        }
    }

    /**
     * returns the player to the store
     */
    @FXML
    private void toStore(){
        getCharacterManager().goToStore();
    }
}