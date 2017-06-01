package project2.ontrck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Cody on 5/27/17.
 */

public class EventDisplay extends AppCompatActivity {

    private ListView listView;
    String date, storedDate;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_display);
        listView = (ListView) findViewById(R.id.display_list_view);

        // getting date from user input
        Intent mIntent = getIntent();                                     //getting date from date class
        date = mIntent.getStringExtra("date");

        // getting the arraylist of calendar events from preferences
        ArrayList<Event> calendar = new ArrayList<Event>();
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("calendar", null);
        Type type = new TypeToken<ArrayList<Event>>() {
        }.getType();
        ArrayList<Event> arrayList = gson.fromJson(json, type);

        getEventsOnDate(arrayList);
/*
        String[] menuItems = new String[]{"Schedule Appointment", "Schedule a range of Appointments", "Search for an Appointment", "Delete Appointment", "Show schedule"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
        ListView myListView = (ListView) findViewById(R.id.calendar_list_view);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                              @Override
                                              public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
                                                  Log.d("MainActivity", "ListView item clicked.");

                                                  if (position == 0) {
                                                      Intent myIntent = new Intent(MainActivity.this, SchedulePage.class);
                                                      //  myIntent.putExtra("key", value); //Optional parameters
                                                      MainActivity.this.startActivity(myIntent);
                                                  } else if (position == 1) {
                                                      Intent myIntent = new Intent(MainActivity.this, SearchPage.class);
                                                      //  myIntent.putExtra("key", value); //Optional parameters
                                                      MainActivity.this.startActivity(myIntent);
                                                  } else if (position == 2) {
                                                      Intent myIntent = new Intent(MainActivity.this, SearchPage.class);
                                                      //  myIntent.putExtra("key", value); //Optional parameters
                                                      MainActivity.this.startActivity(myIntent);
                                                  } else if (position == 4) {
                                                      Intent myIntent = new Intent(MainActivity.this, EventDisplay.class);
                                                      //  myIntent.putExtra("key", value); //Optional parameters
                                                      MainActivity.this.startActivity(myIntent);
                                                  }

                                              }
                                          }
        */
    }

    public void getEventsOnDate(ArrayList<Event> calendar) {
        String events = " ";
        for (int i = 0; i < calendar.size(); i++) {
           // storedDate = calendar.get(i).getDay() + " " + calendar.get(i).getMonth() + " " + calendar.get(i).getYear();
            Log.d("date from list: " , calendar.get(i).getMonth() + " ");


           // if (storedDate.compareTo(date) == 0) {

             //   events += " " + i;
             //   Log.d("hit: ", calendar.get(i).eventName);

           // }
        }


    }
}


