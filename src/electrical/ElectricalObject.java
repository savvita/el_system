package electrical;

public abstract class ElectricalObject {
    protected double consumption;
    protected boolean state;

    public abstract double getConsumption();
    public boolean getState() {
        return state;
    }
}
