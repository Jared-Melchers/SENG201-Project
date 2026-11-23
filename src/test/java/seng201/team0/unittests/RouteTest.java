package seng201.team0.unittests;

import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Car;
import seng201.team0.services.Route;
import seng201.team0.models.Node;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteTest {
    private Route testRoute;
    private Car testCar;
    private Node testNode;

    @BeforeEach
    protected void setUp() {
        testCar = new Car("testCar",100,50,0.5,50,1);
        testNode = new Node(1,1,new ArrayList<>(List.of()));
    }

    @Test
    public void normalTest() {
        testRoute = new Route(100,new ArrayList<>(List.of()),testNode);
        Pair<Integer,String> routeValues= testRoute.getTime(testCar);
        assertEquals(60,routeValues.getKey());
        assertEquals("fine",routeValues.getValue());
    }
    @Test
    public void mudTest(){
        testRoute = new Route(100,new ArrayList<>(List.of("Mud")),testNode);
        Pair<Integer,String> routeValues= testRoute.getTime(testCar);
        assertEquals(240,routeValues.getKey());
        assertEquals("fine",routeValues.getValue());
        assertEquals(95,testCar.getCurrentHealth());
    }
    @Test
    public void gravelTest(){
        testRoute = new Route(100,new ArrayList<>(List.of("Gravel")),testNode);
        Pair<Integer,String> routeValues= testRoute.getTime(testCar);
        assertEquals(60,routeValues.getKey());
        assertEquals("fine",routeValues.getValue());
        assertEquals(88,testCar.getCurrentHealth());
    }
    @Test
    public void iceTest(){
        testRoute = new Route(100,new ArrayList<>(List.of("Ice","Windy")),testNode);
        Pair<Integer,String> routeValues= testRoute.getTime(testCar);
        assertEquals(114,routeValues.getKey());
        assertEquals("fine",routeValues.getValue());
    }
    @Test
    public void steepTest(){
        testRoute = new Route(100,new ArrayList<>(List.of("Steep")),testNode);
        Pair<Integer,String> routeValues= testRoute.getTime(testCar);
        assertEquals(75,routeValues.getKey());
        assertEquals("fine",routeValues.getValue());
    }
    @Test
    public void noFuelTest(){
        testCar.changeFuel(-100);
        testRoute = new Route(100,new ArrayList<>(List.of()),testNode);
        Pair<Integer,String> routeValues= testRoute.getTime(testCar);
        assertEquals("your car ran out of fuel and you had to push it the rest of the way",routeValues.getValue());
    }
    @Test
    public void noHealthTest(){
        testCar.changeHealth(-100);
        testRoute = new Route(100,new ArrayList<>(List.of()),testNode);
        Pair<Integer,String> routeValues= testRoute.getTime(testCar);
        assertEquals("your car broke down and you had to stop for repairs",routeValues.getValue());
    }


}
