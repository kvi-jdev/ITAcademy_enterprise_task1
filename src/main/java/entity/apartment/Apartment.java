package entity.apartment;

import entity.device.Device;
import entity.device.DeviceType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apartment {

    private List<Device> deviceList;

    private final String[] shopList = Arrays.stream(DeviceType.values()).map(DeviceType::getDeviceName)
            .toArray(String[]::new);

    private final List<DeviceType> deviceListFromShop;

    public Apartment() {
        DeviceType[] values = DeviceType.values();
        this.deviceListFromShop = new ArrayList<>(Arrays.asList(values));
        this.deviceList = new ArrayList<>();
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public String[] getShopList() {
        return shopList;
    }

    public List<DeviceType> getDeviceListFromShop() {
        return deviceListFromShop;
    }
}
