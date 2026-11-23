package seng201.team0.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Pair;
import seng201.team0.CharacterManager;
import seng201.team0.models.Car;
import seng201.team0.models.Map;
import seng201.team0.models.Player;
import seng201.team0.services.Mapmaker;
import seng201.team0.models.Node;
import seng201.team0.services.Route;
import seng201.team0.services.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * controller for the gui element that shows the race and the location of the player on the road,
 * also allows the player to select the next route as well as repair and refuel
 */
public class MapController extends ScreenController {
    private Node currentNode;
    private Route currentRoute;
    private Car car;
    private int time = 0;
    private int carIndex;
    @FXML
    private Label timeLabel;
    @FXML
    private Button option1Button;
    @FXML
    private Label option1Description;
    @FXML
    private Button option2Button;
    @FXML
    private Label option2Description;
    @FXML
    private Button option3Button;
    @FXML
    private Label option3Description;
    @FXML
    private Circle playerIndicator;
    @FXML private Button carConfirm;
    @FXML private ListView carOptions;
    @FXML private Label noCarSelected;
    @FXML private Button refuelButton;
    @FXML private Button repairButton;
    @FXML private Label buttonTitle;
    @FXML private Label money;
    @FXML private Label fuelTotal;
    @FXML private Label healthTotal;
    @FXML private ImageView mapImage;
    @FXML private Label carBroke;

    /**
     * constructor for the race screen controller
     * @param characterManager manager class that holds values that can be accessed
     */
    public MapController(CharacterManager characterManager) {
        super(characterManager);
    }
    private ObservableList<String> carOptionsList = FXCollections.observableArrayList();

    /**
     * when the screen opens it sets the image of the map, the prize for the race, the maps name, the starting node and the mapTimes.
     * sets all the navigation buttons and refuel and repair button to invisible and shows the car selection elements.
     */
    public void initialize() {
        // Initialise here
        // Load Map
        Image image = new Image(getCharacterManager().selectedImage);
        mapImage.setImage(image);
        String mapName = getCharacterManager().getMapSelected();
        Map map = new Mapmaker().getMap(mapName);
        getCharacterManager().setPrize(map.getPrize());
        currentNode = map.getNodes().getFirst();
        List<Integer>  mapTimes = map.getOpponentTimes();
        getCharacterManager().setMapTimes(mapTimes);

        // Set the player indicator to the location of the start node
        playerIndicator.setTranslateX(currentNode.getXPos()-5);
        playerIndicator.setTranslateY(currentNode.getYPos()-5);

        // Show car selection
        List<Car> playerCars = Player.getCars();
        for (Car car : playerCars) {
            carOptionsList.add(car.statString());
        }
        time = 0;
        carOptions.setItems(carOptionsList);
        option1Button.setVisible(false);
        option2Button.setVisible(false);
        option3Button.setVisible(false);
        refuelButton.setVisible(false);
        repairButton.setVisible(false);
        carOptions.setVisible(true);
        carConfirm.setVisible(true);
        buttonTitle.setText("Select Car");
        money.setText(String.valueOf(Player.getMoney()));
    }

    /**
     * When a route is selected move the car from the node to the route
     * @param selection an integer representing the route the player has selected
     */
    public void chooseRoute (int selection) {
        List<Route> exits = currentNode.getNodeExits();

        try {
            currentRoute = exits.get(selection);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid route selection: Index out of bounds");
        }
        Pair<Integer,String> routeValues = currentRoute.getTime(car);
        //time += currentRoute.getTime(car);
        time += routeValues.getKey();
        timeLabel.setText(String.format("Time: %dh %dm", time/60, time%60));
        if (Objects.equals(routeValues.getValue(), "your car ran out of fuel and you had to push it the rest of the way")){
            carBroke.setVisible(true);
            carBroke.setText("your car ran out of fuel and you had to push it the rest of the way");
        } else if (Objects.equals(routeValues.getValue(), "your car broke down and you had to stop for repairs")) {
            carBroke.setVisible(true);
            carBroke.setText("your car broke down and you had to stop for repairs");
        }else{
            carBroke.setVisible(false);
        }

        currentNode = currentRoute.getDestination();
        atNode();
    }

