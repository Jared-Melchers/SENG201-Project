package seng201.team0.models;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of nodes which makes up a map of a race
 * @author jared
 */
public class Map {
    List<Node> nodes = new ArrayList<>();
    List<Integer> opponentTimes = new ArrayList<Integer>(3);
    int prize;

    /**
     * Constructor for map object, takes a list of nodes.
     * @param mapNodes list of nodes that make up the map
     * @param parTimes times the opponents achieve on the map
     * @param prize the prize for first place on the map
     */
    public Map(List<Node> mapNodes, List<Integer> parTimes, int prize) {
        this.nodes = mapNodes;
        opponentTimes.addAll(parTimes);
        this.prize = prize;
        }

    /**
     * gets the list of map nodes
     * @return nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * gets the times that the opponents will get on the map
     * @return opponentTimes
     */
    public List<Integer> getOpponentTimes() {
        return opponentTimes;
    }

    /**
     * gets the first place prize money amount for the map
     * @return prize
     */
    public int getPrize() {
        return prize;
    }
}
