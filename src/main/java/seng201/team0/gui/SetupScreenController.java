package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.CharacterManager;
import javafx.scene.control.TextArea;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;

/**
 * controller for the gui element that the player uses to select their name, difficult and length of the game
 */
public class SetupScreenController extends ScreenController {
    /**
     * constructor for the setup screen
     * @param characterManager manager class that holds values that can be accessed
     */
    public SetupScreenController(CharacterManager characterManager) {super(characterManager);}

    /**
     * sets the title of the screen
     * @return "Setup Screen"
     */
    @Override
    protected String getTitle() {return "Setup Screen";}

    /**
     * gets the gui for the setup screen
     * @return "/fxml/name_selection.fxml"
     */
    @Override
    protected String getFxmlFile() {return "/fxml/name_selection.fxml";}

    @FXML
    private TextArea playerName;
    @FXML
    private Slider daySlider;
    @FXML
    private Label dayCount;
    @FXML
    private Label nameTooLong;
    @FXML
    private Button hardDifficulty;
    @FXML
    private Button normalDifficulty;
    @FXML
    private Label difficultyNotSelected;

    /**
     * initializes the slider that lets the player select the amount of seasons they want to race and the label displaying that amount
     */
    @FXML
    public void initialize() {
        daySlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            dayCount.setText(String.valueOf(newValue.intValue()));
        });
    }
    public int startMoney = 0;

    /**
     * sets the starting money to 3000 when hard difficulty is selected
     */
    @FXML
    private void setHardDifficulty(){
        hardDifficulty.setOpacity(.5);
        normalDifficulty.setOpacity(1);
        this.startMoney = 3000;
    }

    /**
     * sets the starting money to 5000 when normal difficulty is selected
     */
    @FXML
    private void setNormalDifficulty(){
        hardDifficulty.setOpacity(1);
        normalDifficulty.setOpacity(.5);
        this.startMoney = 5000;

    }

    /**
     * takes the name input and selected difficulty to the CharacterManager, if one is not input or selected notifies the player
     */
    @FXML
    private void onNameSelected(){
        if (startMoney > 0) {
            if (playerName.getText().length() >= 3 && playerName.getText().length() <= 15) {
                getCharacterManager().setScore(0);
                getCharacterManager().onSetupDone(playerName.getText(), Integer.parseInt(dayCount.getText()), startMoney);
            } else {
                difficultyNotSelected.setVisible(false);
                nameTooLong.setVisible(true);
            }
        }else {
            difficultyNotSelected.setVisible(true);
            nameTooLong.setVisible(false);

        }
    }
}

