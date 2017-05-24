package project2.ontrck;

import java.util.List;

/**
 * Created by songkaiyu on 5/24/17.
 */

public class Event {
    private int[] DMY;
    private String Name;
    private int[] Start;
    private int[] End;

    public Event(int[] dmy, String name, int[] start, int[] end){
        DMY = dmy;
        Name = name;
        Start = start;
        End = end;
    }
}
