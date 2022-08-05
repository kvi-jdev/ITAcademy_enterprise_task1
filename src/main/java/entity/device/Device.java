package entity.device;

import java.util.Objects;

public class Device {

    private final DeviceType deviceModel;

    private final int devicePower;

    private boolean isTurnedOn;

    public Device(DeviceType deviceModel) {
        this.deviceModel = deviceModel;
        this.devicePower = deviceModel.getDevicePower();
        this.isTurnedOn = false;
    }

    public DeviceType getDeviceModel() {
        return deviceModel;
    }

    public int getDevicePower() {
        return devicePower;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    @Override
    public String toString() {
        return "Устройство [" +
                deviceModel.getDeviceName() +
                ", мощность=" + devicePower +
                "вт, " + "подключение к сети=" + isTurnedOn + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return deviceModel == device.deviceModel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceModel);
    }
}
