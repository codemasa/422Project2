package project2.ontrck;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by talaba on 5/16/17.
 */

public class SecondSchedulePage extends AppCompatActivity {

    String date, event;
    int hour, minute;
    ParseClass parser = new ParseClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_schedule_page);



        //getting date from date class

        Intent mIntent = getIntent();
        date = mIntent.getStringExtra("date");
        Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();



        // after theyve selected a time


        Button submitButton = (Button) findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                TimePicker timePickerForSpecial;
                timePickerForSpecial = (TimePicker) findViewById(R.id.time_input);
                hour = timePickerForSpecial.getHour();
                minute = timePickerForSpecial.getMinute();
                event = "testing group name";
                 // Toast.makeText(getApplicationContext(), "this is the time and event " + hour + " " + minute + " " + event + " ", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(SecondSchedulePage.this, ParseClass.class);

                //im sending the date selected by the user over to the time input class


                myIntent.putExtra("date", date); //Optional parameters

                parser.sendInformation(hour,minute,event);
                SecondSchedulePage.this.startActivity(myIntent);


            }
        });


    }
    public void displayAknowlegment(){
        Log.d("hello ", "your appointment was scheduled @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

}