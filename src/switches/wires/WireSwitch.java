package switches.wires;

import connections.Connection;
import switches.Switchable;

import java.util.ArrayList;

public abstract class WireSwitch implements Switchable {
    protected ArrayList<Connection> connections = new ArrayList<>();

    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }
    public void removeConnection(Connection connection) {
        this.connections.remove(connection);
    }

    @Override
    public boolean getState() {
        if(connections.size() > 0) {
            return !connections.stream().anyMatch(x -> x.getState() == false);
        }

        return false;
    }

}
