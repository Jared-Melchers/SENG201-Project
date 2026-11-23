package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng201.team0.CharacterManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

/**
 * controller for the gui elements that allows the player to select their next race when they are ready
 */
public class MapSelectScreenController extends ScreenController {
    /**
     * constructor for the map select screen
     * @param characterManager manager class that holds values that can be accessed
     */
    public MapSelectScreenController(CharacterManager characterManager) {
        super(characterManager);
    }
    int selectedMap;

    /**
     * sets the title of the screen
     * @return "Map Select Screen"
     */
    @Override
    protected String getTitle() {
        return "Map Select Screen";
    }

    /**
     * gets the gui for the map select screen
     * @return "/fxml/map_selector.fxml"
     */
    @Override
    protected String getFxmlFile() {
        return "/fxml/map_selector.fxml";
    }

    @FXML private Button rightButton;
    @FXML private Button leftButton;
    @FXML private Button middleButton;
    @FXML private Label noMapSelected;
    @FXML private ImageView leftMap;
    @FXML private ImageView rightMap;
    @FXML private ImageView middleMap;

    /**
     * sets the value of the selected map to -1 every time the mapSelector is opened and loads the images of the maps
     */
    @FXML
    public void initialize() {
        ArrayList<String> mapImages = getCharacterManager().getMapImages();
        Image image1 = new Image(mapImages.get(0));
        leftMap.setImage(image1);
        Image image2 = new Image(mapImages.get(1));
        middleMap.setImage(image2);
        Image image3 = new Image(mapImages.get(2));
        rightMap.setImage(image3);
        selectedMap = -1;
    }

    /**
     * /when the right map is selected
     */
    @FXML
    private void onRightPressed(){
        rightButton.setOpacity(.5);
        leftButton.setOpacity(1);
        middleButton.setOpacity(1);
        selectedMap = 2;
    }

    /**
     * /when the left map is selected
     */
    @FXML
    private void onLeftPressed(){
        rightButton.setOpacity(1);
        leftButton.setOpacity(.5);
        middleButton.setOpacity(1);
        selectedMap = 0;
    }

    /**
     * when the middle map is selected
     */
    @FXML
    private void onMiddlePressed(){
        rightButton.setOpacity(1);
        leftButton.setOpacity(1);
        middleButton.setOpacity(.5);
        selectedMap = 1;
    }

    /**
     * /takes the player back to the main screen
     */
    @FXML
    private void onBackPressed(){
        getCharacterManager().backToMenu();
    }

    /**
     * sends the value of selected map to CharacterManager to then open the map screen with the selected map,
     * if there is no selected map a notification with alert the player and nothing else will happen
     */
    @FXML
    private void onConfirmPressed(){
        if (selectedMap == -1){
            noMapSelected.setVisible(true);
        }else{
            getCharacterManager().goToRace(selectedMap);

        }
    }

}

