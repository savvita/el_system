package tests;

import connections.Connection;
import connections.wires.PhaseConnection;
import devices.Device;
import power.Power;
import stuff.light.LedLight;
import switches.Switchable;
import switches.wires.ClassicSwitch;
import switches.wires.WireSwitch;

class DeviceBuilder {
    static Device createDevice() {
        return new Device();
    }

    static Device addPower(Device device) {
        Power power = new Power();
        power.setState(true);
        device.setPower(power);

        return device;
    }

    static Switchable addSwitcher(Device device, boolean connected) {
        WireSwitch sw = new ClassicSwitch();

        if(connected) {
            SwitchBuilder.addConnection(sw);
        }

        device.addSwitch(sw);

        return sw;
    }

    static Device addLight(Device device, double consumption) {
        WireSwitch sw = new ClassicSwitch();

        LedLight light = new LedLight(consumption);
        light.setState(true);

        device.addStuff(light);

        return device;
    }
}