    /**
     * disables the navigation buttons that cant be used at the current node and if the node has no continuing routs sends the player to the results screen
     * also updates the shown values for fuel and health after going down a route
     */
    public void atNode() {
        // Set the player indicator to the location of the current node
        playerIndicator.setTranslateX(currentNode.getXPos()-5);
        playerIndicator.setTranslateY(currentNode.getYPos()-5);

        List <Route> nodeExits = currentNode.getNodeExits();
        int exits = nodeExits.size();
        switch (exits) {
            case 0:
                option1Button.setDisable(true);
                option2Button.setDisable(true);
                option3Button.setDisable(true);
                getCharacterManager().setPlayerTime(time);
                getCharacterManager().goToResults();
                break;
            case 1:
                option1Button.setDisable(false);
                option1Description.setText(nodeExits.get(0).getDescription());
                option2Button.setDisable(true);
                option2Description.setText("Not Available");
                option3Button.setDisable(true);
                option3Description.setText("Not Available");
                break;
            case 2:
                option1Button.setDisable(false);
                option1Description.setText(nodeExits.get(0).getDescription());
                option2Button.setDisable(false);
                option2Description.setText(nodeExits.get(1).getDescription());
                option3Button.setDisable(true);
                option3Description.setText("Not Available");
                break;
            case 3:
                option1Button.setDisable(false);
                option1Description.setText(nodeExits.get(0).getDescription());
                option2Button.setDisable(false);
                option2Description.setText(nodeExits.get(1).getDescription());
                option3Button.setDisable(false);
                option3Description.setText(nodeExits.get(2).getDescription());
                break;
        }
        fuelTotal.setText(String.format("%d", car.getFuel()));
        healthTotal.setText(String.format("%d", car.getCurrentHealth()));
    }

    /**
     * gets the gui for the race screen
     * @return "/fxml/map.fxml"
     */
    @Override
    protected String getFxmlFile() {
        return "/fxml/map.fxml";
    }

    /**
     * sets the title fo the screen
     * @return "MapScreen"
     */
    @Override
    protected String getTitle() {
        return "MapScreen";
    }

    /**
     * when the first option is clicked the related route is taken
     */
    @FXML
    private void option1Clicked() {
        chooseRoute(0);
    }

    /**
     * when the second option is clicked the related route is taken
     */
    @FXML
    private void option2Clicked() {
        chooseRoute(1);
    }

    /**
     * when the third option is clicked the related route is taken
     */
    @FXML
    private void option3Clicked() {
        chooseRoute(2);
    }

    /**
     * when the refuel button is clicked the car is refueled by 25 and the player is charged the cost.
     * if the player doesn't have enough money the label showing their money will turn red
     */
    @FXML
    private void refuelClicked() {
        int fuel = car.getFuel();
        if (fuel <= 75){
            int cost = 125;
            if (cost <= Player.getMoney()){
                Player.changeMoney(-cost);
                car.changeFuel(25);
                money.setText(String.valueOf(Player.getMoney()));
                fuelTotal.setText(String.valueOf(car.getFuel()));
                money.setTextFill(Color.BLACK);
            }else{
                money.setTextFill(Color.RED);
            }
        }
    }

    /**
     * when the repair button is clicked the car is repaired by 25 and the player is charged the cost.
     * if the player doesn't have enough money the label showing their money will turn red
     */
    @FXML
    private void repairClicked() {
        int cost = (int) Math.round((Math.pow(car.getCurrentHealth(),1.75))/100)*100;
        if (cost <= Player.getMoney()){
            Store.repairCar(carIndex);
            money.setText(String.valueOf(Player.getMoney()));
            healthTotal.setText(String.valueOf(car.getCurrentHealth()));
            money.setTextFill(Color.BLACK);
        }else{
            money.setTextFill(Color.RED);
        }
    }

    /**
     * when the confirm button is pressed takes the index of the selected car to get the car from the players owned cars
     * if no car is selected it alerts the player
     * after it makes all car selection elements invisible and all navigation buttons visible
     * and applies the current fuel and health of the selected car their labels
     */
    @FXML
    private void carSelected (){
        int index = carOptions.getSelectionModel().getSelectedIndex();
        if (index == -1){
            noCarSelected.setVisible(true);
        }else{
            carIndex = index;
            car = Player.getCars().get(index);
            noCarSelected.setVisible(false);
            carOptions.setVisible(false);
            carConfirm.setVisible(false);
            option1Button.setVisible(true);
            option2Button.setVisible(true);
            option3Button.setVisible(true);
            refuelButton.setVisible(true);
            repairButton.setVisible(true);
            buttonTitle.setText("Navigation options:");
            fuelTotal.setText(String.valueOf(car.getFuel()));
            healthTotal.setText(String.valueOf(car.getCurrentHealth()));
            atNode();
        }

    }
}
