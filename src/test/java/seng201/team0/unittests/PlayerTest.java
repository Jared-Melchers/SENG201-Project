package seng201.team0.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Car;
import seng201.team0.models.Player;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class PlayerTest {
    private Player testPlayer;
    @BeforeEach
    public void setUp() {testPlayer = new Player("TestPlayer");}

    @Test
    public void moneyTest() {
        testPlayer.setMoney(10);
        testPlayer.changeMoney(10);
        assertEquals(20, testPlayer.getMoney());
    }

    @Test
    public void carTest() {
        Car testCar = new Car("TestCar",1,2,3,4,5);
        testPlayer.addCar(testCar);
        ArrayList<Car> expectedCars = new ArrayList<>(List.of(testCar));
        assertIterableEquals(expectedCars, testPlayer.getCars());
    }
}
