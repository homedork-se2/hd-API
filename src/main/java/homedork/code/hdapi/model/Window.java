package homedork.code.hdapi.model;

public class Window extends Device {

    public Window(String id) {
        this.id = id;
        this.state = State.OFF;
    }
}