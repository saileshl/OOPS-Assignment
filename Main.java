abstract class SmartDevice {
    String name;
    boolean status;

    SmartDevice(String name) {
        this.name = name;
        this.status = false;
    }

    abstract void turnOn();
    abstract void turnOff();

    public void showStatus() {
        System.out.println(name + " is " + (status ? "ON" : "OFF"));
    }

    @Override
    protected void finalize() {
        System.out.println(name + " cleaned up.");
    }
}

class Light extends SmartDevice {
    Light(String name) {
        super(name);
    }

    @Override
    void turnOn() {
        status = true;
        System.out.println(name + " Light ON");
    }

    @Override
    void turnOff() {
        status = false;
        System.out.println(name + " Light OFF");
    }
}

class Fan extends SmartDevice {
    Fan(String name) {
        super(name);
    }

    @Override
    void turnOn() {
        status = true;
        System.out.println(name + " Fan ON");
    }

    @Override
    void turnOff() {
        status = false;
        System.out.println(name + " Fan OFF");
    }
}

public class Main {
    public static void main(String[] args) {
        SmartDevice light = new Light("Bedroom");
        SmartDevice fan = new Fan("Hall");

        light.turnOn();
        fan.turnOn();

        light.showStatus();
        fan.showStatus();

        light.turnOff();
        fan.turnOff();

        light = null;
        fan = null;
        System.gc();

        System.out.println("Simulation Complete.");
    }
}
