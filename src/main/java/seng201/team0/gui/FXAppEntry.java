package seng201.team0.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import seng201.team0.CharacterManager;

public class FXAppEntry extends Application {

    @Override
    public void start(Stage primaryStage) {
        new CharacterManager(new ScreenNavagator(primaryStage));
    }
}
