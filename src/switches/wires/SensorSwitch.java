package switches.wires;

import devices.Device;

public class SensorSwitch extends WireSwitch{
    @Override
    public boolean switchState(Device device) {
        if(!getState()) {
            return false;
        }

        if(device == null) {
            return false;
        }

        return device.switchState();
    }
}
