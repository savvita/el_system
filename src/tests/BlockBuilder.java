package tests;

import blocks.Block;
import devices.Device;
import switches.wires.ClassicSwitch;

class BlockBuilder {
    static Block createBlock() {
        return new Block();
    }

    static Block addDevice(Block block, double consumption) {
        Device device = DeviceBuilder.createDevice();
        DeviceBuilder.addPower(device);
        DeviceBuilder.addSwitcher(device, true);
        DeviceBuilder.addLight(device, consumption);

        block.addDevice(device);

        return block;
    }
}
