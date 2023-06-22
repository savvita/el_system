package connections.wires;

import connections.Connection;
import electrical.Electricable;

public abstract class WireConnection
        extends Connection
        implements Electricable {
    protected double resistance;

    public WireConnection(double resistance) {
        this.resistance = resistance;
    }
    @Override
    public double getResistance() {
        return this.resistance;
    }
}
