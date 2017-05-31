package project2.ontrck;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;


/**
 * Created by talaba on 5/16/17.
 */

public class SecondSchedulePage extends AppCompatActivity {

    String date;
    String event;
    int startHour, startMinute, endHour, endMinute;
    //EndTimeSchedulePage endTime = new EndTimeSchedulePage();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_schedule_page);



        Intent mIntent = getIntent();                                     //getting date from date class
        date = mIntent.getStringExtra("date");

        Button submitButton = (Button) findViewById(R.id.submit_button);  // after theyve selected a time

        submitButton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                TimePicker timePickerForSpecial;
                timePickerForSpecial = (TimePicker) findViewById(R.id.time_input);
                startHour = timePickerForSpecial.getHour();
                startMinute = timePickerForSpecial.getMinute();
                EditText eventInput = (EditText)findViewById(R.id.event_input);
                event = eventInput.getText().toString();
                Log.d("event: ", "->" + event);

               // endTime.setInformation(startHour, startMinute, date);
                openEndSchedulePage();
            }
        });


    }
    public void openEndSchedulePage(){

        Intent myIntent = new Intent(this, EndTimeSchedulePage.class);
        myIntent.putExtra("startHour", startHour);
        myIntent.putExtra("startMinute", startMinute);
        myIntent.putExtra("event", event);
        myIntent.putExtra("date", date);
        startActivity(myIntent);
    }

}