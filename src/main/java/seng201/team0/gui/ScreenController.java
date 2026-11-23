package seng201.team0.gui;

import seng201.team0.CharacterManager;

/**
 * parent class for all controllers
 */
public abstract class ScreenController {

    private final CharacterManager characterManager;

    /**
     * constructor for the constructor
     * @param characterManager the manager controlling which screen should be launched
     */
    protected ScreenController(final CharacterManager characterManager) {
        this.characterManager = characterManager;
    }

    /**
     * allows child classes to get their gui implementation
     * @return URL of their gui
     */
    protected abstract String getFxmlFile();

    /**
     * allows child classes to set the title of their screens
     * @return string of the screen title
     */
    protected abstract String getTitle();

    /**
     * allows child classes to get values from CharacterManager
     * @return characterManager
     */
    protected CharacterManager getCharacterManager(){
        return characterManager;
    }
}
