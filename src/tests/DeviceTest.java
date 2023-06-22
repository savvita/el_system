package tests;

import devices.Device;
import org.junit.Assert;
import org.junit.Test;
import stuff.light.LedLight;
import switches.Switchable;
import switches.wires.WireSwitch;

import static org.junit.Assert.*;

public class DeviceTest {
    private static final double DELTA = 1e-5;
    @Test
    public void testSwitchStateOnPowerOff() {
        Device device = DeviceBuilder.createDevice();
        Assert.assertFalse(device.switchState());
    }

    @Test
    public void testSwitchStateOnPowerNoSwitcher() {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        Assert.assertTrue(device.switchState());
    }

    @Test
    public void testSwitchStateOnPowerSwitcherNoConnection() {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        Switchable sw = DeviceBuilder.addSwitcher(device, false);
        Assert.assertFalse(device.switchState(sw));
    }

    @Test
    public void testSwitchStateOnPowerSwitcherConnection() {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        Switchable sw = DeviceBuilder.addSwitcher(device, true);

        Assert.assertTrue(device.switchState(sw));
    }

    @Test
    public void testSwitchStateAlienSwitcher() {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        Switchable sw = DeviceBuilder.addSwitcher(device, true);

        WireSwitch alien = SwitchBuilder.getClassicSwitch();
        SwitchBuilder.addConnection(alien);
        Assert.assertFalse(device.switchState(alien));
    }

    @Test
    public void testGetConsumptionNoStuff() {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        DeviceBuilder.addSwitcher(device, true);

        Assert.assertEquals(0, device.getConsumption(), DELTA);
    }

    @Test
    public void testGetConsumption() {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        DeviceBuilder.addSwitcher(device, true);

        double consumption = 10;

        LedLight light = new LedLight(consumption);
        light.setState(true);

        device.addStuff(light);

        Assert.assertEquals(consumption, device.getConsumption(), DELTA);
    }

    @Test
    public void testEquals() {
        Device device = DeviceBuilder.createDevice();
        Device another = device;

        Assert.assertTrue(device.equals(another));
    }

    @Test
    public void testEqualsFail() {
        Device device = DeviceBuilder.createDevice();
        Device another = DeviceBuilder.createDevice();

        Assert.assertFalse(device.equals(another));
    }

    @Test
    public void testPowerCheckFail() {
        Device device = DeviceBuilder.createDevice();

        Assert.assertFalse(device.powerCheck());
    }

    @Test
    public void testPowerCheck() {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);

        Assert.assertTrue(device.powerCheck());
    }
}