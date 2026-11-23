package seng201.team0.models;

import seng201.team0.services.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * Nodes are points connected by routs which make up a map.
 * This class implements nodes
 * @author jared
 */
public class Node {
    private float xPos;
    private float yPos;
    private List<Route> routes = new ArrayList<>();

    /**
     * Constructor for a node, takes the nodes position co-ordinates, and a list of routs out of the node.
     * @param xPos position of node on x-axis
     * @param yPos position of node on y-axis
     * @param nodeExits routs that lead off the node
     */
    public Node(float xPos, float yPos, List<Route> nodeExits) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.routes = nodeExits;
    }


    /**
     * Get X position
     * @return x-position
     */
    public float getXPos() {
        return xPos;
    }

    /**
     * Get Y position
     * @return y-position
     */
    public float getYPos() {
        return yPos;
    }

    /**
     * Get list of routs
     * @return routs
     */
    public List<Route> getNodeExits() {
        return routes;
    }
}
