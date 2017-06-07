package project2.ontrck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.util.Log;
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
    // they only need 2 items because they are 2 digit time numbers for ex: 12:30
    int[] startTime = new int[2];
    int[] endTime = new int[2];
    int count = 0;

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

        startTime[0] = startHour;
        startTime[1] = startMinute;
        endTime[0] = endHour;
        endTime[1] = endMinute;
        setInformation(date, eventName, startTime, endTime);
        goBackToMain();
    }

    public void setInformation(String date, String _event, int[] _startTime, int[] _endTime) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor ed;



                if (sharedPrefs.contains("calendar")) {
                    sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    Gson gson = new Gson();
                    String json = sharedPrefs.getString("calendar", null);
                    Type type = new TypeToken<ArrayList<Event>>() {
                    }.getType();
                    ArrayList<Event> arrayList = gson.fromJson(json, type);
                    calendar = arrayList;
                    count++;
                    Event event = new Event();
                    String[] splitDate = date.split("\\s+");
                    // so the date comes as a string now we will parse it to more specific information
                    // it was in the form dd mm yyyy
                    day = Integer.parseInt(splitDate[0]);
                    month = Integer.parseInt(splitDate[1]);
                    year = Integer.parseInt(splitDate[2]);

                    event.setDay(day);
                    event.setMonth(month);
                    event.setYear(year);
                    event.setEventName(eventName);
                    event.setStartTime(startTime);
                    event.setEndTime(endTime);

                    calendar.add(event);

                    sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    Editor editor = sharedPrefs.edit();
                    gson = new Gson();
                    json = gson.toJson(calendar);
                    editor.putString("calendar", json);
                    editor.apply();
                } else {
                    Log.d("made it!", " ");
                    Event event = new Event();
                    String[] splitDate = date.split("\\s+");
                    // so the date comes as a string now we will parse it to more specific information
                    // it was in the form dd mm yyyy
                    day = Integer.parseInt(splitDate[0]);
                    month = Integer.parseInt(splitDate[1]);
                    year = Integer.parseInt(splitDate[2]);

                    event.setDay(day);
                    event.setMonth(month);
                    event.setYear(year);
                    event.setEventName(eventName);
                    event.setStartTime(startTime);
                    event.setEndTime(endTime);

                    calendar.add(event);

                    sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    Editor editor = sharedPrefs.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(calendar);
                    editor.putString("calendar", json);
                    editor.apply();
                }
            }

    public void goBackToMain(){
        Toast.makeText(getApplicationContext(), eventName + " Scheduled ", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }


}