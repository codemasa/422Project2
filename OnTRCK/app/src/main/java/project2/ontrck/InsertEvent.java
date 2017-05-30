package project2.ontrck;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by talaba on 5/23/17.
 */

public class InsertEvent {

    public ArrayList<Event> el = new ArrayList<>();

    public void main(){
        ///Kaiyu can start here if you want
    }

    public void setInformation(String date, String event, String start_time, String end_time){
        // date: 11 2 2017   dd mm yyyy
        // event: abcd
        // start_time end_time: 13 11 hh mm
        if(Search(event)==null){
            Event Ev = new Event(Date(date), event, Time(date, start_time), Time(date, end_time));
            if(TimeCheck(Ev)){
                el.add(Ev);
            }
        }
    }

    public Calendar Date(String Date){
        Calendar date = new GregorianCalendar();
        int[] d = Deal(Date);
        date.set(d[0], d[1]-1, d[2]);
        return date;
    }

    public Calendar Time(String Date, String Time){
        Calendar time = new GregorianCalendar();
        int[] d = Deal(Date);
        int[] t = Deal(Time);
        time.set(d[0], d[1]-1, d[2], t[0], t[1]);
        return time;
    }

    public int[] Deal(String data){
        String[] s = data.split(" ");
        int[] result = new int[s.length];
        for(int i = 0; i < s.length; i++){
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public Event Search(String name){
        for(int i = 0; i < el.size(); i ++){
            if(el.get(i).GetName() == name){
                return el.get(i);
            }
        }
        return null;
    }

    public boolean TimeCheck(Event e){
        for(int i = 0; i < el.size(); i ++){
            Event target = el.get(i);
            if(!e.After(target)&&!e.Before(target)){
                return false;
            }
        }
        return true;
    }
}
