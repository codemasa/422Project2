package project2.ontrck;

import java.util.Calendar;

/**
 * Created by songkaiyu on 5/30/17.
 */

public class Event {

    private Calendar DMY;
    private String Name;
    private Calendar Start;
    private Calendar End;

    public Event(){
        DMY = null;
        Name = null;
        Start = null;
        End = null;
    }

    public void SetDate(Calendar dmy){
        DMY = dmy;
    }

    public void SetStartTime(Calendar start){
        Start = start;
    }

    public void SetEndTime(Calendar end){
        End = end;
    }

    public void SetName(String name){
        Name = name;
    }

    public String GetName(){
        return Name;
    }

    public Calendar GetStartTime(){
        return Start;
    }

    public Calendar GetEndTime(){
        return End;
    }

    public  Calendar GetDate(){
        return DMY;
    }

    public boolean After(Event e){
        return Start.after(e.GetEndTime());
    }

    public boolean Before(Event e){
        return End.before(e.GetStartTime());
    }
}
