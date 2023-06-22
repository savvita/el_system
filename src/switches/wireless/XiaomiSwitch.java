package switches.wireless;

import devices.Device;

public class XiaomiSwitch extends WirelessSwitch{
    @Override
    public boolean switchState(Device device) {
        if(connectedDevice == null || !device.equals(connectedDevice)) {
            return false;
        }

        if(!getState()) {
            return false;
        }

        return connectedDevice.switchState();
    }

    @Override
    public boolean connect(Device device) {
        if(device == null) {
            return false;
        }
        connectedDevice = device;
        return true;
    }

    @Override
    public boolean disconnect() {
        if(connectedDevice == null) {
            return false;
        }
        connectedDevice = null;
        return true;
    }
}
