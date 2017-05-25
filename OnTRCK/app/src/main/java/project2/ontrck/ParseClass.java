package project2.ontrck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.util.Log;

/**
 * Created by talaba on 5/16/17.
 */

public class ParseClass extends AppCompatActivity {
    int startHour, startMinute, endHour, endMinute;
    String event, date, startTime, endTime;
    InsertEvent insert = new InsertEvent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_time_schedule_page);
        Intent mIntent = getIntent();
        date = mIntent.getStringExtra("date");
        Toast.makeText(getApplicationContext(),"this is the date from parse: " + date,Toast.LENGTH_SHORT).show();
        startTime = startHour + " " + startMinute;
        endTime = endHour + " " + endMinute;
      //  insert.setInformation(date,event,startTime,endTime);
        //Intent myIntent = new Intent(ParseClass.this, DisplayPage.class);
       // ParseClass.this.startActivity(myIntent);

    }

    public void setInformation(int _startMinute, int _startHour,int _endMinute, int _endHour,  String _event){
        //getting time from second schedule class

        Log.d("date: ", "hello" + date);
        startHour = _startHour;
        endHour = _endHour;
        startMinute = _startMinute;
        endMinute = _endMinute;
        event = _event;
        startTime = startHour + " " + startMinute;
        endTime = endHour + " " + endMinute;
        System.out.println(startHour + ":" + startMinute + " " + "-" + endHour + ":" + endMinute + " " + event);
    }
    public void setDate(String _date){
        date = _date;
    }



}
