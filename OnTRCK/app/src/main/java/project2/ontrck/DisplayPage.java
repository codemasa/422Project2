package project2.ontrck;


import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
public class DisplayPage extends AppCompatActivity {

    String inputString2 = "testing";
    String inputString1 = "testing2";
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_page);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setCustomResourceForDates() {

        Calendar cal = Calendar.getInstance();
        //highlighlighting the holidays in a month taking the static dates
        ArrayList<String> dates = new ArrayList<String>();
        dates.add("02-08-2015");
        dates.add("22-08-2015");
        dates.add("17-09-2015");
        dates.add("25-09-2015");
        dates.add("27-09-2015");
        dates.add("13-10-2015");
        dates.add("22-10-2015");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        Date date1 = new Date();
        Date date2 = new Date();
        for (int i = 1; i < dates.size(); i++) {
            inputString2 = dates.get(i);
            inputString1 = myFormat.format(date);

            try {
                //Converting String format to date format
                date1 = myFormat.parse(inputString1);
                date2 = myFormat.parse(inputString2);
                //Calculating number of days from two dates
                long diff = date2.getTime() - date1.getTime();
                long datee = diff / (1000 * 60 * 60 * 24);
                //Converting long type to int type
                day = (int) datee;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal = Calendar.getInstance();
            cal.add(Calendar.DATE, day);
            int holidayDay;



        }
    }

}


