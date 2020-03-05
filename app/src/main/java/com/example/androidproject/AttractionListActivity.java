package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AttractionListActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[]= {"Tokyo National Museum","Meiji Shrine","Sensoji Temple","Odaiba","Imperial Palace","Metropolitan Government Tower","Ginza","Shinjuku Gyoen National Garden"};
    String mDescription[]={"Museum","Monument","Temple","Tourism Center","Monument","Architecture","Tourism Center","Park"};

    //images to be set in array now:-
    int images[] = {R.drawable.museum,R.drawable.meiji,R.drawable.sensoji,R.drawable.odaiba,R.drawable.imperial,R.drawable.tower,R.drawable.ginza, R.drawable.garden};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_list);

        // setup toolbar
        Toolbar t1 = (Toolbar) findViewById(R.id.toolbarAttractionListScreen);
        t1.setTitle("Tokyo 2020");
        setSupportActionBar(t1);

        // add an up bar
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listView);
        // creating adapter class;;

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        //  setting the items clicked on list view
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        });*/

    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]){

            super(c, R.layout.row, R.id.textView1, title);
            this.context =c;
            this.rTitle= title;
            this.rDescription = description;
            this.rImgs = imgs;



        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent, false);

            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // set resources on views

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }
}
