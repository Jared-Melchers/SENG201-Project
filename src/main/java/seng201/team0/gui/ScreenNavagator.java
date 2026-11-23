package seng201.team0.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import seng201.team0.CharacterManager;


import java.io.IOException;

/**
 * class used by CharacterManager to launch each gui element when they are called
 */
public class ScreenNavagator {
    private final Stage stage;
    private final BorderPane rootPane;

    /**
     * constructor for the screen navigator, sets the parameters for the scale of gui screens and starts the stage
     * @param stage primaryStage
     */
    public ScreenNavagator(Stage stage) {
        this.stage = stage;
        rootPane = new BorderPane();
        rootPane.setPrefHeight(400);
        rootPane.setPrefWidth(600);
        stage.setScene(new Scene(rootPane));
        stage.show();
    }

    /**
     * sets the controller to the start screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchStartScreen(CharacterManager characterManager){
        ScreenController controller = new StartScreenController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the setup screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchSetupScreen(CharacterManager characterManager){
        ScreenController controller = new SetupScreenController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the main screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchMainScreen(CharacterManager characterManager){
        ScreenController controller = new MainScreenController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the store screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchStoreScreen(CharacterManager characterManager){
        ScreenController controller = new StoreScreenController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the map selector screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchMapSelectScreen(CharacterManager characterManager){
        ScreenController controller = new MapSelectScreenController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the race screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchMapScreen(CharacterManager characterManager) {
        ScreenController controller = new MapController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the race result screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchRaceResultsScreen(CharacterManager characterManager) {
        ScreenController controller = new RaceResultsScreenController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the final screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchFinalScreen(CharacterManager characterManager) {
        ScreenController controller = new FinalScreenController(characterManager);
        launchScreen(controller);
    }
    /**
     * sets the controller to the upgrade screens controller
     * @param characterManager the manager controlling which screen should be launched
     */
    public void launchUpgradeScreen(CharacterManager characterManager) {
        ScreenController controller = new UpgradeScreenController(characterManager);
        launchScreen(controller);
    }

    /**
     * launches the screen related to the current controller
     * @param controller controller for the gui element to be launched
     */
    private void launchScreen(ScreenController controller) {
        try{
            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource(controller.getFxmlFile()));
            setupLoader.setControllerFactory(param -> controller);
            Parent setupParent = setupLoader.load();
            rootPane.setCenter(setupParent);
            stage.setTitle(controller.getTitle());
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
