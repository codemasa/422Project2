package project2.ontrck;


import java.lang.*;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.*;



public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.calendar_list_view);
        String [] menuItems = new String[]{"Search","Normal","Special","Show", "Input"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
        ListView myListView = (ListView) findViewById(R.id.calendar_list_view);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "ListView item clicked.");

                if (position == 0) {
                    Intent myIntent = new Intent(MainActivity.this, SearchPage.class);
                  //  myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
                else if(position == 1){
                    Intent myIntent = new Intent(MainActivity.this, NormalPage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
                else if(position == 2){
                    Intent myIntent = new Intent(MainActivity.this, SpecialPage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
                else if(position == 3){
                    Intent myIntent = new Intent(MainActivity.this, ShowPage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
                else if(position == 4){
                    Intent myIntent = new Intent(MainActivity.this, InputPage.class);
                    //  myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
            }
        });
    }
}
