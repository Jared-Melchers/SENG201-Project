package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.CharacterManager;
import seng201.team0.models.Player;

/**
 * controller for the final screen gui, allows the player to quit the game
 */
public class FinalScreenController extends ScreenController {
    @FXML
    private Label score;
    @FXML
    private Button playAgain;
    @FXML
    private Button quit;

    /**
     * constructor for the final screen controller
     * @param characterManager manager class that holds values that can be accessed
     */
    public FinalScreenController(CharacterManager characterManager) {super(characterManager);}

    /**
     * sets the title of the screen
     * @return "Final screen"
     */
    @Override
    protected String getTitle() {return "Final Screen";}

    /**
     * gets the gui of the final screen
     * @return "/fxml/final_screen.fxml"
     */
    @Override
    protected String getFxmlFile() {return "/fxml/final_screen.fxml";}

    /**
     * sets the value of the score when the screen launches
     */
    public void initialize() {
        score.setText(String.format("%d", Player.getMoney()));
    }

    /**
     * ends the program when the quit button in pressed
     */
    @FXML
    private void onQuit() {
        System.exit(0);
    }
}