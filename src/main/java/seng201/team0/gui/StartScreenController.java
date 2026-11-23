package seng201.team0.gui;

import javafx.fxml.FXML;
import seng201.team0.CharacterManager;

/**
 * controller for the start screen gui
 */
public class StartScreenController extends ScreenController {
    /**
     * constructor for the start screen controller
     * @param characterManager manager class that holds values that can be accessed
     */
    public StartScreenController(CharacterManager characterManager) {super(characterManager);}

    /**
     * sets the title of the screen
     * @return "Start Screen"
     */
    @Override
    protected String getTitle() {return "Start Screen";}

    /**
     * gets the gui for the start screen
     * @return "/fxml/start_screen.fxml"
     */
    @Override
    protected String getFxmlFile() {return "/fxml/start_screen.fxml";}

    /**
     * when the start button is pressed sends the player to the setup screen
     */
    @FXML
    private void onStartPressed() {
        getCharacterManager().onStartDone();
    }
}
