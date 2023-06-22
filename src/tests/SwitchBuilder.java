package tests;

import connections.Connection;
import connections.wires.PhaseConnection;
import switches.wires.ClassicSwitch;
import switches.wires.WireSwitch;

class SwitchBuilder {
    static ClassicSwitch getClassicSwitch() {
        return new ClassicSwitch();
    }

    static WireSwitch addConnection(WireSwitch sw) {
        Connection connection = new PhaseConnection(14);
        connection.setState(true);

        sw.addConnection(connection);
        return sw;
    }
}
