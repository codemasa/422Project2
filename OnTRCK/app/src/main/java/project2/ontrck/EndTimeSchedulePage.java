package project2.ontrck;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by talaba on 5/16/17.
 */

public class EndTimeSchedulePage extends AppCompatActivity {

    int endHour, endMinute, startHour, startMinute;
    String event, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_time_schedule_page);
        Intent mIntent = getIntent();
         startHour = mIntent.getIntExtra("startHour", 0);
         startMinute = mIntent.getIntExtra("startMinute",0);
         event = mIntent.getStringExtra("event");
         date = mIntent.getStringExtra("date");
        // after they've selected a time


        Button submitButton = (Button) findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                TimePicker timePickerForSpecial;
                timePickerForSpecial = (TimePicker) findViewById(R.id.time_input);
                endHour = timePickerForSpecial.getHour();
                endMinute = timePickerForSpecial.getMinute();
                if(endHour < startHour){
                    Toast.makeText(getApplicationContext(), "Please enter an hour after your start start!", Toast.LENGTH_SHORT).show();
                }
                else if (endMinute < startMinute && startHour == endHour){
                    Toast.makeText(getApplicationContext(), "Please enter an minute after your start minute!", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Toast.makeText(getApplicationContext(), "this is the time and event " + hour + " " + minute + " " + event + " ", Toast.LENGTH_SHORT).show();
                    sendData();
                }

            }
        });
    }
    public void sendData(){
        Intent mIntent = new Intent(this, InsertEvent.class);

         mIntent.putExtra("startHour", startHour);
        mIntent.putExtra("startMinute", startMinute);
       mIntent.putExtra("endHour", endHour);
        mIntent.putExtra("endMinute", endMinute);
        mIntent.putExtra("event", event);
        mIntent.putExtra("date", date);
        startActivity(mIntent);
    }

}