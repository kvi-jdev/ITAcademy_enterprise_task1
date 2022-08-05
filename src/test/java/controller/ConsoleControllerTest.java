package controller;

import entity.apartment.Apartment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.ApartmentRepositoryImpl;
import service.ApartmentServiceImpl;

import java.util.Scanner;


public class ConsoleControllerTest {
    ApartmentServiceImpl apartmentService;
    ApartmentRepositoryImpl apartmentRepository;
    ConsoleController consoleController;
    Scanner scanner;


    @Before
    public void init() {
        scanner = new Scanner(System.in);
        apartmentRepository = new ApartmentRepositoryImpl();
        apartmentService = new ApartmentServiceImpl(apartmentRepository);
        consoleController = new ConsoleController(apartmentService);
    }

    @Test
    public void test_checkUserName() {
        String userName = "Vadim";
        boolean result = consoleController.checkUserName(userName);
        Assert.assertTrue(result);
    }

    @Test
    public void test_checkSmallUserName() {
        String userName = "Va";
        boolean result = consoleController.checkUserName(userName);
        Assert.assertFalse(result);
    }

    @Test
    public void test_checkIfNumber() {
        String number = "15";
        boolean result = consoleController.checkIfNumber(number);
        Assert.assertTrue(result);
    }

    @Test
    public void test_checkIfNotNumber() {
        String number = "15s";
        boolean result = consoleController.checkIfNumber(number);
        Assert.assertFalse(result);

    }

    @Test
    public void test_getUserName() {
        String unknownUser = "UNKNOWN_USER";
        String userName = consoleController.getUserName();
        Assert.assertEquals(unknownUser, userName);
    }

    @Test
    public void test_setUserName() {
        consoleController.setUserName("Vadim");
        Assert.assertEquals("Vadim", consoleController.getUserName());
    }

    @Test
    public void test_setApartment() {
        Apartment apartment = new Apartment();
        consoleController.setApartment(apartment);
        boolean result = apartment.equals(consoleController.apartment);
        Assert.assertTrue(result);
    }

}
