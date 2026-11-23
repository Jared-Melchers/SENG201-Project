package seng201.team0.unittests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Car;
import seng201.team0.models.Player;
import seng201.team0.services.Store;

import javax.smartcardio.Card;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class StoreTest {
    private Store testStore;
    private Player testPlayer;
    private Car testCar;

    @BeforeEach
    public void setUp() {
        testCar = new Car("testCar",1,1,1,1,500);
        ArrayList<Car> testCarList = new ArrayList<>();
        testCarList.add(testCar);
        testCarList.add(testCar);
        testStore = new Store(testPlayer, testCarList);
    }
    @Test
    public void testBuyCar() {
        String buyOutput;
        testPlayer = new Player("TestPlayer2");
        testPlayer.setMoney(800);
        buyOutput = testStore.buyCar(0);
        assertEquals(300,testPlayer.getMoney(),"buy failed");
        assertEquals("Your car has been purchased",buyOutput);
        ArrayList<Car> testCarList = new ArrayList<>();
        testCarList.add(testCar);
        assertIterableEquals(testCarList,testPlayer.getCars(),"not in players cars");
        buyOutput = testStore.buyCar(0);
        assertEquals("You don't have enough money",buyOutput,"Not enough money output failed");

    }
    @Test
    public void testRepairCar() {
        String repairOutput;
        testPlayer = new Player("TestPlayer3");
        testPlayer.setMoney(200);
        testCar.changeHealth(-100);
        testPlayer.addCar(testCar);
        testStore.repairCar(0);
        assertEquals(0,testPlayer.getMoney());
        assertEquals(25,testPlayer.getCars().get(0).getCurrentHealth());
        repairOutput = testStore.repairCar(0);
        assertEquals("You don't have enough money",repairOutput);
        testPlayer.getCars().get(0).changeHealth(100);
        repairOutput = testStore.repairCar(0);
        assertEquals("Can't repair your car any further",repairOutput);
    }
}
