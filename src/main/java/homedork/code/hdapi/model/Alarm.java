package homedork.code.hdapi.model;

public class Alarm extends Device {

    public Alarm(String id) {
        this.id = id;
        this.state = State.OFF;
    }
}