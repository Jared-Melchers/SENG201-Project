package seng201.team0.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Car;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private Car testCar;
    @BeforeEach
    public void setUp() {
        testCar = new Car("test1",2,3,4,5,6);
    }
    @Test
    public void testConstructor() {
        assertAll("car stats",
                () -> assertEquals(2,testCar.getTopSpeed()),
                () -> assertEquals(3,testCar.getHandling()),
                () -> assertEquals(4,testCar.getReliability()),
                () -> assertEquals(5,testCar.getAcceleration()),
                () -> assertEquals(6,testCar.getCost())
        );
    }
    @Test
    public void testHealth(){
        testCar.changeHealth(-60);
        testCar.changeHealth(10);
        assertEquals(50,testCar.getCurrentHealth());
        testCar.changeHealth(1000);
        assertEquals(100,testCar.getCurrentHealth());
    }
    @Test
    public void testFuel(){
        testCar.changeFuel(-60);
        testCar.changeFuel(10);
        assertEquals(50,testCar.getFuel());
        testCar.changeFuel(1000);
        assertEquals(100,testCar.getFuel());
    }
    @Test
    public void testUpgrades(){
        ArrayList<Integer> expectedUpgrades = new ArrayList<>(asList(0,0,0,0));
        assertIterableEquals(expectedUpgrades,testCar.getUpgrades(),"test1 fail");
        testCar.spoiler();
        testCar.engine();
        testCar.tires();
        testCar.transmission();
        expectedUpgrades = new ArrayList<>(asList(1,1,1,1));
        assertIterableEquals(expectedUpgrades,testCar.getUpgrades(),"test2 fail");
    }
}
