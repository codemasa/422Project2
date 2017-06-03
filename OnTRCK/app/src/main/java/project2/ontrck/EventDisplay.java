package project2.ontrck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_display);


        listView = (ListView) findViewById(R.id.display_list_view);

        Intent mIntent = getIntent();                //getting date from date class
        date = mIntent.getStringExtra("date");


        // getting the data from when the activity is changed or the app is closed
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("calendar", null);
        Type type = new TypeToken<ArrayList<Event>>() {
        }.getType();
        ArrayList<Event> arrayList = gson.fromJson(json, type);
        ArrayList<Event> dayArray = new ArrayList<Event>();

        for (int i = 0 ; i < arrayList.size() ; i++){
            int currentDay = arrayList.get(i).getDay();
            int currentMonth = arrayList.get(i).getMonth();
            int currentYear = arrayList.get(i).getYear();

            //run date into one string to be used to compare to dates already in the calendar
            String currentDate = (Integer.toString(currentDay) + " " + Integer.toString(currentMonth) + " " + Integer.toString(currentYear));
            if (currentDate.compareTo(date) == 0) {
                dayArray.add(arrayList.get(i));
            }
        }
        final String [] eventArray = new String[dayArray.size()];
        if(eventArray.length > 0) {
            for (int i = 0; i < dayArray.size(); i++) {
                String currentStartH = Integer.toString(dayArray.get(i).getStartTime()[0]);
                String currentStartM = Integer.toString(dayArray.get(i).getStartTime()[1]);
                String currentEndH = Integer.toString(dayArray.get(i).getEndTime()[0]);
                String currentEndM = Integer.toString(dayArray.get(i).getEndTime()[1]);

                //appending an extra 0 to single digit numbers for display
                if (dayArray.get(i).getStartTime()[0] < 10){
                    currentStartH = "0" + currentStartH;
                }
                if (dayArray.get(i).getStartTime()[1] < 10){
                    currentStartM = "0" + currentStartM;
                }
                if (dayArray.get(i).getEndTime()[0] < 10){
                    currentEndH = "0" + currentEndH;
                }
                if (dayArray.get(i).getEndTime()[1] < 10){
                    currentEndM = "0" + currentEndM;
                }

                // this displays the range of times on the displayed schedule
                eventArray[i] = dayArray.get(i).getEventName() + " From " +
                        currentStartH + ":" + currentStartM +
                        " to " + currentEndH + ":" + currentEndM;
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, eventArray);
            listView.setAdapter(adapter);
            ListView myListView = (ListView) findViewById(R.id.display_list_view);
            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {

                    //below is what i like to call a shared preference sandwich
                    // this is because to retrieve information from other classes
                    // and then after manipulating re-store the data
                    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    Gson gson = new Gson();
                    String json = sharedPrefs.getString("calendar", null);
                    Type type = new TypeToken<ArrayList<Event>>() {
                    }.getType();
                    ArrayList<Event> calendar = gson.fromJson(json, type);

                    Intent myIntent = new Intent(EventDisplay.this, DeletePage.class);

                    myIntent.putExtra("event", calendar.get(position).getEventName());
                    myIntent.putExtra("position", position);
                    myIntent.putExtra("date", date);
                    Log.d("MainActivity", "ListView item clicked.");
                    sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    gson = new Gson();

                    json = gson.toJson(calendar);

                    editor.putString("calendar", json);
                    editor.apply();
                    EventDisplay.this.startActivity(myIntent);
                }
            });
        }
        else {
            //if no events are in the calendar we display to users on the display page
            String [] defaultArray = new String[] {"There are no events for the date of " + date + "!"};
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, defaultArray);
            listView.setAdapter(adapter);
        }
    }
}



