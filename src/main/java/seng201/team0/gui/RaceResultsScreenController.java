package seng201.team0.gui;

import javafx.fxml.FXML;
import seng201.team0.CharacterManager;
import javafx.scene.control.Label;
import seng201.team0.models.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * controller for the gui element that shows the results from their last race and continues or finishes the game
 */
public class RaceResultsScreenController extends ScreenController {
    /**
     * constructor for the race results screen
     * @param characterManager manager class that holds values that can be accessed
     */
    public RaceResultsScreenController(CharacterManager characterManager) {
        super(characterManager);
    }

    /**
     * sets the title of the screen
     * @return "race results Screen"
     */
    @Override
    protected String getTitle() {
        return "race results Screen";
    }

    /**
     * gets the gui for the race results screen
     * @return "/fxml/race_results.fxml"
     */
    @Override
    protected String getFxmlFile() {
        return "/fxml/race_results.fxml";
    }
    @FXML private Label firstPlaceName;
    @FXML private Label firstPlaceTime;
    @FXML private Label secondPlaceName;
    @FXML private Label secondPlaceTime;
    @FXML private Label thirdPlaceName;
    @FXML private Label thirdPlaceTime;
    @FXML private Label moneyEarned;


    /**
     * randomises the opponents times and then places the top three times in their podiums, if the player
     * achieved a podium position awards them the associated amount of prize money
     */
    @FXML
    public void initialize() {
        List<Label> nameLabels = List.of(firstPlaceName, secondPlaceName, thirdPlaceName);
        List<Label> timeLabels = List.of(firstPlaceTime, secondPlaceTime, thirdPlaceTime);
        List<Integer> mapTimes = getCharacterManager().getMapTimes();
        int playerTime = getCharacterManager().getPlayerTime();
        String playerName = getCharacterManager().getPlayer().getName();
        List<String> competitorNames = new ArrayList<>();
        competitorNames.add("Jeremy");
        competitorNames.add("Richard");
        competitorNames.add("James");
        int timeIndex = 0;
        int labelIndex = 0;
        Random rng = new Random();

        while (labelIndex <= 2 && playerTime > mapTimes.get(timeIndex)) {
            int winnerIndex = rng.nextInt(competitorNames.size());
            nameLabels.get(labelIndex).setText(competitorNames.remove(winnerIndex));
            int time = mapTimes.get(timeIndex);
            timeLabels.get(labelIndex).setText(String.format("%dh %dm", time/60, time%60));
            labelIndex++;
            timeIndex++;
        }
        if (labelIndex <= 2) {
            nameLabels.get(labelIndex).setText(playerName);
            int time = playerTime;
            int winnings = (int) (getCharacterManager().getPrize() * (1. - .25 * labelIndex));
            Player.changeMoney((int) (winnings));
            moneyEarned.setText(String.format("%d", winnings));
            getCharacterManager().setScore(getCharacterManager().getScore() + winnings);
            timeLabels.get(labelIndex).setText(String.format("%dh %dm", time/60, time%60));
            labelIndex++;
        } else {
            int time = playerTime;
            moneyEarned.setText(String.format("Your time of %dh %dm does not qualify you for a prize", time/60, time%60));
        }
        while (labelIndex <= 2) {
            int winnerIndex = rng.nextInt(competitorNames.size());
            nameLabels.get(labelIndex).setText(competitorNames.remove(winnerIndex));
            int time = mapTimes.get(timeIndex);
            timeLabels.get(labelIndex).setText(String.format("%dh %dm", time/60, time%60));
            labelIndex++;
            timeIndex++;
        }
    }

    /**
     * if it is not the final season of the game returns the player to the main screen, otherwise opens the final screen
     */
    @FXML
    private void onNextPressed(){
        if (getCharacterManager().getDayCount()>1){
            getCharacterManager().nextSeason();
            getCharacterManager().backToMenu();
        }else{getCharacterManager().goToFinalScreen();}

    }

}