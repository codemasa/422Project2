package project2.ontrck;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by talaba on 5/16/17.
 */

public class InputPage extends AppCompatActivity {
    ParseClass parser = new ParseClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_page);

        final Button saturdayButton = (Button)findViewById(R.id.saturday);

        saturdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // testing: Toast.makeText(getApplicationContext(), "hello ", Toast.LENGTH_SHORT).show();

              parser.saturday_button_pressed();

            }
        });

    }
}

