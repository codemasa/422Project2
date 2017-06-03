package project2.ontrck;

/**
 * Created by Talaba on 5/26/17.
 */

public class Event {

    int day, month, year;
    int[] startTime = {0,0};
    int[] endTime = {0,0};
    String eventName;
    public Event(){
        day = 0;
        month = 0;
        year = 0;
        eventName = "hasnt been set yet :(";
    }
    // if someone wanted to add more scheduling aspects they can insert here, such as priority
    public String getEventName(){
        return eventName;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public int[] getStartTime(){
        return startTime;
    }
    public int[] getEndTime(){
        return endTime;
    }
    public void setStartTime(int[] _time){
        startTime = _time;
    }
    public void setEndTime(int[] _time){endTime = _time; }
    public void setDay(int _day){
        day = _day;
    }
    public void setMonth(int _month){
        month = _month;
    }
    public void setYear(int _year){
        year = _year;
    }
    public void setEventName(String _eventName){
        eventName = _eventName;
    }
}
