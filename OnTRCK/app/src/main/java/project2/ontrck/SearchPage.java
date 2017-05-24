package project2.ontrck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.widget.CalendarView.OnDateChangeListener;

/**
 * Created by talaba on 5/16/17.
 */

public class SearchPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        CalendarView view = new CalendarView(this);
        setContentView(view);

        view.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month,
                                            int date) {
                Toast.makeText(getApplicationContext(),date+ "/"+month+"/"+year,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
