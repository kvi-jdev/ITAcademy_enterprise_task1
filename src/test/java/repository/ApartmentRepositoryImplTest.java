package repository;

import entity.device.Device;
import entity.device.DeviceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ApartmentServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ApartmentRepositoryImplTest {
    Device device;
    Device device2;
    List<Device> deviceList;
    ApartmentServiceImpl apartmentService;
    ApartmentRepositoryImpl apartmentRepository;

    @Before
    public void init() {
        device = new Device(DeviceType.FRIDGE_SAMSUNG);
        device2 = new Device(DeviceType.MICROWAVE_SAMSUNG);
        deviceList = new ArrayList<>();
        apartmentRepository = new ApartmentRepositoryImpl();
        apartmentService = new ApartmentServiceImpl(apartmentRepository);
    }

    @Test
    public void test_addOneDevice() {
        boolean result = apartmentService.addDevice(device, deviceList);
        Assert.assertTrue(result);
    }
    @Test
    public void test_addTwoDevice() {
        apartmentService.addDevice(device,deviceList);
        boolean result = apartmentService.addDevice(device, deviceList);
        Assert.assertFalse(result);
    }

    @Test
    public void test_turnOnTargetDevice() {
        apartmentService.addDevice(device,deviceList);
        apartmentService.turnOnOffTargetDevice(1, deviceList);
        Assert.assertTrue(device.isTurnedOn());
    }

    @Test
    public void test_turnOnAllDevices() {
        apartmentService.addDevice(device,deviceList);
        apartmentService.addDevice(device2,deviceList);
        apartmentService.turnOnOffAllDevices(deviceList);
        Assert.assertTrue(device.isTurnedOn() && device2.isTurnedOn());
    }

    @Test
    public void test_readAll() {
        apartmentService.addDevice(device,deviceList);
        apartmentService.readAll(deviceList);
        Assert.assertNotNull(deviceList);
    }
}
