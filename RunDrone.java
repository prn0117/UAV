import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RunDrone {
    public static void main(String args[]) {
        // Naive Tests using print statements

        Flight f1 = new Flight("Flight1", new ArrayList<DroneTrick>());
        Flight f2 = new Flight("Flight2", new ArrayList<DroneTrick>());
        Flight f3 = new Flight("Flight3", new ArrayList<DroneTrick>());

        Drone drone = new Drone("myDrone", f1);

        Pinball pinball = new Pinball(new ArrayList<DroneMovement>());
        Pucker pucker = new Pucker(new ArrayList<DroneMovement>());
        TakeOff takeOff = new TakeOff(new ArrayList<DroneMovement>());

        //Adding tricks to f1 (Most amount of unique moves, least amount of tricks)
        drone.getFlight().addToSeq(pinball.trick(Speed.MODERATE, 23));

        //Adding tricks to f2
        f2.addToSeq(pucker.trick(Speed.HIGH, 90));
        f2.addToSeq(pucker.trick(Speed.LOW, 22));

        //Adding tricks to f3 (Lease amount of unique moves, most amount of tricks)
        f3.addToSeq(takeOff.trick(50));
        f3.addToSeq(takeOff.trick(2));
        f3.addToSeq(takeOff.trick(45));
        f3.addToSeq(takeOff.trick(2));

        ArrayList<Flight> flightList = new ArrayList<Flight>();
        flightList.add(f1);
        flightList.add(f2);
        flightList.add(f3);

        System.out.println("UNSORTED");
        for(int i = 0; i < flightList.size();i++ ){
            System.out.println(flightList.get(i).getFlightName());
        }
        System.out.println("");

        Collections.sort(flightList, new SortByMovements());
        System.out.println("SORTED BY UNIQUE MOVEMENTS");
        for(int i = 0; i < flightList.size();i++ ){
            System.out.println(flightList.get(i).getFlightName());
        }
        System.out.println("");

        System.out.println("SORTED BY TRICKS");
        Collections.sort(flightList, new SortByTricks());
        for(int i = 0; i < flightList.size();i++ ){
            System.out.println(flightList.get(i).getFlightName());
        }


        drone.getFlight().getFlightSeq().get(0).record(Format.FLV);
        drone.getFlight().execute();

    }
}
