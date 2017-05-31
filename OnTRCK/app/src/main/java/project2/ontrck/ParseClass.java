package project2.ontrck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by talaba on 5/16/17.
 */

public class ParseClass extends AppCompatActivity {
    int startHour, startMinute, endHour, endMinute;
    int[] startTime, endTime;
    String event, date = "no date input yet!";

    InsertEvent insert = new InsertEvent();

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

         startTime[0] = startHour;
         startTime[1] = startMinute;
        endTime[0] = endHour;
        endTime[1] = endMinute;


        insert.setInformation(date,event,startTime,endTime);
        goBackToMain();

    }
    public void goBackToMain(){
        Toast.makeText(getApplicationContext(), event + " Scheduled ", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);

    }
}
