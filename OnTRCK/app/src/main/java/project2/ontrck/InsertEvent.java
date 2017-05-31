package project2.ontrck;

import java.util.ArrayList;
/**
 * Created by talaba on 5/26/17.
 */

public class InsertEvent {
    ArrayList<Event> calendar = new ArrayList<Event>();
    int count;

    public void main() {
        Event event2 = new Event();
    }

    public void setInformation(String date, String _event, int _startTime, int _endTime) {

        int day, month, year;
        Event event = new Event();
        String[] splitDate = date.split("\\s+");
        day = Integer.parseInt(splitDate[0]);
        month = Integer.parseInt(splitDate[1]);
        year = Integer.parseInt(splitDate[2]);
        event.setDay(day);
        event.setMonth(month);
        event.setYear(year);
        event.setEventName(_event);
        calendar.add(count, event);
        count++;
        // Log.d("this is the current event: ", calendar.get((count -1)).getEventName());
    }
    public ArrayList<Event> getCalendar(){
        return calendar;
    }


}
