package project2.ontrck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by talaba on 5/16/17.
 */

public class SearchPage extends AppCompatActivity {
    String eventName;
    String date;
    InsertEvent data = new InsertEvent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        EditText eventInput = (EditText)findViewById(R.id.event_input);
        EditText dateInput = (EditText)findViewById(R.id.date_input);
         eventName = eventInput.getText().toString();
         date = dateInput.getText().toString();

        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                searchButtonPressed(eventName, date);
            }
        });
    }
    public void searchButtonPressed(String eventName, String date){

        if(eventName.matches("") && date.matches("")) {
            Toast.makeText(getApplicationContext(),"Please enter a date or a event",Toast.LENGTH_SHORT).show();
        }
        else if(!(eventName.matches("")) && !(date.matches(""))){
            Toast.makeText(getApplicationContext(),"Please only enter single field ",Toast.LENGTH_SHORT).show();
        }
        else if(eventName.matches("")){
            //data.searchDate(date);

        }
        else{
            //data.searchEvent(eventName);
        }
    }
}

