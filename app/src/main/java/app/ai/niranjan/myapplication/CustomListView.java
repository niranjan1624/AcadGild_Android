package app.ai.niranjan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {
    ArrayList<PersonObj> personObjs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        personObjs.add(new PersonObj("Niranjan", "984749374"));
        personObjs.add(new PersonObj("Balu", "984749474"));
        personObjs.add(new PersonObj("Balaji", "908780987"));
        personObjs.add(new PersonObj("Ravi", "9087457638"));
        personObjs.add(new PersonObj("Venu", "903475692"));
        personObjs.add(new PersonObj("Sowjanya", "890987873"));
        personObjs.add(new PersonObj("Lukshmi", "9087676534"));

        CustomListAdapter myAdapter = new CustomListAdapter();

        ListView lv = (ListView) findViewById(R.id.custom_list_view);
        lv.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_custom_list_view, menu);
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
    private class CustomListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
           return personObjs.size();
        }

        @Override
        public Object getItem(int position) {

            return personObjs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if(view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.custom_list_view,null);
            }
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView phone = (TextView) view.findViewById(R.id.phoneNo);
            PersonObj pObj = personObjs.get(position);
            name.setText(pObj.name);
            phone.setText(pObj.phone);
            return view;
        }
    }

    private class PersonObj {
        String name, phone;
        PersonObj(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
