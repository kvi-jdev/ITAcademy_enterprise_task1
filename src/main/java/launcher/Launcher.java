package launcher;


import controller.ConsoleController;
import repository.ApartmentRepositoryImpl;
import service.ApartmentServiceImpl;

public class Launcher {

    public static void main(String[] args) {
        ApartmentRepositoryImpl apartmentRepository = new ApartmentRepositoryImpl();
        ApartmentServiceImpl apartmentService = new ApartmentServiceImpl(apartmentRepository);
        ConsoleController consoleController = new ConsoleController(apartmentService);
        consoleController.start();

    }
}
