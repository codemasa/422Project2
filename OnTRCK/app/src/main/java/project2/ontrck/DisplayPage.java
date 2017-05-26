package project2.ontrck;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class DisplayPage extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_page);
        listView = (ListView) findViewById(R.id.calendar_list_view);
        String [] menuItems = new String[]{"Schedule Appointment","Schedule a range of Appointments","Search for an Appointment"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
        ListView myListView = (ListView) findViewById(R.id.calendar_list_view);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "ListView item clicked.");

                if (position == 0) {
                    Intent myIntent = new Intent(DisplayPage.this, SchedulePage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    DisplayPage.this.startActivity(myIntent);
                }
                else if(position == 1){
                    Intent myIntent = new Intent(DisplayPage.this, SchedulePage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    DisplayPage.this.startActivity(myIntent);
                }
                else if(position == 2){
                    Intent myIntent = new Intent(DisplayPage.this, SearchPage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    DisplayPage.this.startActivity(myIntent);
                }

            }
        });
    }

}