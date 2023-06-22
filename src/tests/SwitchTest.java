package tests;

import devices.Device;
import org.junit.Assert;
import org.junit.Test;
import switches.Switchable;
import switches.wires.WireSwitch;

import static org.junit.Assert.*;

public class SwitchTest {
    @Test
    public void testSwitchStateFail() {
        Switchable sw = SwitchBuilder.getClassicSwitch();
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        device.addSwitch(sw);

        Assert.assertFalse(sw.switchState(device));
    }

    @Test
    public void testSwitchState() {
        WireSwitch sw = SwitchBuilder.getClassicSwitch();
        SwitchBuilder.addConnection(sw);
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        device.addSwitch(sw);

        Assert.assertTrue(sw.switchState(device));
    }
}