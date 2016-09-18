package com.droidloft.speciallist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText entryEditText;
    Button addButton;
    //String myDate, myText;
    ListView listView;
    ArrayList<String>myTime;
    ArrayList<String>myText;
    ArrayList<String>myName;
    String myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entryEditText = (EditText)findViewById(R.id.entryEditText);
        addButton = (Button)findViewById(R.id.addButton);
        myTime = new ArrayList<>();
        myText = new ArrayList<>();
        myName = new ArrayList<>();


       // CustomAdapter adapter = new CustomAdapter(MainActivity.this, myTime, myText);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entryText = entryEditText.getText().toString();
                if(entryText.equals("")) {
                    //Do nothing
                } else {
                    myText.add(entryText);
                    getTime();
                    myTime.add(myDate);
                    myName.add("M.May");
                    entryEditText.setText("");

                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, myName, myTime, myText);
                    listView = (ListView)findViewById(R.id.listView);
                    listView.setAdapter(adapter);
                }


            }
        });




    }

    private void getTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        myDate = sdf.format(cal.getTime());
    }
}
