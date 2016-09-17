package com.droidloft.speciallist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
    String myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entryEditText = (EditText)findViewById(R.id.entryEditText);
        addButton = (Button)findViewById(R.id.addButton);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this, myTime, myText);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entryText = entryEditText.getText().toString();
                myText.add(entryText);
                getTime();
                myTime.add(myDate);

                CustomAdapter adapter = new CustomAdapter(MainActivity.this, myTime, myText);
                listView = (ListView)findViewById(R.id.listView);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
            }
        });




    }

    private void getTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        myDate = sdf.format(cal.getTime());
    }
}
