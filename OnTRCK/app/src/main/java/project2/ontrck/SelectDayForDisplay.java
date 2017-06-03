package project2.ontrck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
/**
 * Created by talaba on 5/16/17.
 */

public class SelectDayForDisplay extends AppCompatActivity {
    String date;
    int day_, month_, year_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_page);
        final CalendarView calendar = (CalendarView) findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int day_of_month = dayOfMonth;
                day_ = day_of_month;
                month_ = month;
                year_ = year;
                date = (Integer.toString(day_) + " " + Integer.toString(month_) + " " + Integer.toString(year_));
                Intent myIntent = new Intent(SelectDayForDisplay.this, EventDisplay.class);
                //im sending the date selected by the user over to the time input class
                myIntent.putExtra("date", date); //Optional parameters
                SelectDayForDisplay.this.startActivity(myIntent);
            }
        });



    }
}