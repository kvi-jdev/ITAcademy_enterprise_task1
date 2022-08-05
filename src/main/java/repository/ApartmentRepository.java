package repository;

import java.util.List;

public interface ApartmentRepository<T> {

    boolean addDevice(T t, List<T> list);

    void turnOnOffTargetDevice(int index, List<T> list);

    void turnOnOffAllDevices(List<T> list);

    void readAll(List<T> t);

    void readDeviceNames(String[] shopList);


}
