import java.util.ArrayList;
import java.util.Iterator;

public class TakeOff implements DroneTrick, Recordable{

    private ArrayList<DroneMovement> aList = new ArrayList<DroneMovement>();
    private int uniqueMoves;

    /**
     *
     * @param dList
     * @pre aList != null
     */

    public TakeOff(ArrayList<DroneMovement> dList){
        assert aList != null;
        this.aList = dList;
    }


    public TakeOff trick(int distance){

        aList.add(new DroneMovement(Direction.UP, Speed.LOW, distance));
        aList.add(new DroneMovement(Direction.UP, Speed.MODERATE, distance));

        return this;
    }


    @Override
    public int getUniqueMoves(){
        int duplicateMoves = 0;
        int uniqueMoves = 0;
        ArrayList<String> s = new ArrayList<>();
        //String d[]= new String[aList.size()];
        for(int i = 0; i<aList.size();i++){
            s.add(i,aList.get(i).getaDirection().toString());
        }
        for(int i =0; i < s.size(); i++) {
            if (s.lastIndexOf(s.get(i)) != i)  {
                duplicateMoves+=1;
            }
        }
        uniqueMoves = s.size()-duplicateMoves;
        return uniqueMoves;
    }
    @Override
    public void executeTrick() {
        System.out.println("TAKEOFF TRICK");
        for (Iterator<DroneMovement> iter = aList.iterator(); iter.hasNext(); ) {
            DroneMovement d = iter.next();
            d.execute();
        }
        aList.clear();
        System.out.println("END OF TRICK\n");
    }
    @Override
    public void record(Format f) {
        for (Iterator<DroneMovement> iter = aList.iterator(); iter.hasNext(); ) {
            DroneMovement d = iter.next();
            d.recordOn();
        }
        System.out.println("The trick was recorded as an " + f + " file.");
    }
}
