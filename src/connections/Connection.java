package connections;

public abstract class Connection {
    protected boolean state;

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }
}
