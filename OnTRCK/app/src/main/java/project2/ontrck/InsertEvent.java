package project2.ontrck;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by talaba on 5/26/17.
 */

public class InsertEvent {
    ArrayList<Event> EventList = new ArrayList<Event>();

    public void setInformation(String date, String _event, int[] _startTime, int[] _endTime) {
        if(NameSearch(_event)){
            int[] d = Deal(date);
            Event event = new Event();
            event.SetDate(Date(d));
            event.SetName(_event);
            event.SetStartTime(Time(d, _startTime));
            event.SetEndTime(Time(d, _endTime));
            if(TimeCheck(event)){
                EventList.add(event);
            }
        }
    }

    public boolean TimeCheck(Event event){
        for(int i = 0; i < EventList.size(); i++){
            Event target = EventList.get(i);
            if(!target.After(event)&&!target.Before(event)){
                return false;
            }
        }
        return true;
    }

    public Calendar Date(int[] Date){
        Calendar date = new GregorianCalendar();
        date.set(Date[2], Date[1], Date[0]);
        return date;
    }

    public Calendar Time(int[] Date, int[] Time){
        Calendar time = new GregorianCalendar();
        time.set(Date[2], Date[1], Date[0], Time[0], Time[1]);
        return time;
    }

    public boolean NameSearch(String name){
        for(int i = 0; i < EventList.size(); i++){
            if(EventList.get(i).GetName().equals(name)){
                return false;
            }
        }
        return true;
    }

    public int[] Deal(String data){
        String[] s = data.split(" ");
        int[] result = new int[s.length];
        for(int i = 0; i < s.length; i++){
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public ArrayList<Event> GetEventList(){
        return EventList;
    }
}
