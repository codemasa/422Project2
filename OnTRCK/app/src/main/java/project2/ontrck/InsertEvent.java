package project2.ontrck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by talaba on 5/26/17.
 */

public class InsertEvent extends AppCompatActivity {
    ArrayList<Event> calendar = new ArrayList<Event>();
    int startHour, startMinute, endHour, endMinute, day, month, year;
    String date, eventName;

    int[] startTime = {0,0};
    int[] endTime = {0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_page);
        Intent mIntent = getIntent();
        startHour = mIntent.getIntExtra("startHour", 0);
        startMinute = mIntent.getIntExtra("startMinute",0);
        endHour = mIntent.getIntExtra("endHour", 0);
        endMinute = mIntent.getIntExtra("endMinute", 0);
        eventName = mIntent.getStringExtra("event");
        date = mIntent.getStringExtra("date");

        setInformation(date, eventName, startTime, endTime);

        startTime[0] = startHour;
        startTime[1] = startMinute;
        endTime[0] = endHour;
        endTime[1] = endMinute;

        goBackToMain();
    }
    public ArrayList<Event> getCalendar() {
        return calendar;
    }


    public void setInformation(String date, String _event, int[] _startTime, int[] _endTime) {
     //   if (NameSearch(_event)) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("calendar", null);
        Type type = new TypeToken<ArrayList<Event>>() {}.getType();
        ArrayList<Event> arrayList = gson.fromJson(json, type);
        calendar = arrayList;
            Event event = new Event();
            String[] splitDate = date.split("\\s+");
            day = Integer.parseInt(splitDate[0]);
            month = Integer.parseInt(splitDate[1]);
            year = Integer.parseInt(splitDate[2]);
            event.setDay(day);

            event.setEventName(eventName);

            event.setStartTime(startTime);
            event.setEndTime(endTime);

                calendar.add(event);
         sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Editor editor = sharedPrefs.edit();
        gson = new Gson();

         json = gson.toJson(calendar);

        editor.putString("calendar", json);
        editor.commit();
        printArrayList();

        //}
    }




    /*public boolean NameSearch(String name) {
        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).getEventName().equals(name)) {
                return false;
            }
        }
        return true;
    }*/


    public void printArrayList(){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("calendar", null);
        Type type = new TypeToken<ArrayList<Event>>() {}.getType();
        ArrayList<Event> arrayList = gson.fromJson(json, type);

        for(int i = 0; i < arrayList.size(); i++) {
            Log.d("the size of calendar: ", calendar.size()+ " ");
            Log.d("the event : " + calendar.get(i).getEventName(), " <--");
        }

            //return preferences;
        }

    public void goBackToMain(){

        Toast.makeText(getApplicationContext(), eventName + " Scheduled ", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }


}