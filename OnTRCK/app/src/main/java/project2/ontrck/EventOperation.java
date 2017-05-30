package project2.ontrck;

import android.widget.Switch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by songkaiyu on 5/30/17.
 */

public class EventOperation {
    public ArrayList<Event> EL = new ArrayList<Event>();

    public void SetEvent(){

    }

    public void Delete(){

    }

    public void Change(String name, String order, String value){
        switch (order){
            case "Date":
                Search(name).SetDate(Date(value));
                break;
            case "Start":
                Search(name).SetStartTime(Time(value));
                break;
            case "End":
                Search(name).SetEndTime(Time(value));
                break;
            default:
                break;
        }
    }

    public Event Search(String name){
        for(int i = 0; i < EL.size(); i ++){
            if(EL.get(i).GetName() == name){
                return EL.get(i);
            }
        }
        return null;
    }

    public ArrayList<Event> SearchDate(String Date){
        Calendar date = Date(Date);
        ArrayList<Event> result = new ArrayList<>();
        for(int i = 0; i < EL.size(); i ++){
            if(EL.get(i).GetDate().equals(date)){
                result.add(EL.get(i));
            }
        }
        return result;
    }

    public Calendar Time(String Time){
        Calendar time = new GregorianCalendar();
        int[] t = Deal(Time);
        time.set(t[0], t[1]-1, t[2], t[3], t[4]);
        return time;
    }

    public Calendar Date(String Date){
        Calendar date = new GregorianCalendar();
        int[] d = Deal(Date);
        date.set(d[0], d[1]-1, d[2]);
        return date;
    }

    public int[] Deal(String data){
        String[] s = data.split(" ");
        int[] result = new int[s.length];
        for(int i = 0; i < s.length; i++){
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }
}
