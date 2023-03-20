import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Flight implements Movement{

    private int noOfTricks;
    private int uniqueMoves;
    private String flightName;
    private ArrayList<DroneTrick> aList = new ArrayList<>();

    /**
     *
     * @param flightName
     * @param sequence
     * @pre flightName != null && aList != null
     */


    public Flight(String flightName, ArrayList<DroneTrick> sequence){
        assert flightName != null && aList != null;
        this.flightName = flightName;
        this.aList = sequence;
    }

    public ArrayList<DroneTrick> getFlightSeq(){
        return new ArrayList<DroneTrick>(aList);
    }

    public Flight copy() {
        return new Flight(this.flightName, this.aList);
    }

    public String getFlightName() {
        return flightName;
    }

    public void addToSeq(DroneTrick dt){
        aList.add(dt);
        noOfTricks++;
    }
    public int getNoOfTricks(){
        noOfTricks = aList.size();
        return noOfTricks;
    }

    public int getUniqueMovesF(){

        uniqueMoves = aList.get(0).getUniqueMoves();
        for (int i =1; i< aList.size(); i++){

            if(uniqueMoves < aList.get(i).getUniqueMoves()){
                uniqueMoves = aList.get(i).getUniqueMoves();
            }
        }
        return uniqueMoves;
    }

    public String toString(){
        return getFlightName();
    }
    @Override
    public void execute(){
        for (Iterator<DroneTrick> iter = aList.iterator(); iter.hasNext(); ) {
            DroneTrick dt = iter.next();
            dt.executeTrick();
        }
    }

}
