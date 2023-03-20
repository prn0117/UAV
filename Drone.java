public class Drone {

    final private String name;

    final private Flight f;


    /**
     * Constructor
     * @param name of the drone
     * @param flight
     * @pre name != null
     */
    public Drone(String name, Flight flight) {
        assert name != null;
        this.name = name;
        this.f = flight;
    }

    public Flight getFlight() {
        return f.copy();
    }

    /**
     * Name getter
     * @return drone name
     */
    public String getName() {
        return this.name;
    }
}
