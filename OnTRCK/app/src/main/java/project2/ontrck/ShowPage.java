package project2.ontrck;

import android.util.Log;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;


/**
 * Created by talaba on 5/16/17.
 */

public class ShowPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_page);
        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
       // int firstDayOfWeek = simpleCalendarView.getFirstDayOfWeek(); // get first day of the week


    }
}