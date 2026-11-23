package seng201.team0.services;

import javafx.util.Pair;
import seng201.team0.models.Car;
import seng201.team0.models.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A route is a closs containing all information about route that a car is tacking or could take.
 * @author jared
 */
public class Route {
    private float length;
    private List<String> hazards = new ArrayList<>();
    private Node destination;

    /**
     * Constructor for the route
     * @param length The length of the route in km
     * @param hazards A list of hazards that this route contains
     * @param destination The node that this route exits onto
     */
    public Route(float length, List<String> hazards, Node destination) {
        this.length = length;
        this.hazards = hazards;
        this.destination = destination;

    }

    /**
     *  returns a String containing the hazards on the route
     * @return description
     */
    public String getDescription() {
        String description = String.format("%.2f", length);
        for (String hazard : hazards) {
            description += "\n" + hazard;
        }
        return description;
    }

    /**
     *  returns the destination node
     * @return destination
     */
    public Node getDestination() {
        return destination;
    }

    /**
     * return the time it takes to cross the route and if the car ran out of fuel or broke down
     * @param car the car the player is racing with
     * @return Pair Integer, String time carBroke
     */
    public Pair<Integer, String> getTime(Car car) {
        // Store the performance variables of the car for later use and modification
        float speed = car.getTopSpeed();
        float handling = car.getHandling();
        float acceleration = car.getAcceleration();

        // For every hazard on this rout apply effects on the cars performance
        // When adding hazards to routes, ad them in the order they appear in the switch function
        for (String hazard : hazards) {
            switch (hazard) {
                case "Gravel": // should not be used with Ice or Mud
                    handling *= 0.75F;
                    car.changeHealth((int) (-(length * 0.2) * (1 - car.getReliability())));
                    break;
                case "Ice": // Should not ber used with Gravel or Mud
                    handling *= 0.1F;
                    break;
                case "Mud": // Should not be used with Gravel or Ice
                    speed *= 0.25F;
                    car.changeHealth((int) (-(length *0.075) * (1 - car.getReliability())));
                    break;
                case "Windy":
                    speed *= (100 - (100 - handling) * ((100 - acceleration) / 100)) / 100;
                    break;
                case "Steep":
                    speed *= 0.8F;
                    break;
            }
        }
        String carBroke = "fine";
        int time = 0;
        Random rng = new Random();

        car.changeFuel((int) (- length / 4));
        if (car.getFuel() < 0) {
            time += ((-car.getFuel() * 4) / (5. / 60));
            car.changeFuel(-car.getFuel());
            carBroke = "your car ran out of fuel and you had to push it the rest of the way";
        }
        car.changeHealth((int) (-(length / 20) * (1 - car.getReliability())));
        if (car.getCurrentHealth()< 0){
            car.changeHealth(-car.getCurrentHealth());
        }
        if (car.getCurrentHealth() < rng.nextInt(80)) {
            time += 240;
            carBroke = "your car broke down and you had to stop for repairs";
        }

        time += length / (speed / 60); //Speed is divided by 60 to get k's per minute


        return new Pair<Integer, String>(time,carBroke);
    }
}
