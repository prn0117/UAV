public class DroneMovement implements Movement, Recordable{
    private Direction aDirection;
    private Speed aSpeed;
    private int aDistance;
    private int noOfMovements;
    private boolean recordOnOff = false;

    /**
     *
     * @pre pDirection != null && pSpeed != null
     * @pre pDistance >= 0
     */
    public DroneMovement(Direction pDirection, Speed pSpeed, int pDistance){

        assert pDirection != null && pSpeed != null;
        assert pDistance >= 0;

        this.aDirection = pDirection;
        this.aSpeed = pSpeed;
        this.aDistance = pDistance;
    }

    /**
     *
     * @pre pDirection != null && pSpeed != null
     * @pre pDistance >= 0
     */
    public DroneMovement(int pDistance, Speed pSpeed) {

        assert pSpeed != null;
        assert pDistance >= 0;

        this.aSpeed = pSpeed;
        this.aDistance = pDistance;
    }

    public Direction getaDirection(){
        return this.aDirection;
    }
    @Override
    public void execute() {
        System.out.println("Move " + this.aDirection + " " + this.aDistance + " units at " + this.aSpeed+ " speed.");
    }


    public void recordOn() {
        this.recordOnOff = true;
    }

    @Override
    public void record(Format format){
        if(!this.recordOnOff){
            System.out.println("Please turn ON recording function.");
        }
        else {
            System.out.println("The movement was recorded as a " + format + " file.");
        }
    }
}

