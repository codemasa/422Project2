package project2.ontrck;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.util.Log;

/**
 * Created by talaba on 5/16/17.
 */

public class EndTimeSchedulePage extends AppCompatActivity {

    int startHour, startMinute, endHour, endMinute;
    String date, event;
    ParseClass parser = new ParseClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_time_schedule_page);

        // after theyve selected a time


        Button submitButton = (Button) findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                TimePicker timePickerForSpecial;
                timePickerForSpecial = (TimePicker) findViewById(R.id.time_input);
                endHour = timePickerForSpecial.getHour();
                endMinute = timePickerForSpecial.getMinute();
                event = "testing group name";
                // Toast.makeText(getApplicationContext(), "this is the time and event " + hour + " " + minute + " " + event + " ", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(EndTimeSchedulePage.this, ParseClass.class);
                Log.d(" this is the date: ", date + " <-that was it");
                parser.setInformation(startMinute, startHour, endMinute, endHour, event);
                EndTimeSchedulePage.this.startActivity(myIntent);
            }
        });


    }
    //set all parameters to be packaged for the parse class
    public void setInformation(int _startHour, int _startMinute, String _date){
        startHour = _startHour;
        startMinute = _startMinute;
        date = _date;
      //  Log.d("date: ", date);
       // Toast.makeText(getApplicationContext(),date + "hello", Toast.LENGTH_SHORT).show();
    }
}