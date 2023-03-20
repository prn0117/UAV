import java.util.Comparator;

public class SortByTricks implements Comparator<Flight> {
    public int compare(Flight flight1, Flight flight2)
    {
        return Integer.compare(flight1.getNoOfTricks(), flight2.getNoOfTricks());
    }
}
