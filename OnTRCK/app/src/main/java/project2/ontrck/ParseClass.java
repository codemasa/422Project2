package project2.ontrck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by talaba on 5/16/17.
 */

public class ParseClass extends AppCompatActivity {
    int hour, minute;
    String event, date;
    InsertEvent insert = new InsertEvent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_page);
        Intent mIntent = getIntent();
        date = mIntent.getStringExtra("date");
        insert.setInformation(date,event,hour,minute);

    }

    public void sendInformation(int _hour, int _minute, String _event){
        //getting time from second schedule class
        hour = _hour;
        minute = _minute;
        event = _event;
    }



}
