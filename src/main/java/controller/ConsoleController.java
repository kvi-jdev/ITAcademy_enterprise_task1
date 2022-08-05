package controller;

import constant.MenuConstant;
import entity.apartment.Apartment;
import entity.device.Device;
import service.ApartmentServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleController {

    final static Logger log = Logger.getLogger(ConsoleController.class.getSimpleName());

    private String userName = "UNKNOWN_USER";

    public Apartment apartment;

    private final ApartmentServiceImpl apartmentService;

    public ConsoleController(ApartmentServiceImpl apartmentService) {
        this.apartmentService = apartmentService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }


    public void start() {
        info("Вход в главное меню");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MenuConstant.MENU_REGISTRATION);
            System.out.print(MenuConstant.CURSOR);
            String userName = scanner.nextLine();
            if (userName.equalsIgnoreCase(MenuConstant.EXIT)) {
                info("Завершение программы.");
                System.exit(1);
            } else {
                boolean checkUserName = checkUserName(userName);
                if (checkUserName) {
                    setUserName(userName);
                    openUserMenu();
                    break;
                } else {
                    System.out.println(MenuConstant.WRONG_USERNAME);
                    warning();
                    start();
                }
            }
        }
    }

    public void openUserMenu() {
        info("Вход в меню пользователя");
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConstant.USER_MENU);
        System.out.print(MenuConstant.CURSOR);
        String input = scanner.nextLine();
        switch (input) {
            case MenuConstant.THREE -> {
                info("Завершение программы.");
                System.exit(1);
            }
            case MenuConstant.ONE -> openShopMenu();
            case MenuConstant.TWO -> openMyDeviceListMenu();
            default -> {
                System.out.println(MenuConstant.WRONG_NUMBER);
                warning();
                openUserMenu();
            }
        }
    }

    private void openMyDeviceListMenu() {
        info("Вход в меню просмотра имеющихся устройств");
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConstant.CURRENT_USER_DEVICE_LIST);
        if (apartment == null) {
            setApartment(new Apartment());
        }
        List<Device> deviceList = apartment.getDeviceList();
        if (deviceList.size() > 0) {
            deviceList.sort(Comparator.comparing(Device::getDevicePower));
            System.out.println(MenuConstant.SORTED_LIST);
            apartmentService.readAll(deviceList);
            System.out.println(MenuConstant.USER_DEVICE_ACTIONS);
            System.out.print(MenuConstant.CURSOR);
            String input = scanner.nextLine();
            switch (input) {
                case MenuConstant.THREE -> openUserMenu();
                case MenuConstant.TWO -> openFindMenu();
                case MenuConstant.ONE -> openDeviceTurnOnOffMenu();
                default -> {
                    System.out.println(MenuConstant.WRONG_NUMBER);
                    warning();
                    openUserMenu();
                }
            }
        } else {
            System.out.println(MenuConstant.LIST_IS_EMPTY);
            openUserMenu();
        }
    }

    private void openDeviceTurnOnOffMenu() {
        info("Вход в меню включения/выключения устройств");
        List<Device> deviceList = apartment.getDeviceList();
        if (deviceList.size() > 0) {
            System.out.println(MenuConstant.CURRENT_USER_DEVICE_LIST);
        } else {
            System.out.println(MenuConstant.LIST_IS_EMPTY);
        }
        for (Device device : deviceList) {
            System.out.println((deviceList.indexOf(device) + 1) + " " + device);
        }
        System.out.print(MenuConstant.TOTAL_POWER);
        int totalPower = 0;
        int totalDevicesTurnedOn = 0;
        for (Device device : deviceList) {
            if (device.isTurnedOn()) {
                totalDevicesTurnedOn++;
                totalPower = totalPower + device.getDevicePower();
            }
        }
        System.out.println(totalPower + MenuConstant.TOTAL_DEVICES + "" + totalDevicesTurnedOn);
        System.out.println(MenuConstant.TURN_OFF_ON_MENU);
        System.out.print(MenuConstant.CURSOR);
        Scanner scanner = new Scanner(System.in);
        int deviceIndex;
        String inputText;
        if (scanner.hasNextInt()) {
            deviceIndex = scanner.nextInt();
            try {
                apartmentService.turnOnOffTargetDevice(deviceIndex, deviceList);
                info("Включил/выключил одно устройство в сеть");
                openDeviceTurnOnOffMenu();
            } catch (Exception e) {
                System.out.println(MenuConstant.WRONG_NUMBER);
                warning();
                openDeviceTurnOnOffMenu();
            }
        } else {
            inputText = scanner.nextLine();
            switch (inputText.toLowerCase()) {
                case MenuConstant.EXIT -> openUserMenu();
                case MenuConstant.ALL -> {
                    apartmentService.turnOnOffAllDevices(deviceList);
                    info("Включил/выключил все устройства в сеть");
                    openDeviceTurnOnOffMenu();
                }
            }
        }
    }

    private void openFindMenu() {
        info("Вход в меню поиска устройств");
        System.out.println(MenuConstant.SEARCH_MENU_BOT);
        System.out.print(MenuConstant.CURSOR);
        Scanner scanner = new Scanner(System.in);
        int botPower = 0;
        String inputText;
        if (scanner.hasNextInt()) {
            botPower = scanner.nextInt();
        } else {
            inputText = scanner.nextLine();
            if (inputText.equalsIgnoreCase(MenuConstant.EXIT)) {
                openUserMenu();
            } else {
                System.out.println(MenuConstant.WRONG_NUMBER);
                warning();
                openFindMenu();
            }
        }
        System.out.println(MenuConstant.SEARCH_MENU_TOP);
        System.out.print(MenuConstant.CURSOR);
        int topPower = 0;
        if (scanner.hasNextInt()) {
            topPower = scanner.nextInt();
        } else {
            inputText = scanner.nextLine();
            if (inputText.equalsIgnoreCase(MenuConstant.EXIT)) {
                openUserMenu();
            } else {
                System.out.println(MenuConstant.WRONG_NUMBER);
                warning();
                openFindMenu();
            }
        }
        int finalBotPower = botPower;
        int finalTopPower = topPower;
        if (apartment.getDeviceList().size() > 0) {
            List<Device> collect = apartment.getDeviceList().stream()
                    .filter(device -> (device.getDevicePower() > finalBotPower && device.getDevicePower() < finalTopPower))
                    .toList();
            System.out.println(MenuConstant.FOUNDED_LIST);
            for (Device device : collect) {
                System.out.println(device);
            }
            info("Произвел сортировку устройств по заданным параметрам");
        } else {
            System.out.println(MenuConstant.LIST_IS_EMPTY);
        }
        openUserMenu();
    }

    private void openShopMenu() {
        info("Вход в меню магазина");
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuConstant.SHOP_MENU);
        if (apartment == null) {
            Apartment currentApartment = new Apartment();
            setApartment(currentApartment);
        }
        String[] shopList = apartment.getShopList();
        apartmentService.readDeviceNames(shopList);
        System.out.println("\n" + getUserName() + MenuConstant.BUY_SOMETHING);
        System.out.println(MenuConstant.MAKE_CHOOSE);
        System.out.print(MenuConstant.CURSOR);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(MenuConstant.EXIT)) {
            System.exit(1);
        } else {
            boolean checkNumber = checkIfNumber(input);
            if (checkNumber) {
                List<Device> deviceList = apartment.getDeviceList();
                Device device = new Device(apartment.getDeviceListFromShop().get((Integer.parseInt(input) - 1)));
                boolean result = apartmentService.addDevice(device, deviceList);
                if (result) {
                    info("Успешная попытка покупки устройства " + device.getDeviceModel() + " ");
                    System.out.println(MenuConstant.DEVICE_ADDED);
                } else {
                    info("Неудачная попытка покупки устройства " + device.getDeviceModel() + " ");
                    System.out.println(MenuConstant.DEVICE_NOT_ADDED);
                }
                openUserMenu();
            } else {
                System.out.println(MenuConstant.WRONG_NUMBER);
                warning();
                openShopMenu();
            }
        }
    }

    public boolean checkIfNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            warning();
            return false;
        }
        return Integer.parseInt(input) > 0 && Integer.parseInt(input) < 19;
    }

    public boolean checkUserName(String userName) {
        Pattern pattern = Pattern.compile("\\w{3,15}");
        Matcher matcher = pattern.matcher(userName);
        return matcher.matches();
    }

    private void info(String text) {
        log.info(text + " Пользователь: " + userName);
    }

    private void warning() {
        log.warning("Введено неверное число. Пользователь: " + userName);
    }
}
