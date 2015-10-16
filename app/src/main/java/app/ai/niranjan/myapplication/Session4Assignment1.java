package app.ai.niranjan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Session4Assignment1 extends AppCompatActivity {
    ListView listView;
    ArrayList<String> monthList = new ArrayList<String>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session4_assignment1);
        listView = (ListView) findViewById(R.id.list_view);
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        monthList.addAll(Arrays.asList(months));
        adapter = new ArrayAdapter(this, R.layout.text_view,monthList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_session4_assignment1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ascend(View view) {
        Collections.sort(monthList);
        listView.setAdapter(adapter);
    }

    public void descend(View view) {
        Collections.reverse(monthList);
        listView.setAdapter(adapter);
    }
}
