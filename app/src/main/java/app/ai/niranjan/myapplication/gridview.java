package app.ai.niranjan.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class gridview extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter());
    }
    public class ImageAdapter extends BaseAdapter{
        private Integer[] mThumbIds = {
                R.mipmap.gingerbread,R.mipmap.honeycomb,
                R.mipmap.icecream, R.mipmap.jellybean,
                R.mipmap.kitkat, R.mipmap.lollypop
        };

        private String[] names = {"Ginger Bread", "Honey Comb", "Icecream Sandwitch",
                "JellyBean", "KitKat", "Lollypop"};

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View rowView = convertView;
            if(rowView == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.custom_grid_view, null);
            }


            TextView tv=(TextView) rowView.findViewById(R.id.textView1);
            ImageView img=(ImageView) rowView.findViewById(R.id.imageView1);

            tv.setText(names[position]);
            img.setImageResource(mThumbIds[position]);


            return rowView;
        }



    }

}