package switches.wireless;

import devices.Device;
import switches.Switchable;

public abstract class WirelessSwitch implements Switchable {
    protected Device connectedDevice;
    public abstract boolean connect(Device device);
    public abstract boolean disconnect();

    @Override
    public boolean getState() {
        return connectedDevice != null;
    }
}
