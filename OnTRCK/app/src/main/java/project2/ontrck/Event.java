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

    public void SetDate(int[] dmy){
        DMY = dmy;
    }

    public void SetStartTime(int[] start){
        Start = start;
    }

    public void SetEndTime(int[] end){
        End = end;
    }

    public void SetName(String name){
        Name = name;
    }

    public String GetName(){
        return Name;
    }

    public int[] GetStartTime(){
        return Start;
    }

    public int[] GetEndTime(){
        return End;
    }

    public  int[] GetDate(){
        return DMY;
    }
}
