package entity.device;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeviceTest {

    Device device;
    Device device2;

    @Before
    public void init() {
        device = new Device(DeviceType.FRIDGE_ATLANT);
        device2 = new Device(DeviceType.FRIDGE_ATLANT);
    }

    @Test
    public void test_devicePower() {
        Assert.assertEquals(200, device.getDevicePower());
    }

    @Test
    public void test_isTurnedOn() {
        Assert.assertFalse(device.isTurnedOn());
    }

    @Test
    public void test_setIsTurnedOn() {
        device.setTurnedOn(true);
        Assert.assertTrue(device.isTurnedOn());
    }

    @Test
    public void test_getDeviceModel() {
        DeviceType deviceType = device.getDeviceModel();
        Assert.assertEquals(DeviceType.FRIDGE_ATLANT, deviceType);
    }

    @Test
    public void test_getDeviceName() {
        String deviceName = device.getDeviceModel().getDeviceName();
        Assert.assertEquals("холодильник Atlant", deviceName);
    }

    @Test
    public void test_equals() {
        boolean equals = device.equals(device2);
        Assert.assertTrue(equals);
    }

}
