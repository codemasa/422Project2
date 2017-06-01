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
    String date, storedDate;
    int index;
    ArrayList<Event> calendar = new ArrayList<Event>();
    String[] events = {"nothing scheduled","nothing scheduled","nothing scheduled","nothing scheduled","nothing scheduled","nothing scheduled","nothing scheduled","nothing scheduled","nothing scheduled"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_display);


        listView = (ListView) findViewById(R.id.display_list_view);

        // getting date from user input
        Intent mIntent = getIntent();                                     //getting date from date class
        date = mIntent.getStringExtra("date");

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("calendar", null);
        Type type = new TypeToken<ArrayList<Event>>() {
        }.getType();
        calendar = gson.fromJson(json, type);

        // now to loop through the calendar and grab any events on that day
        for(int i = 0; i < calendar.size(); i++){
            String _date = calendar.get(i).getDay() + " " +  calendar.get(i).getMonth() + " " + calendar.get(i).getYear();

            // lots of conditions ! the reason for this is too allow for nice output layout
            if(date.compareTo(_date) == 0){
                if(i == 0){
                    events[i] = calendar.get(i).getEventName();
                }
                else {
                    if (events[i - 1].compareTo("nothing scheduled") == 0) {
                        events[i - 1] = calendar.get(i).getEventName();
                    } else {
                        events[i] = calendar.get(i).getEventName();
                    }
                }
            }
        }

       String[] menuItems = new String[]{events[0], events[1], events[2], events[3], events[4], events[5], events[6],events[7],events[8]};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
        ListView myListView = (ListView) findViewById(R.id.display_list_view);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
                Log.d("EventDisplay activity", "ListView item clicked.");

                if (position == 0) {
                    Intent myIntent = new Intent(EventDisplay.this, SchedulePage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    EventDisplay.this.startActivity(myIntent);
                } else if (position == 1) {
                    Intent myIntent = new Intent(EventDisplay.this, SearchPage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    EventDisplay.this.startActivity(myIntent);
                } else if (position == 2) {
                    Intent myIntent = new Intent(EventDisplay.this, SearchPage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    EventDisplay.this.startActivity(myIntent);
                } else if (position == 4) {
                    Intent myIntent = new Intent(EventDisplay.this, EventDisplay.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    EventDisplay.this.startActivity(myIntent);
                }
            }
        });
    }
}



