package project2.ontrck;

import java.util.ArrayList;

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
        Event Ev = new Event(Deal(date), event, Deal(start_time), Deal(end_time));
        el.add(Ev);
    }

    public int[] Deal(String data){
        String[] datalist = data.split(" ");
        int[] result = new int[datalist.length];
        for(int i = 0; i < datalist.length; i++){
            result[i] = Integer.parseInt(datalist[i]);
        }
        return result;
    }
}
