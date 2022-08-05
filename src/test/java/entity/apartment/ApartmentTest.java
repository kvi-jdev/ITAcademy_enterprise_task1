package entity.apartment;

import entity.device.Device;
import entity.device.DeviceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ApartmentTest {
    Apartment apartment;
    Device device;

    @Before
    public void init() {
        apartment = new Apartment();
        device = new Device(DeviceType.FRIDGE_LG);
    }

    @Test
    public void test_getDeviceList() {
        List<Device> deviceList = apartment.getDeviceList();
        deviceList.add(device);
        int size = apartment.getDeviceList().size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void test_getDeviceListFromShop() {
        List<DeviceType> deviceList = apartment.getDeviceListFromShop();
        int size = deviceList.size();
        DeviceType[] values = DeviceType.values();
        int length = values.length;
        Assert.assertEquals(length, size);
    }

    @Test
    public void test_getShopList() {
        int length = apartment.getShopList().length;
        int values = DeviceType.values().length;
        Assert.assertEquals(values,length);
    }



}
