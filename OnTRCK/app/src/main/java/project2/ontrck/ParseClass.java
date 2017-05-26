package project2.ontrck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by talaba on 5/16/17.
 */

public class ParseClass extends AppCompatActivity {
    int startHour, startMinute, endHour, endMinute;
    String event, date = "no date input yet!", startTime, endTime;

    //InsertEvent insert = new InsertEvent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_page);
        Intent mIntent = getIntent();
        startHour = mIntent.getIntExtra("startHour", 0);
        startMinute = mIntent.getIntExtra("startMinute",0);
        endHour = mIntent.getIntExtra("endHour", 0);
        endMinute = mIntent.getIntExtra("endMinute", 0);
        event = mIntent.getStringExtra("event");
        date = mIntent.getStringExtra("date");
        Log.d("start time: " , startHour + "" + startMinute);
        Log.d( "end time: " ,  endHour + "" + endMinute);
        Log.d("event: ", " " + event);
        Log.d("date: ", " " + date);
        startTime = startHour + " " + startMinute;
        endTime = endHour + " " + endMinute;
      //  insert.setInformation(date,event,startTime,endTime);

        goBackToMain();

    }
    public void goBackToMain(){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
