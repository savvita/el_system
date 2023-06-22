package stuff.light;

import electrical.ElectricalObject;

public abstract class Light extends ElectricalObject {
    public Light(double consumption) {
        this.consumption = consumption;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    @Override
    public double getConsumption() {
        if(!state) {
            return 0;
        }

        return this.consumption;
    }
}
