package seng201.team0.gui;

import javafx.fxml.FXML;
import seng201.team0.CharacterManager;
import javafx.scene.control.Label;
import seng201.team0.models.Player;

/**
 * controller for the gui element that acts as the players main screen connecting the elements the player will use to
 * manage their cars and select the next race
 */
public class MainScreenController extends ScreenController {
    /**
     * constructor for the main screen controller
     * @param characterManager manager class that holds values that can be accessed
     */
    public MainScreenController(CharacterManager characterManager) {super(characterManager);}

    /**
     * sets the title of the screen
     * @return "Main Screen"
     */
    @Override
    protected String getTitle() {return "Main Screen";}

    /**
     * gets the gui for the main screen
     * @return "/fxml/main_screen.fxml"
     */
    @Override
    protected String getFxmlFile() {return "/fxml/main_screen.fxml";}
    @FXML
    private Label nameDisplay;
    @FXML
    private Label daysRemaining;
    @FXML
    private Label moneyDisplay;

    /**
     * displays the season count and player money and name to the player when the main screen is opened.
     */
    @FXML
    public void initialize() {
        nameDisplay.setText(CharacterManager.getPlayer().getName());
        daysRemaining.setText(String.valueOf(getCharacterManager().getDayCount()));
        moneyDisplay.setText(String.valueOf(Player.getMoney()));
    }

    /**
     * opens the store gui for the player
     */
    @FXML
    private void onStoreClicked() {
        getCharacterManager().goToStore();
    }

    /**
     * opens the race selection gui for the player
     */
    @FXML
    private void onRaceClicked() {
        getCharacterManager().goToRaceSelector();
    }
}