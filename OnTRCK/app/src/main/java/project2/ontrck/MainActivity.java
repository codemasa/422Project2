package project2.ontrck;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.calendar_list_view);

        //if you want to add items to the main page insert below, simply add them after "show schedule"
        //these will imediately display on the home screen, then below add more if conditions
        String [] menuItems = new String[]{"Schedule Appointment", "Show Schedule"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
        ListView myListView = (ListView) findViewById(R.id.calendar_list_view);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "ListView item clicked.");


                //here is where you would add if statements to extend your home screen item selection
                if (position == 0) {
                    Intent myIntent = new Intent(MainActivity.this, SchedulePage.class);
                  //  myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
                else if(position == 1){
                    Intent myIntent = new Intent(MainActivity.this, SelectDayForDisplay.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
                //ex: position == 2 will be the new third item handler
                //insert other options such as google api here

            }
        });
    }

}
