import java.util.Iterator;
import java.util.ArrayList;

public class Pinball implements DroneTrick, Recordable {
    private ArrayList<DroneMovement> aList = new ArrayList<DroneMovement>();
    private int uniqueMoves;

    /**
     *
     * @param dList
     * @pre aList != null
     */

    public Pinball(ArrayList<DroneMovement> dList){
        assert aList != null;
        this.aList = dList;
    }

    public Pinball trick(Speed trickSpeed, int distance){

        aList.add(new DroneMovement(Direction.UP, Speed.HIGH, distance));
        aList.add(new DroneMovement(Direction.LEFT, trickSpeed, distance));
        aList.add(new DroneMovement(Direction.DOWN, Speed.MODERATE, distance));
        aList.add(new DroneMovement(Direction.FORWARD, Speed.HIGH, distance));
        aList.add(new DroneMovement(Direction.LEFT, trickSpeed, distance));
        return this;
    }

    @Override
    public int getUniqueMoves(){
        int duplicateMoves = 0;
        int uniqueMoves = 0;
        ArrayList<String> s = new ArrayList<>();
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
        System.out.println("PINBALL TRICK");
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
