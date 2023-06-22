package tests;

import blocks.Block;
import devices.Device;
import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class BlockTest {
    private static final double DELTA = 1e-5;

    @Test
    public void testGetConsumption() {
        double consumption = 10;
        Block block = BlockBuilder.createBlock();
        BlockBuilder.addDevice(block, consumption);
        Assert.assertEquals(consumption, block.getConsumption(), DELTA);
    }

    @Test
    public void testSwitchState() {
        double consumption = 10;
        Block block = BlockBuilder.createBlock();
        BlockBuilder.addDevice(block, consumption);
        Device device = block.getDevices()[0];

        Assert.assertTrue(device.switchState());
    }
}