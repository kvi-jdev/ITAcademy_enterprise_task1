package repository;

import entity.device.Device;

import java.util.List;

public class ApartmentRepositoryImpl implements ApartmentRepository<Device> {

    @Override
    public boolean addDevice(Device o, List<Device> list) {
        boolean contains = list.contains(o);
        if (contains) {
            return false;
        } else {
            list.add(o);
            return true;
        }
    }

    @Override
    public void turnOnOffTargetDevice(int deviceIndex, List<Device> deviceList) {
        Device device = deviceList.get(deviceIndex - 1);
        device.setTurnedOn(!device.isTurnedOn());
    }

    @Override
    public void turnOnOffAllDevices(List<Device> list) {
        for (Device device : list) {
            device.setTurnedOn(!device.isTurnedOn());
        }
    }


    @Override
    public void readAll(List<Device> list) {
        for (Device device : list) {
            System.out.println(device);
        }
    }

    @Override
    public void readDeviceNames(String[] shopList) {
        for (int i = 0; i < shopList.length; i++) {
            System.out.println((i + 1) + ". " + shopList[i]);
        }
    }

}
