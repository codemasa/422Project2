package project2.ontrck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.main_list_view);
        String [] menuItems = new String[]{"Search","Normal","Special","Show"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
    }

    private ListView listView;
}
