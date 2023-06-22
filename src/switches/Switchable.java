package switches;

import devices.Device;

public interface Switchable {
    public boolean getState();
    public boolean switchState(Device device);
}
