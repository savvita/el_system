package devices;

import electrical.ElectricalObject;
import power.Power;
import switches.Switchable;

import java.util.ArrayList;
import java.util.UUID;

public class Device extends ElectricalObject {
    private final UUID uuid;
    private Power power;
    private final ArrayList<Switchable> switches = new ArrayList<>();
    private final ArrayList<ElectricalObject> stuff = new ArrayList<>();

    public Device() {
        uuid = java.util.UUID.randomUUID();
    }

    public String getId() {
        return uuid.toString();
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public void removePower() {
        this.power = null;
    }

    public Switchable[] getSwitches() {
        Switchable[] arr = new Switchable[switches.size()];
        return switches.toArray(arr);
    }

    public void addSwitch(Switchable switcher) {
        switches.add(switcher);
    }

    public void removeSwitch(Switchable switcher) {
        switches.remove(switcher);
    }

    public ElectricalObject[] getStuff() {
        ElectricalObject[] arr = new ElectricalObject[stuff.size()];
        return stuff.toArray(arr);
    }

    public void addStuff(ElectricalObject stuff) {
        this.stuff.add(stuff);
    }

    public void removeStuff(ElectricalObject stuff) {
        this.stuff.remove(stuff);
    }

    public boolean switchState() {
        if(!powerCheck()) {
            return false;
        }

        state = !state;
        return true;
    }

    public boolean powerCheck() {
        if(power == null || !power.getState()) {
            return false;
        }

        return stuff.stream().allMatch(x -> x.getState());
    }

    public boolean switchState(Switchable switcher) {
        if(switches.contains(switcher)) {
            return switcher.switchState(this);
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Device device)) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        return this.getId().equals(device.getId());
    }

    @Override
    public int hashCode() {
        return uuid.toString().hashCode();
    }

    @Override
    public double getConsumption() {
        if(!powerCheck()) {
            return 0;
        }

        double sum = 0;
        for(ElectricalObject st : stuff) {
            sum += st.getConsumption();
        }
        return sum;
    }
}
