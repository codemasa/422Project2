package project2.ontrck;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;

/**
 * Created by Cody on 5/27/17.
 */

public class EventDisplay extends AppCompatActivity {

    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.event_display);

        listView = (ListView) findViewById(R.id.display_list_view);





    }
}
