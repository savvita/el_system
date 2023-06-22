package blocks;

import devices.Device;

import java.util.ArrayList;

public class Block {
    private final ArrayList<Device> devices = new ArrayList<Device>();

    public boolean addDevice(Device device) {
        if(device == null) {
            return false;
        }

        var d = getDevice(device.getId());
        if(d != null) {
            return false;
        }

        devices.add(device);
        return true;
    }

    public boolean removeDevice(Device device) {
        return devices.remove(device);
    }

    public boolean removeDevice(String id) {
        var device = getDevice(id);

        if(device == null) {
            return false;
        }

        return devices.remove(device);
    }

    public Device[] getDevices() {
        Device[] arr = new Device[devices.size()];
        return devices.toArray(arr);
    }

    public Device getDevice(String id) {
        return devices.stream()
                .filter((d) -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public double getConsumption() {
        double sum = 0;
        for(Device device : devices) {
            sum += device.getConsumption();
        }

        return sum;
    }
}
