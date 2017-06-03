package project2.ontrck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by talaba on 6/2/17.
 */

public class DeletePage extends AppCompatActivity{
    private Button delete;
    String event;
    int position;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_page);


        // here we are grabbing the correct event to delete
        // it generates from the put intents in the view schedule class
        Intent mIntent = getIntent();
        date = mIntent.getStringExtra("date");
        event = mIntent.getStringExtra("event");
        position = mIntent.getIntExtra("position", 0);

        // here we are defining a button and event handler as well as listener
        delete = (Button)findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            //implementing a handler
            @Override
            public void onClick(View v) {

                // in android studio in order to have an app store its state we must store and recieve from and to shared preferences
                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Gson gson = new Gson();
                String json = sharedPrefs.getString("calendar", null);
                Type type = new TypeToken<ArrayList<Event>>() {}.getType();
                ArrayList<Event> calendar = gson.fromJson(json, type);


                // to add more to the button listener the developer can input here

                // removing the correct event from the calendar
                calendar.remove(position);

                // now we are putting information into shared preferences
                sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();
                gson = new Gson();
                json = gson.toJson(calendar);
                editor.putString("calendar", json);
                editor.apply();
                Intent myIntent = new Intent(DeletePage.this, MainActivity.class);
                DeletePage.this.startActivity(myIntent);
            }
        });
    }
}
