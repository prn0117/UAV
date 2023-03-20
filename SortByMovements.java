import java.util.Comparator;

public class SortByMovements implements Comparator<Flight> {
    public int compare(Flight flight1, Flight flight2)
    {
        return flight1.getUniqueMovesF()-flight2.getUniqueMovesF();
    }
}
